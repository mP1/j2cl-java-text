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
import walkingkooka.reflect.ClassTesting;
import walkingkooka.reflect.JavaVisibility;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class DecimalFormatSymbolsTest implements ClassTesting<DecimalFormatSymbols>,
        HashCodeEqualsDefinedTesting2<DecimalFormatSymbols>,
        ToStringTesting<DecimalFormatSymbols> {

    @Test
    public void testNew() {
        final Locale locale = Locale.FRENCH;
        Locale.setDefault(locale);
        Locale.setDefault(Locale.forLanguageTag(locale.toLanguageTag()));

        this.check(new DecimalFormatSymbols(), new java.text.DecimalFormatSymbols());
    }

    @Test
    public void testNewLocale() {
        final Locale locale = Locale.FRENCH;
        Locale.setDefault(locale);
        Locale.setDefault(Locale.forLanguageTag(locale.toLanguageTag()));

        this.check(new DecimalFormatSymbols(Locale.getDefault()), new java.text.DecimalFormatSymbols(locale));
    }

    private void check(final DecimalFormatSymbols emulated,
                       final java.text.DecimalFormatSymbols expected) {

        assertEquals(expected.getCurrency().toString(), emulated.getCurrency(), "currency");
        assertEquals(expected.getCurrencySymbol(), emulated.getCurrencySymbol(), "currencySymbol");
        assertEquals(expected.getDecimalSeparator(), emulated.getDecimalSeparator(), "decimalSeparator");
        assertEquals(expected.getDigit(), emulated.getDigit(), "digit");
        assertEquals(expected.getExponentSeparator(), emulated.getExponentSeparator(), "exponentSeparator");
        assertEquals(expected.getGroupingSeparator(), emulated.getGroupingSeparator(), "groupingSeparator");
        assertEquals(expected.getInfinity(), emulated.getInfinity(), "infinity");
        assertEquals(expected.getInternationalCurrencySymbol(), emulated.getInternationalCurrencySymbol(), "internationalCurrencySymbol");
        assertEquals(expected.getMinusSign(), emulated.getMinusSign(), "minusSign");
        assertEquals(expected.getMonetaryDecimalSeparator(), emulated.getMonetaryDecimalSeparator(), "monetaryDecimalSeparator");
        assertEquals(expected.getNaN(), emulated.getNaN(), "nan");
        assertEquals(expected.getPatternSeparator(), emulated.getPatternSeparator(), "patternSeparator");
        assertEquals(expected.getPercent(), emulated.getPercent(), "percent");
        assertEquals(expected.getPerMill(), emulated.getPerMill(), "perMill");
        assertEquals(expected.getZeroDigit(), emulated.getZeroDigit(), "zeroDigit");
    }

    // clone............................................................................................................

    @Test
    public void testCloneState() {
        this.cloneStateAndCheck(new DecimalFormatSymbols());
    }

    @Test
    public void testCloneState2() {
        final DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setCurrency("AUD");
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

        this.cloneStateAndCheck(symbols);
    }

    private void cloneStateAndCheck(final DecimalFormatSymbols symbols) {
        this.checkEquals(symbols, symbols.cloneState());
    }

    // equals...........................................................................................................

    @Test
    public void testDifferentLocale() {
        this.checkNotEquals(new DecimalFormatSymbols(Locale.FRANCE));
    }

    @Test
    public void testDifferentCurrency() {
        final DecimalFormatSymbols symbols = this.createObject();
        symbols.setCurrency("Q");
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
                "currency=\"XXX\" currencySymbol=\"¤\" decimalSeparator='.' digit='#' exponentSeparator=\"E\" groupingSeparator=',' infinity=\"∞\" internationalCurrencySymbol=\"XXX\" minusSign='-' monetaryDecimalSeparator='.' nan=\"NaN\" patternSeparator=';' percent='%' perMill='‰' zeroDigit='0'");
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
