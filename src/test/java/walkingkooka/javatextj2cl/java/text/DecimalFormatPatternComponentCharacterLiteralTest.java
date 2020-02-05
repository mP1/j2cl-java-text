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

import org.junit.jupiter.api.Test;
import walkingkooka.HashCodeEqualsDefinedTesting2;

public final class DecimalFormatPatternComponentCharacterLiteralTest extends DecimalFormatPatternComponentTestCase<DecimalFormatPatternComponentCharacterLiteral>
        implements HashCodeEqualsDefinedTesting2<DecimalFormatPatternComponentCharacterLiteral> {

    @Test
    public void testIsCurrency() {
        this.isCurrencyAndCheck(DecimalFormatPatternComponentCharacterLiteral.with('A'), false);
    }

    @Test
    public void testDifferentCase() {
        this.checkNotEquals(DecimalFormatPatternComponentCharacterLiteral.with('a'));
    }

    @Test
    public void testToStringNonStandard() {
        this.toStringAndCheck('A', "A");
    }

    @Test
    public void testToStringCurrency() {
        this.toStringAndCheck(DecimalFormat.CURRENCY, "'" + DecimalFormat.CURRENCY + "'");
    }

    @Test
    public void testToStringDecimalSeparator() {
        this.toStringAndCheck('.', "'.'");
    }

    @Test
    public void testToStringExponent() {
        this.toStringAndCheck('E', "'E'");
    }

    @Test
    public void testToStringGroupingSeparator() {
        this.toStringAndCheck(',', "','");
    }

    @Test
    public void testToStringHash() {
        this.toStringAndCheck('#', "'#'");
    }

    @Test
    public void testToStringMinusSign() {
        this.toStringAndCheck('-', "'-'");
    }

    @Test
    public void testToStringPercent() {
        this.toStringAndCheck('%', "'%'");
    }

    @Test
    public void testToStringPerMille() {
        this.toStringAndCheck('\u2030', "'\u2030'");
    }

    @Test
    public void testToStringQuote() {
        this.toStringAndCheck(DecimalFormat.QUOTE, "''");
    }

    @Test
    public void testToStringZero() {
        this.toStringAndCheck('0', "'0'");
    }

    private void toStringAndCheck(final char value,
                                  final String toString) {
        this.toStringAndCheck(DecimalFormatPatternComponentCharacterLiteral.with(value), toString);
    }

    @Override
    public Class<DecimalFormatPatternComponentCharacterLiteral> type() {
        return DecimalFormatPatternComponentCharacterLiteral.class;
    }

    // HashCodeEqualsDefinedTesting2....................................................................................

    @Override
    public DecimalFormatPatternComponentCharacterLiteral createObject() {
        return DecimalFormatPatternComponentCharacterLiteral.with('A');
    }
}
