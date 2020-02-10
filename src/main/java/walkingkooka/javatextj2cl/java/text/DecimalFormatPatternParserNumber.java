/*
 * Copyright 2019 Miroslav Pokorny (github.com/mP1)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package walkingkooka.javatextj2cl.java.text;

import walkingkooka.ToStringBuilder;
import walkingkooka.collect.list.Lists;

import java.text.DecimalFormat;
import java.util.List;

/**
 * A parser that accepts a pattern and produces a list of {@link DecimalFormatPatternComponent}.
 */
final class DecimalFormatPatternParserNumber extends DecimalFormatPatternParser {

    static DecimalFormatPatternParserNumber with(final String pattern,
                                                 final int position) {
        return new DecimalFormatPatternParserNumber(pattern, position);
    }

    private DecimalFormatPatternParserNumber(final String pattern,
                                             final int position) {
        super(pattern, position);

        this.prefix = Lists.array();
        this.prefixOrSuffix = this.prefix;
    }

    @Override
    void handle(final char c) {
        this.mode.handle(c, this);
    }

    @Override
    boolean isFinished() {
        return this.subPatternSeparator;
    }

    void setMode(final DecimalFormatPatternParserNumberMode mode) {
        if (this.mode == DecimalFormatPatternParserNumberMode.INTEGER) {
            this.checkGroupingSeparator();
        }
        this.mode = mode;
    }

    /**
     * The current mode keeping track of the pattern being parsed. Will be null when the pattern-separator is found.
     */
    DecimalFormatPatternParserNumberMode mode = DecimalFormatPatternParserNumberMode.PREFIX;

    void decimalSeparator() {
        if (-1 != this.decimalSeparator) {
            this.failInvalidCharacter();
        }
        this.decimalSeparator = this.number.size();
        this.addNumberComponent(DecimalFormatPatternComponent.decimalSeparator());
    }

    boolean hasDecimalSeparator() {
        return -1 != this.decimalSeparator;
    }

    /**
     * An index into {@link #number} holding the position of any decimal separator.
     */
    private int decimalSeparator = -1;

    /**
     * <pre>
     * - Exponential patterns may not contain grouping separators.
     * - Multiple exponents in a row are a fail.
     * </pre>
     */
    void exponent() {
        final int position = this.position;

        // if exponent immediately after fraction fail
        final int decimalSeparator = this.decimalSeparator;
        if (-1 != decimalSeparator && position == decimalSeparator + 1) {
            this.failInvalidCharacter();
        }

        this.number.add(DecimalFormatPatternComponent.exponent());
        this.setMode(DecimalFormatPatternParserNumberMode.EXPONENT);
        this.exponent = position;
    }

    /**
     * The number portion of the pattern cannot end with E
     */
    private void checkExponent() {
        final List<DecimalFormatPatternComponent> number = this.number;
        if (number.size() > 0 && number.get(number.size() - 1) instanceof DecimalFormatPatternComponentExponent) {
            this.failInvalidCharacter(this.exponent);
        }
    }

    /**
     * A value of zero or greater indicates an scientific format.
     */
    private int exponent = -1;

    /**
     * Returns true if a scientific format.\
     */
    boolean isScientificFormat() {
        return -1 != this.exponent;
    }

    // groupingSeparator................................................................................................

    void groupingSeparator() {
        final int position = this.position;

        if (-1 != this.groupingSeparator) {
            this.failInvalidCharacter(position);
        }
        this.groupingSeparator = position;

        this.addNumberComponent(DecimalFormatPatternComponent.groupingSeparator());
    }

    private void checkGroupingSeparator() {
        // if number ends in grouping its a bad pattern
        if (0 == this.groupingSize()) {
            this.failInvalidCharacter(this.groupingSeparator);
        }
    }

    int groupingSize() {
        if (-1 != this.groupingSeparator && -1 == this.groupingSize) {
            final List<DecimalFormatPatternComponent> number = this.number;
            int decimal = this.decimalSeparator;
            if (-1 == decimal) {
                decimal = number.size();
            }

            final int index = number.lastIndexOf(DecimalFormatPatternComponent.groupingSeparator());
            this.groupingSize = -1 == index ?
                    -1 :
                    decimal - index - 1;
        }
        return this.groupingSize;
    }

    /**
     * Kept to help produce accurate {@link walkingkooka.InvalidCharacterException} messages.
     */
    private int groupingSeparator = -1;

    /**
     * The computed groupingSeparator for {@link DecimalFormat#getGroupingSize()}
     */
    int groupingSize = -1;

    // hash.............................................................................................................

    void hash() {
        if (DecimalFormatPatternParserNumberMode.INTEGER == this.mode) {
            if (this.integerZero) {
                this.failInvalidCharacter();
            }
        }
        this.addNumberComponent(DecimalFormatPatternComponent.hash());
    }

    /**
     * Becomes true when hashes are encountered in a fraction pattern. This helps guards against zeroes coming after hashes.
     */
    boolean fractionHash;

    // maximumFractionDigits............................................................................................

    // TODO not sure whether exponent patterns need to be handled specially.

    private void computeFractionDigits() {
        // maximumFractionDigits: number of hash/zero AFTER the decimal point
        // minimumFractionDigits: number of zero AFTER the decimal point

        int hashOrZero = 0;
        int zero = 0;

        final int decimal = this.decimalSeparator;
        if (-1 != decimal) {
            final List<DecimalFormatPatternComponent> number = this.number;
            final int numberCount = number.size();

            int i = decimal + 1;
            while (i < numberCount) {
                if (number.get(i).isZero()) {
                    zero++;
                    i++;
                    continue;
                }

                while (i < numberCount) {
                    if (number.get(i).isHashOrZero()) {
                        hashOrZero++;
                        i++;
                        continue;
                    }
                    break;
                }
                break;
            }
        }

        this.maximumFractionDigits = hashOrZero + zero;
        this.minimumFractionDigits = zero;
    }

    int maximumFractionDigits = 0;
    int minimumFractionDigits = 0;

    // maximumIntegerDigits..............................................................................................

    private void computeIntegerDigits() {
        // minimumIntegerDigits count zeros to the left of decimal point
        int zero = 0;

        final List<DecimalFormatPatternComponent> number = this.number;

        int i = this.decimalSeparator;
        if (-1 == i) {
            i = number.size();
        }

        while (i > 0) {
            i--;
            final DecimalFormatPatternComponent component = number.get(i);
            if (component.isGroupingSeparator()) {
                continue;
            }
            if (component.isZero()) {
                zero++;
                continue;
            }
            break;
        }

        // DecimalFormat.applyPattern then getMaximumIntegerDigits always returns Integer.MAX_VALUE
        this.maximumIntegerDigits = Integer.MAX_VALUE;
        this.minimumIntegerDigits = zero;
    }

    int maximumIntegerDigits = 0;
    int minimumIntegerDigits = 0;

    // subPatternSeparator..............................................................................................

    void subPatternSeparator() {
        this.onComplete();
        this.subPatternSeparator = true;
    }

    boolean subPatternSeparator;

    // zero............................................................................................................

    void zero() {
        if (DecimalFormatPatternParserNumberMode.INTEGER == this.mode) {
            this.integerZero = true;
        }
        this.addNumberComponent(DecimalFormatPatternComponent.zero());
    }

    /**
     * Becomes true when a zero is encountered in a integer pattern. This helps guards against hashes coming after zeroes.
     */
    boolean integerZero;

    // nonNumberComponent...............................................................................................

    @Override
    void addNonNumberComponent(final DecimalFormatPatternComponent component) {
        this.prefixOrSuffix.add(component);
    }

    @Override
    List<DecimalFormatPatternComponent> nonNumberComponents() {
        return this.prefixOrSuffix;
    }

    /**
     * Will only ever point to prefix or suffix.
     */
    List<DecimalFormatPatternComponent> prefixOrSuffix;

    /**
     * Collects the prefix
     */
    final List<DecimalFormatPatternComponent> prefix;

    // numberComponent..................................................................................................

    private void addNumberComponent(final DecimalFormatPatternComponent component) {
        this.number.add(component);
        this.prefixOrSuffix = this.suffix;
    }

    final List<DecimalFormatPatternComponent> number = Lists.array();

    final List<DecimalFormatPatternComponent> suffix = Lists.array();

    // onComplete.......................................................................................................

    @Override
    void onComplete() {
        this.addLeadingHashIfNecessary();

        this.currencySeparatorFix();
        this.checkGroupingSeparator();
        this.checkExponent();
        this.computeFractionDigits();
        this.computeIntegerDigits();
    }

    /**
     * This solves patterns starting with decimal separator or with integer pattern without a leading hash etc.
     */
    private void addLeadingHashIfNecessary() {
        final List<DecimalFormatPatternComponent> number = this.number;
        if (number.isEmpty() || false == number.get(0).isHash()) {
            number.add(0, DecimalFormatPatternComponent.hash());

            final int decimalSeparator = this.decimalSeparator;
            if(-1 != decimalSeparator) {
                this.decimalSeparator = decimalSeparator + 1;
            }

            final int groupingSeparator = this.groupingSeparator;
            if(-1 != groupingSeparator) {
                this.groupingSeparator = groupingSeparator + 1;
            }
        }
    }

    private void currencySeparatorFix() {
        final int decimalSeparator = this.decimalSeparator;
        if (-1 != decimalSeparator) {
            if (this.currency) {
                this.number.set(decimalSeparator, DecimalFormatPatternComponent.currencySeparator());
            }
        }
    }

    // toString.........................................................................................................

    @Override
    public String toString() {
        return ToStringBuilder.empty()
                .value(this.pattern)
                .valueSeparator("")
                .label("prefix").value(this.prefix)
                .label("number").value(this.number)
                .label("suffix").value(this.suffix)
                .build();
    }
}
