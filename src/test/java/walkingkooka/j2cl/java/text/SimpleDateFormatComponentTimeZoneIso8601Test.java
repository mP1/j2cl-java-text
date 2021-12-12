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
    public void testFormatDateAdelaide() {
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

    // parse ...........................................................................................................

    // plus/minus two-digit-hours

    @Test
    public void testParseText1MissingSignFails() {
        this.parseTextAndCheck(1, "");
    }

    @Test
    public void testParseText1MissingSignFails2() {
        this.parseTextAndCheck(1, "Q");
    }

    @Test
    public void testParseText1IncompleteHoursFails() {
        this.parseTextAndCheck(1, "-1");
    }

    @Test
    public void testParseText1InvalidHoursFails() {
        this.parseTextAndCheck(1, "-99");
    }

    @Test
    public void testParseText1HoursMinus10() {
        this.parseTextAndCheck(1, "-10");
    }

    @Test
    public void testParseText1HoursMinus05() {
        this.parseTextAndCheck(1, "-05");
    }

    @Test
    public void testParseText1HoursPlus10() {
        this.parseTextAndCheck(1, "+10");
    }

    @Test
    public void testParseText1HoursPlus05() {
        this.parseTextAndCheck(1, "+05");
    }

    // plus/minus two-digit-hours two-digit-minutes

    @Test
    public void testParseText2MissingSign() {
        this.parseTextAndCheck(2, "");
    }

    @Test
    public void testParseText2MissingSign2() {
        this.parseTextAndCheck(2, "Q");
    }

    @Test
    public void testParseText2MissingHours() {
        this.parseTextAndCheck(2, "-");
    }

    @Test
    public void testParseText2IncompletegHoursFails() {
        this.parseTextAndCheck(2, "-1");
    }

    @Test
    public void testParseText2MissingMinutesFails() {
        this.parseTextAndCheck(2, "-10");
    }

    @Test
    public void testParseText2IncompleteMinutesFails() {
        this.parseTextAndCheck(2, "-102");
    }

    @Test
    public void testParseText2InvalidHoursFails() {
        this.parseTextAndCheck(2, "+9930");
    }

    @Test
    public void testParseText2InvalidMinutesFails() {
        this.parseTextAndCheck(2, "+0099");
    }

    @Test
    public void testParseText2HoursMinus1045() {
        this.parseTextAndCheck(2, "-1045");
    }

    @Test
    public void testParseText2HoursMinus0530() {
        this.parseTextAndCheck(2, "-0530");
    }

    @Test
    public void testParseText2HoursPlus1045() {
        this.parseTextAndCheck(2, "+1045");
    }

    @Test
    public void testParseText2HoursPlus0530() {
        this.parseTextAndCheck(2, "+0530");
    }

    // plus/minus two-digit-hours colon two-digit-minutes

    @Test
    public void testParseText3MissingSignFails() {
        this.parseTextAndCheck(3, "");
    }

    @Test
    public void testParseText3MissingSignFails2() {
        this.parseTextAndCheck(3, "Q");
    }

    @Test
    public void testParseText3MissingHoursFails() {
        this.parseTextAndCheck(3, "-");
    }

    @Test
    public void testParseText3HoursOnlyFails() {
        this.parseTextAndCheck(3, "-10");
    }

    @Test
    public void testParseText3MissingColonFails() {
        this.parseTextAndCheck(3, "-10:");
    }

    @Test
    public void testParseText3IncompleteMinutesFails() {
        this.parseTextAndCheck(3, "-10:1");
    }

    @Test
    public void testParseText3HoursMinus10Colon45() {
        this.parseTextAndCheck(3, "-10:45");
    }

    @Test
    public void testParseText3HoursMinus05Colon30() {
        this.parseTextAndCheck(3, "-05:30");
    }

    @Test
    public void testParseText3HoursPlus10Colon45() {
        this.parseTextAndCheck(3, "+10:45");
    }

    @Test
    public void testParseText3HoursPlus05Colon30() {
        this.parseTextAndCheck(3, "+05:30");
    }

    private void parseTextAndCheck(final int length,
                                   final String text) {
        this.parseTextAndCheck(this.createComponent(length),
                text);
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
