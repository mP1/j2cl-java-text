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
 * The only non singleton component and holds a single character
 */
final class DecimalFormatPatternComponentCharacterLiteral extends DecimalFormatPatternComponent {

    /**
     * Factory that creates a character literal.
     */
    final static DecimalFormatPatternComponentCharacterLiteral with(final char value) {
        return new DecimalFormatPatternComponentCharacterLiteral(value);
    }

    private DecimalFormatPatternComponentCharacterLiteral(final char value) {
        super();
        this.value = value;
    }

    private final char value;

    @Override
    boolean isCurrency() {
        return false;
    }

    @Override
    int multiplier() {
        return 0;
    }

    // Object...........................................................................................................

    @Override
    public int hashCode() {
        return Character.hashCode(this.value);
    }

    @Override
    public boolean equals(final Object other) {
        return this == other || other instanceof DecimalFormatPatternComponentCharacterLiteral && this.equals0((DecimalFormatPatternComponentCharacterLiteral) other);
    }

    private boolean equals0(final DecimalFormatPatternComponentCharacterLiteral other) {
        return this.value == other.value;
    }

    @Override
    public String toString() {
        final char value = this.value;
        final String toString;

        switch (value) {
            case DecimalFormat.QUOTE:
                toString = "''";
                break;
            case DecimalFormat.CURRENCY:
            case DecimalFormat.DECIMAL_SEPARATOR:
            case DecimalFormat.DIGIT:
            case DecimalFormat.DIGIT_ZERO:
            case DecimalFormat.EXPONENT:
            case DecimalFormat.GROUPING_SEPARATOR:
            case DecimalFormat.MINUS_SIGN:
            case DecimalFormat.PERCENT:
            case DecimalFormat.PER_MILLE:
                toString = "'" + value + "'";
                break;
            default:
                toString = String.valueOf(value);
                break;
        }

        return toString;
    }
}