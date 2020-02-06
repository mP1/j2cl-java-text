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

import java.util.List;

/**
 * Base class for serveral parsers that handle prefix, number and suffix.
 */
abstract class DecimalFormatPatternParser {

    DecimalFormatPatternParser(final String pattern,
                               final int position) {
        super();
        this.pattern = pattern;
        this.position = position;
    }

    /**
     * Parses the pattern text into its equivalent pattern components.
     */
    final void parse() {
        final String pattern = this.pattern;
        int escapedMode = MODE_NORMAL;

        while (this.position < pattern.length()) {
            final char c = pattern.charAt(this.position);

            switch (escapedMode) {
                case MODE_NORMAL:
                    if (DecimalFormat.QUOTE == c) {
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
                        this.failInvalidCharacter();
                    }
                    escapedMode = MODE_NORMAL;
                    break;
                default:
                    NeverError.unhandledCase(escapedMode, MODE_NORMAL, MODE_ESCAPED, MODE_CLOSING_QUOTE);
            }
            if (this.isFinished()) {
                break;
            }
            this.position++;
        }

        if(MODE_CLOSING_QUOTE == escapedMode) {
            this.failInvalidCharacter(this.position -1);
        }

        this.onComplete();
    }

    private final static int MODE_NORMAL = 1;
    private final static int MODE_ESCAPED = 2;
    private final static int MODE_CLOSING_QUOTE = 3;

    /**
     * Handles a non character literal.
     */
    abstract void handle(final char c);

    /**
     * Provides a way for sub pattern separators to terminate parsing early.
     */
    abstract boolean isFinished();

    /**
     * Called when parsing is complete.
     */
    abstract void onComplete();

    /**
     * Handles currency symbols in a pattern, including detection of double currency symbol and transforming that into the international sign.
     */
    final void currency() {
        final List<DecimalFormatPatternComponent> components = this.nonNumberComponents();
        final int last = components.size() - 1;

        final boolean currency;
        if (last >= 0) {
            currency = components.get(last) instanceof DecimalFormatPatternComponentCurrencySign;
            if (currency) {
                components.remove(last); // will be replaced by currencyInternationalSign in #addNonNumberComponent
            }
        } else {
            currency = false;
        }

        this.addNonNumberComponent(currency ?
                DecimalFormatPatternComponent.currencyInternationalSign() :
                DecimalFormatPatternComponent.currencySign());
        this.currency = true;
    }

    final void minusSign() {
        this.addNonNumberComponent(DecimalFormatPatternComponent.minusSign());
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
            this.failInvalidCharacter();
        }
        this.multiplier = multiplier;
        this.addNonNumberComponent(component);
    }

    int multiplier = DecimalFormatPatternComponent.DEFAULT_MULTIPLIER;

    // text literal.....................................................................................................

    /**
     * Adds a character literal to the components being captured.
     */
    final void addCharacterLiteral(final char c) {
        this.addNonNumberComponent(DecimalFormatPatternComponent.characterLiteral(c));
    }

    // component........................................................................................................

    abstract void addNonNumberComponent(final DecimalFormatPatternComponent component);

    abstract List<DecimalFormatPatternComponent> nonNumberComponents();

    /**
     * Used to report an invalid pattern character.
     */
    final void failInvalidCharacter() {
        this.failInvalidCharacter(this.position);
    }

    final void failInvalidCharacter(final int position) {
        throw new InvalidCharacterException(this.pattern, position);
    }

    /**
     * The pattern text being parsed.
     */
    final String pattern;

    /**
     * Points to the current character in the pattern. This is used to build fail messages.
     */
    int position;

    /**
     * Becomes true when a currency symbol is encountered. This will trigger replacing decimalSeparator with currencySeparator.
     */
    boolean currency;
}
