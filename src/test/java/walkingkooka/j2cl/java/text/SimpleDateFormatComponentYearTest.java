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

import javaemul.internal.annotations.GwtIncompatible;
import org.junit.jupiter.api.Test;

import java.util.Date;

public final class SimpleDateFormatComponentYearTest extends SimpleDateFormatComponentNumberTestCase<SimpleDateFormatComponentYear> {

    @Test
    public void testFormatYearAll1() {
        this.formatYearAndCheck(1);
    }

    @Test
    public void testFormatYearAll2() {
        this.formatYearAndCheck(2);
    }

    @Test
    public void testFormatYearAll3() {
        this.formatYearAndCheck(3);
    }

    @Test
    public void testFormatYearAll4() {
        this.formatYearAndCheck(4);
    }

    private void formatYearAndCheck(final int length) {
        for (int year = 1800; year < 2050; year++) {
            this.formatDateAndCheck(length, new Date(Date.UTC(year - 1900, 1, 2, 3, 4, 5)));
        }
    }

    @Override
    SimpleDateFormatComponentYear createComponent(final int patternLength,
                                                  final int maxDigitLength) {
        return SimpleDateFormatComponentYear.with(patternLength,
            maxDigitLength);
    }

    @Override
    public Class<SimpleDateFormatComponentYear> type() {
        return SimpleDateFormatComponentYear.class;
    }

    @GwtIncompatible
    public static void main(final String[] a) throws Exception {
        final Date twoDigit = new Date(Date.UTC(1905 - 1900, 0, 0, 0, 0, 0));

        final java.text.SimpleDateFormat sdf1 = new java.text.SimpleDateFormat("y");
        sdf1.set2DigitYearStart(twoDigit);

        final java.text.SimpleDateFormat sdf2 = new java.text.SimpleDateFormat("yy");
        sdf2.set2DigitYearStart(twoDigit);

        final java.text.SimpleDateFormat sdf3 = new java.text.SimpleDateFormat("yyy");
        sdf3.set2DigitYearStart(twoDigit);

        final java.text.SimpleDateFormat sdf4 = new java.text.SimpleDateFormat("yyyy");
        sdf4.set2DigitYearStart(twoDigit);

        for (int i = 0; i < 120; i++) {
            System.out.println(i + " \ty: " + sdf1.parse(String.valueOf(i)) + " \tyy: " + sdf2.parse(String.valueOf(i)) + " \tyyy: " + sdf3.parse(String.valueOf(i)) + " \tyyyy: " + sdf4.parse(String.valueOf(i)));
        }
    }
}
