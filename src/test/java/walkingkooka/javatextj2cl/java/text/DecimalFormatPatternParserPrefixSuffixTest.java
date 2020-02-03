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

import java.util.Locale;

public final class DecimalFormatPatternParserPrefixSuffixTest extends DecimalFormatPatternParserTestCase<DecimalFormatPatternParserPrefixSuffix> {

    // prefix mode, decimalSeparator/digit/digitZero/exponen are literals................................................

    @Test
    public void testPrefixCurrency() {
        this.parsePrefixAndCheck("" + CURRENCY,
                DecimalFormatPatternComponent.currencySign());
    }

    @Test
    public void testPrefixCurrencyCurrency() {
        this.parsePrefixAndCheck("" + CURRENCY + CURRENCY,
                DecimalFormatPatternComponent.currencyInternationalSign());
    }

    @Test
    public void testPrefixCurrencyCurrencyCurrency() {
        this.parsePrefixAndCheck("" + CURRENCY + CURRENCY + CURRENCY,
                DecimalFormatPatternComponent.currencyInternationalSign(),
                DecimalFormatPatternComponent.currencySign());
    }

    @Test
    public void testPrefixDecimalSeparator() {
        final char c = DecimalFormat.DECIMAL_SEPARATOR;

        this.parsePrefixAndCheck("" + c,
                "" + c);
    }

    @Test
    public void testPrefixDigit() {
        final char c = DecimalFormat.DIGIT;

        this.parsePrefixAndCheck("" + c,
                "" + c);
    }

    @Test
    public void testPrefixDigitZero() {
        final char c = DecimalFormat.DIGIT_ZERO;

        this.parsePrefixAndCheck("" + c,
                "" + c);
    }

    @Test
    public void testPrefixExponent() {
        final char c = DecimalFormat.EXPONENT;

        this.parsePrefixAndCheck("" + c,
                DecimalFormatPatternComponent.characterLiteral(c));
    }

    @Test
    public void testPrefixGroupingSeparator() {
        final char c = DecimalFormat.GROUPING_SEPARATOR;

        this.parsePrefixAndCheck("" + c,
                "" + c);
    }

    @Test
    public void testPrefixMinusSign() {
        final char c = DecimalFormat.MINUS_SIGN;

        this.parsePrefixAndCheck("" + c,
                DecimalFormatPatternComponent.minusSign());
    }

    @Test
    public void testPrefixNonSpecial() {
        this.parsePrefixAndCheck("A",
                DecimalFormatPatternComponent.characterLiteral('A'));
    }

    @Test
    public void testPrefixNonSpecial2() {
        this.parsePrefixAndCheck("AB",
                DecimalFormatPatternComponent.characterLiteral('A'),
                DecimalFormatPatternComponent.characterLiteral('B'));
    }

    @Test
    public void testPrefixPercent() {
        final char c = DecimalFormat.PERCENT;
        this.parsePrefixAndCheck("" + c,
                DecimalFormatPatternComponent.percent());
    }

    @Test
    public void testPrefixPerMille() {
        final char c = DecimalFormat.PER_MILLE;
        this.parsePrefixAndCheck("" + c,
                DecimalFormatPatternComponent.perMille());
    }

    @Test
    public void testPrefixQuote() {
        this.parsePrefixAndCheck("''",
                DecimalFormatPatternComponent.characterLiteral('\''));
    }

    @Test
    public void testPrefixQuotedDigit() {
        final char c = DecimalFormat.DIGIT;
        this.parsePrefixAndCheck("\'" + c + "\'",
                DecimalFormatPatternComponent.characterLiteral(c));
    }

    @Test
    public void testPrefixQuotedZero() {
        final char c = DecimalFormat.DIGIT_ZERO;
        this.parsePrefixAndCheck("\'" + c + "\'",
                DecimalFormatPatternComponent.characterLiteral(c));
    }

    @Test
    public void testPrefixMixed() {
        this.parsePrefixAndCheck("ABC % ",
                DecimalFormatPatternComponent.characterLiteral('A'),
                DecimalFormatPatternComponent.characterLiteral('B'),
                DecimalFormatPatternComponent.characterLiteral('C'),
                DecimalFormatPatternComponent.characterLiteral(' '),
                DecimalFormatPatternComponent.percent(),
                DecimalFormatPatternComponent.characterLiteral(' '));
    }

    @Test
    public void testPrefixMixed2() {
        this.parsePrefixAndCheck("ABC % " + CURRENCY + CURRENCY,
                DecimalFormatPatternComponent.characterLiteral('A'),
                DecimalFormatPatternComponent.characterLiteral('B'),
                DecimalFormatPatternComponent.characterLiteral('C'),
                DecimalFormatPatternComponent.characterLiteral(' '),
                DecimalFormatPatternComponent.percent(),
                DecimalFormatPatternComponent.characterLiteral(' '),
                DecimalFormatPatternComponent.currencyInternationalSign());
    }

    @Test
    public void testPrefixMixed3IncludesQuoted() {
        this.parsePrefixAndCheck("ABC 'D'",
                DecimalFormatPatternComponent.characterLiteral('A'),
                DecimalFormatPatternComponent.characterLiteral('B'),
                DecimalFormatPatternComponent.characterLiteral('C'),
                DecimalFormatPatternComponent.characterLiteral(' '),
                DecimalFormatPatternComponent.characterLiteral('D'));
    }

    // suffix mode, decimalSeparator/digit/digitZero/exponen are literals................................................

    @Test
    public void testSuffixCurrency() {
        this.parseSuffixAndCheck("" + CURRENCY,
                DecimalFormatPatternComponent.currencySign());
    }

    @Test
    public void testSuffixCurrencyCurrency() {
        this.parseSuffixAndCheck("" + CURRENCY + CURRENCY,
                DecimalFormatPatternComponent.currencyInternationalSign());
    }

    @Test
    public void testSuffixDecimalSeparator() {
        final char c = DecimalFormat.DECIMAL_SEPARATOR;
        this.parseSuffixAndCheck("" + c,
                DecimalFormatPatternComponent.characterLiteral(c));
    }

    @Test
    public void testSuffixDigit() {
        final char c = DecimalFormat.DIGIT;
        this.parseSuffixAndCheck("" + c,
                DecimalFormatPatternComponent.characterLiteral(c));
    }

    @Test
    public void testSuffixDigitZero() {
        final char c = DecimalFormat.DIGIT_ZERO;
        this.parseSuffixAndCheck("" + c,
                DecimalFormatPatternComponent.characterLiteral(c));
    }

    @Test
    public void testSuffixExponent() {
        final char c = DecimalFormat.EXPONENT;
        this.parseSuffixAndCheck("" + c,
                DecimalFormatPatternComponent.characterLiteral(c));
    }

    @Test
    public void testSuffixGroupingSeparator() {
        final char c = DecimalFormat.GROUPING_SEPARATOR;
        this.parseSuffixAndCheck("" + c,
                DecimalFormatPatternComponent.characterLiteral(c));
    }

    @Test
    public void testSuffixMinusSign() {
        final char c = DecimalFormat.MINUS_SIGN;
        this.parseSuffixAndCheck("" + c,
                DecimalFormatPatternComponent.minusSign());
    }

    @Test
    public void testSuffixNonSpecial() {
        this.parseSuffixAndCheck("A",
                DecimalFormatPatternComponent.characterLiteral('A'));
    }

    @Test
    public void testSuffixNonSpecial2() {
        this.parseSuffixAndCheck("AB",
                DecimalFormatPatternComponent.characterLiteral('A'),
                DecimalFormatPatternComponent.characterLiteral('B'));
    }

    @Test
    public void testSuffixPercent() {
        final char c = DecimalFormat.PERCENT;
        this.parseSuffixAndCheck("" + c,
                DecimalFormatPatternComponent.percent());
    }

    @Test
    public void testSuffixPerMille() {
        final char c = DecimalFormat.PER_MILLE;
        this.parseSuffixAndCheck("" + c,
                DecimalFormatPatternComponent.perMille());
    }

    @Test
    public void testSuffixQuote() {
        this.parseSuffixAndCheck("''",
                DecimalFormatPatternComponent.characterLiteral('\''));
    }

    @Test
    public void testSuffixQuotedDigit() {
        final char c = DecimalFormat.DIGIT;
        this.parseSuffixAndCheck("\'" + c + "\'",
                DecimalFormatPatternComponent.characterLiteral(c));
    }

    @Test
    public void testSuffixQuotedZero() {
        final char c = DecimalFormat.DIGIT_ZERO;
        this.parseSuffixAndCheck("\'" + c + "\'",
                DecimalFormatPatternComponent.characterLiteral(c));
    }

    @Test
    public void testSuffixMixed() {
        this.parseSuffixAndCheck("ABC % ",
                DecimalFormatPatternComponent.characterLiteral('A'),
                DecimalFormatPatternComponent.characterLiteral('B'),
                DecimalFormatPatternComponent.characterLiteral('C'),
                DecimalFormatPatternComponent.characterLiteral(' '),
                DecimalFormatPatternComponent.percent(),
                DecimalFormatPatternComponent.characterLiteral(' '));
    }

    @Test
    public void testSuffixMixed2() {
        this.parseSuffixAndCheck("ABC % " + CURRENCY + CURRENCY,
                DecimalFormatPatternComponent.characterLiteral('A'),
                DecimalFormatPatternComponent.characterLiteral('B'),
                DecimalFormatPatternComponent.characterLiteral('C'),
                DecimalFormatPatternComponent.characterLiteral(' '),
                DecimalFormatPatternComponent.percent(),
                DecimalFormatPatternComponent.characterLiteral(' '),
                DecimalFormatPatternComponent.currencyInternationalSign());
    }

    @Test
    public void testSuffixMixed3IncludesQuoted() {
        this.parseSuffixAndCheck("ABC 'D'",
                DecimalFormatPatternComponent.characterLiteral('A'),
                DecimalFormatPatternComponent.characterLiteral('B'),
                DecimalFormatPatternComponent.characterLiteral('C'),
                DecimalFormatPatternComponent.characterLiteral(' '),
                DecimalFormatPatternComponent.characterLiteral('D'));
    }

    // helpers..........................................................................................................

    @Override
    DecimalFormatPatternParserPrefixSuffix createParser(final DecimalFormatPatternParserTextCursor pattern) {
        return DecimalFormatPatternParserPrefixSuffix.with(pattern, true);
    }

    private void parsePrefixAndCheck(final String text,
                                     final DecimalFormatPatternComponent... components) {
        this.parsePrefixAndCheck(text,
                "",
                components);
    }

    private void parsePrefixAndCheck(final String text,
                                     final String left,
                                     final DecimalFormatPatternComponent... components) {
        Locale.setDefault(Locale.forLanguageTag("EN-AU"));

        final String prefix = text.substring(0, text.length() - left.length());
        this.checkPositivePrefix(prefix,
                prefix.replace("''", "'")
                        .replace("\'D\'", "D")
                        .replace("\'#\'", "#")
                        .replace("\'0\'", "0")
                        .replace("" + CURRENCY + CURRENCY, "AUD")
                        .replace("" + CURRENCY, "$"));

        this.parseAndCheck(DecimalFormatPatternParserPrefixSuffix.with(DecimalFormatPatternParserTextCursor.with(text, 0), true),
                left,
                components);
    }

    private void parseSuffixAndCheck(final String text,
                                     final DecimalFormatPatternComponent... components) {
        this.parseAndCheck(DecimalFormatPatternParserPrefixSuffix.with(DecimalFormatPatternParserTextCursor.with(text, 0), false),
                "",
                components);
    }

    // ClassTesting.....................................................................................................

    @Override
    public Class<DecimalFormatPatternParserPrefixSuffix> type() {
        return DecimalFormatPatternParserPrefixSuffix.class;
    }
}
