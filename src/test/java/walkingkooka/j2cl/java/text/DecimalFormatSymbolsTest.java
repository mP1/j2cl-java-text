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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import walkingkooka.HashCodeEqualsDefinedTesting2;
import walkingkooka.ToStringTesting;
import walkingkooka.collect.set.Sets;
import walkingkooka.j2cl.locale.WalkingkookaLanguageTag;
import walkingkooka.reflect.ClassTesting;
import walkingkooka.reflect.JavaVisibility;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Currency;
import java.util.Locale;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public final class DecimalFormatSymbolsTest implements ClassTesting<DecimalFormatSymbols>,
        HashCodeEqualsDefinedTesting2<DecimalFormatSymbols>,
        ToStringTesting<DecimalFormatSymbols> {

    @BeforeEach
    public void beforeEach() {
        DateFormatSymbols.DEFAULT = null;
    }

    // getAvailableLocales..............................................................................................

    @Test
    public void testGetAvailableLocales() {
        final Comparator<Locale> comparator = (l, r) -> l.toLanguageTag().compareTo(r.toLanguageTag());

        final Set<Locale> jdk = Sets.sorted(comparator);
        for(final Locale locale : java.text.DateFormatSymbols.getAvailableLocales()) {
            switch(locale.toString()) {
                case "th_TH_TH_#u-nu-thai":
                case "ja_JP_JP_#u-ca-japanese":
                case "no_NO_NY":
                    break;
                default:
                    jdk.add(locale);
            }
        }

        final Set<Locale> emulated = Sets.sorted(comparator);
        emulated.addAll(Arrays.asList(DecimalFormatSymbols.getAvailableLocales()));

        assertEquals(jdk, emulated);
    }

    // getInstance......................................................................................................

    @Test
    public void testGetInstance() {
        DecimalFormatSymbols.DEFAULT = null;

        final java.util.Locale locale = Locale.FRENCH;
        java.util.Locale.setDefault(locale);

        this.check(DecimalFormatSymbols.getInstance(),
                java.text.DecimalFormatSymbols.getInstance(),
                locale);
    }

    @Test
    public void testGetInstance2() {
        DecimalFormatSymbols.DEFAULT = null;

        final java.util.Locale locale = Locale.GERMAN;
        java.util.Locale.setDefault(locale);

        this.check(DecimalFormatSymbols.getInstance(),
                java.text.DecimalFormatSymbols.getInstance(),
                locale);
    }

    @Test
    public void testGetInstanceSingleton() {
        DecimalFormatSymbols.DEFAULT = null;

        final java.util.Locale locale = Locale.GERMAN;
        java.util.Locale.setDefault(locale);

        assertEquals(java.text.DecimalFormatSymbols.getInstance(), java.text.DecimalFormatSymbols.getInstance());
    }

    @Test
    public void testGetInstanceCloned() {
        DecimalFormatSymbols.DEFAULT = null;

        final java.util.Locale locale = Locale.ITALIAN;
        java.util.Locale.setDefault(locale);

        final DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
        symbols.setInfinity("symbols was not cloned if this property value is present!!!");

        assertNotEquals(symbols, DecimalFormatSymbols.getInstance());
    }

    // getInstance(Locale)...............................................................................................

    @Test
    public void testGetInstanceLocale() {
        final java.util.Locale locale = Locale.FRENCH;
        java.util.Locale.setDefault(locale);
        Locale.setDefault(Locale.forLanguageTag(locale.toLanguageTag()));

        this.check(DecimalFormatSymbols.getInstance(locale),
                new java.text.DecimalFormatSymbols(locale),
                locale);
    }

    @Test
    public void testGetInstanceLocaleAllLocales() {
        for (final Locale locale : Locale.getAvailableLocales()) {
            if(WalkingkookaLanguageTag.isUnsupported(locale.toLanguageTag())) {
                continue;
            }
            this.check(DecimalFormatSymbols.getInstance(locale),
                    java.text.DecimalFormatSymbols.getInstance(locale),
                    locale);
        }
    }

    // new..............................................................................................................

    @Test
    public void testNew() {
        final Locale locale = Locale.FRENCH;
        Locale.setDefault(locale);
        Locale.setDefault(Locale.forLanguageTag(locale.toLanguageTag()));

        this.check(new DecimalFormatSymbols(),
                new java.text.DecimalFormatSymbols(),
                locale);
    }

    @Test
    public void testNewLocale() {
        final Locale locale = Locale.FRENCH;
        Locale.setDefault(locale);
        Locale.setDefault(Locale.forLanguageTag(locale.toLanguageTag()));

        DecimalFormatSymbols.getAvailableLocales();

        this.check(new DecimalFormatSymbols(locale),
                new java.text.DecimalFormatSymbols(locale),
                locale);
    }

    private void check(final DecimalFormatSymbols emulated,
                       final java.text.DecimalFormatSymbols expected,
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

    // currency.........................................................................................................

    @Test
    public void testCurrencyEnAu() {
        this.getCurrencyAndCheck(Locale.forLanguageTag("en-au"));
    }

    @Test
    public void testCurrencyEnCa() {
        this.getCurrencyAndCheck(Locale.forLanguageTag("en-ca"));
    }

    @Test
    public void testCurrencyAllLocales() {
        for (final Locale locale : java.text.DecimalFormatSymbols.getAvailableLocales()) {
            if (WalkingkookaLanguageTag.isUnsupported(locale.toLanguageTag())) {
                continue;
            }
            this.getCurrencyAndCheck(locale);
        }
    }

    private void getCurrencyAndCheck(final Locale locale) {
        Locale.setDefault(locale);
        getCurrencyAndCheck(new java.text.DecimalFormatSymbols(),
                new DecimalFormatSymbols(),
                locale);
    }

    private void getCurrencyAndCheck(final java.text.DecimalFormatSymbols jdk,
                                     final DecimalFormatSymbols emul,
                                     final Locale locale) {

        assertEquals(jdk.getCurrency(),
                emul.getCurrency(),
                () -> "currency " + locale);
        this.getCurrencySymbolAndCheck(jdk, emul, locale);
    }

    private void getCurrencySymbolAndCheck(final java.text.DecimalFormatSymbols jdk,
                                           final DecimalFormatSymbols emul,
                                           final Locale locale) {

        assertEquals(jdk.getCurrencySymbol(),
                emul.getCurrencySymbol(),
                () -> "currencySymbol " + locale);
    }

    @Test
    public void testSetCurrencyNullFails() {
        assertThrows(NullPointerException.class, () -> new java.text.DecimalFormatSymbols().setCurrency(null));
        assertThrows(NullPointerException.class, () -> new DecimalFormatSymbols().setCurrency(null));
    }

    @Test
    public void testSetCurrencySymbolNullFails() {
        assertThrows(NullPointerException.class, () -> new DecimalFormatSymbols().setCurrencySymbol(null));
    }

    @Test
    public void testSetCurrencyNZD() {
        this.setCurrencyAndCheck(Locale.forLanguageTag("en-au"),
                Currency.getInstance("NZD"));
    }

    @Test
    public void testSetCurrencyEuro() {
        this.setCurrencyAndCheck(Locale.forLanguageTag("en-au"),
                Currency.getInstance("EUR"));
    }

    @Test
    public void testSetCurrencyAllLocalesAUD() {
        for (final Locale locale : Locale.getAvailableLocales()) {
            if (WalkingkookaLanguageTag.isUnsupported(locale.toLanguageTag())) {
                continue;
            }
            this.setCurrencyAndCheck(locale,
                    Currency.getInstance("AUD"));
        }
    }

    @Test
    public void testSetCurrencyAllLocalesAllCurrencies() {
        for (final Locale locale : Locale.getAvailableLocales()) {
            if (WalkingkookaLanguageTag.isUnsupported(locale.toLanguageTag())) {
                continue;
            }
            for (final Currency currency : Currency.getAvailableCurrencies()) {
                this.setCurrencyAndCheck(locale,
                        currency);
            }
        }
    }

    private void setCurrencyAndCheck(final Locale locale,
                                     final Currency currency) {
        Locale.setDefault(locale);

        final java.text.DecimalFormatSymbols jdk = new java.text.DecimalFormatSymbols();
        jdk.setCurrency(currency);

        final DecimalFormatSymbols emul = new DecimalFormatSymbols();
        emul.setCurrency(currency);

        this.getCurrencyAndCheck(jdk, emul, locale);
    }

    @Test
    public void testSetCurrencySymbolNZD() {
        this.setCurrencySymbolAndCheck(Locale.forLanguageTag("en-au"), "NZD");
    }

    @Test
    public void testSetCurrencySymbolAllLocalesAUD() {
        for (final Locale locale : Locale.getAvailableLocales()) {
            if (WalkingkookaLanguageTag.isUnsupported(locale.toLanguageTag())) {
                continue;
            }
            this.setCurrencySymbolAndCheck(locale, "AUD");
        }
    }

    @Test
    public void testSetCurrencySymbolAllLocalesAllCurrencySymbols() {
        for (final Locale locale : Locale.getAvailableLocales()) {
            if (WalkingkookaLanguageTag.isUnsupported(locale.toLanguageTag())) {
                continue;
            }

            for (final Currency currency : Currency.getAvailableCurrencies()) {
                this.setCurrencySymbolAndCheck(locale, currency.getSymbol());
            }
        }
    }

    private void setCurrencySymbolAndCheck(final Locale locale,
                                           final String currencySymbol) {
        Locale.setDefault(locale);

        final java.text.DecimalFormatSymbols jdk = new java.text.DecimalFormatSymbols();
        jdk.setCurrencySymbol(currencySymbol);

        final DecimalFormatSymbols emul = new DecimalFormatSymbols();
        emul.setCurrencySymbol(currencySymbol);

        this.getCurrencyAndCheck(jdk, emul, locale);
    }

    // exponent.........................................................................................................

    @Test
    public void testSetExponentSeparatorNullFails() {
        assertThrows(NullPointerException.class, () -> new java.text.DecimalFormatSymbols().setExponentSeparator(null));
        assertThrows(NullPointerException.class, () -> new DecimalFormatSymbols().setExponentSeparator(null));
    }

    // clone............................................................................................................

    @Test
    public void testClone() {
        this.cloneAndCheck(new DecimalFormatSymbols());
    }

    @Test
    public void testClone2() {
        Locale.setDefault(Locale.forLanguageTag("EN-AU"));

        final DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setCurrency(Currency.getInstance("AUD"));
        symbols.setCurrencySymbol("$");
        symbols.setDecimalSeparator('.');
        symbols.setDigit('D');
        symbols.setExponentSeparator("E");
        symbols.setGroupingSeparator('G');
        symbols.setInfinity("I");
        symbols.setInternationalCurrencySymbol("@");
        symbols.setMinusSign('-');
        symbols.setMonetaryDecimalSeparator('M');
        symbols.setNaN("N");
        symbols.setPatternSeparator('P');
        symbols.setPercent('%');
        symbols.setPerMill('T');
        symbols.setZeroDigit('Z');

        this.cloneAndCheck(symbols);
    }

    private void cloneAndCheck(final DecimalFormatSymbols symbols) {
        this.checkEquals(symbols, symbols.clone());
    }

    // equals...........................................................................................................

    @Test
    public void testDifferentLocale() {
        this.checkNotEquals(new DecimalFormatSymbols(Locale.FRANCE));
    }

    @Test
    public void testDifferentCurrency() {
        final DecimalFormatSymbols symbols = this.createObject();
        symbols.setCurrency(Currency.getInstance("NZD"));
        this.checkNotEquals(symbols);
    }

    @Test
    public void testDifferentCurrencySymbol() {
        final DecimalFormatSymbols symbols = this.createObject();
        symbols.setCurrencySymbol("Q");
        this.checkNotEquals(symbols);
    }

    @Test
    public void testDifferentDecimalSeparator() {
        final DecimalFormatSymbols symbols = this.createObject();
        symbols.setDecimalSeparator('Q');
        this.checkNotEquals(symbols);
    }

    @Test
    public void testDifferentDigit() {
        final DecimalFormatSymbols symbols = this.createObject();
        symbols.setDigit('Q');
        this.checkNotEquals(symbols);
    }

    @Test
    public void testDifferentExponentSymbol() {
        final DecimalFormatSymbols symbols = this.createObject();
        symbols.setExponentSeparator("Q");
        this.checkNotEquals(symbols);
    }

    @Test
    public void testDifferentGroupingSeparator() {
        final DecimalFormatSymbols symbols = this.createObject();
        symbols.setGroupingSeparator('Q');
        this.checkNotEquals(symbols);
    }

    @Test
    public void testDifferentInfinity() {
        final DecimalFormatSymbols symbols = this.createObject();
        symbols.setInfinity("Q");
        this.checkNotEquals(symbols);
    }

    @Test
    public void testDifferentInternationalCurrencySymbol() {
        final DecimalFormatSymbols symbols = this.createObject();
        symbols.setInternationalCurrencySymbol("Q");
        this.checkNotEquals(symbols);
    }

    @Test
    public void testDifferentMinusSign() {
        final DecimalFormatSymbols symbols = this.createObject();
        symbols.setMinusSign('Q');
        this.checkNotEquals(symbols);
    }

    @Test
    public void testDifferentMonetaryDecimalSeparator() {
        final DecimalFormatSymbols symbols = this.createObject();
        symbols.setMonetaryDecimalSeparator('Q');
        this.checkNotEquals(symbols);
    }

    @Test
    public void testDifferentNaN() {
        final DecimalFormatSymbols symbols = this.createObject();
        symbols.setNaN("Q");
        this.checkNotEquals(symbols);
    }

    @Test
    public void testDifferentPatternSeparator() {
        final DecimalFormatSymbols symbols = this.createObject();
        symbols.setPatternSeparator('Q');
        this.checkNotEquals(symbols);
    }

    @Test
    public void testDifferentPercent() {
        final DecimalFormatSymbols symbols = this.createObject();
        symbols.setPercent('Q');
        this.checkNotEquals(symbols);
    }

    @Test
    public void testDifferentPerMill() {
        final DecimalFormatSymbols symbols = this.createObject();
        symbols.setPerMill('Q');
        this.checkNotEquals(symbols);
    }

    @Test
    public void testDifferentZeroDigit() {
        final DecimalFormatSymbols symbols = this.createObject();
        symbols.setZeroDigit('Q');
        this.checkNotEquals(symbols);
    }

    // String...........................................................................................................

    @Test
    public void testToString() {
        this.toStringAndCheck(this.createObject(),
                "currency=XXX currencySymbol=\"¤\" decimalSeparator='.' digit='#' exponentSeparator=\"E\" groupingSeparator=',' infinity=\"∞\" internationalCurrencySymbol=\"XXX\" minusSign='-' monetaryDecimalSeparator='.' nan=\"NaN\" patternSeparator=';' percent='%' perMill='‰' zeroDigit='0'");
    }

    // ClassTesting.....................................................................................................

    @Override
    public Class<DecimalFormatSymbols> type() {
        return DecimalFormatSymbols.class;
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PUBLIC;
    }

    // HashCodeEqualsDefinedTesting2....................................................................................

    @Override
    public DecimalFormatSymbols createObject() {
        return new DecimalFormatSymbols(Locale.ENGLISH);
    }
}
