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

import java.text.ParseException;
import java.util.Objects;

public abstract class Format {

    protected Format() {
    }

    public final String format(final Object value) {
        return format(value,
            new StringBuffer(),
            new FieldPosition(0)).toString();
    }

    public abstract StringBuffer format(final Object value,
                                        final StringBuffer appendTo,
                                        final FieldPosition pos);


    public abstract Object parseObject(final String source,
                                       final ParsePosition pos);

    public Object parseObject(final String source) throws ParseException {
        final ParsePosition pos = new ParsePosition(0);
        final Object result = parseObject(source, pos);
        if (0 == pos.getIndex()) {
            throw new ParseException("Format.parseObject(String) failed",pos.getErrorIndex());
        }
        return result;
    }

    public static class Field {

        protected Field(final String name) {
            super();
            this.name = name;
        }

        protected String getName() {
            return this.name;
        }

        private final String name;

        // Object...........................................................................................................

        @Override
        public int hashCode() {
            return Objects.hash(this.name);
        }

        public boolean equals(final Object other) {
            return this == other || other instanceof Field && this.equals0((Field) other);
        }

        private boolean equals0(final Field other) {
            return Objects.equals(this.name, other.name);
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
}
