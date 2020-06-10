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

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class SimpleDateFormatComponent2Test extends SimpleDateFormatComponentTestCase<SimpleDateFormatComponent2> {

    @Test
    public void testHoursMinutesToMillis0() {
        this.hoursMinutesToMillisAndCheck(0, 0, 0);
    }

    @Test
    public void testHoursMinutesToMillis1Hour() {
        this.hoursMinutesToMillisAndCheck(1, 0, 1 * 60 * 60 * 1000);
    }

    @Test
    public void testHoursMinutesToMillis1TwoHourThirtyMinutes() {
        this.hoursMinutesToMillisAndCheck(2, 30, 5 * 60 * 60 * 1000 / 2);
    }

    private void hoursMinutesToMillisAndCheck(final int hours,
                                              final int minutes,
                                              final int expected) {
        assertEquals(expected,
                SimpleDateFormatComponent2.hoursMinutesToMillis(hours, minutes),
                () -> "hoursMinutesToMillis " + hours + ":" + minutes);
    }

    @Override
    public Class<SimpleDateFormatComponent2> type() {
        return SimpleDateFormatComponent2.class;
    }
}
