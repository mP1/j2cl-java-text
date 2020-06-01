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

import walkingkooka.text.CharSequences;

import java.util.Calendar;

final class SimpleDateFormatRequest {

    static SimpleDateFormatRequest with(final Calendar calendar,
                                        final StringBuffer text,
                                        final DateFormatSymbols symbols,
                                        final boolean daylightSavingTime) {
        return new SimpleDateFormatRequest(calendar, text, symbols, daylightSavingTime);
    }

    private SimpleDateFormatRequest(final Calendar calendar,
                                    final StringBuffer text,
                                    final DateFormatSymbols symbols,
                                    final boolean daylightSavingTime) {
        super();
        this.calendar = calendar;
        this.text = text;
        this.symbols = symbols;
        this.daylightSavingTime = daylightSavingTime;
    }
    
    final Calendar calendar;

    final StringBuffer text;

    final DateFormatSymbols symbols;

    boolean daylightSavingTime;

    @Override
    public String toString() {
        return this.calendar + " " + CharSequences.quoteAndEscape(this.text) + " " + symbols + " " + daylightSavingTime;
    }
}
