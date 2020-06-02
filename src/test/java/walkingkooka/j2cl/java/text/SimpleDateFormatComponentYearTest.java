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

import org.junit.jupiter.api.Test;

import java.util.Date;

public final class SimpleDateFormatComponentYearTest extends SimpleDateFormatComponentNumberTestCase<SimpleDateFormatComponentYear> {

    @Test
    public void testFormatYearAll1() {
        this.formatYearAndCheck(1);
    }

    @Test
    public void testFormatYearAll2() {
        this.formatYearAndCheck(2);
    }

    @Test
    public void testFormatYearAll3() {
        this.formatYearAndCheck(3);
    }

    @Test
    public void testFormatYearAll4() {
        this.formatYearAndCheck(4);
    }

    private void formatYearAndCheck(final int length) {
        for (int year = 1800; year < 2050; year++) {
            this.formatDateAndCheck(length, new Date(DATE.UTC(year - 1900, 1, 2, 3, 4, 5)));
        }
    }

    @Override
    SimpleDateFormatComponentYear createComponent(final int length) {
        return SimpleDateFormatComponentYear.with(length);
    }

    @Override
    public Class<SimpleDateFormatComponentYear> type() {
        return SimpleDateFormatComponentYear.class;
    }
}
