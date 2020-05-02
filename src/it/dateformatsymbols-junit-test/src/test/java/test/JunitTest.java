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
import org.junit.Test;
import walkingkooka.collect.list.Lists;

import java.util.Arrays;
import java.util.Currency;
import java.util.Locale;
import java.util.stream.Collectors;


@J2clTestInput(JunitTest.class)
public class JunitTest {

    @Test
    public void testENAUCurrencyCode() {
        this.getCurrencyAndCheckCurrencyCode("EN-AU", "AUD");
    }

    @Test
    public void testENNZCurrencyCode() {
        this.getCurrencyAndCheckCurrencyCode("EN-NZ", "NZD");
    }

    private void getCurrencyAndCheckCurrencyCode(final String locale, final String currencyCode) {
        final Currency currency = Currency.getInstance(Locale.forLanguageTag(locale));
        Assert.assertEquals(currencyCode, currency.getCurrencyCode());
    }

    @Test
    public void testGetAvailableLocalesAllEnglish() {
        Assert.assertNotEquals(Lists.empty(),
                Arrays.stream(java.text.DateFormatSymbols.getAvailableLocales())
                        .filter(l -> l.getLanguage().equalsIgnoreCase("EN"))
                        .collect(Collectors.toList()));
    }

    @Test
    public void testENAUWeekdays() {
        final java.text.DateFormatSymbols symbols = java.text.DateFormatSymbols.getInstance(Locale.forLanguageTag("EN-AU"));

        // Assert.assertArrayEquals not implemented
        Assert.assertEquals("[, Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday]", Arrays.toString(symbols.getWeekdays()));
    }
}
