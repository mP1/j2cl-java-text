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
package test;

import com.google.gwt.junit.client.GWTTestCase;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import walkingkooka.j2cl.locale.LocaleAware;

@LocaleAware
public class TestGwtTest extends GWTTestCase {
    @Override
    public String getModuleName() {
        return "test.Test";
    }

    public void testAssertEquals() {
        assertEquals(
            1,
            1
        );
    }

    public void testDecimalFormat() throws Exception {
        final DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(
            Locale.forLanguageTag("EN-AU")
        );

        assertEquals(
            "12.490",
            decimalFormat.format(12.49)
        );
    }

    public void testSimpleDateFormatParse() throws Exception {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
            "yyyy-MM-dd",
            Locale.forLanguageTag("EN-AU")
        );

        Date date = simpleDateFormat.parse("1999-12-31");

        assertEquals(
            1999 - 1900,
            date.getYear()
        );

        assertEquals(
            12 - 1,
            date.getMonth()
        );

//        assertEquals(
//                31,
//                date.getDate()
//        );
    }
}
