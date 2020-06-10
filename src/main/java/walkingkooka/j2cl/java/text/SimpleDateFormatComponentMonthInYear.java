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

final class SimpleDateFormatComponentMonthInYear extends SimpleDateFormatComponent2 {

    final static char LETTER = MONTH_IN_YEAR;

    static SimpleDateFormatComponentMonthInYear with(final int length) {
        return new SimpleDateFormatComponentMonthInYear(length);
    }

    private SimpleDateFormatComponentMonthInYear(final int length) {
        super(length);
    }

    // format...........................................................................................................

    @Override
    void formatDate(final SimpleDateFormatFormatRequest request) {
        final int month = request.calendar.get(CALENDAR_FIELD);
        final int length = this.length;

        switch(length) {
            case 1:
            case 2:
                this.formatNumericValue(request, month + 1, length);
                break;
            case 3:
                this.formatName(request, month, request.symbols.getShortMonths());
                break;
            default:
                this.formatName(request, month, request.symbols.getMonths());
                break;
        }
    }

    @Override
    void parseText(final SimpleDateFormatParseRequest request) {
        final int length = this.length;

        switch (length) {
            case 1:
            case 2:
                this.parseNumberAndUpdateCalendar(request,
                        CALENDAR_FIELD,
                        Integer.MAX_VALUE,
                        SimpleDateFormatComponentMonthInYear::adjustWriteValue);
                break;
            default:
                final DateFormatSymbols symbols = request.symbols;
                this.parseFromOptionsAndUpdateCalendar(request,
                        CALENDAR_FIELD,
                        0,
                        symbols.getMonths(),
                        symbols.getShortMonths());
                break;
        }
    }

    private static Integer adjustWriteValue(final Integer month,
                                            final SimpleDateFormatParseRequest request) {
        return Math.max(0, month -1);
    }

    private final static int CALENDAR_FIELD = Calendar.MONTH;

    // SimpleDateFormatComponent2.......................................................................................

    @Override
    char letter() {
        return LETTER;
    }
}
