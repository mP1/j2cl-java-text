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

import static org.junit.jupiter.api.Assertions.assertSame;

public final class DateFormatTest extends FormatTestCase<DateFormat> {

    @Test
    public void testShortConstants() {
        assertSame(java.text.DateFormat.SHORT, DateFormat.SHORT);
    }

    @Test
    public void testMediumConstants() {
        assertSame(java.text.DateFormat.MEDIUM, DateFormat.MEDIUM);
    }

    @Test
    public void testLongConstants() {
        assertSame(java.text.DateFormat.LONG, DateFormat.LONG);
    }

    @Test
    public void testFullConstants() {
        assertSame(java.text.DateFormat.FULL, DateFormat.FULL);
    }

    // ClassTesting.....................................................................................................

    @Override
    public Class<DateFormat> type() {
        return DateFormat.class;
    }
}
