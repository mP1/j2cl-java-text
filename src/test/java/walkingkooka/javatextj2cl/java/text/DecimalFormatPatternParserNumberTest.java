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

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import walkingkooka.collect.list.Lists;
import walkingkooka.text.CharSequences;

import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public final class DecimalFormatPatternParserNumberTest extends DecimalFormatPatternParserTestCase<DecimalFormatPatternParserNumber> {

    private final static Locale LOCALE = Locale.forLanguageTag("en-AU");

    @BeforeAll
    public static void before() {
        Locale.setDefault(LOCALE);
    }

    // currency.........................................................................................................

    @Test
    public void testCurrency() {
        this.parseNumberAndCheck("" + DecimalFormat.CURRENCY,
                list(DecimalFormatPatternComponent.currencySign()),
                list(DecimalFormatPatternComponent.hash()),
                NO_COMPONENTS);
    }

    @Test
    public void testCurrencyCurrency() {
        this.parseNumberAndCheck("" + DecimalFormat.CURRENCY + DecimalFormat.CURRENCY,
                list(DecimalFormatPatternComponent.currencyInternationalSign()),
                list(DecimalFormatPatternComponent.hash()),
                NO_COMPONENTS);
    }

    // decimalSeparator.................................................................................................

    @Test
    public void testDecimalSeparator() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.DECIMAL_SEPARATOR);
        this.parseNumberAndCheck(parser,
                DecimalFormatPatternComponent.hash(), DecimalFormatPatternComponent.decimalSeparator());
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.FRACTION);
    }

    @Test
    public void testDecimalSeparatorDecimalSeparatorFails() {
        this.parseFails("..", 1);
    }

    @Test
    public void testDecimalSeparatorZeroDecimalSeparatorFails() {
        this.parseFails(".0.", 2);
    }

    @Test
    public void testDecimalSeparatorCharacterLiteral() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.DECIMAL_SEPARATOR + "A");
        this.parseNumberAndCheck(parser,
                NO_COMPONENTS,
                list(DecimalFormatPatternComponent.hash(), DecimalFormatPatternComponent.decimalSeparator()),
                list(DecimalFormatPatternComponent.characterLiteral('A')));
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.FRACTION);
    }

    @Test
    public void testDecimalSeparatorCurrency() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.DECIMAL_SEPARATOR + DecimalFormat.CURRENCY);
        this.parseNumberAndCheck(parser,
                NO_COMPONENTS,
                list(DecimalFormatPatternComponent.hash(), DecimalFormatPatternComponent.currencySeparator()),
                list(DecimalFormatPatternComponent.currencySign()));
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.FRACTION);
    }

    @Test
    public void testDecimalSeparatorCurrency2() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.HASH + DecimalFormat.DECIMAL_SEPARATOR + DecimalFormat.CURRENCY);
        this.parseNumberAndCheck(parser,
                NO_COMPONENTS,
                list(DecimalFormatPatternComponent.hash(), DecimalFormatPatternComponent.currencySeparator()),
                list(DecimalFormatPatternComponent.currencySign()));
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.FRACTION);
    }

    @Test
    public void testDecimalSeparatorCurrencyWithPrefix() {
        final DecimalFormatPatternParserNumber parser = this.createParser("A" + DecimalFormat.DECIMAL_SEPARATOR + DecimalFormat.CURRENCY);
        this.parseNumberAndCheck(parser,
                list(DecimalFormatPatternComponent.characterLiteral('A')),
                list(DecimalFormatPatternComponent.hash(), DecimalFormatPatternComponent.currencySeparator()),
                list(DecimalFormatPatternComponent.currencySign()));
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.FRACTION);
    }

    @Test
    public void testDecimalSeparatorCurrencyWithPrefix2() {
        final DecimalFormatPatternParserNumber parser = this.createParser("ABC" + DecimalFormat.DECIMAL_SEPARATOR + DecimalFormat.CURRENCY);
        this.parseNumberAndCheck(parser,
                list(DecimalFormatPatternComponent.characterLiteral('A'), DecimalFormatPatternComponent.characterLiteral('B'), DecimalFormatPatternComponent.characterLiteral('C')),
                list(DecimalFormatPatternComponent.hash(), DecimalFormatPatternComponent.currencySeparator()),
                list(DecimalFormatPatternComponent.currencySign()));
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.FRACTION);
    }

    @Test
    public void testDecimalSeparatorExponentFails() {
        this.parseFails("" + DecimalFormat.DECIMAL_SEPARATOR + DecimalFormat.EXPONENT, 1);
    }

    @Test
    public void testDecimalSeparatorExponentZero() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.DECIMAL_SEPARATOR + DecimalFormat.ZERO + DecimalFormat.EXPONENT + DecimalFormat.ZERO);
        this.parseNumberAndCheck(parser,
                DecimalFormatPatternComponent.hash(), DecimalFormatPatternComponent.decimalSeparator(), DecimalFormatPatternComponent.zero(), DecimalFormatPatternComponent.exponent(), DecimalFormatPatternComponent.zero());
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.EXPONENT);
    }

    @Test
    public void testDecimalSeparatorGroupingSeparatorFails() {
        this.parseFails("" + DecimalFormat.DECIMAL_SEPARATOR + DecimalFormat.GROUPING_SEPARATOR, 1);
    }

    @Test
    public void testDecimalSeparatorHash() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.DECIMAL_SEPARATOR + DecimalFormat.HASH);
        this.parseNumberAndCheck(parser,
                DecimalFormatPatternComponent.hash(), DecimalFormatPatternComponent.decimalSeparator(), DecimalFormatPatternComponent.hash());
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.FRACTION);
        this.checkInteger(parser, 0);
        this.checkFraction(parser, 0, 1); // hash is optional
    }

    @Test
    public void testDecimalSeparatorHashCurrency() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.DECIMAL_SEPARATOR + DecimalFormat.HASH + DecimalFormat.CURRENCY);
        this.parseNumberAndCheck(parser,
                NO_COMPONENTS,
                list(DecimalFormatPatternComponent.hash(), DecimalFormatPatternComponent.currencySeparator(), DecimalFormatPatternComponent.hash()),
                list(DecimalFormatPatternComponent.currencySign()));
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.FRACTION);
        this.checkInteger(parser, 0);
        this.checkFraction(parser, 0, 1); // hash is optional
    }

    @Test
    public void testDecimalSeparatorHashCharacterLiteral() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.DECIMAL_SEPARATOR + DecimalFormat.HASH + "A");
        this.parseNumberAndCheck(parser,
                NO_COMPONENTS,
                list(DecimalFormatPatternComponent.hash(), DecimalFormatPatternComponent.decimalSeparator(), DecimalFormatPatternComponent.hash()),
                list(DecimalFormatPatternComponent.characterLiteral('A')));
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.FRACTION);
        this.checkInteger(parser, 0);
        this.checkFraction(parser, 0, 1); // hash is optional
    }

    @Test
    public void testDecimalSeparatorHashCharacterLiteralCurrency() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.DECIMAL_SEPARATOR + DecimalFormat.HASH + "A" + DecimalFormat.CURRENCY);
        this.parseNumberAndCheck(parser,
                NO_COMPONENTS,
                list(DecimalFormatPatternComponent.hash(), DecimalFormatPatternComponent.currencySeparator(), DecimalFormatPatternComponent.hash()),
                list(DecimalFormatPatternComponent.characterLiteral('A'), DecimalFormatPatternComponent.currencySign()));
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.FRACTION);
        this.checkInteger(parser, 0);
        this.checkFraction(parser, 0, 1); // hash is optional
    }

    @Test
    public void testDecimalSeparatorMinus() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.DECIMAL_SEPARATOR + DecimalFormat.MINUS_SIGN);
        this.parseNumberAndCheck(parser,
                NO_COMPONENTS,
                list(DecimalFormatPatternComponent.hash(), DecimalFormatPatternComponent.decimalSeparator()),
                list(DecimalFormatPatternComponent.minusSign()));
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.FRACTION);
        this.checkInteger(parser, 0);
        this.checkFraction(parser, 0, 0);
    }

    @Test
    public void testDecimalSeparatorPercent() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.DECIMAL_SEPARATOR + DecimalFormat.PERCENT);
        this.parseNumberAndCheck(parser,
                NO_COMPONENTS,
                list(DecimalFormatPatternComponent.hash(), DecimalFormatPatternComponent.decimalSeparator()),
                list(DecimalFormatPatternComponent.percent()));
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.FRACTION);
        this.checkInteger(parser, 0);
        this.checkFraction(parser, 0, 0);
    }

    @Test
    public void testDecimalSeparatorPerMille() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.DECIMAL_SEPARATOR + DecimalFormat.PER_MILLE);
        this.parseNumberAndCheck(parser,
                NO_COMPONENTS,
                list(DecimalFormatPatternComponent.hash(), DecimalFormatPatternComponent.decimalSeparator()),
                list(DecimalFormatPatternComponent.perMille()));
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.FRACTION);
        this.checkInteger(parser, 0);
        this.checkFraction(parser, 0, 0);
    }

    @Test
    public void testDecimalSeparatorZero() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.DECIMAL_SEPARATOR + DecimalFormat.ZERO);
        this.parseNumberAndCheck(parser,
                DecimalFormatPatternComponent.hash(), DecimalFormatPatternComponent.decimalSeparator(), DecimalFormatPatternComponent.zero());
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.FRACTION);
        this.checkInteger(parser, 0);
        this.checkFraction(parser, 1, 1); // zero is required
    }

    @Test
    public void testDecimalSeparatorZeroZero() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.DECIMAL_SEPARATOR + DecimalFormat.ZERO + DecimalFormat.ZERO);
        this.parseNumberAndCheck(parser,
                DecimalFormatPatternComponent.hash(), DecimalFormatPatternComponent.decimalSeparator(), DecimalFormatPatternComponent.zero(), DecimalFormatPatternComponent.zero());
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.FRACTION);
        this.checkInteger(parser, 0);
        this.checkFraction(parser, 2, 2); // zero is required
    }

    @Test
    public void testDecimalSeparatorZeroZeroHashHashHash() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.DECIMAL_SEPARATOR + DecimalFormat.ZERO + DecimalFormat.ZERO + DecimalFormat.HASH + DecimalFormat.HASH + DecimalFormat.HASH);
        this.parseNumberAndCheck(parser,
                DecimalFormatPatternComponent.hash(), DecimalFormatPatternComponent.decimalSeparator(), DecimalFormatPatternComponent.zero(), DecimalFormatPatternComponent.zero(), DecimalFormatPatternComponent.hash(), DecimalFormatPatternComponent.hash(), DecimalFormatPatternComponent.hash());
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.FRACTION);
        this.checkInteger(parser, 0);
        this.checkFraction(parser, 2, 5); // zero is required
    }

    @Test
    public void testDecimalSeparatorZeroZeroZero() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.DECIMAL_SEPARATOR + DecimalFormat.ZERO + DecimalFormat.ZERO + DecimalFormat.ZERO);
        this.parseNumberAndCheck(parser,
                DecimalFormatPatternComponent.hash(), DecimalFormatPatternComponent.decimalSeparator(), DecimalFormatPatternComponent.zero(), DecimalFormatPatternComponent.zero(), DecimalFormatPatternComponent.zero());
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.FRACTION);
        this.checkInteger(parser, 0);
        this.checkFraction(parser, 3, 3); // zero is required
    }

    @Test
    public void testDecimalSeparatorZeroDecimalSeparator() {
        this.parseFails("" + DecimalFormat.DECIMAL_SEPARATOR + DecimalFormat.ZERO + DecimalFormat.DECIMAL_SEPARATOR, 2);
    }

    // exponent.........................................................................................................

    @Test
    public void testExponent() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.EXPONENT);
        this.parseNumberAndCheck(parser,
                list(DecimalFormatPatternComponent.characterLiteral(DecimalFormat.EXPONENT)),
                list(DecimalFormatPatternComponent.hash()),
                NO_COMPONENTS);
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.PREFIX);
    }

    @Test
    public void testExponentCharacterLiteralFails() {
        this.parseFails("" + DecimalFormat.HASH + DecimalFormat.EXPONENT + 'A', 2);
    }

    @Test
    public void testExponentDecimalSeparatorFails() {
        this.parseFails("" + DecimalFormat.HASH + DecimalFormat.EXPONENT + DecimalFormat.DECIMAL_SEPARATOR, 2);
    }

    @Test
    public void testExponentExponentFails() {
        this.parseFails("" + DecimalFormat.HASH + DecimalFormat.EXPONENT + DecimalFormat.EXPONENT, 2);
    }

    @Test
    public void testExponentGroupingSeparatorFails() {
        this.parseFails("" + DecimalFormat.HASH + DecimalFormat.EXPONENT + DecimalFormat.GROUPING_SEPARATOR, 2);
    }

    @Test
    public void testExponentHashFails() {
        this.parseFails("" + DecimalFormat.HASH + DecimalFormat.EXPONENT + DecimalFormat.HASH, 2);
    }

    @Test
    public void testExponentQuotedCharacterLiteralFails() {
        this.parseFails("" + DecimalFormat.HASH + DecimalFormat.EXPONENT + "'A'", 1); // should be 2
    }

    @Test
    public void testExponentZero() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.DECIMAL_SEPARATOR + DecimalFormat.ZERO + DecimalFormat.EXPONENT + DecimalFormat.ZERO);
        this.parseNumberAndCheck(parser,
                DecimalFormatPatternComponent.hash(), DecimalFormatPatternComponent.decimalSeparator(), DecimalFormatPatternComponent.zero(), DecimalFormatPatternComponent.exponent(), DecimalFormatPatternComponent.zero());
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.EXPONENT);
        this.checkInteger(parser, 0);
        this.checkFraction(parser, 1, 1);
    }

    @Test
    public void testExponentZeroZero() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.DECIMAL_SEPARATOR + DecimalFormat.ZERO + DecimalFormat.EXPONENT + DecimalFormat.ZERO + DecimalFormat.ZERO);
        this.parseNumberAndCheck(parser,
                DecimalFormatPatternComponent.hash(), DecimalFormatPatternComponent.decimalSeparator(), DecimalFormatPatternComponent.zero(), DecimalFormatPatternComponent.exponent(), DecimalFormatPatternComponent.zero(), DecimalFormatPatternComponent.zero());
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.EXPONENT);
        this.checkInteger(parser, 0);
        this.checkFraction(parser, 1, 1);
    }

    // grouping.........................................................................................................

    @Test
    public void testGroupingSeparatorFails() {
        this.parseFails("" + DecimalFormat.GROUPING_SEPARATOR, 0);
    }

    @Test
    public void testHashGroupingSeparatorFails() {
        this.parseFails("" + DecimalFormat.HASH + DecimalFormat.GROUPING_SEPARATOR, 1);
    }

    @Test
    public void testHashGroupingSeparatorCharacterLiteralFails() {
        this.parseFails("" + DecimalFormat.HASH + DecimalFormat.GROUPING_SEPARATOR + 'A', 1);
    }

    @Test
    public void testHashGroupingSeparatorGroupingSeparatorFails() {
        this.parseFails("" + DecimalFormat.HASH + DecimalFormat.GROUPING_SEPARATOR + 'A' + DecimalFormat.GROUPING_SEPARATOR, 3);
    }

    // hash.............................................................................................................

    @Test
    public void testHash() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.HASH);
        this.parseNumberAndCheck(parser,
                DecimalFormatPatternComponent.hash());
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.INTEGER);
        this.checkInteger(parser, 0);
        this.checkFraction(parser, 0, 0);
    }

    @Test
    public void testHashCharacterLiteral() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.HASH + 'A');
        this.parseNumberAndCheck(parser,
                NO_COMPONENTS,
                list(DecimalFormatPatternComponent.hash()),
                list(DecimalFormatPatternComponent.characterLiteral('A')));
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.INTEGER);
        this.checkInteger(parser, 0);
        this.checkFraction(parser, 0, 0);
    }

    @Test
    public void testHashHash() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.HASH + DecimalFormat.HASH);
        this.parseNumberAndCheck(parser,
                DecimalFormatPatternComponent.hash(), DecimalFormatPatternComponent.hash());
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.INTEGER);
        this.checkInteger(parser, 0);
        this.checkFraction(parser, 0, 0);
    }

    @Test
    public void testHashZero() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.HASH + DecimalFormat.ZERO);
        this.parseNumberAndCheck(parser,
                DecimalFormatPatternComponent.hash(), DecimalFormatPatternComponent.zero());
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.INTEGER);
        this.checkInteger(parser, 1);
        this.checkFraction(parser, 0, 0);
    }

    @Test
    public void testHashHashHashZeroZero() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.HASH + DecimalFormat.HASH + DecimalFormat.ZERO + DecimalFormat.ZERO + DecimalFormat.ZERO);
        this.parseNumberAndCheck(parser,
                DecimalFormatPatternComponent.hash(), DecimalFormatPatternComponent.hash(), DecimalFormatPatternComponent.zero(), DecimalFormatPatternComponent.zero(), DecimalFormatPatternComponent.zero());
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.INTEGER);
        this.checkInteger(parser, 3);
        this.checkFraction(parser, 0, 0);
    }

    // minusSign.........................................................................................................

    @Test
    public void testMinusSign() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.MINUS_SIGN);
        this.parseNumberAndCheck(parser,
                list(DecimalFormatPatternComponent.minusSign()),
                list(DecimalFormatPatternComponent.hash()),
                NO_COMPONENTS);
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.PREFIX);
    }

    @Test
    public void testMinusSignHash() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.MINUS_SIGN + DecimalFormat.HASH);
        this.parseNumberAndCheck(parser,
                list(DecimalFormatPatternComponent.minusSign()),
                list(DecimalFormatPatternComponent.hash()),
                NO_COMPONENTS);
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.INTEGER);
    }

    @Test
    public void testHashMinusSign() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.HASH + DecimalFormat.MINUS_SIGN);
        this.parseNumberAndCheck(parser,
                NO_COMPONENTS,
                list(DecimalFormatPatternComponent.hash()),
                list(DecimalFormatPatternComponent.minusSign()));
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.INTEGER);
    }

    // percent.........................................................................................................

    @Test
    public void testPercent() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.PERCENT);
        this.parseNumberAndCheck(parser,
                list(DecimalFormatPatternComponent.percent()),
                list(DecimalFormatPatternComponent.hash()),
                NO_COMPONENTS);
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.PREFIX);
        this.checkMultiplier(parser, DecimalFormatPatternComponent.PERCENT_MULTIPLIER);
    }

    @Test
    public void testPercentPercentFails() {
        this.parseFails("" + DecimalFormat.PERCENT + DecimalFormat.PERCENT, 1);
    }

    @Test
    public void testPercentPerMilleFails() {
        this.parseFails("" + DecimalFormat.PERCENT + DecimalFormat.PER_MILLE, 1);
    }

    @Test
    public void testPercentHash() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.PERCENT + DecimalFormat.HASH);
        this.parseNumberAndCheck(parser,
                list(DecimalFormatPatternComponent.percent()),
                list(DecimalFormatPatternComponent.hash()),
                NO_COMPONENTS);
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.INTEGER);
        this.checkMultiplier(parser, DecimalFormatPatternComponent.PERCENT_MULTIPLIER);
    }

    @Test
    public void testHashPercent() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.HASH + DecimalFormat.PERCENT);
        this.parseNumberAndCheck(parser,
                NO_COMPONENTS,
                list(DecimalFormatPatternComponent.hash()),
                list(DecimalFormatPatternComponent.percent()));
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.INTEGER);
        this.checkMultiplier(parser, DecimalFormatPatternComponent.PERCENT_MULTIPLIER);
        this.checkInteger(parser, 0);
        this.checkFraction(parser, 0, 0);
    }

    // perMille.........................................................................................................

    @Test
    public void testPerMille() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.PER_MILLE);
        this.parseNumberAndCheck(parser,
                list(DecimalFormatPatternComponent.perMille()),
                list(DecimalFormatPatternComponent.hash()),
                NO_COMPONENTS);
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.PREFIX);
        this.checkMultiplier(parser, DecimalFormatPatternComponent.PER_MILLE_MULTIPLIER);
        this.checkInteger(parser, 0);
        this.checkFraction(parser, 0, 0);
    }

    @Test
    public void testPerMillePercentFails() {
        this.parseFails("" + DecimalFormat.PER_MILLE + DecimalFormat.PERCENT, 1);
    }

    @Test
    public void testPerMillePerMilleFails() {
        this.parseFails("" + DecimalFormat.PER_MILLE + DecimalFormat.PER_MILLE, 1);
    }

    @Test
    public void testPerMilleHash() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.PER_MILLE + DecimalFormat.HASH);
        this.parseNumberAndCheck(parser,
                list(DecimalFormatPatternComponent.perMille()),
                list(DecimalFormatPatternComponent.hash()),
                NO_COMPONENTS);
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.INTEGER);
        this.checkMultiplier(parser, DecimalFormatPatternComponent.PER_MILLE_MULTIPLIER);
        this.checkInteger(parser, 0);
        this.checkFraction(parser, 0, 0);
    }

    @Test
    public void testHashPerMille() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.HASH + DecimalFormat.PER_MILLE);
        this.parseNumberAndCheck(parser,
                NO_COMPONENTS,
                list(DecimalFormatPatternComponent.hash()),
                list(DecimalFormatPatternComponent.perMille()));
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.INTEGER);
        this.checkMultiplier(parser, DecimalFormatPatternComponent.PER_MILLE_MULTIPLIER);
        this.checkInteger(parser, 0);
        this.checkFraction(parser, 0, 0);
    }

    // zero.............................................................................................................

    @Test
    public void testZero() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.ZERO);
        this.parseNumberAndCheck(parser,
                DecimalFormatPatternComponent.hash(), DecimalFormatPatternComponent.zero());
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.INTEGER);
        this.checkInteger(parser, 1);
        this.checkFraction(parser, 0, 0);
    }

    @Test
    public void testZeroCharacterLiteral() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.ZERO + 'A');
        this.parseNumberAndCheck(parser,
                NO_COMPONENTS,
                list(DecimalFormatPatternComponent.hash(), DecimalFormatPatternComponent.zero()),
                list(DecimalFormatPatternComponent.characterLiteral('A')));
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.INTEGER);
        this.checkInteger(parser, 1);
        this.checkFraction(parser, 0, 0);
    }

    @Test
    public void testZeroHashFails() {
        this.parseFails("" + DecimalFormat.ZERO + DecimalFormat.HASH, 1);
    }

    @Test
    public void testZeroZero() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.ZERO + DecimalFormat.ZERO);
        this.parseNumberAndCheck(parser,
                DecimalFormatPatternComponent.hash(), DecimalFormatPatternComponent.zero(), DecimalFormatPatternComponent.zero());
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.INTEGER);
        this.checkInteger(parser, 2);
        this.checkFraction(parser, 0, 0);
    }

    @Test
    public void testZeroZeroZeroGroupingSeparatorZeroZero() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.ZERO + DecimalFormat.ZERO + DecimalFormat.ZERO + DecimalFormat.GROUPING_SEPARATOR + DecimalFormat.ZERO + DecimalFormat.ZERO);
        this.parseNumberAndCheck(parser,
                DecimalFormatPatternComponent.hash(), DecimalFormatPatternComponent.zero(), DecimalFormatPatternComponent.zero(), DecimalFormatPatternComponent.zero(), DecimalFormatPatternComponent.groupingSeparator(), DecimalFormatPatternComponent.zero(), DecimalFormatPatternComponent.zero());
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.INTEGER);
        this.checkInteger(parser, 5);
        this.checkFraction(parser, 0, 0);
        this.checkGroupingSeparator(parser, 2);
    }

    @Test
    public void testZeroDecimalSeparatorHash() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.ZERO + DecimalFormat.DECIMAL_SEPARATOR + DecimalFormat.HASH);
        this.parseNumberAndCheck(parser,
                DecimalFormatPatternComponent.hash(), DecimalFormatPatternComponent.zero(), DecimalFormatPatternComponent.decimalSeparator(), DecimalFormatPatternComponent.hash());
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.FRACTION);
        this.checkInteger(parser, 1);
        this.checkFraction(parser, 0, 1);
    }

    @Test
    public void testZeroDecimalSeparatorZero() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.ZERO + DecimalFormat.DECIMAL_SEPARATOR + DecimalFormat.ZERO);
        this.parseNumberAndCheck(parser,
                DecimalFormatPatternComponent.hash(), DecimalFormatPatternComponent.zero(), DecimalFormatPatternComponent.decimalSeparator(), DecimalFormatPatternComponent.zero());
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.FRACTION);
        this.checkInteger(parser, 1);
        this.checkFraction(parser, 1, 1);
    }

    @Test
    public void testZeroExponentFails() {
        this.parseFails("" + DecimalFormat.ZERO + DecimalFormat.EXPONENT, 1);
    }

    @Test
    public void testZeroExponentHashFails() {
        this.parseFails("" + DecimalFormat.ZERO + DecimalFormat.EXPONENT + DecimalFormat.HASH, 2);
    }

    @Test
    public void testZeroExponentZero() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.ZERO + DecimalFormat.EXPONENT + DecimalFormat.ZERO);
        this.parseNumberAndCheck(parser,
                DecimalFormatPatternComponent.hash(), DecimalFormatPatternComponent.zero(), DecimalFormatPatternComponent.exponent(), DecimalFormatPatternComponent.zero());
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.EXPONENT);
        this.checkInteger(parser, 1);
        this.checkFraction(parser, 0, 0);
    }

    @Test
    public void testZeroExponentZeroHashFails() {
        this.parseFails("" + DecimalFormat.ZERO + DecimalFormat.EXPONENT + DecimalFormat.ZERO + DecimalFormat.HASH, 3);
    }

    // subPattern.......................................................................................................

    @Test
    public void testSubPatternFails() {
        this.parseFails("" + DecimalFormat.SUB_PATTERN_SEPARATOR, 0);
    }

    @Test
    public void testPrefixSubPatternFails() {
        this.parseFails("A" + DecimalFormat.SUB_PATTERN_SEPARATOR, 1);
    }

    @Test
    public void testHashSubPattern() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.HASH + DecimalFormat.SUB_PATTERN_SEPARATOR);
        this.parseNumberAndCheck(parser,
                DecimalFormatPatternComponent.hash());
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.INTEGER);
    }

    @Test
    public void testSubPatternAnything() {
        final DecimalFormatPatternParserNumber parser = this.createParser("" + DecimalFormat.HASH + DecimalFormat.SUB_PATTERN_SEPARATOR + "A");
        this.parseNumberAndCheck(parser,
                "A",
                NO_COMPONENTS,
                list(DecimalFormatPatternComponent.hash()),
                NO_COMPONENTS);
        this.checkMode(parser, DecimalFormatPatternParserNumberMode.INTEGER);
    }

    // toString.........................................................................................................

    @Test
    public void testToString() {
        final DecimalFormatPatternParserNumber parser = this.createParser("P#00S");
        parser.parse();

        this.toStringAndCheck(parser, "\"P#00S\" prefix=P number=#00 suffix=S");
    }

    @Test
    public void testToString2() {
        final DecimalFormatPatternParserNumber parser = this.createParser("P#00");
        parser.parse();

        this.toStringAndCheck(parser, "\"P#00\" prefix=P number=#00");
    }

    // helpers..........................................................................................................

    private void parseNumberAndCheck(final String pattern,
                                     final List<DecimalFormatPatternComponent> prefix,
                                     final List<DecimalFormatPatternComponent> number,
                                     final List<DecimalFormatPatternComponent> suffix) {
        this.parseNumberAndCheck(pattern,
                "",
                prefix,
                number,
                suffix);
    }

    private void parseNumberAndCheck(final String pattern,
                                     final String left,
                                     final List<DecimalFormatPatternComponent> prefix,
                                     final List<DecimalFormatPatternComponent> number,
                                     final List<DecimalFormatPatternComponent> suffix) {
        this.parseNumberAndCheck(DecimalFormatPatternParserNumber.with(pattern, 0),
                left,
                prefix,
                number,
                suffix);
    }

    private void parseNumberAndCheck(final DecimalFormatPatternParserNumber parser,
                                     final DecimalFormatPatternComponent... number) {
        this.parseNumberAndCheck(parser,
                NO_COMPONENTS,
                list(number),
                NO_COMPONENTS);
    }

    private void parseNumberAndCheck(final DecimalFormatPatternParserNumber parser,
                                     final List<DecimalFormatPatternComponent> prefix,
                                     final List<DecimalFormatPatternComponent> number,
                                     final List<DecimalFormatPatternComponent> suffix) {
        this.parseNumberAndCheck(parser,
                "",
                prefix,
                number,
                suffix);
    }

    private void parseNumberAndCheck(final DecimalFormatPatternParserNumber parser,
                                     final String left,
                                     final List<DecimalFormatPatternComponent> prefix,
                                     final List<DecimalFormatPatternComponent> number,
                                     final List<DecimalFormatPatternComponent> suffix) {
        final String pattern = parser.pattern;

        if (number.isEmpty()) {
            fail("Expected Number must not be empty");
        }
        if (!number.get(0).isHash()) {
            fail("Expected Number must start with hash " + number);
        }

        this.checkPositivePrefixAndSuffix(pattern,
                join(prefix),
                join(suffix));

        parser.parse();

        assertEquals(prefix,
                parser.prefix,
                () -> "parse " + CharSequences.quoteAndEscape(pattern) + " prefix, number=" + parser.number + ", suffix: " + parser.suffix);
        assertEquals(number,
                parser.number,
                () -> "parse " + CharSequences.quoteAndEscape(pattern) + " number, suffix: " + parser.suffix);
        assertEquals(suffix,
                parser.suffix,
                () -> "parse " + CharSequences.quoteAndEscape(pattern) + " suffix");

        assertEquals(parser.number.contains(DecimalFormatPatternComponent.exponent()),
                parser.isScientificFormat(),
                () -> "parse " + CharSequences.quoteAndEscape(pattern) + " scientific number, number=" + parser.number);

        final String parsed = pattern.substring(0, pattern.length() - left.length());
        assertEquals(parsed.endsWith("" + DecimalFormat.SUB_PATTERN_SEPARATOR),
                parser.subPatternSeparator,
                () -> " subPatternSeparator " + parser);

        assertEquals(parser.number.contains(DecimalFormatPatternComponent.decimalSeparator()) || parser.number.contains(DecimalFormatPatternComponent.currencySeparator()),
                parser.hasDecimalSeparator(),
                () -> "parser.hasDecimalSeparator " + parser);
    }

    private static String join(final List<DecimalFormatPatternComponent> prefix) {
        return prefix.stream()
                .map(DecimalFormatPatternComponent::toString)
                .collect(Collectors.joining())
                .replace("'E'", "E")
                .replace(DecimalFormat.PERCENT, new DecimalFormatSymbols(LOCALE).getPercent())
                .replace(DecimalFormat.PER_MILLE, new DecimalFormatSymbols(LOCALE).getPerMill())
                .replace("" + CURRENCY + CURRENCY, "AUD")
                .replace("" + CURRENCY, "$");
    }

    private List<DecimalFormatPatternComponent> NO_COMPONENTS = Lists.empty();

    private List<DecimalFormatPatternComponent> list(final DecimalFormatPatternComponent... components) {
        return Lists.of(components);
    }

    private void checkMode(final DecimalFormatPatternParserNumber parser,
                           final DecimalFormatPatternParserNumberMode mode) {
        assertEquals(mode, parser.mode, () -> "mode " + parser);
    }

    private void checkGroupingSeparator(final DecimalFormatPatternParserNumber parser,
                                        final int groupingSeparator) {
        assertEquals(groupingSeparator, parser.groupingSize(), () -> "groupingSeparator " + parser);
    }

    private void checkFraction(final DecimalFormatPatternParserNumber parser,
                               final int min,
                               final int max) {
        if (min < 0) {
            fail("minimumFractionDigits " + min + " < 0");
        }
        if (min > max) {
            fail("minimumFractionDigits " + min + " > maximumFractionDigits " + max);
        }
        assertEquals(max, parser.maximumFractionDigits, () -> "maximumFractionDigits " + parser);
        assertEquals(min, parser.minimumFractionDigits, () -> "minimumFractionDigits " + parser);
    }

    private void checkInteger(final DecimalFormatPatternParserNumber parser, final int min) {
        if (min < 0) {
            fail("minIntegerDigits " + min + " < 0");
        }
        assertEquals(Integer.MAX_VALUE, parser.maximumIntegerDigits, () -> "maximumIntegerDigits " + parser);
        assertEquals(min, parser.minimumIntegerDigits, () -> "minimumIntegerDigits " + parser);
    }

    private void checkMultiplier(final DecimalFormatPatternParserNumber parser,
                                 final int multipier) {
        assertEquals(multipier, parser.multiplier, () -> "multiplier " + parser);
    }

    @Override
    DecimalFormatPatternParserNumber createParser(final String pattern,
                                                  final int position) {
        return DecimalFormatPatternParserNumber.with(pattern, position);
    }

    // ClassTesting.....................................................................................................

    @Override
    public Class<DecimalFormatPatternParserNumber> type() {
        return DecimalFormatPatternParserNumber.class;
    }
}
