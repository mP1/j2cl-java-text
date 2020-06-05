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

import java.util.TimeZone;

final class SimpleDateFormatComponentTimeZoneGeneral extends SimpleDateFormatComponentTimeZoneGeneralRfc822 {

    final static char LETTER = TIME_ZONE_GENERAL;

    static SimpleDateFormatComponentTimeZoneGeneral with(final int length) {
        return new SimpleDateFormatComponentTimeZoneGeneral(length);
    }

    private SimpleDateFormatComponentTimeZoneGeneral(final int length) {
        super(length);
    }

    // format...........................................................................................................

    @Override
    void formatDate(final SimpleDateFormatFormatRequest request) {
        request.text.append(request.calendar.getTimeZone()
                .getDisplayName(request.daylightSavingTime,
                        this.length < 4 ? TimeZone.SHORT : TimeZone.LONG));
    }

    // SimpleDateFormatComponent........................................................................................

    @Override
    char letter() {
        return LETTER;
    }
}