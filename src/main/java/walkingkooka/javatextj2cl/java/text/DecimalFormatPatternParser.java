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

import walkingkooka.InvalidCharacterException;
import walkingkooka.NeverError;
import walkingkooka.collect.list.Lists;
import walkingkooka.text.CharSequences;

import java.util.List;

/**
 * Base class for serveral parsers that handle prefix, number and suffix.
 */
abstract class DecimalFormatPatternParser {

    DecimalFormatPatternParser(final DecimalFormatPatternParserTextCursor pattern) {
        super();
        this.pattern = pattern;
    }

    /**
     * Parses the pattern text into its equivalent pattern components.
     */
    final List<DecimalFormatPatternComponent> parse() {
        final DecimalFormatPatternParserTextCursor pattern = this.pattern;
        int escapedMode = MODE_NORMAL;

        while (pattern.hasMore()) {
            final char c = pattern.charAt();

            switch (escapedMode) {
                case MODE_NORMAL:
                    if(DecimalFormat.QUOTE == c) {
                        escapedMode = MODE_ESCAPED;
                    } else {
                        this.handle(c);
                    }
                    break;
                case MODE_ESCAPED:
                    this.addCharacterLiteral(c);
                    escapedMode = DecimalFormat.QUOTE == c ?
                            MODE_NORMAL :
                            MODE_CLOSING_QUOTE;
                    break;
                case MODE_CLOSING_QUOTE:
                    if (DecimalFormat.QUOTE != c) {
                        pattern.failInvalidCharacter();
                    }
                    escapedMode = MODE_NORMAL;
                    break;
                default:
                    NeverError.unhandledCase(escapedMode, MODE_NORMAL, MODE_ESCAPED, MODE_CLOSING_QUOTE);
            }
            if (this.shouldStop()) {
                break;
            }
            pattern.next();
        }

        this.addTextLiteralIfNecessary();
        return this.components;
    }

    private final static int MODE_NORMAL = 1;
    private final static int MODE_ESCAPED = 2;
    private final static int MODE_CLOSING_QUOTE = 3;

    /**
     * Handles a non character literal.
     */
    abstract void handle(final char c);

    /**
     * Returns true if this parser should ignore any extra charactes and stop immediately.
     */
    abstract boolean shouldStop();

    /**
     * Handles currency symbols in a pattern, including detection of double currency symbol and transforming that into the international sign.
     */
    final void currency() {
        final List<DecimalFormatPatternComponent> components = this.components;
        final int last = components.size() - 1;

        final boolean currency;
        if (last >= 0) {
            currency = components.get(last) instanceof DecimalFormatPatternComponentCurrencySign;
            if (currency) {
                components.remove(last); // will be replaced by currencyInternationalSign in #addComponent
            }
        } else {
            currency = false;
        }

        this.addComponent(currency ?
                DecimalFormatPatternComponent.currencyInternationalSign() :
                DecimalFormatPatternComponent.currencySign());
    }

    final void minusSign() {
        this.addComponent(DecimalFormatPatternComponent.minusSign());
    }

    // multipliers......................................................................................................

    final void percent() {
        this.setMultiplier(DecimalFormatPatternComponent.PERCENT_MULTIPLIER, DecimalFormatPatternComponent.percent());
    }

    final void perMille() {
        this.setMultiplier(DecimalFormatPatternComponent.PER_MILLE_MULTIPLIER, DecimalFormatPatternComponent.perMille());
    }

    private void setMultiplier(final int multiplier,
                               final DecimalFormatPatternComponent component) {
        if (DecimalFormatPatternComponent.DEFAULT_MULTIPLIER != this.multiplier) {
            this.pattern.failInvalidCharacter();
        }
        this.multiplier = multiplier;
        this.addComponent(component);
    }

    private int multiplier = DecimalFormatPatternComponent.DEFAULT_MULTIPLIER;

    // text literal.....................................................................................................

    final void addCharacterLiteral() {
        this.addCharacterLiteral(this.pattern.charAt());
    }

    final void addCharacterLiteral(final char c) {
        this.textLiteral.append(c);
    }

    /**
     * Checks if a text literal is being built and adds it if present.
     */
    final void addTextLiteralIfNecessary() {
        final StringBuilder textLiteral = this.textLiteral;

        if (textLiteral.length() > 0) {
            this.components.add(DecimalFormatPatternComponent.textLiteral(textLiteral.toString()));

            textLiteral.setLength(0);
        }
    }

    /**
     * Used to collect one or more charater literals.
     */
    private final StringBuilder textLiteral = new StringBuilder();

    // component........................................................................................................

    /**
     * Used to detect duplicate percent signs and similar.
     */
    final void addComponentFailDuplicate(final DecimalFormatPatternComponent component) {
        if (this.components.contains(component)) {
            this.pattern.failInvalidCharacter();
        }
        this.addComponent(component);
    }

    final void addComponent(final DecimalFormatPatternComponent component) {
        this.addTextLiteralIfNecessary();
        this.components.add(component);
    }

    /**
     * Contains the translated pattern into components in order.
     */
    final List<DecimalFormatPatternComponent> components = Lists.array();


    /**
     * The pattern being parsed
     */
    final DecimalFormatPatternParserTextCursor pattern;

    // Object...........................................................................................................

    @Override
    public String toString() {
        return this.pattern + " " + this.components.toString();
    }
}
