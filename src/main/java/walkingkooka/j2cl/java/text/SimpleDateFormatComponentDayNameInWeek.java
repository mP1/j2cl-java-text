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

import javaemul.internal.annotations.GwtIncompatible;

import java.util.Calendar;

final class SimpleDateFormatComponentDayNameInWeek extends SimpleDateFormatComponent2 {

    final static char LETTER = DAY_NAME_IN_WEEK;

    static SimpleDateFormatComponentDayNameInWeek with(final int length) {
        return new SimpleDateFormatComponentDayNameInWeek(length);
    }

    private SimpleDateFormatComponentDayNameInWeek(final int length) {
        super(length);
    }

    @Override
    boolean isNumber() {
        return false;
    }

    @Override
    SimpleDateFormatComponent setNumberNext() {
        return this; // dont care if followed by a number.
    }

    // format...........................................................................................................

    @Override
    void formatDate(final SimpleDateFormatFormatRequest request) {
        final int day = request.calendar.get(CALENDAR_FIELD);
        final int length = this.length;
        final DateFormatSymbols symbols = request.symbols;

        switch(length) {
            case 1:
            case 2:
            case 3:
                this.formatName(request, day, symbols.getShortWeekdays());
                break;
            default:
                this.formatName(request, day, symbols.getWeekdays());
                break;
        }
    }

    // parse...........................................................................................................

    @Override
    void parseText(final SimpleDateFormatParseRequest request) {
        final DateFormatSymbols symbols = request.symbols;
        this.parseFromOptionsAndUpdateCalendar(request,
                CALENDAR_FIELD,
                1,
                symbols.getWeekdays(), symbols.getShortWeekdays());
    }

    private final static int CALENDAR_FIELD = Calendar.DAY_OF_WEEK;

    // SimpleDateFormatComponent........................................................................................

    @Override
    char letter() {
        return LETTER;
    }

    @Override
    int maxDigitLength() {
        return 0;
    }

    @GwtIncompatible
    public static void main(final String[] args) throws Exception{
        System.out.println(new java.text.SimpleDateFormat("dd/MM/yyyy E").parse("6/6/2000 Saturday"));
        System.out.println(new java.text.SimpleDateFormat("dd/MM/yyyy EE").parse("6/6/2000 Sat."));
        System.out.println(new java.text.SimpleDateFormat("dd/MM/yyyy EEE").parse("6/6/2000 Sat."));
        System.out.println(new java.text.SimpleDateFormat("dd/MM/yyyy EEEE").parse("6/6/2000 Saturday"));
        System.out.println(new java.text.SimpleDateFormat("dd/MM/yyyy EEEE").parse("6/6/2000 Sat."));
    }
}