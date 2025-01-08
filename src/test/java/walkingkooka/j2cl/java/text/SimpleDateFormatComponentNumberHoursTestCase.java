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

public abstract class SimpleDateFormatComponentNumberHoursTestCase<C extends SimpleDateFormatComponent2> extends SimpleDateFormatComponentNumberTestCase<C> {

    SimpleDateFormatComponentNumberHoursTestCase() {
        super();
    }

    @Test
    public final void testFormat0() {
        this.formatHoursAndCheck(0);
    }

    @Test
    public final void testFormat1() {
        this.formatHoursAndCheck(1);
    }

    @Test
    public final void testFormat12() {
        this.formatHoursAndCheck(12);
    }

    @Test
    public final void testFormat23() {
        this.formatHoursAndCheck(23);
    }

    @Test
    public final void testFormat24() {
        this.formatHoursAndCheck(24);
    }

    @Test
    public final void testFormatAll() {
        for (int h = 0; h < 24; h++) {
            this.formatHoursAndCheck(h);
        }
    }

    private void formatHoursAndCheck(final int hours) {
        this.formatDateAndCheck(2, new Date(Date.UTC(2020, 6, 2, hours, 58, 59)));
    }
}
