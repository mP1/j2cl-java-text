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

/**
 * Base class for all components belonging to a {@link DecimalFormat} pattern.
 */
abstract class DecimalFormatPatternComponent {

    final static int PERCENT_MULTIPLIER = 100;

    final static int PER_MILLE_MULTIPLIER = 1000;

    /**
     * {@see DecimalFormatPatternComponentCurrencySeparator}
     */
    static DecimalFormatPatternComponent currencySeparator() {
        return DecimalFormatPatternComponentCurrencySeparator.INSTANCE;
    }

    /**
     * {@see DecimalFormatPatternComponentDecimalSeparator}
     */
    static DecimalFormatPatternComponent decimalSeparator() {
        return DecimalFormatPatternComponentDecimalSeparator.INSTANCE;
    }

    /**
     * {@see DecimalFormatPatternComponentDigit}
     */
    static DecimalFormatPatternComponent digit() {
        return DecimalFormatPatternComponentDigit.INSTANCE;
    }

    /**
     * {@see DecimalFormatPatternComponentDigitZero}
     */
    static DecimalFormatPatternComponent digitZero() {
        return DecimalFormatPatternComponentDigitZero.INSTANCE;
    }

    /**
     * {@see DecimalFormatPatternComponentExponent}
     */
    static DecimalFormatPatternComponent exponent() {
        return DecimalFormatPatternComponentExponent.INSTANCE;
    }

    /**
     * {@see DecimalFormatPatternComponentGroupingSeparator}
     */
    static DecimalFormatPatternComponent groupingSeparator() {
        return DecimalFormatPatternComponentGroupingSeparator.INSTANCE;
    }

    /**
     * {@see DecimalFormatPatternComponentMinusSign}
     */
    static DecimalFormatPatternComponent minusSign() {
        return DecimalFormatPatternComponentMinusSign.INSTANCE;
    }

    /**
     * {@see DecimalFormatPatternComponentPercent}
     */
    static DecimalFormatPatternComponent percent() {
        return DecimalFormatPatternComponentPercent.INSTANCE;
    }

    /**
     * {@see DecimalFormatPatternComponentPerMille}
     */
    static DecimalFormatPatternComponent perMille() {
        return DecimalFormatPatternComponentPerMille.INSTANCE;
    }

    /**
     * {@see DecimalFormatPatternComponentSubpatternSeparator}
     */
    static DecimalFormatPatternComponent subpatternSeparator() {
        return DecimalFormatPatternComponentSubpatternSeparator.INSTANCE;
    }

    /**
     * {@see DecimalFormatPatternComponentTextLiteral}
     */
    static DecimalFormatPatternComponent textLiteral(final String text) {
        return DecimalFormatPatternComponentTextLiteral.with(text);
    }

    /**
     * Package private to limit sub classing.
     */
    DecimalFormatPatternComponent() {
        super();
    }

    /**
     * Returns true if this symbol makes this pattern a currency format pattern.
     */
    abstract boolean isCurrency();

    /**
     * All components except for percent and permill will return 1.
     */
    abstract int multiplier();

    @Override
    public abstract String toString();
}
