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

import walkingkooka.j2cl.locale.Calendar;

final class SimpleDateFormatComponentTimeZoneRfc822 extends SimpleDateFormatComponent2 {

    final static char LETTER = TIME_ZONE_RFC822;

    static SimpleDateFormatComponentTimeZoneRfc822 with(final int length) {
        return new SimpleDateFormatComponentTimeZoneRfc822(length);
    }

    private SimpleDateFormatComponentTimeZoneRfc822(final int length) {
        super(length);
    }

    // format...........................................................................................................

    @Override
    void formatDate(final SimpleDateFormatRequest request) {
        final int offset = request.calendar.get(Calendar.ZONE_OFFSET) / 36000;
        request.text.append(offset < 0 ? '-' : '+');

        this.formatNumericValue(request,
                offset,
                4);
    }

    // SimpleDateFormatComponent........................................................................................

    @Override
    char letter() {
        return LETTER;
    }
}