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
import walkingkooka.HashCodeEqualsDefinedTesting2;
import walkingkooka.InvalidCharacterException;
import walkingkooka.ToStringTesting;
import walkingkooka.javautillocalej2cl.WalkingkookaLocale;
import walkingkooka.text.CharSequences;

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

    private final static Locale DEFAULT_LOCALE = EN_AU;

    private final static String PATTERN = "0";

    private final static Currency CURRENCY = Currency.getInstance("AUD");

    private final static boolean DECIMAL_SEPARATOR_ALWAYS_SHOWN = false;

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
    public void testCurrencyInstanceDefaultEsCL() {
        this.currencyInstanceAndCheck(Locale.forLanguageTag("es-CL"));
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
    public void testNewEmptyPattern() {
        this.newPatternAndCheck("", EN_AU);
    }

    @Test
    public void testNewPatternHash() {
        this.newPatternAndCheck("#", EN_AU);
    }

    @Test
    public void testNewPatternZero() {
        this.newPatternAndCheck("#", EN_AU);
    }

    @Test
    public void testNewPatternPositiveWithPrefixNegativeNumberOnly() {
        this.newPatternAndCheck("P#;#", EN_AU);
    }

    @Test
    public void testNewPatternPositiveWithSuffixNegativeNumberOnly() {
        this.newPatternAndCheck("#S;#", EN_AU);
    }

    @Test
    public void testNewPatternPositiveWithPrefixAndSuffixNegativeNumberOnly() {
        this.newPatternAndCheck("#S;#", EN_AU);
    }

    @Test
    public void testNewPatternNegativeWithoutPrefix() {
        this.newPatternAndCheck("#;#", EN_AU);
    }

    @Test
    public void testNewPatternNegativeWithoutPrefix2() {
        this.newPatternAndCheck("#;#0", EN_AU);
    }

    @Test
    public void testNewPatternNegativeWithPrefix() {
        this.newPatternAndCheck("#;P#", EN_AU);
    }

    @Test
    public void testNewPatternNegativeWithPrefixAndSuffix() {
        this.newPatternAndCheck("#;P#S", EN_AU);
    }

    @Test
    public void testNewScientificPatternHash() {
        this.newPatternAndCheck("#E0", EN_AU);
    }

    @Test
    public void testNewScientificPatternHashHash() {
        this.newPatternAndCheck("##E0", EN_AU);
    }

    @Test
    public void testNewScientificPatternHashHashHash() {
        this.newPatternAndCheck("###E0", EN_AU);
    }

    @Test
    public void testNewScientificPatternZero() {
        this.newPatternAndCheck("0E0", EN_AU);
    }

    @Test
    public void testNewScientificPatternZeroZero() {
        this.newPatternAndCheck("00E0", EN_AU);
    }

    @Test
    public void testNewScientificPatternZeroZeroZero() {
        this.newPatternAndCheck("000.0E0", EN_AU);
    }

    @Test
    public void testNewScientificPatternZeroDecimalZero() {
        this.newPatternAndCheck("0.0E0", EN_AU);
    }

    @Test
    public void testNewScientificPatternZeroDecimalZeroZero() {
        this.newPatternAndCheck("0.00E0", EN_AU);
    }

    @Test
    public void testNewScientificPatternZeroDecimalHash() {
        this.newPatternAndCheck("0.#E0", EN_AU);
    }

    @Test
    public void testNewScientificPatternZeroDecimalHashHash() {
        this.newPatternAndCheck("0.##E0", EN_AU);
    }

    @Test
    public void testNewScientificPatternZeroDecimalZeroHashHash() {
        this.newPatternAndCheck("0.0##E0", EN_AU);
    }

    @Test
    public void testNewPatternExtraSubPatternSeparatorFails() {
        final String pattern = "#;#;";

        assertThrows(IllegalArgumentException.class, () -> new java.text.DecimalFormat(pattern));
        assertThrows(InvalidCharacterException.class, () -> new DecimalFormat(pattern));
    }

    @Test
    public void testNewPatternEnAu() {
        this.newPatternAndCheck(PATTERN, EN_AU);
    }

    @Test
    public void testNewPatternEsCl() {
        this.newPatternAndCheck("¤#,##0;¤-#,##0", Locale.forLanguageTag("es-CL"));
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

        // TODO toPattern with sub-patterns rules are complex.
        this.check(new java.text.DecimalFormat(pattern),
                new DecimalFormat(pattern),
                locale,
                true);
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

        assertEquals(jdk.getCurrency(), emul.getCurrency(), () -> "currency AUD");
    }

    // decimalSeparatorAlwaysShown......................................................................................

    @Test
    public void testSetDecimalSeparatorAlwaysShownFalse() {
        this.setDecimalSeparatorAlwaysShownAndCheck(false);
    }

    @Test
    public void testSetDecimalSeparatorAlwaysShownTrue() {
        this.setDecimalSeparatorAlwaysShownAndCheck(true);
    }

    private void setDecimalSeparatorAlwaysShownAndCheck(final boolean decimalSeparatorAlwaysShown) {
        final java.text.DecimalFormat jdk = new java.text.DecimalFormat("#");
        jdk.setDecimalSeparatorAlwaysShown(decimalSeparatorAlwaysShown);

        final DecimalFormat emul = new DecimalFormat("#");
        emul.setDecimalSeparatorAlwaysShown(decimalSeparatorAlwaysShown);

        assertEquals(jdk.isDecimalSeparatorAlwaysShown(), emul.isDecimalSeparatorAlwaysShown(), () -> "decimalSeparatorAlwaysShown");
    }

    @Test
    public void testSetDecimalSeparatorAlwaysShownFalseToPattern() {
        Locale.setDefault(EN_AU);

        this.setDecimalSeparatorAlwaysShownAndCheck("#", false);
    }

    @Test
    public void testSetDecimalSeparatorAlwaysShownTrueToPattern() {
        Locale.setDefault(EN_AU);

        this.setDecimalSeparatorAlwaysShownAndCheck("#", true);
    }

    @Test
    public void testSetDecimalSeparatorAlwaysShownTrueFalseToPattern() {
        Locale.setDefault(EN_AU);

        final String pattern = "#";
        final boolean decimalSeparatorAlwaysShown = true;

        final java.text.DecimalFormat jdk = new java.text.DecimalFormat(pattern);
        jdk.setDecimalSeparatorAlwaysShown(decimalSeparatorAlwaysShown);

        final DecimalFormat emul = new DecimalFormat(pattern);
        emul.setDecimalSeparatorAlwaysShown(decimalSeparatorAlwaysShown);

        this.check(jdk, emul, EN_AU);

        this.setDecimalSeparatorAlwaysShownAndCheck(jdk, emul, false);
    }

    private void setDecimalSeparatorAlwaysShownAndCheck(final String pattern,
                                                        final boolean always) {
        this.setDecimalSeparatorAlwaysShownAndCheck(new java.text.DecimalFormat(pattern),
                new DecimalFormat(pattern),
                always);
    }

    private void setDecimalSeparatorAlwaysShownAndCheck(final java.text.DecimalFormat jdk,
                                                        final DecimalFormat emul,
                                                        final boolean always) {

        jdk.setDecimalSeparatorAlwaysShown(always);
        emul.setDecimalSeparatorAlwaysShown(always);

        this.check(jdk, emul, EN_AU);
    }

    // negativePrefix.........................................................................................................

    @Test
    public void testSetNegativePrefixNullToPatternFails() {
        final String pattern = "#";
        final String negativePrefix = null;

        final java.text.DecimalFormat jdk = new java.text.DecimalFormat(pattern);
        jdk.setNegativePrefix(negativePrefix);

        final DecimalFormat emul = new DecimalFormat(pattern);
        emul.setNegativePrefix(negativePrefix);

        assertThrows(NullPointerException.class, () -> jdk.toPattern());
        assertThrows(NullPointerException.class, () -> emul.toPattern());
    }

    @Test
    public void testSetNegativePrefix() {
        this.setNegativePrefixAndCheck("#", "ABC");
    }

    @Test
    public void testSetNegativePrefixCurrency() {
        this.setNegativePrefixAndCheck("#0.00", "" + DecimalFormat.CURRENCY);
    }

    @Test
    public void testSetNegativePrefixDecimalSeparator() {
        this.setNegativePrefixAndCheck("#0.00", "" + DecimalFormat.DECIMAL_SEPARATOR);
    }

    @Test
    public void testSetNegativePrefixExponent() {
        this.setNegativePrefixAndCheck("#0.00", "" + DecimalFormat.EXPONENT);
    }

    @Test
    public void testSetNegativePrefixGroupingSeparator() {
        this.setNegativePrefixAndCheck("#0.00", "" + DecimalFormat.GROUPING_SEPARATOR);
    }

    @Test
    public void testSetNegativePrefixHash() {
        this.setNegativePrefixAndCheck("#0.00", "" + DecimalFormat.HASH);
    }

    @Test
    public void testSetNegativePrefixMinusSign() {
        this.setNegativePrefixAndCheck("#0.00", "" + DecimalFormat.MINUS_SIGN);
    }

    @Test
    public void testSetNegativePrefixPercent() {
        this.setNegativePrefixAndCheck("#0.00", "" + DecimalFormat.PERCENT);
    }

    @Test
    public void testSetNegativePrefixPerMille() {
        this.setNegativePrefixAndCheck("#0.00", "" + DecimalFormat.PER_MILLE);
    }

    @Test
    public void testSetNegativePrefixZero() {
        this.setNegativePrefixAndCheck("#0.00", "" + DecimalFormat.ZERO);
    }

    @Test
    public void testSetNegativePrefixAllCharacters() {
        for (int i = 32; i < 0x8000; i++) {
            if (DecimalFormat.QUOTE == i) {
                continue;
            }
            this.setNegativePrefixAndCheck("#0.00", "" + (char) i);
        }
    }

    private void setNegativePrefixAndCheck(final String pattern,
                                           final String negativePrefix) {
        final java.text.DecimalFormat jdk = new java.text.DecimalFormat(pattern);
        jdk.setNegativePrefix(negativePrefix);

        final DecimalFormat emul = new DecimalFormat(pattern);
        emul.setNegativePrefix(negativePrefix);

        this.check(jdk, emul);
    }

    // negativeSuffix.........................................................................................................

    @Test
    public void testSetNegativeSuffixNullToPatternFails() {
        final String pattern = "#";
        final String negativeSuffix = null;

        final java.text.DecimalFormat jdk = new java.text.DecimalFormat(pattern);
        jdk.setNegativeSuffix(negativeSuffix);

        final DecimalFormat emul = new DecimalFormat(pattern);
        emul.setNegativeSuffix(negativeSuffix);

        assertThrows(NullPointerException.class, () -> jdk.toPattern());
        assertThrows(NullPointerException.class, () -> emul.toPattern());
    }

    @Test
    public void testSetNegativeSuffix() {
        this.setNegativeSuffixAndCheck("#", "ABC");
    }

    @Test
    public void testSetNegativeSuffixCurrency() {
        this.setNegativeSuffixAndCheck("#0.00", "" + DecimalFormat.CURRENCY);
    }

    @Test
    public void testSetNegativeSuffixDecimalSeparator() {
        this.setNegativeSuffixAndCheck("#0.00", "" + DecimalFormat.DECIMAL_SEPARATOR);
    }

    @Test
    public void testSetNegativeSuffixExponent() {
        this.setNegativeSuffixAndCheck("#0.00", "" + DecimalFormat.EXPONENT);
    }

    @Test
    public void testSetNegativeSuffixGroupingSeparator() {
        this.setNegativeSuffixAndCheck("#0.00", "" + DecimalFormat.GROUPING_SEPARATOR);
    }

    @Test
    public void testSetNegativeSuffixHash() {
        this.setNegativeSuffixAndCheck("#0.00", "" + DecimalFormat.HASH);
    }

    @Test
    public void testSetNegativeSuffixMinusSign() {
        this.setNegativeSuffixAndCheck("#0.00", "" + DecimalFormat.MINUS_SIGN);
    }

    @Test
    public void testSetNegativeSuffixPercent() {
        this.setNegativeSuffixAndCheck("#0.00", "" + DecimalFormat.PERCENT);
    }

    @Test
    public void testSetNegativeSuffixPerMille() {
        this.setNegativeSuffixAndCheck("#0.00", "" + DecimalFormat.PER_MILLE);
    }

    @Test
    public void testSetNegativeSuffixZero() {
        this.setNegativeSuffixAndCheck("#0.00", "" + DecimalFormat.ZERO);
    }

    @Test
    public void testSetNegativeSuffixAllCharacters() {
        for (int i = 32; i < 0x8000; i++) {
            if (DecimalFormat.QUOTE == i) {
                continue;
            }
            this.setNegativeSuffixAndCheck("#0.00", "" + (char) i);
        }
    }

    private void setNegativeSuffixAndCheck(final String pattern,
                                           final String negativeSuffix) {
        final java.text.DecimalFormat jdk = new java.text.DecimalFormat(pattern);
        jdk.setNegativeSuffix(negativeSuffix);

        final DecimalFormat emul = new DecimalFormat(pattern);
        emul.setNegativeSuffix(negativeSuffix);

        this.check(jdk, emul);
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
    public void testSetPositivePrefixNullToPatternFails() {
        final String pattern = "#";
        final String positivePrefix = null;

        final java.text.DecimalFormat jdk = new java.text.DecimalFormat(pattern);
        jdk.setPositivePrefix(positivePrefix);

        final DecimalFormat emul = new DecimalFormat(pattern);
        emul.setPositivePrefix(positivePrefix);

        assertThrows(NullPointerException.class, () -> jdk.toPattern());
        assertThrows(NullPointerException.class, () -> emul.toPattern());
    }

    @Test
    public void testSetPositivePrefix() {
        this.setPositivePrefixAndCheck("#", "ABC");
    }

    @Test
    public void testSetPositivePrefixCurrency() {
        this.setPositivePrefixAndCheck("#0.00", "" + DecimalFormat.CURRENCY);
    }

    @Test
    public void testSetPositivePrefixDecimalSeparator() {
        this.setPositivePrefixAndCheck("#0.00", "" + DecimalFormat.DECIMAL_SEPARATOR);
    }

    @Test
    public void testSetPositivePrefixExponent() {
        this.setPositivePrefixAndCheck("#0.00", "" + DecimalFormat.EXPONENT);
    }

    @Test
    public void testSetPositivePrefixGroupingSeparator() {
        this.setPositivePrefixAndCheck("#0.00", "" + DecimalFormat.GROUPING_SEPARATOR);
    }

    @Test
    public void testSetPositivePrefixHash() {
        this.setPositivePrefixAndCheck("#0.00", "" + DecimalFormat.HASH);
    }

    @Test
    public void testSetPositivePrefixMinusSign() {
        this.setPositivePrefixAndCheck("#0.00", "" + DecimalFormat.MINUS_SIGN);
    }

    @Test
    public void testSetPositivePrefixPercent() {
        this.setPositivePrefixAndCheck("#0.00", "" + DecimalFormat.PERCENT);
    }

    @Test
    public void testSetPositivePrefixPerMille() {
        this.setPositivePrefixAndCheck("#0.00", "" + DecimalFormat.PER_MILLE);
    }

    @Test
    public void testSetPositivePrefixZero() {
        this.setPositivePrefixAndCheck("#0.00", "" + DecimalFormat.ZERO);
    }

    @Test
    public void testSetPositivePrefixAllCharacters() {
        for (int i = 32; i < 0x8000; i++) {
            if (DecimalFormat.QUOTE == i) {
                continue;
            }
            this.setPositivePrefixAndCheck("#0.00", "" + (char) i);
        }
    }

    private void setPositivePrefixAndCheck(final String pattern,
                                           final String positivePrefix) {
        final java.text.DecimalFormat jdk = new java.text.DecimalFormat(pattern);
        jdk.setPositivePrefix(positivePrefix);

        final DecimalFormat emul = new DecimalFormat(pattern);
        emul.setPositivePrefix(positivePrefix);

        this.check(jdk, emul);
    }

    // positiveSuffix.........................................................................................................

    @Test
    public void testSetPositiveSuffixNullToPatternFails() {
        final String pattern = "#";
        final String positiveSuffix = null;

        final java.text.DecimalFormat jdk = new java.text.DecimalFormat(pattern);
        jdk.setPositiveSuffix(positiveSuffix);

        final DecimalFormat emul = new DecimalFormat(pattern);
        emul.setPositiveSuffix(positiveSuffix);

        assertThrows(NullPointerException.class, () -> jdk.toPattern());
        assertThrows(NullPointerException.class, () -> emul.toPattern());
    }

    @Test
    public void testSetPositiveSuffix() {
        this.setPositiveSuffixAndCheck("#", "ABC");
    }

    @Test
    public void testSetPositiveSuffixCurrency() {
        this.setPositiveSuffixAndCheck("#0.00", "" + DecimalFormat.CURRENCY);
    }

    @Test
    public void testSetPositiveSuffixDecimalSeparator() {
        this.setPositiveSuffixAndCheck("#0.00", "" + DecimalFormat.DECIMAL_SEPARATOR);
    }

    @Test
    public void testSetPositiveSuffixExponent() {
        this.setPositiveSuffixAndCheck("#0.00", "" + DecimalFormat.EXPONENT);
    }

    @Test
    public void testSetPositiveSuffixGroupingSeparator() {
        this.setPositiveSuffixAndCheck("#0.00", "" + DecimalFormat.GROUPING_SEPARATOR);
    }

    @Test
    public void testSetPositiveSuffixHash() {
        this.setPositiveSuffixAndCheck("#0.00", "" + DecimalFormat.HASH);
    }

    @Test
    public void testSetPositiveSuffixMinusSign() {
        this.setPositiveSuffixAndCheck("#0.00", "" + DecimalFormat.MINUS_SIGN);
    }

    @Test
    public void testSetPositiveSuffixPercent() {
        this.setPositiveSuffixAndCheck("#0.00", "" + DecimalFormat.PERCENT);
    }

    @Test
    public void testSetPositiveSuffixPerMille() {
        this.setPositiveSuffixAndCheck("#0.00", "" + DecimalFormat.PER_MILLE);
    }

    @Test
    public void testSetPositiveSuffixZero() {
        this.setPositiveSuffixAndCheck("#0.00", "" + DecimalFormat.ZERO);
    }

    @Test
    public void testSetPositiveSuffixAllCharacters() {
        for (int i = 32; i < 0x8000; i++) {
            if (DecimalFormat.QUOTE == i) {
                continue;
            }
            this.setPositiveSuffixAndCheck("#0.00", "" + (char) i);
        }
    }

    private void setPositiveSuffixAndCheck(final String pattern,
                                           final String positiveSuffix) {
        final java.text.DecimalFormat jdk = new java.text.DecimalFormat(pattern);
        jdk.setPositiveSuffix(positiveSuffix);

        final DecimalFormat emul = new DecimalFormat(pattern);
        emul.setPositiveSuffix(positiveSuffix);

        this.check(jdk, emul);
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
                       final NumberFormat emul) {
        this.check((java.text.DecimalFormat) jdk,
                (DecimalFormat) emul,
                Locale.getDefault());
    }

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
        this.check(jdk,
                emul,
                locale,
                false); // skipPatternCheck=true
    }

    private void check(final java.text.DecimalFormat jdk,
                       final DecimalFormat emul,
                       final Locale locale,
                       final boolean skipPatternCheck) {
        assertEquals(jdk.getCurrency(), emul.getCurrency(), () -> "currency " + locale + " " + emul);
        assertEquals(jdk.isDecimalSeparatorAlwaysShown(), emul.isDecimalSeparatorAlwaysShown(), () -> "decimalSeparatorAlwaysShown " + locale + " " + emul);
        assertEquals(jdk.getGroupingSize(), emul.getGroupingSize(), () -> "groupingSize " + locale + " " + emul);
        assertEquals(jdk.isGroupingUsed(), emul.isGroupingUsed(), () -> "groupingUsed " + locale + " " + emul);
        assertEquals(jdk.getMaximumFractionDigits(), emul.getMaximumFractionDigits(), () -> "maximumFractionDigits " + locale + " " + emul);
        assertEquals(jdk.getMinimumFractionDigits(), emul.getMinimumFractionDigits(), () -> "minimumFractionDigits " + locale + " " + emul);
        assertEquals(jdk.getMaximumIntegerDigits(), emul.getMaximumIntegerDigits(), () -> "maximumIntegerDigits " + locale + " " + emul);
        assertEquals(jdk.getMinimumIntegerDigits(), emul.getMinimumIntegerDigits(), () -> "minimumIntegerDigits " + locale + " " + emul);
        assertEquals(jdk.getMultiplier(), emul.getMultiplier(), () -> "multiplier " + locale + " " + emul);
        assertEquals(jdk.getNegativePrefix(), emul.getNegativePrefix(), () -> "negativePrefix " + locale + " " + emul);
        assertEquals(jdk.getNegativeSuffix(), emul.getNegativeSuffix(), () -> "negativeSuffix " + locale + " " + emul);
        assertEquals(jdk.isParseBigDecimal(), emul.isParseBigDecimal(), () -> "parseBigDecimal " + locale + " " + emul);
        assertEquals(jdk.isParseIntegerOnly(), emul.isParseIntegerOnly(), () -> "parseIntegerOnly " + locale + " " + emul);

        if (false == skipPatternCheck) {
            assertEquals(jdk.toPattern(), emul.toPattern(), () -> "pattern " + locale + " " + emul);
        }

        assertEquals(jdk.getPositivePrefix(), emul.getPositivePrefix(), () -> "positivePrefix " + locale + " " + emul);
        assertEquals(jdk.getPositiveSuffix(), emul.getPositiveSuffix(), () -> "positiveSuffix " + locale + " " + emul);
        assertEquals(jdk.getRoundingMode(), emul.getRoundingMode(), () -> "roundingMode " + locale + " " + emul);

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

    // format...........................................................................................................

    @Test
    public void testFormatDoublePositiveInfinity() {
        this.formatAndCheck("#", Double.POSITIVE_INFINITY);
    }

    @Test
    public void testFormatDoublePositiveInfinityWithPrefixAndSuffix() {
        this.formatAndCheck("P#N;PP#NN", Double.POSITIVE_INFINITY);
    }

    @Test
    public void testFormatDoubleNegativeInfinity() {
        this.formatAndCheck("#", Double.NEGATIVE_INFINITY);
    }

    @Test
    public void testFormatDoubleNegativeInfinityWithPrefixAndSuffix() {
        this.formatAndCheck("P#N;PP#NN", Double.NEGATIVE_INFINITY);
    }

    @Test
    public void testFormatDoubleNan() {
        this.formatAndCheck("#", Double.NaN);
    }

    @Test
    public void testFormatDoubleNanWithPrefixAndSuffix() {
        this.formatAndCheck("P#N;Q#Z", Double.NaN);
    }

    @Test
    public void testFormatZero() {
        this.formatAndCheck("#", 0);
    }

    @Test
    public void testFormatPositiveInteger() {
        this.formatAndCheck("#;NP#####", 1);
    }

    @Test
    public void testFormatPositiveInteger2() {
        this.formatAndCheck("#;NP#####", 1234);
    }

    @Test
    public void testFormatPositiveInteger3() {
        this.formatAndCheck("#;NP#####", 1234567890);
    }

    @Test
    public void testFormatNegativeInteger() {
        this.formatAndCheck("PP#PS;#", -1);
    }

    @Test
    public void testFormatNegativeInteger2() {
        this.formatAndCheck("PP#PS;#", -1234);
    }

    @Test
    public void testFormatNegativeInteger3() {
        this.formatAndCheck("PP#PS;#", -1234567890);
    }

    @Test
    public void testFormatPositiveIntegerZeroPadded() {
        this.formatAndCheck("0000", 1);
    }

    @Test
    public void testFormatPrefix() {
        this.formatAndCheck("P#", 1);
    }

    @Test
    public void testFormatSuffix() {
        this.formatAndCheck("#S", 1);
    }

    @Test
    public void testFormatPrefixAndSuffix() {
        this.formatAndCheck("PP#SS", 1);
    }

    @Test
    public void testFormatPositiveIntegerAlwaysDecimalShown() {
        final String pattern = "#";
        final boolean always = true;

        final java.text.DecimalFormat jdk = new java.text.DecimalFormat(pattern);
        jdk.setDecimalSeparatorAlwaysShown(always);

        final DecimalFormat emul = new DecimalFormat(pattern);
        emul.setDecimalSeparatorAlwaysShown(always);

        this.formatAndCheck(jdk, emul, 1);
    }

    @Test
    public void testFormatIntegerFractionRounding() {
        this.formatAndCheck("#",
                RoundingMode.HALF_UP,
                1.25);
    }

    @Test
    public void testFormatIntegerFractionRounding2() {
        this.formatAndCheck("#",
                RoundingMode.HALF_UP,
                1.5);
    }

    @Test
    public void testFormatIntegerCustomZero() {
        final String pattern = "#0";

        final java.text.DecimalFormatSymbols jdkSymbols = new java.text.DecimalFormatSymbols(EN_AU);
        jdkSymbols.setZeroDigit('A');
        final java.text.DecimalFormat jdk = new java.text.DecimalFormat(pattern, jdkSymbols);

        final DecimalFormatSymbols emulSymbols = new DecimalFormatSymbols(EN_AU);
        emulSymbols.setZeroDigit('A');
        final DecimalFormat emul = new DecimalFormat(pattern, emulSymbols);

        this.formatAndCheck(jdk,
                emul,
                1234567);
    }

    @Test
    public void testFormatIntegerMaximumIntegerDigits() {
        final String pattern = "#0";
        final int max = 2;

        final java.text.DecimalFormat jdk = new java.text.DecimalFormat(pattern);
        jdk.setMaximumIntegerDigits(max);

        final DecimalFormat emul = new DecimalFormat(pattern);
        emul.setMaximumIntegerDigits(max);

        this.formatAndCheck(jdk,
                emul,
                1);
    }

    @Test
    public void testFormatIntegerMaximumIntegerDigits2() {
        final String pattern = "#0";
        final int max = 2;

        final java.text.DecimalFormat jdk = new java.text.DecimalFormat(pattern);
        jdk.setMaximumIntegerDigits(max);

        final DecimalFormat emul = new DecimalFormat(pattern);
        emul.setMaximumIntegerDigits(max);

        this.formatAndCheck(jdk,
                emul,
                1234567);
    }

    @Test
    public void testFormatFraction() {
        this.formatAndCheck("#",
                RoundingMode.HALF_UP,
                1.5);
    }

    @Test
    public void testFormatFractionNegative() {
        this.formatAndCheck("#",
                RoundingMode.HALF_UP,
                -1.5);
    }

    @Test
    public void testFormatFractionCustomZero() {
        final String pattern = "#.#";

        final java.text.DecimalFormatSymbols jdkSymbols = new java.text.DecimalFormatSymbols(EN_AU);
        jdkSymbols.setZeroDigit('A');
        final java.text.DecimalFormat jdk = new java.text.DecimalFormat(pattern, jdkSymbols);

        final DecimalFormatSymbols emulSymbols = new DecimalFormatSymbols(EN_AU);
        emulSymbols.setZeroDigit('A');
        final DecimalFormat emul = new DecimalFormat(pattern, emulSymbols);

        this.formatAndCheck(jdk,
                emul,
                123.5);
    }

    @Test
    public void testFormatGroupingValueLessThanGrouping() {
        this.formatAndCheck("#,000",
                1);
    }

    @Test
    public void testFormatGroupingValueLessThanGrouping2() {
        this.formatAndCheck("#,000",
                12);
    }

    @Test
    public void testFormatGroupingValueLessThanGrouping3() {
        this.formatAndCheck("#,000",
                123);
    }

    @Test
    public void testFormatGrouping() {
        this.formatAndCheck("#,000",
                1234);
    }

    @Test
    public void testFormatGroupingTwoGroups() {
        this.formatAndCheck("#,000",
                12345678);
    }

    @Test
    public void testFormatGroupingWithFraction() {
        this.formatAndCheck("#,000.0",
                1234.5);
    }

    @Test
    public void testFormatCurrency() {
        Locale.setDefault(EN_AU);

        final String pattern = CURRENCY + "#";

        final java.text.DecimalFormat jdk = new java.text.DecimalFormat(pattern);
        final DecimalFormat emul = new DecimalFormat(pattern);

        this.formatAndCheck(jdk,
                emul,
                123.5);
    }

    @Test
    public void testFormatInternationalCurrency() {
        Locale.setDefault(EN_AU);

        final String pattern = "" + CURRENCY + CURRENCY + "#";

        final java.text.DecimalFormat jdk = new java.text.DecimalFormat(pattern);
        final DecimalFormat emul = new DecimalFormat(pattern);

        this.formatAndCheck(jdk,
                emul,
                123.5);
    }

    @Test
    public void testFormatPercent() {
        Locale.setDefault(EN_AU);

        final String pattern = "%#";

        final java.text.DecimalFormat jdk = new java.text.DecimalFormat(pattern);
        final DecimalFormat emul = new DecimalFormat(pattern);

        this.formatAndCheck(jdk,
                emul,
                123.5);
    }

    @Test
    public void testFormatPerMille() {
        Locale.setDefault(EN_AU);

        final String pattern = DecimalFormat.PER_MILLE + "#";

        final java.text.DecimalFormat jdk = new java.text.DecimalFormat(pattern);
        final DecimalFormat emul = new DecimalFormat(pattern);

        this.formatAndCheck(jdk,
                emul,
                123.5);
    }

    // formatScientific.................................................................................................

    @Test
    public void testFormatScientificZeroOneSignificant() {
        this.formatAndCheck("#.#E0",
                RoundingMode.HALF_UP,
                0);
    }

    @Test
    public void testFormatScientificZeroTwoSignificant() {
        this.formatAndCheck("##.#E0",
                RoundingMode.HALF_UP,
                0);
    }

    @Test
    public void testFormatScientificOneSignificantLarge() {
        this.formatAndCheck("#.#E0",
                RoundingMode.HALF_UP,
                12);
    }

    @Test
    public void testFormatScientificOneSignificant() {
        this.formatAndCheck("#.#E0",
                RoundingMode.HALF_UP,
                1.2);
    }

    @Test
    public void testFormatScientificOneSignificant2() {
        this.formatAndCheck("#.#E0",
                RoundingMode.HALF_UP,
                1.5);
    }

    @Test
    public void testFormatScientificOneSignificantSmall() {
        this.formatAndCheck("#.#E0",
                RoundingMode.HALF_UP,
                0.23);
    }

    @Test
    public void testFormatScientificOneSignificantSmall2() {
        this.formatAndCheck("#.#E0",
                RoundingMode.HALF_UP,
                0.25);
    }

    @Test
    public void testFormatScientificTwoSignificantLarge() {
        this.formatAndCheck("##.#E0",
                RoundingMode.HALF_UP,
                12);
    }

    @Test
    public void testFormatScientificTwoSignificantLarge2() {
        this.formatAndCheck("##.#E0",
                RoundingMode.HALF_UP,
                15);
    }

    @Test
    public void testFormatScientificTwoSignificant() {
        this.formatAndCheck("##.#E0",
                RoundingMode.HALF_UP,
                1.23,
                "12.3e-1");
    }

    @Test
    public void testFormatScientificTwoSignificant2() {
        this.formatAndCheck("##.#E0",
                RoundingMode.HALF_UP,
                1.53,
                "15.3e-1");
    }

    @Test
    public void testFormatScientificTwoSignificant3() {
        this.formatAndCheck("00.0E0",
                RoundingMode.HALF_UP,
                1.2,
                "12.0e-1");
    }

    @Test
    public void testFormatScientificTwoSignificant4() {
        this.formatAndCheck("00.0E0",
                RoundingMode.HALF_UP,
                1.23);
    }

    @Test
    public void testFormatScientificTwoSignificant4Rounding() {
        this.formatAndCheck("00.0E0",
                RoundingMode.HALF_UP,
                1.234);
    }

    @Test
    public void testFormatScientificTwoSignificantSmall() {
        this.formatAndCheck("##.#E0",
                RoundingMode.HALF_UP,
                0.23);
    }

    @Test
    public void testFormatScientificTwoSignificantSmall2() {
        this.formatAndCheck("##.#E0",
                RoundingMode.HALF_UP,
                0.25);
    }

    // helpers..........................................................................................................

    private void formatAndCheck(final String pattern,
                                final Object value) {
        this.formatAndCheck(pattern,
                RoundingMode.UNNECESSARY,
                value);
    }

    private void formatAndCheck(final String pattern,
                                final RoundingMode roundingMode,
                                final Object value) {
        this.formatAndCheck(pattern,
                roundingMode,
                value,
                EN_AU);
    }

    private void formatAndCheck(final String pattern,
                                final RoundingMode roundingMode,
                                final Object value,
                                final Locale locale) {
        Locale.setDefault(locale);

        final java.text.DecimalFormat jdk = new java.text.DecimalFormat(pattern);
        jdk.setRoundingMode(roundingMode);

        final DecimalFormat emul = new DecimalFormat(pattern);
        emul.setRoundingMode(roundingMode);

        this.formatAndCheck(jdk, emul, value, locale);
    }

    private void formatAndCheck(final java.text.DecimalFormat jdk,
                                final DecimalFormat emul,
                                final Object value) {
        this.formatAndCheck(jdk, emul, value, EN_AU);
    }

    private void formatAndCheck(final java.text.DecimalFormat jdk,
                                final DecimalFormat emul,
                                final Object value,
                                final Locale locale) {
        this.check(jdk, emul, locale, true);

        this.formatAndCheck(emul, value, locale, jdk.format(value));
    }

    private void formatAndCheck(final String pattern,
                                final RoundingMode roundingMode,
                                final Object value,
                                final String expected) {
        final Locale locale = EN_AU;
        Locale.setDefault(locale);

        final DecimalFormat emul = new DecimalFormat(pattern);
        emul.setRoundingMode(roundingMode);

        this.formatAndCheck(emul, value, locale, expected);
    }

    private void formatAndCheck(final DecimalFormat emul,
                                final Object value,
                                final Locale locale,
                                final String expected) {
        assertEquals(expected,
                emul.format(value),
                () -> emul.toPattern() + " value " + value + " locale " + locale + " decimalFormat: " + emul);
    }

    // parse............................................................................................................

    @Test
    public void testParseDoubleNan() {
        Locale.setDefault(DEFAULT_LOCALE);
        this.parseAndCheck("0", "" + new DecimalFormatSymbols().getNaN());
    }

    @Test
    public void testParseDoublePositiveInfinity() {
        Locale.setDefault(DEFAULT_LOCALE);
        this.parseAndCheck("0", "" + new DecimalFormatSymbols().getInfinity());
    }

    @Test
    public void testParseDoublePositiveInfinityWithPrefixAndSuffix() {
        Locale.setDefault(DEFAULT_LOCALE);
        this.parseAndCheck("P0S;Q0Z", "" + new DecimalFormatSymbols().getInfinity());
    }

    @Test
    public void testParseDoubleNegativeInfinity() {
        Locale.setDefault(DEFAULT_LOCALE);
        this.parseAndCheck("0", "" + new DecimalFormatSymbols().getInfinity());
    }

    @Test
    public void testParseDoubleNegativeInfinityWithPrefixAndSuffix() {
        Locale.setDefault(DEFAULT_LOCALE);
        this.parseAndCheck("P0S;Q0Z", "" + new DecimalFormatSymbols().getInfinity());
    }

    @Test
    public void testParseIntegerTooFewDigits() {
        this.parseBigDecimalOnlyAndCheck("00", "1");
    }

    @Test
    public void testParseIntegerTooFewDigits2() {
        this.parseBigDecimalOnlyAndCheck("0000", "123");
    }

    @Test
    public void testParseIntegerTooManyDigits() {
        this.parseBigDecimalOnlyAndCheck("0", "12");
    }

    @Test
    public void testParseIntegerTooManyDigits2() {
        this.parseBigDecimalOnlyAndCheck("00", "123");
    }

    @Test
    public void testParseFractionTooFewDigits() {
        this.parseBigDecimalOnlyAndCheck("0.00", "1");
    }

    @Test
    public void testParseFractionTooFewDigits2() {
        this.parseBigDecimalOnlyAndCheck("0.000", "1.23");
    }

    @Test
    public void testParseFractionTooManyDigits() {
        this.parseBigDecimalOnlyAndCheck("0", "1.2");
    }

    @Test
    public void testParseFractionTooManyDigits2() {
        this.parseBigDecimalOnlyAndCheck("0.0", "1.23");
    }

    @Test
    public void testParseZeroBigDecimalOnly() {
        this.parseBigDecimalOnlyAndCheck("#", "0");
    }

    @Test
    public void testParseZeroIntegerOnly() {
        this.parseIntegerOnlyAndCheck("#", "0");
    }

    @Test
    public void testParseZero() {
        this.parseAndCheck("#", "0");
    }

    @Test
    public void testParseOneBigDecimalOnly() {
        this.parseBigDecimalOnlyAndCheck("#", "1");
    }

    @Test
    public void testParseOneIntegerOnly() {
        this.parseIntegerOnlyAndCheck("#", "1");
    }

    @Test
    public void testParseOne() {
        this.parseAndCheck("#", "1");
    }

    @Test
    public void testParseMinusOneBigDecimalOnly() {
        this.parseBigDecimalOnlyAndCheck("#", "-1");
    }

    @Test
    public void testParseMinusOneIntegerOnly() {
        this.parseIntegerOnlyAndCheck("#", "-1");
    }

    @Test
    public void testParseMinusOne() {
        this.parseAndCheck("#", "-1");
    }

    @Test
    public void testParseZeroHalfBigDecimalOnly() {
        this.parseBigDecimalOnlyAndCheck("#.#", "0.5");
    }

    @Test
    public void testParseZeroHalfIntegerOnly() {
        this.parseIntegerOnlyAndCheck("#.#", "0.5");
    }

    @Test
    public void testParseZeroHalf() {
        this.parseAndCheck("#.#", "0.5");
    }

    @Test
    public void testParseHalfBigDecimalOnly() {
        this.parseBigDecimalOnlyAndCheck("#.#", ".5");
    }

    @Test
    public void testParseHalfIntegerOnly() {
        this.parseIntegerOnlyAndCheck("#.#", ".5");
    }

    @Test
    public void testParseHalf() {
        this.parseAndCheck("#.#", ".5");
    }

    @Test
    public void testParseGroupingSeparators() {
        this.parseAndCheck("#,###.#", "1,234.5");
    }

    @Test
    public void testParseIntegerExponent() {
        this.parseAndCheck("#E0", "1e5");
    }

    @Test
    public void testParseIntegerExponentNegative() {
        this.parseAndCheck("#E0", "1e-5");
    }

    @Test
    public void testParseIntegerFractionExponent() {
        this.parseAndCheck("#.#E0", "1.2e5");
    }

    @Test
    public void testParseIntegerFractionExponentNegative() {
        this.parseAndCheck("#.#E0", "1.2e-5");
    }

    @Test
    public void testParsePercentage() {
        this.parseAndCheck("#%", "123%");
    }

    @Test
    public void testParsePercentage2() {
        this.parseAndCheck("#.#%", "12.34%");
    }

    @Test
    public void testParsePerMille() {
        this.parseAndCheck("#" + DecimalFormat.PER_MILLE, "123" + DecimalFormat.PER_MILLE);
    }

    @Test
    public void testParsePerMille2() {
        this.parseAndCheck("#" + DecimalFormat.PER_MILLE, "12.34" + DecimalFormat.PER_MILLE);
    }

    @Test
    public void testParseCurrency() {
        this.parseAndCheck(DecimalFormat.CURRENCY + "#.00", "$1.25");
    }

    private void parseBigDecimalOnlyAndCheck(final String pattern,
                                             final String value) {
        final Locale locale = EN_AU;
        Locale.setDefault(locale);

        final java.text.DecimalFormat jdk = new java.text.DecimalFormat(pattern);
        jdk.setParseBigDecimal(true);

        final DecimalFormat emul = new DecimalFormat(pattern);
        emul.setParseBigDecimal(true);

        this.parseAndCheck(jdk,
                emul,
                value);
    }

    private void parseIntegerOnlyAndCheck(final String pattern,
                                          final String value) {
        final Locale locale = EN_AU;
        Locale.setDefault(locale);

        final java.text.DecimalFormat jdk = new java.text.DecimalFormat(pattern);
        jdk.setParseIntegerOnly(true);

        final DecimalFormat emul = new DecimalFormat(pattern);
        emul.setParseIntegerOnly(true);

        this.parseAndCheck(jdk,
                emul,
                value);
    }

    private void parseAndCheck(final String pattern,
                               final String value) {
        final Locale locale = DEFAULT_LOCALE;
        Locale.setDefault(locale);

        this.parseAndCheck(new java.text.DecimalFormat(pattern),
                new DecimalFormat(pattern),
                value);
    }

    private void parseAndCheck(final java.text.DecimalFormat jdk,
                               final DecimalFormat emul,
                               final String value) {
        final java.text.ParsePosition jdkPosition = new java.text.ParsePosition(0);
        final ParsePosition emulPosition = new ParsePosition(0);

        assertEquals(jdk.parse(value, jdkPosition),
                emul.parse(value, emulPosition),
                () -> jdk.toPattern() + " parse " + CharSequences.quoteAndEscape(value) + " jdk: " + jdk + " emul: " + emul);
        assertEquals(jdkPosition.getIndex(),
                emulPosition.getIndex(),
                () -> "index, " + jdk.toPattern() + " parse " + CharSequences.quoteAndEscape(value) + " jdk: " + jdk + " emul: " + emul);
        assertEquals(jdkPosition.getErrorIndex(),
                emulPosition.getErrorIndex(),
                () -> "error index, " + jdk.toPattern() + " parse " + CharSequences.quoteAndEscape(value) + " jdk: " + jdk + " emul: " + emul);
    }

    // equals............................................................................................................

    @Test
    public void testDifferentCurrency() {
        final DecimalFormat format = this.createObject();
        format.setCurrency(Currency.getInstance("NZD"));
        this.checkNotEquals(format);
    }

    @Test
    public void testDifferentDecimalSeparatorAlwaysShown() {
        final DecimalFormat format = this.createObject();
        format.setDecimalSeparatorAlwaysShown(!DECIMAL_SEPARATOR_ALWAYS_SHOWN);
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
        format.setDecimalSeparatorAlwaysShown(DECIMAL_SEPARATOR_ALWAYS_SHOWN);
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
        Locale.setDefault(Locale.forLanguageTag("en-AU"));
        this.toStringAndCheck(this.createObject(),
                "currency=AUD groupingSize=10 maximumFractionDigits=8 minimumFractionDigits=4 maximumIntegerDigits=20 minimumIntegerDigits=10 multiplier=100 negativePrefix=\"NegativePrefix1\" negativeSuffix=\"NegativeSuffix2\" numberComponents=# positivePrefix=\"PositivePrefix1\" positiveSuffix=\"PositiveSuffix2\" roundingMode=HALF_EVEN symbols=currency=AUD currencySymbol=\"$\" decimalSeparator='.' digit='#' exponentSeparator=\"e\" groupingSeparator=',' infinity=\"∞\" internationalCurrencySymbol=\"AUD\" minusSign='-' monetaryDecimalSeparator='.' nan=\"NaN\" patternSeparator=';' percent='%' perMill='‰' zeroDigit='0'");
    }

    @Test
    public void testToStringDecimalSeparatorAlwaysShown() {
        Locale.setDefault(Locale.forLanguageTag("en-AU"));

        final DecimalFormat format = new DecimalFormat("###.00", new DecimalFormatSymbols(Locale.forLanguageTag("en-AU")));
        format.setDecimalSeparatorAlwaysShown(true);

        this.toStringAndCheck(format,
                "currency=AUD decimalSeparatorAlwaysShown=true maximumFractionDigits=2 minimumFractionDigits=2 maximumIntegerDigits=2147483647 minimumIntegerDigits=1 multiplier=1 negativePrefix=\"-\" numberComponents=#.00 roundingMode=HALF_EVEN symbols=currency=AUD currencySymbol=\"$\" decimalSeparator='.' digit='#' exponentSeparator=\"e\" groupingSeparator=',' infinity=\"∞\" internationalCurrencySymbol=\"AUD\" minusSign='-' monetaryDecimalSeparator='.' nan=\"NaN\" patternSeparator=';' percent='%' perMill='‰' zeroDigit='0'");
    }

    @Test
    public void testToStringLongPattern() {
        Locale.setDefault(Locale.forLanguageTag("en-AU"));

        this.toStringAndCheck(new DecimalFormat("###.00", new DecimalFormatSymbols(Locale.forLanguageTag("en-AU"))),
                "currency=AUD maximumFractionDigits=2 minimumFractionDigits=2 maximumIntegerDigits=2147483647 minimumIntegerDigits=1 multiplier=1 negativePrefix=\"-\" numberComponents=#.00 roundingMode=HALF_EVEN symbols=currency=AUD currencySymbol=\"$\" decimalSeparator='.' digit='#' exponentSeparator=\"e\" groupingSeparator=',' infinity=\"∞\" internationalCurrencySymbol=\"AUD\" minusSign='-' monetaryDecimalSeparator='.' nan=\"NaN\" patternSeparator=';' percent='%' perMill='‰' zeroDigit='0'");
    }

    @Test
    public void testToStringPositiveNegativePattern() {
        Locale.setDefault(Locale.forLanguageTag("es-CL"));

        this.toStringAndCheck(new DecimalFormat("¤#,##0;¤-#,##0"),
                "currency=CLP groupingSize=3 groupingUsed=true maximumIntegerDigits=2147483647 minimumIntegerDigits=1 multiplier=1 negativePrefix=\"$-\" numberComponents=#,##0 positivePrefix=\"$\" roundingMode=HALF_EVEN symbols=currency=CLP currencySymbol=\"$\" decimalSeparator=',' digit='#' exponentSeparator=\"E\" groupingSeparator='.' infinity=\"∞\" internationalCurrencySymbol=\"CLP\" minusSign='-' monetaryDecimalSeparator=',' nan=\"NaN\" patternSeparator=';' percent='%' perMill='‰' zeroDigit='0'");
    }

    // ClassTesting.....................................................................................................

    @Override
    public Class<DecimalFormat> type() {
        return DecimalFormat.class;
    }
}
