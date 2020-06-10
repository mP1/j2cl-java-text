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

final class SimpleDateFormatComponentEra extends SimpleDateFormatComponent2 {

    final static char LETTER = ERA;

    static SimpleDateFormatComponentEra with(final int length) {
        return new SimpleDateFormatComponentEra(length);
    }

    private SimpleDateFormatComponentEra(final int length) {
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
        this.formatCalendarFieldName(request,
                CALENDAR_FIELD,
                request.symbols.getEras());
    }

    // parse...........................................................................................................

    @Override
    void parseText(final SimpleDateFormatParseRequest request) {
        final DateFormatSymbols symbols = request.symbols;
        this.parseFromOptionsAndUpdateCalendar(request,
                CALENDAR_FIELD,
                0,
                symbols.getEras());
    }

    private final static int CALENDAR_FIELD = Calendar.ERA;

    // SimpleDateFormatComponent2.......................................................................................

    @Override
    char letter() {
        return LETTER;
    }

    @Override
    int maxDigitLength() {
        return 0;
    }

//    @GwtIncompatible
//    public static void main(final String[] args) throws Exception{
//        //System.out.println(new java.text.SimpleDateFormat("dd/MM/yyyy G").parse("1/12/2000 A"));
//        System.out.println(new java.text.SimpleDateFormat("dd/MM/yyyy GG").parse("1/12/2000 AD"));
//        //System.out.println(new java.text.SimpleDateFormat("dd/MM/yyyy GG").parse("1/12/2000 A")); <- fails must be complete match
//        System.out.println(new java.text.SimpleDateFormat("dd/MM/yyyy GG").parse("1/12/2000 AD"));
//    }
}
