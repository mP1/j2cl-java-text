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

import java.util.Calendar;
import java.util.TimeZone;

final class SimpleDateFormatComponentTimeZoneIso8601 extends SimpleDateFormatComponent2 {

    final static char LETTER = TIME_ZONE_ISO8601;

    static SimpleDateFormatComponentTimeZoneIso8601 with(final int length) {
        return new SimpleDateFormatComponentTimeZoneIso8601(length);
    }

    private SimpleDateFormatComponentTimeZoneIso8601(final int length) {
        super(length);
    }

    // format...........................................................................................................

    @Override
    void formatDate(final SimpleDateFormatFormatRequest request) {
        final Calendar calendar = request.calendar;
        final TimeZone timeZone = calendar.getTimeZone();

        final int daylightSaving = timeZone.inDaylightTime(calendar.getTime()) ?
                calendar.get(Calendar.DST_OFFSET) :
                0;
        final int offset = (calendar.get(Calendar.ZONE_OFFSET) + daylightSaving) / 36000;
        final int absolute = Math.abs(offset);

        final StringBuffer text = request.text;

        if (0 == offset) {
            text.append('Z');
        } else {
            text.append(offset < 0 ? '-' : '+');
            final int hours = absolute / 100;
            final int minutes = (int)(((absolute - hours * 100f)/ 100f) * 60);

            switch (this.length) {
                case 1:
                    addDoubleDigit(hours, text); // ignore minutes component
                    break;
                case 2:
                    addDoubleDigit(hours, text);
                    addDoubleDigit(minutes, text);
                    break;
                case 3:
                    addDoubleDigit(hours, text);
                    text.append(':');
                    addDoubleDigit(minutes, text);
                    break;
                default:
                    break;
            }
        }
    }

    private void addDoubleDigit(final int value, final StringBuffer text) {
        if(value < 10) {
            text.append('0');
        }
        text.append(value);
    }

    // SimpleDateFormatComponent........................................................................................

    @Override
    char letter() {
        return LETTER;
    }
}