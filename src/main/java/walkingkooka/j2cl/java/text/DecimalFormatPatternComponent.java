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

package walkingkooka.j2cl.java.text;

/**
 * Base class for all components belonging to a {@link DecimalFormat} pattern.
 */
abstract class DecimalFormatPatternComponent {

    final static int DEFAULT_MULTIPLIER = 1;

    final static int PERCENT_MULTIPLIER = 100;

    final static int PER_MILLE_MULTIPLIER = 1000;

    /**
     * {@see DecimalFormatPatternComponentCharacterLiteral}
     */
    static DecimalFormatPatternComponent characterLiteral(final char value) {
        return DecimalFormatPatternComponentCharacterLiteral.with(value);
    }

    /**
     * {@see DecimalFormatPatternComponentCurrencySeparator}
     */
    static DecimalFormatPatternComponent currencySeparator() {
        return DecimalFormatPatternComponentCurrencySeparator.INSTANCE;
    }

    /**
     * {@see DecimalFormatPatternComponentCurrencySign}
     */
    static DecimalFormatPatternComponent currencySign() {
        return DecimalFormatPatternComponentCurrencySign.INSTANCE;
    }

    /**
     * {@see DecimalFormatPatternComponentCurrencyInternationalSign}
     */
    static DecimalFormatPatternComponent currencyInternationalSign() {
        return DecimalFormatPatternComponentCurrencyInternationalSign.INSTANCE;
    }

    /**
     * {@see DecimalFormatPatternComponentDecimalSeparator}
     */
    static DecimalFormatPatternComponent decimalSeparator() {
        return DecimalFormatPatternComponentDecimalSeparator.INSTANCE;
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
     * {@see DecimalFormatPatternComponentHash}
     */
    static DecimalFormatPatternComponent hash() {
        return DecimalFormatPatternComponentHash.INSTANCE;
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
     * {@see DecimalFormatPatternComponentZero}
     */
    static DecimalFormatPatternComponent zero() {
        return DecimalFormatPatternComponentZero.INSTANCE;
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

    public final boolean isCharacterLiteral() {
        return this instanceof DecimalFormatPatternComponentCharacterLiteral;
    }

    public final boolean isCurrencyInternationalSign() {
        return this instanceof DecimalFormatPatternComponentCurrencyInternationalSign;
    }

    public final boolean isCurrencySeparator() {
        return this instanceof DecimalFormatPatternComponentCurrencySeparator;
    }

    public final boolean isCurrencySign() {
        return this instanceof DecimalFormatPatternComponentCurrencySign;
    }

    public final boolean isDecimalSeparator() {
        return this instanceof DecimalFormatPatternComponentDecimalSeparator;
    }

    public final boolean isExponent() {
        return this instanceof DecimalFormatPatternComponentExponent;
    }

    /**
     * Only {@link DecimalFormatPatternComponentGroupingSeparator} returns true.
     */
    public final boolean isGroupingSeparator() {
        return this instanceof DecimalFormatPatternComponentGroupingSeparator;
    }

    /**
     * Only {@link DecimalFormatPatternComponentHash} returns true.
     */
    public final boolean isHash() {
        return this instanceof DecimalFormatPatternComponentHash;
    }

    /**
     * Only {@link DecimalFormatPatternComponentHash} or {@link DecimalFormatPatternComponentZero} returns true.
     */
    final boolean isHashOrZero() {
        return this.isHash() || this.isZero();
    }

    public final boolean isMinusSign() {
        return this instanceof DecimalFormatPatternComponentMinusSign;
    }

    public final boolean isPercent() {
        return this instanceof DecimalFormatPatternComponentPercent;
    }

    public final boolean isPerMille() {
        return this instanceof DecimalFormatPatternComponentPerMille;
    }

    /**
     * Only {@link DecimalFormatPatternComponentZero} returns true.
     */
    public final boolean isZero() {
        return this instanceof DecimalFormatPatternComponentZero;
    }

    /**
     * All components except for percent and permill will return 1.
     */
    abstract int multiplier();

    /**
     * Used to materialise this component into the {@link String} form for a prefix or suffix.
     */
    abstract void toPattern(final StringBuilder pattern);

    /**
     * Used to materialise this component into the {@link String} form for a prefix or suffix.
     */
    abstract void toPatternLocalized(final DecimalFormatSymbols symbols,
                                     final StringBuilder pattern);

    @Override
    public abstract String toString();
}
