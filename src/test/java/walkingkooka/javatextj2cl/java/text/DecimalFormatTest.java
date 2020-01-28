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
import walkingkooka.ToStringTesting;
import walkingkooka.javautillocalej2cl.WalkingkookaLocale;

import java.math.RoundingMode;
import java.util.Currency;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public final class DecimalFormatTest extends FormatTestCase<DecimalFormat> implements HashCodeEqualsDefinedTesting2<DecimalFormat>,
        ToStringTesting<DecimalFormat> {

    private final static Locale EN_AU = Locale.forLanguageTag("en-AU");
    private final static Locale FR = Locale.forLanguageTag("fr");

    private final static String PATTERN = "0";

    private final static Currency CURRENCY = Currency.getInstance("AUD");
    private final static int GROUPING_SIZE = 10;

    private final static int MAX_FRACTION = 8;
    private final static int MIN_FRACTION = 4;
    private final static int MAX_INTEGER = 20;
    private final static int MIN_INTEGER = 10;

    private final static int MULTPLIER = 100;

    private final static String NEGATIVE_PREFIX = "NegativePrefix1";
    private final static String NEGATIVE_SUFFIX = "NegativeSuffix2";

    private final static boolean PARSE_BIG_DECIMAL = false;
    private final static boolean PARSE_INTEGER_ONLY = false;

    private final static String POSITIVE_PREFIX = "PositivePrefix1";
    private final static String POSITIVE_SUFFIX = "PositiveSuffix2";

    private final static RoundingMode ROUNDING_MODE = RoundingMode.HALF_EVEN;

    // NumberFormat.getCurrencyInstance(Locale) ........................................................................

    @Test
    public void testCurrencyInstanceDefaultEnAu() {
        this.currencyInstanceAndCheck(EN_AU);
    }

    @Test
    public void testCurrencyInstanceDefaultFr() {
        this.currencyInstanceAndCheck(FR);
    }

    @Test
    public void testCurrencyInstanceDefaultAllLocales() {
        for (final Locale locale : java.text.DecimalFormat.getAvailableLocales()) {
            if (WalkingkookaLocale.isUnsupported(locale.toLanguageTag())) {
                continue;
            }
            this.currencyInstanceAndCheck(locale);
        }
    }

    private void currencyInstanceAndCheck(final Locale locale) {
        Locale.setDefault(locale);

        this.check(java.text.NumberFormat.getCurrencyInstance(),
                NumberFormat.getCurrencyInstance(),
                locale);
    }

    @Test
    public void testCurrencyInstanceCloned() {
        for (final Locale locale : java.text.DecimalFormat.getAvailableLocales()) {
            if (WalkingkookaLocale.isUnsupported(locale.toLanguageTag())) {
                continue;
            }

            Locale.setDefault(locale);

            final NumberFormat format = DecimalFormat.getCurrencyInstance();
            format.setMaximumFractionDigits(66);
            format.setMinimumFractionDigits(77);
            format.setMaximumIntegerDigits(88);
            format.setMinimumIntegerDigits(99);

            assertNotEquals(format, DecimalFormat.getCurrencyInstance());
        }
    }

    // NumberFormat.getCurrencyInstance(Locale) ........................................................................

    @Test
    public void testCurrencyInstanceLocaleDefaultEnAu() {
        this.currencyInstanceLocaleAndCheck(EN_AU);
    }

    @Test
    public void testCurrencyInstanceLocaleDefaultFr() {
        this.currencyInstanceLocaleAndCheck(FR);
    }

    @Test
    public void testCurrencyInstanceLocaleDefaultAllLocales() {
        for (final Locale locale : java.text.DecimalFormat.getAvailableLocales()) {
            if (WalkingkookaLocale.isUnsupported(locale.toLanguageTag())) {
                continue;
            }
            this.currencyInstanceLocaleAndCheck(locale);
        }
    }

    private void currencyInstanceLocaleAndCheck(final Locale locale) {
        this.check(java.text.NumberFormat.getCurrencyInstance(locale),
                NumberFormat.getCurrencyInstance(locale),
                locale);
    }

    @Test
    public void testCurrencyInstanceLocaleCloned() {
        for (final Locale locale : java.text.DecimalFormat.getAvailableLocales()) {
            if (WalkingkookaLocale.isUnsupported(locale.toLanguageTag())) {
                continue;
            }

            final NumberFormat format = DecimalFormat.getCurrencyInstance(locale);
            format.setMaximumFractionDigits(66);
            format.setMinimumFractionDigits(77);
            format.setMaximumIntegerDigits(88);
            format.setMinimumIntegerDigits(99);

            assertNotEquals(format, DecimalFormat.getCurrencyInstance(locale));
        }
    }

    // NumberFormat.getIntegerInstance(Locale) .........................................................................

    @Test
    public void testIntegerInstanceDefaultEnAu() {
        this.integerInstanceAndCheck(EN_AU);
    }

    @Test
    public void testIntegerInstanceDefaultFr() {
        this.integerInstanceAndCheck(FR);
    }

    @Test
    public void testIntegerInstanceDefaultAllLocales() {
        for (final Locale locale : java.text.DecimalFormat.getAvailableLocales()) {
            if (WalkingkookaLocale.isUnsupported(locale.toLanguageTag())) {
                continue;
            }
            this.integerInstanceAndCheck(locale);
        }
    }

    private void integerInstanceAndCheck(final Locale locale) {
        Locale.setDefault(locale);

        this.check(java.text.NumberFormat.getIntegerInstance(),
                NumberFormat.getIntegerInstance(),
                locale);
    }

    @Test
    public void testIntegerInstanceCloned() {
        for (final Locale locale : java.text.DecimalFormat.getAvailableLocales()) {
            if (WalkingkookaLocale.isUnsupported(locale.toLanguageTag())) {
                continue;
            }

            Locale.setDefault(locale);

            final NumberFormat format = DecimalFormat.getCurrencyInstance();
            format.setMaximumFractionDigits(66);
            format.setMinimumFractionDigits(77);
            format.setMaximumIntegerDigits(88);
            format.setMinimumIntegerDigits(99);

            assertNotEquals(format, DecimalFormat.getCurrencyInstance());
        }
    }

    // NumberFormat.getIntegerInstance(Locale) .........................................................................

    @Test
    public void testIntegerInstanceLocaleDefaultEnAu() {
        this.integerInstanceLocaleAndCheck(EN_AU);
    }

    @Test
    public void testIntegerInstanceLocaleDefaultFr() {
        this.integerInstanceLocaleAndCheck(FR);
    }

    @Test
    public void testIntegerInstanceLocaleDefaultAllLocales() {
        for (final Locale locale : java.text.DecimalFormat.getAvailableLocales()) {
            if (WalkingkookaLocale.isUnsupported(locale.toLanguageTag())) {
                continue;
            }
            this.integerInstanceLocaleAndCheck(locale);
        }
    }

    private void integerInstanceLocaleAndCheck(final Locale locale) {
        this.check(java.text.NumberFormat.getIntegerInstance(locale),
                NumberFormat.getIntegerInstance(locale),
                locale);
    }

    @Test
    public void testIntegerInstanceLocaleCloned() {
        for (final Locale locale : java.text.DecimalFormat.getAvailableLocales()) {
            if (WalkingkookaLocale.isUnsupported(locale.toLanguageTag())) {
                continue;
            }

            final NumberFormat format = DecimalFormat.getCurrencyInstance(locale);
            format.setMaximumFractionDigits(66);
            format.setMinimumFractionDigits(77);
            format.setMaximumIntegerDigits(88);
            format.setMinimumIntegerDigits(99);

            assertNotEquals(format, DecimalFormat.getCurrencyInstance(locale));
        }
    }

    // NumberFormat.getInstance(Locale) ................................................................................

    @Test
    public void testInstanceDefaultEnAu() {
        this.instanceAndCheck(EN_AU);
    }

    @Test
    public void testInstanceDefaultFr() {
        this.instanceAndCheck(FR);
    }

    @Test
    public void testInstanceDefaultAllLocales() {
        for (final Locale locale : java.text.DecimalFormat.getAvailableLocales()) {
            if (WalkingkookaLocale.isUnsupported(locale.toLanguageTag())) {
                continue;
            }
            this.instanceAndCheck(locale);
        }
    }

    private void instanceAndCheck(final Locale locale) {
        Locale.setDefault(locale);

        this.check(java.text.NumberFormat.getInstance(),
                NumberFormat.getInstance(),
                locale);
    }

    @Test
    public void testInstanceCloned() {
        for (final Locale locale : java.text.DecimalFormat.getAvailableLocales()) {
            if (WalkingkookaLocale.isUnsupported(locale.toLanguageTag())) {
                continue;
            }

            Locale.setDefault(locale);

            final NumberFormat format = DecimalFormat.getCurrencyInstance();
            format.setMaximumFractionDigits(66);
            format.setMinimumFractionDigits(77);
            format.setMaximumIntegerDigits(88);
            format.setMinimumIntegerDigits(99);

            assertNotEquals(format, DecimalFormat.getCurrencyInstance());
        }
    }

    // NumberFormat.getInstance(Locale) ................................................................................

    @Test
    public void testInstanceLocaleDefaultEnAu() {
        this.instanceLocaleAndCheck(EN_AU);
    }

    @Test
    public void testInstanceLocaleDefaultFr() {
        this.instanceLocaleAndCheck(FR);
    }

    @Test
    public void testInstanceLocaleDefaultAllLocales() {
        for (final Locale locale : java.text.DecimalFormat.getAvailableLocales()) {
            if (WalkingkookaLocale.isUnsupported(locale.toLanguageTag())) {
                continue;
            }
            this.instanceLocaleAndCheck(locale);
        }
    }

    private void instanceLocaleAndCheck(final Locale locale) {
        this.check(java.text.NumberFormat.getInstance(locale),
                NumberFormat.getInstance(locale),
                locale);
    }

    @Test
    public void testInstanceLocaleCloned() {
        for (final Locale locale : java.text.DecimalFormat.getAvailableLocales()) {
            if (WalkingkookaLocale.isUnsupported(locale.toLanguageTag())) {
                continue;
            }

            final NumberFormat format = DecimalFormat.getCurrencyInstance(locale);
            format.setMaximumFractionDigits(66);
            format.setMinimumFractionDigits(77);
            format.setMaximumIntegerDigits(88);
            format.setMinimumIntegerDigits(99);

            assertNotEquals(format, DecimalFormat.getCurrencyInstance(locale));
        }
    }

    // NumberFormat.getNumberInstance(Locale) ................................................................................

    @Test
    public void testNumberInstanceDefaultEnAu() {
        this.numberInstanceAndCheck(EN_AU);
    }

    @Test
    public void testNumberInstanceDefaultFr() {
        this.numberInstanceAndCheck(FR);
    }

    @Test
    public void testNumberInstanceDefaultAllLocales() {
        for (final Locale locale : java.text.DecimalFormat.getAvailableLocales()) {
            if (WalkingkookaLocale.isUnsupported(locale.toLanguageTag())) {
                continue;
            }
            this.numberInstanceAndCheck(locale);
        }
    }

    private void numberInstanceAndCheck(final Locale locale) {
        Locale.setDefault(locale);

        this.check(java.text.NumberFormat.getNumberInstance(),
                NumberFormat.getNumberInstance(),
                locale);
    }

    @Test
    public void testNumberInstanceCloned() {
        for (final Locale locale : java.text.DecimalFormat.getAvailableLocales()) {
            if (WalkingkookaLocale.isUnsupported(locale.toLanguageTag())) {
                continue;
            }

            Locale.setDefault(locale);

            final NumberFormat format = DecimalFormat.getCurrencyInstance();
            format.setMaximumFractionDigits(66);
            format.setMinimumFractionDigits(77);
            format.setMaximumIntegerDigits(88);
            format.setMinimumIntegerDigits(99);

            assertNotEquals(format, DecimalFormat.getCurrencyInstance());
        }
    }

    // NumberFormat.getNumberInstance(Locale) ..........................................................................

    @Test
    public void testNumberInstanceLocaleDefaultEnAu() {
        this.numberInstanceLocaleAndCheck(EN_AU);
    }

    @Test
    public void testNumberInstanceLocaleDefaultFr() {
        this.numberInstanceLocaleAndCheck(FR);
    }

    @Test
    public void testNumberInstanceLocaleDefaultAllLocales() {
        for (final Locale locale : java.text.DecimalFormat.getAvailableLocales()) {
            if (WalkingkookaLocale.isUnsupported(locale.toLanguageTag())) {
                continue;
            }
            this.numberInstanceLocaleAndCheck(locale);
        }
    }

    private void numberInstanceLocaleAndCheck(final Locale locale) {
        this.check(java.text.NumberFormat.getNumberInstance(locale),
                NumberFormat.getNumberInstance(locale),
                locale);
    }

    @Test
    public void testNumberInstanceLocaleCloned() {
        for (final Locale locale : java.text.DecimalFormat.getAvailableLocales()) {
            if (WalkingkookaLocale.isUnsupported(locale.toLanguageTag())) {
                continue;
            }

            final NumberFormat format = DecimalFormat.getCurrencyInstance(locale);
            format.setMaximumFractionDigits(66);
            format.setMinimumFractionDigits(77);
            format.setMaximumIntegerDigits(88);
            format.setMinimumIntegerDigits(99);

            assertNotEquals(format, DecimalFormat.getCurrencyInstance(locale));
        }
    }

    // NumberFormat.getPercentInstance(Locale) .........................................................................

    @Test
    public void testPercentInstanceDefaultEnAu() {
        this.percentInstanceAndCheck(EN_AU);
    }

    @Test
    public void testPercentInstanceDefaultFr() {
        this.percentInstanceAndCheck(FR);
    }

    @Test
    public void testPercentInstanceDefaultAllLocales() {
        for (final Locale locale : java.text.DecimalFormat.getAvailableLocales()) {
            if (WalkingkookaLocale.isUnsupported(locale.toLanguageTag())) {
                continue;
            }
            this.percentInstanceAndCheck(locale);
        }
    }

    private void percentInstanceAndCheck(final Locale locale) {
        Locale.setDefault(locale);

        this.check(java.text.NumberFormat.getPercentInstance(),
                NumberFormat.getPercentInstance(),
                locale);
    }

    @Test
    public void testPercentInstanceCloned() {
        for (final Locale locale : java.text.DecimalFormat.getAvailableLocales()) {
            if (WalkingkookaLocale.isUnsupported(locale.toLanguageTag())) {
                continue;
            }

            Locale.setDefault(locale);

            final NumberFormat format = DecimalFormat.getPercentInstance();
            format.setMaximumFractionDigits(66);
            format.setMinimumFractionDigits(77);
            format.setMaximumIntegerDigits(88);
            format.setMinimumIntegerDigits(99);

            assertNotEquals(format, DecimalFormat.getPercentInstance());
        }
    }

    // NumberFormat.getPercentInstance(Locale) .........................................................................

    @Test
    public void testPercentInstanceLocaleDefaultEnAu() {
        this.percentInstanceLocaleAndCheck(EN_AU);
    }

    @Test
    public void testPercentInstanceLocaleDefaultFr() {
        this.percentInstanceLocaleAndCheck(FR);
    }

    @Test
    public void testPercentInstanceLocaleDefaultAllLocales() {
        for (final Locale locale : java.text.DecimalFormat.getAvailableLocales()) {
            if (WalkingkookaLocale.isUnsupported(locale.toLanguageTag())) {
                continue;
            }
            this.percentInstanceLocaleAndCheck(locale);
        }
    }

    private void percentInstanceLocaleAndCheck(final Locale locale) {
        this.check(java.text.NumberFormat.getPercentInstance(locale),
                NumberFormat.getPercentInstance(locale),
                locale);
    }

    @Test
    public void testPercentInstanceLocaleCloned() {
        for (final Locale locale : java.text.DecimalFormat.getAvailableLocales()) {
            if (WalkingkookaLocale.isUnsupported(locale.toLanguageTag())) {
                continue;
            }

            final NumberFormat format = DecimalFormat.getPercentInstance(locale);
            format.setMaximumFractionDigits(66);
            format.setMinimumFractionDigits(77);
            format.setMaximumIntegerDigits(88);
            format.setMinimumIntegerDigits(99);

            assertNotEquals(format, DecimalFormat.getPercentInstance(locale));
        }
    }

    // new .............................................................................................................

    @Test
    public void testNewDefaultEnAu() {
        this.newAndCheck(EN_AU);
    }

    @Test
    public void testNewDefaultFr() {
        this.newAndCheck(FR);
    }

    @Test
    public void testNewDefaultAllLocales() {
        for (final Locale locale : java.text.DecimalFormat.getAvailableLocales()) {
            if (WalkingkookaLocale.isUnsupported(locale.toLanguageTag())) {
                continue;
            }
            this.newAndCheck(locale);
        }
    }

    private void newAndCheck(final Locale locale) {
        Locale.setDefault(locale);

        this.check(new java.text.DecimalFormat(),
                new DecimalFormat(),
                locale);
    }

    // new pattern.......................................................................................................

    @Test
    public void testNewPatternEnAu() {
        this.newPatternAndCheck(PATTERN, EN_AU);
    }

    @Test
    public void testNewPatternFr() {
        this.newPatternAndCheck(PATTERN, FR);
    }

    @Test
    public void testNewPatternAllLocales() {
        for (final Locale locale : java.text.DecimalFormat.getAvailableLocales()) {
            if (WalkingkookaLocale.isUnsupported(locale.toLanguageTag())) {
                continue;
            }

            this.newPatternAndCheck(PATTERN, locale);
        }
    }

    private void newPatternAndCheck(final String pattern,
                                    final Locale locale) {
        Locale.setDefault(locale);

        this.check(new java.text.DecimalFormat(pattern),
                new DecimalFormat(pattern),
                locale);
    }

    // new pattern, symbols.............................................................................................

    @Test
    public void testNewPatternSymbolsEnAu() {
        Locale.setDefault(EN_AU);

        this.check(new java.text.DecimalFormat(PATTERN, new java.text.DecimalFormatSymbols(EN_AU)),
                new DecimalFormat(PATTERN, new DecimalFormatSymbols(EN_AU)),
                EN_AU);
    }

    @Test
    public void testNewPatternSymbolsFr() {
        Locale.setDefault(FR);

        this.check(new java.text.DecimalFormat(PATTERN, new java.text.DecimalFormatSymbols(FR)),
                new DecimalFormat(PATTERN, new DecimalFormatSymbols(FR)),
                FR);
    }

    @Test
    public void testNewPatternSymbolsAllLocales() {
        for (final Locale locale : java.text.DecimalFormat.getAvailableLocales()) {
            if (WalkingkookaLocale.isUnsupported(locale.toLanguageTag())) {
                continue;
            }

            this.newPatternAndSymbolsAndCheck(PATTERN, locale);
        }
    }

    private void newPatternAndSymbolsAndCheck(final String pattern,
                                              final Locale locale) {
        Locale.setDefault(locale);

        this.check(new java.text.DecimalFormat(pattern, new java.text.DecimalFormatSymbols(locale)),
                new DecimalFormat(pattern, new DecimalFormatSymbols(locale)),
                locale);
    }

    // currency.........................................................................................................

    @Test
    public void testSetCurrencyNullFails() {
        assertThrows(NullPointerException.class, () -> new java.text.DecimalFormat("#").setCurrency(null));
        assertThrows(NullPointerException.class, () -> new DecimalFormat("#").setCurrency(null));
    }

    @Test
    public void testSetCurrencyAUD() {
        final Currency currency = Currency.getInstance("AUD");

        final java.text.DecimalFormat jdk = new java.text.DecimalFormat("#");
        jdk.setCurrency(currency);

        final DecimalFormat emul = new DecimalFormat("#");
        emul.setCurrency(currency);

        assertEquals(jdk.getCurrency(), emul.getCurrency(), () -> "currency AUD");;
    }

    // negativePrefix.........................................................................................................

    @Test
    public void testSetNegativePrefixNull() {
        new java.text.DecimalFormat("#").setNegativePrefix(null);
        new DecimalFormat("#").setNegativePrefix(null);
    }

    @Test
    public void testSetNegativePrefix() {
        final String negativePrefix = "ABC";

        final java.text.DecimalFormat jdk = new java.text.DecimalFormat("#");
        jdk.setNegativePrefix(negativePrefix);

        final DecimalFormat emul = new DecimalFormat("#");
        emul.setNegativePrefix(negativePrefix);

        assertEquals(jdk.getNegativePrefix(), emul.getNegativePrefix(), () -> "negativePrefix");
    }

    // negativeSuffix.........................................................................................................

    @Test
    public void testSetNegativeSuffixNull() {
        new java.text.DecimalFormat("#").setNegativeSuffix(null);
        new DecimalFormat("#").setNegativeSuffix(null);
    }

    @Test
    public void testSetNegativeSuffix() {
        final String negativeSuffix = "ABC";

        final java.text.DecimalFormat jdk = new java.text.DecimalFormat("#");
        jdk.setNegativeSuffix(negativeSuffix);

        final DecimalFormat emul = new DecimalFormat("#");
        emul.setNegativeSuffix(negativeSuffix);

        assertEquals(jdk.getNegativeSuffix(), emul.getNegativeSuffix(), () -> "negativeSuffix");
    }

    // parseBigDecimal, parseIntegerOnly................................................................................

    @Test
    public void testSetParseBigDecimalTrue() {
        this.setParseBigDecimalAndCheck(true);
    }

    @Test
    public void testSetBigIntegerTrueBigDecimalTrue() {
        this.setParseBigDecimalAndCheck(true, true);
    }

    @Test
    public void testSetBigIntegerFalseBigDecimalFalse() {
        this.setParseBigDecimalAndCheck(false, true);
    }

    private void setParseBigDecimalAndCheck(final boolean integerOnly,
                                            final boolean bigDecimal) {
        final java.text.DecimalFormat jdk = new java.text.DecimalFormat("#");
        jdk.setParseIntegerOnly(integerOnly);
        jdk.setParseBigDecimal(bigDecimal);

        final DecimalFormat emul = new DecimalFormat("#");
        emul.setParseIntegerOnly(integerOnly);
        emul.setParseBigDecimal(bigDecimal);

        this.checkParseBigDecimalParseIntegerOnly(jdk, emul);
    }

    @Test
    public void testSetParseBigDecimalFalse() {
        this.setParseBigDecimalAndCheck(true);
    }

    private void setParseBigDecimalAndCheck(final boolean bigDecimal) {
        final java.text.DecimalFormat jdk = new java.text.DecimalFormat("#");
        jdk.setParseBigDecimal(bigDecimal);

        final DecimalFormat emul = new DecimalFormat("#");
        emul.setParseBigDecimal(bigDecimal);

        this.checkParseBigDecimalParseIntegerOnly(jdk, emul);
    }

    @Test
    public void testSetParseIntegerOnlyTrue() {
        this.setParseIntegerOnlyAndCheck(true);
    }

    @Test
    public void testSetBigIntegerTrueParseIntegerOnlyTrue() {
        this.setParseIntegerOnlyAndCheck(true, true);
    }

    @Test
    public void testSetBigIntegerFalseParseIntegerOnlyFalse() {
        this.setParseIntegerOnlyAndCheck(false, true);
    }

    private void setParseIntegerOnlyAndCheck(final boolean integerOnly,
                                             final boolean bigDecimal) {
        final java.text.DecimalFormat jdk = new java.text.DecimalFormat("#");
        jdk.setParseIntegerOnly(integerOnly);
        jdk.setParseBigDecimal(bigDecimal);

        final DecimalFormat emul = new DecimalFormat("#");
        emul.setParseIntegerOnly(integerOnly);
        emul.setParseBigDecimal(bigDecimal);

        this.checkParseBigDecimalParseIntegerOnly(jdk, emul);
    }

    @Test
    public void testSetParseIntegerOnlyFalse() {
        this.setParseIntegerOnlyAndCheck(true);
    }

    private void setParseIntegerOnlyAndCheck(final boolean parseIntegerOnly) {
        final java.text.DecimalFormat jdk = new java.text.DecimalFormat("#");
        jdk.setParseIntegerOnly(parseIntegerOnly);

        final DecimalFormat emul = new DecimalFormat("#");
        emul.setParseIntegerOnly(parseIntegerOnly);

        this.checkParseBigDecimalParseIntegerOnly(jdk, emul);
    }

    private void checkParseBigDecimalParseIntegerOnly(final java.text.DecimalFormat jdk,
                                                      final DecimalFormat emul) {
        assertEquals(jdk.isParseBigDecimal(), emul.isParseBigDecimal(), () -> "parseBigDecimal");
        ;
        assertEquals(jdk.isParseIntegerOnly(), emul.isParseIntegerOnly(), () -> "parseIntegerOnly");
    }

    // positivePrefix.........................................................................................................

    @Test
    public void testSetPositivePrefixNull() {
        new java.text.DecimalFormat("#").setPositivePrefix(null);
        new DecimalFormat("#").setPositivePrefix(null);
    }

    @Test
    public void testSetPositivePrefix() {
        final String positivePrefix = "ABC";

        final java.text.DecimalFormat jdk = new java.text.DecimalFormat("#");
        jdk.setPositivePrefix(positivePrefix);

        final DecimalFormat emul = new DecimalFormat("#");
        emul.setPositivePrefix(positivePrefix);

        assertEquals(jdk.getPositivePrefix(), emul.getPositivePrefix(), () -> "positivePrefix");
    }

    // positiveSuffix.........................................................................................................

    @Test
    public void testSetPositiveSuffixNull() {
        new java.text.DecimalFormat("#").setPositiveSuffix(null);
        new DecimalFormat("#").setPositiveSuffix(null);
    }

    @Test
    public void testSetPositiveSuffix() {
        final String positiveSuffix = "ABC";

        final java.text.DecimalFormat jdk = new java.text.DecimalFormat("#");
        jdk.setPositiveSuffix(positiveSuffix);

        final DecimalFormat emul = new DecimalFormat("#");
        emul.setPositiveSuffix(positiveSuffix);

        assertEquals(jdk.getPositiveSuffix(), emul.getPositiveSuffix(), () -> "positiveSuffix");
    }

    // roundingMode.........................................................................................................

    @Test
    public void testSetRoundingModeNullFails() {
        assertThrows(NullPointerException.class, () -> new java.text.DecimalFormat("#").setRoundingMode(null));
        assertThrows(NullPointerException.class, () -> new DecimalFormat("#").setRoundingMode(null));
    }

    @Test
    public void testSetRoundingMode() {
        final RoundingMode roundingMode = RoundingMode.DOWN;

        final java.text.DecimalFormat jdk = new java.text.DecimalFormat("#");
        jdk.setRoundingMode(roundingMode);

        final DecimalFormat emul = new DecimalFormat("#");
        emul.setRoundingMode(roundingMode);

        assertEquals(jdk.getRoundingMode(), emul.getRoundingMode(), () -> "roundingMode");
        assertEquals(jdk.getRoundingMode(), emul.getRoundingMode(), () -> "roundingMode");
    }

    @Test
    public void testSetRoundingModeAll() {
        for (final RoundingMode roundingMode : RoundingMode.values()) {

            final java.text.DecimalFormat jdk = new java.text.DecimalFormat("#");
            jdk.setRoundingMode(roundingMode);

            final DecimalFormat emul = new DecimalFormat("#");
            emul.setRoundingMode(roundingMode);

            assertEquals(jdk.getRoundingMode(), emul.getRoundingMode(), () -> "roundingMode");
            assertEquals(jdk.getRoundingMode(), emul.getRoundingMode(), () -> "roundingMode");
        }
    }

    // check............................................................................................................

    private void check(final java.text.NumberFormat jdk,
                       final NumberFormat emul,
                       final Locale locale) {
        this.check((java.text.DecimalFormat) jdk,
                (DecimalFormat) emul,
                locale);
    }

    private void check(final java.text.DecimalFormat jdk,
                       final DecimalFormat emul,
                       final Locale locale) {
        // the commented out tests will fail because the pattern is not parsed and the tested values not correctly set.

        assertEquals(jdk.getCurrency(), emul.getCurrency(), () -> "currency " + locale);
//        assertEquals(jdk.getGroupingSize(), emul.getGroupingSize(), () -> "groupingSize " + locale);
//        assertEquals(jdk.isGroupingUsed(), emul.isGroupingUsed(), () -> "groupingUsed " + locale);
//        assertEquals(jdk.getMaximumFractionDigits(), emul.getMaximumFractionDigits(), () -> "maximumFractionDigits " + locale);
        assertEquals(jdk.getMinimumFractionDigits(), emul.getMinimumFractionDigits(), () -> "minimumFractionDigits " + locale);
//        assertEquals(jdk.getMaximumIntegerDigits(), emul.getMaximumIntegerDigits(), () -> "maximumIntegerDigits " + locale);
        assertEquals(jdk.getMinimumIntegerDigits(), emul.getMinimumIntegerDigits(), () -> "minimumIntegerDigits " + locale);
        assertEquals(jdk.getMultiplier(), emul.getMultiplier(), () -> "multiplier " + locale);
        assertEquals(jdk.getNegativePrefix(), emul.getNegativePrefix(), () -> "negativePrefix " + locale);
        assertEquals(jdk.getNegativeSuffix(), emul.getNegativeSuffix(), () -> "negativeSuffix " + locale);
        assertEquals(jdk.isParseBigDecimal(), emul.isParseBigDecimal(), () -> "parseBigDecimal " + locale);
        assertEquals(jdk.isParseIntegerOnly(), emul.isParseIntegerOnly(), () -> "parseIntegerOnly " + locale);
//        assertEquals(jdk.toPattern(), emul.toPattern(), () -> "pattern " + locale);
        assertEquals(jdk.getPositivePrefix(), emul.getPositivePrefix(), () -> "positivePrefix " + locale);
        assertEquals(jdk.getPositiveSuffix(), emul.getPositiveSuffix(), () -> "positiveSuffix " + locale);
        assertEquals(jdk.getRoundingMode(), emul.getRoundingMode(), () -> "roundingMode " + locale);

        this.check(jdk.getDecimalFormatSymbols(), emul.getDecimalFormatSymbols(), locale);
    }

    private void check(final java.text.DecimalFormatSymbols expected,
                       final DecimalFormatSymbols emulated,
                       final Locale locale) {

        assertEquals(expected.getCurrency(), emulated.getCurrency(), () -> "currency " + locale.toLanguageTag());
        assertEquals(expected.getCurrencySymbol(), emulated.getCurrencySymbol(), () -> "currencySymbol " + locale.toLanguageTag());
        assertEquals(expected.getDecimalSeparator(), emulated.getDecimalSeparator(), () -> "decimalSeparator " + locale.toLanguageTag());
        assertEquals(expected.getDigit(), emulated.getDigit(), () -> "digit " + locale.toLanguageTag());
        assertEquals(expected.getExponentSeparator(), emulated.getExponentSeparator(), () -> "exponentSeparator " + locale.toLanguageTag());
        assertEquals(expected.getGroupingSeparator(), emulated.getGroupingSeparator(), () -> "groupingSeparator " + locale.toLanguageTag());
        assertEquals(expected.getInfinity(), emulated.getInfinity(), "infinity " + locale.toLanguageTag());
        assertEquals(expected.getInternationalCurrencySymbol(), emulated.getInternationalCurrencySymbol(), () -> "internationalCurrencySymbol " + locale.toLanguageTag());
        assertEquals(expected.getMinusSign(), emulated.getMinusSign(), () -> "minusSign " + locale.toLanguageTag());
        assertEquals(expected.getMonetaryDecimalSeparator(), emulated.getMonetaryDecimalSeparator(), () -> "monetaryDecimalSeparator " + locale.toLanguageTag());
        assertEquals(expected.getNaN(), emulated.getNaN(), () -> "nan " + locale.toLanguageTag());
        assertEquals(expected.getPatternSeparator(), emulated.getPatternSeparator(), () -> "patternSeparator " + locale.toLanguageTag());
        assertEquals(expected.getPercent(), emulated.getPercent(), () -> "percent " + locale.toLanguageTag());
        assertEquals(expected.getPerMill(), emulated.getPerMill(), () -> "perMill " + locale.toLanguageTag());
        assertEquals(expected.getZeroDigit(), emulated.getZeroDigit(), () -> "zeroDigit " + locale.toLanguageTag());
    }

    // equals............................................................................................................

    @Test
    public void testDifferentCurrency() {
        final DecimalFormat format = this.createObject();
        format.setCurrency(Currency.getInstance("NZD"));
        this.checkNotEquals(format);
    }

    @Test
    public void testDifferentGroupingSize() {
        final DecimalFormat format = this.createObject();
        format.setGroupingSize(format.getGroupingSize() + 1);
        this.checkNotEquals(format);
    }

    @Test
    public void testDifferentMaximumFractionDigits() {
        final DecimalFormat format = this.createObject();
        format.setMaximumFractionDigits(format.getMaximumFractionDigits() + 1);
        this.checkNotEquals(format);
    }

    @Test
    public void testDifferentMinimumFractionDigits() {
        final DecimalFormat format = this.createObject();
        format.setMinimumFractionDigits(format.getMinimumFractionDigits() + 1);
        this.checkNotEquals(format);
    }

    @Test
    public void testDifferentMaximumIntegerDigits() {
        final DecimalFormat format = this.createObject();
        format.setMaximumIntegerDigits(format.getMaximumIntegerDigits() + 1);
        this.checkNotEquals(format);
    }

    @Test
    public void testDifferentMinimumIntegerDigits() {
        final DecimalFormat format = this.createObject();
        format.setMinimumIntegerDigits(format.getMinimumIntegerDigits() + 1);
        this.checkNotEquals(format);
    }

    @Test
    public void testDifferentMultiplier() {
        final DecimalFormat format = this.createObject();
        format.setMultiplier(format.getMultiplier() + 1);
        this.checkNotEquals(format);
    }

    @Test
    public void testDifferentRoundingMode() {
        final DecimalFormat format = this.createObject();

        final RoundingMode roundingMode = RoundingMode.CEILING;
        assertNotSame(ROUNDING_MODE, roundingMode);

        format.setRoundingMode(roundingMode);
        this.checkNotEquals(format);
    }

    @Override
    public DecimalFormat createObject() {
        final DecimalFormat format = new DecimalFormat("#", new DecimalFormatSymbols(Locale.forLanguageTag("en-AU")));


        format.setCurrency(CURRENCY);
        format.setGroupingSize(GROUPING_SIZE);

        format.setMinimumFractionDigits(MIN_FRACTION);
        format.setMaximumFractionDigits(MAX_FRACTION);
        format.setMinimumIntegerDigits(MIN_INTEGER);
        format.setMaximumIntegerDigits(MAX_INTEGER);

        format.setMultiplier(MULTPLIER);

        format.setNegativePrefix(NEGATIVE_PREFIX);
        format.setNegativeSuffix(NEGATIVE_SUFFIX);

        format.setParseBigDecimal(PARSE_BIG_DECIMAL);
        format.setParseIntegerOnly(PARSE_INTEGER_ONLY);

        format.setPositivePrefix(POSITIVE_PREFIX);
        format.setPositiveSuffix(POSITIVE_SUFFIX);

        format.setRoundingMode(ROUNDING_MODE);
        return format;
    }

    // String...........................................................................................................

    @Test
    public void testToString() {
        this.toStringAndCheck(this.createObject(),
                "currency=AUD groupingSize=10 groupingUsed=true maximumFractionDigits=8 minimumFractionDigits=4 maximumIntegerDigits=20 minimumIntegerDigits=10 multiplier=100 negativePrefix=\"NegativePrefix1\" negativeSuffix=\"NegativeSuffix2\" pattern=\"#\" positivePrefix=\"PositivePrefix1\" positiveSuffix=\"PositiveSuffix2\" roundingMode=HALF_EVEN symbols=currency=AUD currencySymbol=\"$\" decimalSeparator='.' digit='#' exponentSeparator=\"e\" groupingSeparator=',' infinity=\"∞\" internationalCurrencySymbol=\"AUD\" minusSign='-' monetaryDecimalSeparator='.' nan=\"NaN\" patternSeparator=';' percent='%' perMill='‰' zeroDigit='0'");
    }

    // ClassTesting.....................................................................................................

    @Override
    public Class<DecimalFormat> type() {
        return DecimalFormat.class;
    }
}
