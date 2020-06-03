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
import walkingkooka.text.CharSequences;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public final class SimpleDateFormatComponentTimeZoneIso8601Test extends SimpleDateFormatComponentTestCase2<SimpleDateFormatComponentTimeZoneIso8601> {

    @Test
    public final void testFormatDateAdelaide() {
        this.formatDateAndCheck(1, DATE, Locale.forLanguageTag("Australia/Adelaide"));
    }

    @Test
    public void testAllTimeOffset1() {
        this.allTimeZoneOffsetsAndCheck(1);
    }

    @Test
    public void testAllTimeOffset2() {
        this.allTimeZoneOffsetsAndCheck(2);
    }

    @Test
    public void testAllTimeOffset3() {
        this.allTimeZoneOffsetsAndCheck(3);
    }

    private void allTimeZoneOffsetsAndCheck(final int length) {
        for (final String zoneId : TimeZone.getAvailableIDs()) {
            final TimeZone timeZone = TimeZone.getTimeZone(zoneId);
            final Calendar calendar = Calendar.getInstance(timeZone, LOCALE);
            calendar.setTime(DATE);
            calendar.setTimeZone(timeZone);

            TimeZone.setDefault(timeZone);

            this.formatDateAndCheck(SimpleDateFormatComponentTimeZoneIso8601.with(length),
                    calendar,
                    new DateFormatSymbols(LOCALE),
                    false,
                    new java.text.SimpleDateFormat(CharSequences.repeating('X', length).toString(), LOCALE).format(calendar.getTime()));
        }
    }

    @Override
    SimpleDateFormatComponentTimeZoneIso8601 createComponent(final int length) {
        return SimpleDateFormatComponentTimeZoneIso8601.with(length);
    }

    @Override
    public Class<SimpleDateFormatComponentTimeZoneIso8601> type() {
        return SimpleDateFormatComponentTimeZoneIso8601.class;
    }
}
