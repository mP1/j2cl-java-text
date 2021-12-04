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
import walkingkooka.HashCodeEqualsDefinedTesting2;
import walkingkooka.ToStringTesting;
import walkingkooka.predicate.Predicates;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.function.Predicate;

public final class ParsePositionTest extends JavaTextTestCase<ParsePosition>
        implements HashCodeEqualsDefinedTesting2<ParsePosition>,
        ToStringTesting<ParsePosition> {

    private final static int INDEX = 12;
    private final static int ERROR_INDEX = 34;

    private final static int DIFFERENT = 99;

    @Test
    public void testNew() {
        this.check(new ParsePosition(INDEX), new java.text.ParsePosition(INDEX));
    }

    @Test
    public void testSetIndex() {
        final ParsePosition emulated = new ParsePosition(DIFFERENT);
        emulated.setIndex(INDEX);

        final java.text.ParsePosition jre = new java.text.ParsePosition(DIFFERENT);
        jre.setIndex(INDEX);

        this.check(emulated, jre);
    }

    @Test
    public void testSetIndexZero() {
        final ParsePosition emulated = new ParsePosition(DIFFERENT);
        emulated.setIndex(0);

        final java.text.ParsePosition jre = new java.text.ParsePosition(DIFFERENT);
        jre.setIndex(0);

        this.check(emulated, jre);
    }

    @Test
    public void testSetIndexNegativeOne() {
        final ParsePosition emulated = new ParsePosition(INDEX);
        emulated.setIndex(-1);

        final java.text.ParsePosition jre = new java.text.ParsePosition(INDEX);
        jre.setIndex(-1);

        this.check(emulated, jre);
    }

    @Test
    public void testSetErrorIndex() {
        final ParsePosition emulated = new ParsePosition(INDEX);
        emulated.setErrorIndex(ERROR_INDEX);

        final java.text.ParsePosition jre = new java.text.ParsePosition(INDEX);
        jre.setErrorIndex(ERROR_INDEX);

        this.check(emulated, jre);
    }

    @Test
    public void testSetErrorIndexZero() {
        final ParsePosition emulated = new ParsePosition(INDEX);
        emulated.setErrorIndex(0);

        final java.text.ParsePosition jre = new java.text.ParsePosition(INDEX);
        jre.setErrorIndex(0);

        this.check(emulated, jre);
    }

    @Test
    public void testSetErrorIndexNegativeOne() {
        final ParsePosition emulated = new ParsePosition(INDEX);
        emulated.setErrorIndex(-1);

        final java.text.ParsePosition jre = new java.text.ParsePosition(INDEX);
        jre.setErrorIndex(-1);

        this.check(emulated, jre);
    }

    private void check(final ParsePosition emulated,
                       final java.text.ParsePosition expected) {

        this.checkEquals(expected.getIndex(), emulated.getIndex(), "index");
        this.checkEquals(expected.getErrorIndex(), emulated.getErrorIndex(), "errorIndex");
    }

    @Test
    public void testDifferentIndex() {
        this.checkNotEquals(new ParsePosition(DIFFERENT));
    }

    @Test
    public void testDifferentErrorIndex() {
        final ParsePosition symbols = this.createObject();
        symbols.setErrorIndex(DIFFERENT);
        this.checkNotEquals(symbols);
    }

    @Test
    public void testToString() {
        this.toStringAndCheck2(INDEX, -1);
    }

    @Test
    public void testToStringErrorIndex() {
        this.toStringAndCheck2(1, 2);
    }

    @Test
    public void testToStringErrorIndex0() {
        this.toStringAndCheck2(0, 0);
    }

    private void toStringAndCheck2(final int index,
                                   final int errorIndex) {
        final ParsePosition position = new ParsePosition(index);
        position.setErrorIndex(errorIndex);
        this.toStringAndCheck(position, "index=" + index + " errorIndex=" + errorIndex);
    }

    // ShadedClassTesting...............................................................................................

    @Override
    public Class<ParsePosition> type() {
        return ParsePosition.class;
    }

    @Override
    public Predicate<Method> requiredMethods() {
        return Predicates.always();
    }

    @Override
    public Predicate<Field> requiredFields() {
        return (f) -> {
            final boolean required;

            switch (f.getName()) {
                case "errorIndex":
                case "index":
                    required = false;
                    break;
                default:
                    required = true;
                    break;
            }

            return required;
        };
    }

    // HashCodeEqualsDefinedTesting2....................................................................................

    @Override
    public ParsePosition createObject() {
        return new ParsePosition(INDEX);
    }
}
