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
        this.decimalSeparator = this.position;
        this.addNumberComponent(DecimalFormatPatternComponent.decimalSeparator());
    }

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
        this.checkGroupingSeparator();
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

    private int exponent = -1;

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
        final int groupingSeparator = this.computeGroupingSeparator();
        if (0 == groupingSeparator) {
            this.failInvalidCharacter(this.groupingSeparator);
        }
    }

    int computeGroupingSeparator() {
        final List<DecimalFormatPatternComponent> number = this.number;
        final int index = number.lastIndexOf(DecimalFormatPatternComponent.groupingSeparator());
        return -1 == index ?
                -1 :
                number.size() - index - 1;
    }

    /**
     * Kept to help produce accurate {@link walkingkooka.InvalidCharacterException} messages.
     */
    private int groupingSeparator = -1;

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
        this.currencySeparatorFix();
        this.checkGroupingSeparator();
        this.checkExponent();
    }

    private void currencySeparatorFix() {
        if (-1 != this.decimalSeparator) {
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
                .label("prefix").value(this.prefix)
                .label("number").value(this.number)
                .label("suffix").value(this.suffix)
                .build();
    }
}
