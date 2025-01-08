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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;


@J2clTestInput(JunitTest.class)
public class JunitTest {

    @Test
    public void testGetDateInstanceShortENAU() {
        this.getDateInstanceCheck(DateFormat.SHORT, "EN-AU", "d/M/yy");
    }

    @Test
    public void testGetDateInstanceMediumENCA() {
        this.getDateInstanceCheck(DateFormat.MEDIUM, "EN-CA", "MMM d, y");
    }

    @Test
    public void testGetDateInstanceFullENNZ() {
        this.getDateInstanceCheck(DateFormat.FULL, "EN-NZ", "EEEE, d MMMM y");
    }

    private void getDateInstanceCheck(final int style,
                                      final String locale,
                                      final String pattern) {
        Locale.setDefault(Locale.forLanguageTag("EN-AU"));
        TimeZone.setDefault(TimeZone.getTimeZone("Australia/Sydney"));
        Assert.assertEquals(pattern,
            ((SimpleDateFormat) DateFormat.getDateInstance(style, Locale.forLanguageTag(locale))).toPattern());
    }
}
