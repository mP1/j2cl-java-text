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

final class SimpleDateFormatComponentDayNumberOfWeek extends SimpleDateFormatComponentNumber {

    final static char LETTER = DAY_NUMBER_OF_WEEK;

    static SimpleDateFormatComponentDayNumberOfWeek with(final int patternLength,
                                                         final int maxDigitLength) {
        return new SimpleDateFormatComponentDayNumberOfWeek(patternLength,
            maxDigitLength);
    }

    private SimpleDateFormatComponentDayNumberOfWeek(final int patternLength,
                                                     final int maxDigitLength) {
        super(patternLength, maxDigitLength);
    }

    @Override
    SimpleDateFormatComponentDayNumberOfWeek setNumberNext() {
        return new SimpleDateFormatComponentDayNumberOfWeek(this.length, 1);
    }

    // format...........................................................................................................

    @Override
    int calendarField() {
        return Calendar.DAY_OF_WEEK;
    }

    @Override
    int adjustReadValue(int day) {
        final int number;

        switch (day) {
            case 0:
                number = 7;
                break;
            case 1:
                number = 7;
                break;
            default:
                number = day - 1;
                break;
        }

        return number;
    }

    // parse............................................................................................................

    @Override
    int adjustWriteValue(final int value,
                         final SimpleDateFormatParseRequest parse) {
        final int day;

        switch (value) {
            case 0:
                day = 7;
                break;
            case 8:
                day = 8;
                break;
            default:
                day = value < 8 ?
                    value + 1 :
                    (value % 7);
                break;
        }

        return day;
    }

    // SimpleDateFormatComponent2.......................................................................................

    @Override
    char letter() {
        return LETTER;
    }
}