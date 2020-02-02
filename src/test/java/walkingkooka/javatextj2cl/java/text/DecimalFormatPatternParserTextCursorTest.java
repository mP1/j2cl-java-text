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

package walkingkooka.javatextj2cl.java.text;

import org.junit.jupiter.api.Test;
import walkingkooka.ToStringTesting;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class DecimalFormatPatternParserTextCursorTest extends DecimalFormatPatternTestCase<DecimalFormatPatternParserTextCursor>
        implements ToStringTesting<DecimalFormatPatternParserTextCursor> {

    @Test
    public void testText() {
        final String text = "ABC";
        final int position = 2;

        final DecimalFormatPatternParserTextCursor cursor = DecimalFormatPatternParserTextCursor.with(text, position);

        assertEquals(text, cursor.text, "text");
        assertEquals(position, cursor.position, "position");
    }

    @Test
    public void testConsume() {
        final DecimalFormatPatternParserTextCursor cursor = DecimalFormatPatternParserTextCursor.with("ABC", 0);

        this.charAtAndCheck(cursor, 'A');
        cursor.next();

        this.charAtAndCheck(cursor, 'B');
        cursor.next();

        this.charAtAndCheck(cursor, 'C');
        cursor.next();
    }

    @Test
    public void testConsume2() {
        final DecimalFormatPatternParserTextCursor cursor = DecimalFormatPatternParserTextCursor.with("ABCDEF", 3);

        this.charAtAndCheck(cursor, 'D');
        cursor.next();

        this.charAtAndCheck(cursor, 'E');
        cursor.next();

        this.charAtAndCheck(cursor, 'F');
        cursor.next();
    }

    private void charAtAndCheck(final DecimalFormatPatternParserTextCursor cursor, final char c) {
        assertEquals(c, cursor.charAt(), () -> "charAt " + cursor);
    }

    @Test
    public void testToString() {
        this.toStringAndCheck(DecimalFormatPatternParserTextCursor.with("ABC", 1), "pos: 1 in \"ABC\"");
    }

    // ClassTesting.....................................................................................................

    @Override
    public Class<DecimalFormatPatternParserTextCursor> type() {
        return DecimalFormatPatternParserTextCursor.class;
    }

    // TypeNameTesting..................................................................................................

    @Override
    public String typeNamePrefix() {
        return DecimalFormat.class.getSimpleName();
    }

    @Override
    public String typeNameSuffix() {
        return "";
    }
}
