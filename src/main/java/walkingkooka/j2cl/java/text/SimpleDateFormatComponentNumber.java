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

/**
 * Base class for most {@link SimpleDateFormatComponent} holding a run count for the length of that pattern.
 */
abstract class SimpleDateFormatComponentNumber extends SimpleDateFormatComponent2 {

    /**
     * Package private to limit sub classing.
     */
    SimpleDateFormatComponentNumber(final int length) {
        super(length);
    }

    // formatDate.......................................................................................................

    @Override
    final void formatDate(final SimpleDateFormatFormatRequest request) {
        this.formatCalendarFieldNumericValue(request, this.calendarField(), this::adjustReadValue, this.length);
    }

    abstract int calendarField();

    abstract int adjustReadValue(final int value);

    // parseText........................................................................................................

    @Override
    final void parseText(final SimpleDateFormatParseRequest request) {
        this.parseNumberAndUpdateCalendar(request,
                this.calendarField(),
                Integer.MAX_VALUE,
                this::adjustWriteValue);
    }

    /**
     * Some fields such as year need special support for the value that is about to be set.
     */
    abstract int adjustWriteValue(final int value,
                                  final SimpleDateFormatParseRequest parse);

    final int adjustWriteYearValue(final int value,
                                   final SimpleDateFormatParseRequest parse) {
        return value >= 10 && value < 100 && this.length <= 2 ?
                parse.adjustTwoDigitYear(value) :
                value;
    }
}
