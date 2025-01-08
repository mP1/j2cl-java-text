/*
 * Copyright © 2020 Miroslav Pokorny
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
 */
package test;


import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import walkingkooka.text.CharSequences;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;


@J2clTestInput(JunitTest.class)
public class JunitTest {

    @Before
    public void setDefaultLocale() {
        Locale.setDefault(Locale.forLanguageTag("EN-AU")); // TODO https://github.com/mP1/j2cl-java-util-Locale/issues/88
    }

    // format...........................................................................................................

    @Test
    public void testFormatIntegerRequiredTrailingZerosWithAuLocale() {
        this.formatAndCheck("###.00000", "EN-AU", 123, "123.00000");
    }

    @Test
    public void testFormatIntegerRequiredLeadingZerosWithFrLocale() {
        this.formatAndCheck("00000.#", "FR", 123, "00123,0");
    }

    @Test
    public void testFormatDoubleGBLocale() {
        this.formatAndCheck("0", "EN-GB", 123.456, "123");
    }

    @Test
    public void testFormatPercentCanadaLocale() {
        this.formatAndCheck("0%", "EN-CA", 0.45, "45%");
    }

    @Test
    public void testFormatBigDecimalCurrencyAuLocale() {
        this.formatAndCheck(NumberFormat.getCurrencyInstance(Locale.forLanguageTag("EN-AU")),
            BigDecimal.valueOf(123.45),
            "$123.45");
    }

    @Test
    public void testFormatBigDecimalCurrencyFRLocale() {
        this.formatAndCheck(NumberFormat.getCurrencyInstance(Locale.forLanguageTag("FR-FR")),
            BigDecimal.valueOf(123.45),
            "123,45 €");
    }

    @Test
    public void testFormatGrouping() {
        this.formatAndCheck("#,####.00", "EN-AU",
            BigDecimal.valueOf(12345.6),
            "1,2345.60");
    }

    @Test
    public void testFormatCustomFormatAndSymbols() {
        final DecimalFormatSymbols symbols = symbols("FR-FR");
        symbols.setDecimalSeparator('D');
        symbols.setMinusSign('M');
        symbols.setGroupingSeparator('G');

        final DecimalFormat format = new DecimalFormat("0.000", symbols);
        format.setGroupingUsed(true);
        format.setGroupingSize(4);

        this.formatAndCheck(format, -123456789.12, "M1G2345G6789D120");
    }

    private void formatAndCheck(final String pattern,
                                final String symbolsLocale,
                                final double number,
                                final String expected) {
        this.formatAndCheck(pattern, symbolsLocale, Double.valueOf(number), expected);
    }

    private void formatAndCheck(final String pattern,
                                final String symbolsLocale,
                                final Number number,
                                final String expected) {
        this.formatAndCheck(this.decimalFormat(pattern, symbolsLocale),
            number,
            expected);
    }

    private void formatAndCheck(final NumberFormat format,
                                final Number number,
                                final String expected) {
        Assert.assertEquals("format number " + number + " with " + format,
            expected,
            format.format(number)
        );
    }

    // parse............................................................................................................

    @Test
    public void testParse() throws ParseException {
        this.parseAndCheck("0", "EN-AU", "123", 123L);
    }

    @Test
    public void testParseCurrency() throws ParseException {
        this.parseAndCheck("$0.00", "EN-AU", "$123.50", 123.50);
    }

    @Test
    public void testParsePercent() throws ParseException {
        this.parseAndCheck("0.0%", "EN-AU", "123.45", 1.2345);
    }

    @Test
    public void testParseCustomFormatAndSymbols() throws ParseException {
        final DecimalFormatSymbols symbols = symbols("FR-FR");
        symbols.setDecimalSeparator('D');
        symbols.setMinusSign('M');
        symbols.setGroupingSeparator('G');

        final DecimalFormat format = new DecimalFormat("0.000", symbols);
        format.setGroupingUsed(true);
        format.setGroupingSize(4);

        this.parseAndCheck(format, "M1G2345G6789D120", -123456789.12);
    }

    private void parseAndCheck(final String pattern,
                               final String locale,
                               final String text,
                               final Number expected) throws ParseException {
        this.parseAndCheck(this.decimalFormat(pattern, locale),
            text,
            expected);
    }

    private void parseAndCheck(final NumberFormat format,
                               final String text,
                               final Number expected) throws ParseException {
        Assert.assertEquals("parse " + CharSequences.quote(text) + " with format " + format,
            expected,
            format.parse(text)
        );
    }

    private DecimalFormat decimalFormat(final String pattern, final String symbolsLocale) {
        return new DecimalFormat(pattern, symbols(symbolsLocale));
    }

    private DecimalFormatSymbols symbols(final String symbolsLocale) {
        return new DecimalFormatSymbols(java.util.Locale.forLanguageTag(symbolsLocale));
    }
}
