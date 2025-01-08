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

final class SimpleDateFormatComponentDayInYear extends SimpleDateFormatComponentNumber {

    final static char LETTER = DAY_IN_YEAR;

    static SimpleDateFormatComponentDayInYear with(final int patternLength,
                                                   final int maxDigitLength) {
        return new SimpleDateFormatComponentDayInYear(patternLength,
            maxDigitLength);
    }

    private SimpleDateFormatComponentDayInYear(final int patternLength,
                                               final int maxDigitLength) {
        super(patternLength, maxDigitLength);
    }

    @Override
    SimpleDateFormatComponentDayInYear setNumberNext() {
        return new SimpleDateFormatComponentDayInYear(this.length, 3);
    }

    // format...........................................................................................................

    @Override
    int calendarField() {
        return Calendar.DAY_OF_YEAR;
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

    // SimpleDateFormatComponent........................................................................................

    @Override
    char letter() {
        return LETTER;
    }
}