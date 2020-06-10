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

import java.sql.Date;
import java.util.Calendar;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertTrue;

public final class SimpleDateFormatComponentDayNumberOfWeekTest extends SimpleDateFormatComponentNumberTestCase<SimpleDateFormatComponentDayNumberOfWeek> {

    @Test
    public void testFormatSunday() {
        this.formatDateAndCheck0(7, "Sun");
    }

    @Test
    public void testFormatMonday() {
        this.formatDateAndCheck0(1, "Mon");
    }

    @Test
    public void testFormatThursday() {
        this.formatDateAndCheck0(4, "Thu");
    }

    @Test
    public void testFormatFriday() {
        this.formatDateAndCheck0(5, "Fri");
    }

    @Test
    public void testFormatSaturday() {
        this.formatDateAndCheck0(6, "Sat");
    }

    private void formatDateAndCheck0(final int day, final String dowName) {
        final Date date = new Date(Date.UTC(2020 - 1900, Calendar.JUNE, day, 12, 58, 59));
        final String dateToString = new java.text.SimpleDateFormat("EEE yyyy/MMM/dd", Locale.ENGLISH)
                .format(date);
        assertTrue(dateToString.contains(dowName), dateToString + " missing " + dowName);

        this.formatDateAndCheck(1, date);
    }

    @Test
    public void testParseZeroToFifty() {
        for(int i = 0; i < 50; i++) {
            this.parseTextAndCheck(1, "" + i);
            this.parseTextAndCheck(2, "" + i);
            this.parseTextAndCheck(3, "" + i);
        }
    }

    @Override
    SimpleDateFormatComponentDayNumberOfWeek createComponent(final int length) {
        return SimpleDateFormatComponentDayNumberOfWeek.with(length);
    }

    @Override
    public Class<SimpleDateFormatComponentDayNumberOfWeek> type() {
        return SimpleDateFormatComponentDayNumberOfWeek.class;
    }
}
