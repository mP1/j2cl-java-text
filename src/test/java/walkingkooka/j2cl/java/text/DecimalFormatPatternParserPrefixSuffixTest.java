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

import org.junit.jupiter.api.Test;
import walkingkooka.collect.list.Lists;
import walkingkooka.text.CharSequences;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class DecimalFormatPatternParserPrefixSuffixTest extends DecimalFormatPatternParserTestCase<DecimalFormatPatternParserPrefixSuffix> {

    @Test
    public void testCurrency() {
        this.parseSpecialAndCheck(DecimalFormat.CURRENCY);
    }

    @Test
    public void testCurrencyCurrency() {
        this.parseAndCheck("" + CURRENCY + CURRENCY,
                DecimalFormatPatternComponent.characterLiteral(DecimalFormat.QUOTE), DecimalFormatPatternComponent.characterLiteral(CURRENCY), DecimalFormatPatternComponent.characterLiteral(DecimalFormat.QUOTE),
                DecimalFormatPatternComponent.characterLiteral(DecimalFormat.QUOTE), DecimalFormatPatternComponent.characterLiteral(CURRENCY), DecimalFormatPatternComponent.characterLiteral(DecimalFormat.QUOTE));
    }

    @Test
    public void testDecimalSeparator() {
        this.parseSpecialAndCheck(DecimalFormat.DECIMAL_SEPARATOR);
    }

    @Test
    public void testExponent() {
        this.parseAndCheck("" + DecimalFormatPatternComponent.exponent(),
                DecimalFormatPatternComponent.exponent());
    }

    @Test
    public void testGroupingSeparator() {
        this.parseSpecialAndCheck(DecimalFormat.GROUPING_SEPARATOR);
    }

    @Test
    public void testHash() {
        this.parseSpecialAndCheck(DecimalFormat.HASH);
    }

    @Test
    public void testMinusSign() {
        this.parseSpecialAndCheck(DecimalFormat.MINUS_SIGN);
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
        this.parseSpecialAndCheck(DecimalFormat.PERCENT);
    }

    @Test
    public void testPerMille() {
        this.parseSpecialAndCheck(DecimalFormat.PER_MILLE);
    }

    @Test
    public void testQuote() {
        this.parseAndCheck("''",
                DecimalFormatPatternComponent.characterLiteral('\''));
    }

    @Test
    public void testQuotedHash() {
        final char c = DecimalFormat.HASH;
        this.parseAndCheck("\'" + c + "\'",
                DecimalFormatPatternComponent.characterLiteral(c));
    }

    @Test
    public void testSubPatternSeparator() {
        this.parseSpecialAndCheck(DecimalFormat.SUB_PATTERN_SEPARATOR);
    }

    @Test
    public void testQuotedZero() {
        final char c = DecimalFormat.ZERO;
        this.parseAndCheck("\'" + c + "\'",
                DecimalFormatPatternComponent.characterLiteral(c));
    }

    @Test
    public void testZero() {
        this.parseSpecialAndCheck(DecimalFormat.ZERO);
    }

    @Test
    public void testMixed() {
        this.parseAndCheck("ABC ",
                DecimalFormatPatternComponent.characterLiteral('A'),
                DecimalFormatPatternComponent.characterLiteral('B'),
                DecimalFormatPatternComponent.characterLiteral('C'),
                DecimalFormatPatternComponent.characterLiteral(' '));
    }

    @Test
    public void testMixedIncludesQuoted() {
        this.parseAndCheck("ABC 'D'",
                DecimalFormatPatternComponent.characterLiteral('A'),
                DecimalFormatPatternComponent.characterLiteral('B'),
                DecimalFormatPatternComponent.characterLiteral('C'),
                DecimalFormatPatternComponent.characterLiteral(' '),
                DecimalFormatPatternComponent.characterLiteral('D'));
    }

    // toString.........................................................................................................

    @Test
    public void testToString() {
        final DecimalFormatPatternParserPrefixSuffix parser = this.createParser("prefix 123");
        parser.parse();

        this.toStringAndCheck(parser, "10 p, r, e, f, i, x,  , 1, 2, 3");
    }

    // helpers..........................................................................................................

    @Override
    DecimalFormatPatternParserPrefixSuffix createParser(final String pattern,
                                                        final int position) {
        return DecimalFormatPatternParserPrefixSuffix.with(pattern, position);
    }

    private void parseSpecialAndCheck(final char c) {
        this.parseAndCheck("" + c,
                DecimalFormatPatternComponentCharacterLiteral.characterLiteral(DecimalFormat.QUOTE), DecimalFormatPatternComponent.characterLiteral(c), DecimalFormatPatternComponentCharacterLiteral.characterLiteral(DecimalFormat.QUOTE));
    }

    private void parseAndCheck(final String text,
                               final DecimalFormatPatternComponent... components) {
        this.parseAndCheck(this.createParser(text, 0),
                components);
    }

    private void parseAndCheck(final DecimalFormatPatternParserPrefixSuffix parser,
                               final DecimalFormatPatternComponent... components) {
        parser.parse();

        final String pattern = parser.pattern;
        assertEquals(Lists.of(components),
                parser.components,
                "components parse " + CharSequences.quoteAndEscape(pattern));

        assertEquals(Lists.of(components),
                DecimalFormatPatternParserPrefixSuffix.parseAndGetComponents(pattern, "pattern"),
                "parseAndGetComponents " + CharSequences.quoteAndEscape(pattern));
    }

    // ClassTesting.....................................................................................................

    @Override
    public Class<DecimalFormatPatternParserPrefixSuffix> type() {
        return DecimalFormatPatternParserPrefixSuffix.class;
    }
}
