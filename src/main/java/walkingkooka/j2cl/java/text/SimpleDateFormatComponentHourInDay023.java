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

/**
 * Hour in day pattern code <code>H</code> where hour values are between 0 and 23.
 */
final class SimpleDateFormatComponentHourInDay023 extends SimpleDateFormatComponentNumber {

    final static char LETTER = HOUR_IN_DAY_0_23;

    static SimpleDateFormatComponentHourInDay023 with(final int patternLength,
                                                      final int maxDigitLength) {
        return new SimpleDateFormatComponentHourInDay023(patternLength,
                maxDigitLength);
    }

    private SimpleDateFormatComponentHourInDay023(final int patternLength,
                                                  final int maxDigitLength) {
        super(patternLength, maxDigitLength);
    }

    @Override
    SimpleDateFormatComponentHourInDay023 setNumberNext() {
        return new SimpleDateFormatComponentHourInDay023(this.length, 2);
    }

    // format...........................................................................................................

    @Override
    int calendarField() {
        return Calendar.HOUR_OF_DAY;
    }

    @Override
    int adjustReadValue(final int value) {
        return value;
    }

    // parse............................................................................................................

    @Override
    int adjustWriteValue(final int value,
                         final SimpleDateFormatParseRequest parse) {
        return value;
    }

    // SimpleDateFormatComponent2.......................................................................................

    @Override
    char letter() {
        return LETTER;
    }
}
