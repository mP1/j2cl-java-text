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

public final class DecimalFormatPatternParserPrefixSuffixTest extends DecimalFormatPatternParserTestCase<DecimalFormatPatternParserPrefixSuffix> {

    @Test
    public void testCurrency() {
        this.parseAndCheck("" + CURRENCY,
                DecimalFormatPatternComponent.currencySign());
    }

    @Test
    public void testCurrencyCurrency() {
        this.parseAndCheck("" + CURRENCY + CURRENCY,
                DecimalFormatPatternComponent.currencyInternationalSign());
    }

    @Test
    public void testDecimalSeparator() {
        final char c = DecimalFormat.DECIMAL_SEPARATOR;
        this.parseAndCheck("" + c,
                DecimalFormatPatternComponent.characterLiteral(c));
    }

    @Test
    public void testDigit() {
        final char c = DecimalFormat.DIGIT;
        this.parseAndCheck("" + c,
                DecimalFormatPatternComponent.characterLiteral(c));
    }

    @Test
    public void testDigitZero() {
        final char c = DecimalFormat.DIGIT_ZERO;
        this.parseAndCheck("" + c,
                DecimalFormatPatternComponent.characterLiteral(c));
    }

    @Test
    public void testExponent() {
        final char c = DecimalFormat.EXPONENT;
        this.parseAndCheck("" + c,
                DecimalFormatPatternComponent.characterLiteral(c));
    }

    @Test
    public void testGroupingSeparator() {
        final char c = DecimalFormat.GROUPING_SEPARATOR;
        this.parseAndCheck("" + c,
                DecimalFormatPatternComponent.characterLiteral(c));
    }

    @Test
    public void testMinusSign() {
        final char c = DecimalFormat.MINUS_SIGN;
        this.parseAndCheck("" + c,
                DecimalFormatPatternComponent.minusSign());
    }

    @Test
    public void testNonSpecial() {
        this.parseAndCheck("A",
                DecimalFormatPatternComponent.characterLiteral('A'));
    }

    @Test
    public void testNonSpecial2() {
        this.parseAndCheck("AB",
                DecimalFormatPatternComponent.characterLiteral('A'),
                DecimalFormatPatternComponent.characterLiteral('B'));
    }

    @Test
    public void testPercent() {
        final char c = DecimalFormat.PERCENT;
        this.parseAndCheck("" + c,
                DecimalFormatPatternComponent.percent());
    }

    @Test
    public void testPerMille() {
        final char c = DecimalFormat.PER_MILLE;
        this.parseAndCheck("" + c,
                DecimalFormatPatternComponent.perMille());
    }

    @Test
    public void testQuote() {
        this.parseAndCheck("''",
                DecimalFormatPatternComponent.characterLiteral('\''));
    }

    @Test
    public void testQuotedDigit() {
        final char c = DecimalFormat.DIGIT;
        this.parseAndCheck("\'" + c + "\'",
                DecimalFormatPatternComponent.characterLiteral(c));
    }

    @Test
    public void testQuotedZero() {
        final char c = DecimalFormat.DIGIT_ZERO;
        this.parseAndCheck("\'" + c + "\'",
                DecimalFormatPatternComponent.characterLiteral(c));
    }

    @Test
    public void testMixed() {
        this.parseAndCheck("ABC % ",
                DecimalFormatPatternComponent.characterLiteral('A'),
                DecimalFormatPatternComponent.characterLiteral('B'),
                DecimalFormatPatternComponent.characterLiteral('C'),
                DecimalFormatPatternComponent.characterLiteral(' '),
                DecimalFormatPatternComponent.percent(),
                DecimalFormatPatternComponent.characterLiteral(' '));
    }

    @Test
    public void testMixed2() {
        this.parseAndCheck("ABC % " + CURRENCY + CURRENCY,
                DecimalFormatPatternComponent.characterLiteral('A'),
                DecimalFormatPatternComponent.characterLiteral('B'),
                DecimalFormatPatternComponent.characterLiteral('C'),
                DecimalFormatPatternComponent.characterLiteral(' '),
                DecimalFormatPatternComponent.percent(),
                DecimalFormatPatternComponent.characterLiteral(' '),
                DecimalFormatPatternComponent.currencyInternationalSign());
    }

    @Test
    public void testMixed3IncludesQuoted() {
        this.parseAndCheck("ABC 'D'",
                DecimalFormatPatternComponent.characterLiteral('A'),
                DecimalFormatPatternComponent.characterLiteral('B'),
                DecimalFormatPatternComponent.characterLiteral('C'),
                DecimalFormatPatternComponent.characterLiteral(' '),
                DecimalFormatPatternComponent.characterLiteral('D'));
    }

    // helpers..........................................................................................................

    @Override
    DecimalFormatPatternParserPrefixSuffix createParser(final String pattern,
                                                        final int position) {
        return DecimalFormatPatternParserPrefixSuffix.with(pattern, position);
    }

    // ClassTesting.....................................................................................................

    @Override
    public Class<DecimalFormatPatternParserPrefixSuffix> type() {
        return DecimalFormatPatternParserPrefixSuffix.class;
    }
}
