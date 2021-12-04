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
import walkingkooka.j2cl.java.text.Format.Field;
import walkingkooka.predicate.Predicates;

import java.lang.reflect.Method;
import java.util.function.Predicate;

public final class FieldPositionTest extends JavaTextTestCase<FieldPosition>
        implements
        HashCodeEqualsDefinedTesting2<FieldPosition>,
        ToStringTesting<FieldPosition> {

    private final static int FIELD = 11;
    private final static String FIELD_NAME = "Field123";
    private final static int BEGIN_INDEX = 22;
    private final static int END_INDEX = 33;

    private final static int DIFFERENT = 99;

    @Test
    public void testNewIntField() {
        this.check(new FieldPosition(FIELD), new java.text.FieldPosition(FIELD));
    }

    @Test
    public void testNewFormatNullField() {
        this.check(new FieldPosition(null), new java.text.FieldPosition(null));
    }

    //@Test
    public void testNewFormatField() {
        this.check(new FieldPosition(new Field(FIELD_NAME)), new java.text.FieldPosition(null));
    }

    @Test
    public void testSetBeginIndex() {
        final FieldPosition emulated = new FieldPosition(DIFFERENT);
        emulated.setBeginIndex(BEGIN_INDEX);

        final java.text.FieldPosition jre = new java.text.FieldPosition(DIFFERENT);
        jre.setBeginIndex(BEGIN_INDEX);

        this.check(emulated, jre);
    }

    @Test
    public void testSetBeginIndexZero() {
        final FieldPosition emulated = new FieldPosition(DIFFERENT);
        emulated.setBeginIndex(0);

        final java.text.FieldPosition jre = new java.text.FieldPosition(DIFFERENT);
        jre.setBeginIndex(0);

        this.check(emulated, jre);
    }

    @Test
    public void testSetBeginIndexNegativeOne() {
        final FieldPosition emulated = new FieldPosition(BEGIN_INDEX);
        emulated.setBeginIndex(-1);

        final java.text.FieldPosition jre = new java.text.FieldPosition(BEGIN_INDEX);
        jre.setBeginIndex(-1);

        this.check(emulated, jre);
    }

    @Test
    public void testSetetEndIndex() {
        final FieldPosition emulated = new FieldPosition(BEGIN_INDEX);
        emulated.setEndIndex(END_INDEX);

        final java.text.FieldPosition jre = new java.text.FieldPosition(BEGIN_INDEX);
        jre.setEndIndex(END_INDEX);

        this.check(emulated, jre);
    }

    @Test
    public void testSetetEndIndexZero() {
        final FieldPosition emulated = new FieldPosition(BEGIN_INDEX);
        emulated.setEndIndex(0);

        final java.text.FieldPosition jre = new java.text.FieldPosition(BEGIN_INDEX);
        jre.setEndIndex(0);

        this.check(emulated, jre);
    }

    @Test
    public void testSetEndIndexNegativeOne() {
        final FieldPosition emulated = new FieldPosition(BEGIN_INDEX);
        emulated.setEndIndex(-1);

        final java.text.FieldPosition jre = new java.text.FieldPosition(BEGIN_INDEX);
        jre.setEndIndex(-1);

        this.check(emulated, jre);
    }

    private void check(final FieldPosition emulated,
                       final java.text.FieldPosition expected) {

        this.checkEquals(expected.getField(), emulated.getField(), "field");
        checkFieldAttribute(expected.getFieldAttribute(), emulated.getFieldAttribute());
        this.checkEquals(expected.getBeginIndex(), emulated.getBeginIndex(), "beginIndex");
        this.checkEquals(expected.getEndIndex(), emulated.getEndIndex(), "endIndex");
    }

    private void checkFieldAttribute(final java.text.Format.Field jre, final Field emulated) {
        if (null == jre) {
            this.checkEquals(jre, emulated, "fieldAttribute");
        }
    }

    @Test
    public void testDifferentField() {
        this.checkNotEquals(new FieldPosition(DIFFERENT));
    }

    @Test
    public void testDifferentEndIndex() {
        final FieldPosition symbols = this.createObject();
        symbols.setEndIndex(DIFFERENT);
        this.checkNotEquals(symbols);
    }

    @Test
    public void testToString() {
        this.toStringAndCheck(new FieldPosition(FIELD), "field=" + FIELD);
    }

    @Test
    public void testToStringBeginIndexEndIndex() {
        final FieldPosition position = new FieldPosition(FIELD);
        position.setBeginIndex(BEGIN_INDEX);
        position.setEndIndex(END_INDEX);
        this.toStringAndCheck(position, "field=" + FIELD + " beginIndex=" + BEGIN_INDEX + " endIndex=" + END_INDEX);
    }

    // ShadedClassTesting...............................................................................................

    @Override
    public Class<FieldPosition> type() {
        return FieldPosition.class;
    }

    @Override
    public Predicate<Method> requiredMethods() {
        return Predicates.always();
    }

    @Override
    public Predicate<java.lang.reflect.Field> requiredFields() {
        return (f) -> {
            final boolean required;

            switch (f.getName()) {
                case "attribute":
                case "beginIndex":
                case "endIndex":
                case "field":
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
    public FieldPosition createObject() {
        return new FieldPosition(FIELD);
    }
}
