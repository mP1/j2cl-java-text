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
 * A millisecond with a pattern letter of <code>S</code>
 */
final class SimpleDateFormatComponentMilli extends SimpleDateFormatComponentNumber {

    final static char LETTER = MILLI;

    static SimpleDateFormatComponentMilli with(final int patternLength,
                                               final int maxDigitLength) {
        return new SimpleDateFormatComponentMilli(patternLength,
                maxDigitLength);
    }

    private SimpleDateFormatComponentMilli(final int patternLength,
                                           final int maxDigitLength) {
        super(patternLength, maxDigitLength);
    }

    @Override
    SimpleDateFormatComponentMilli setNumberNext() {
        return this; // parsing will fail if a number follows a milli, maybe should honour $maxDigitLength
    }

    // format...........................................................................................................

    @Override
    int calendarField() {
        return Calendar.MILLISECOND;
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
