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

import walkingkooka.ToStringBuilder;

import java.util.Objects;

public class FieldPosition {

    public FieldPosition(final int field) {
        this(null, field);
    }

    public FieldPosition(final Format.Field attribute) {
        this(attribute, -1);
    }

    public FieldPosition(final Format.Field attribute, final int field) {
        this.attribute = attribute;
        this.field = field;
        this.beginIndex = 0;
        this.endIndex = 0;
    }

    public int getField() {
        return field;
    }

    private int field = 0;

    public Format.Field getFieldAttribute() {
        return attribute;
    }

    private final Format.Field attribute;

    public int getBeginIndex() {
        return this.beginIndex;
    }

    public void setBeginIndex(final int beginIndex) {
        this.beginIndex = beginIndex;
    }

    private int beginIndex = 0;

    public int getEndIndex() {
        return this.endIndex;
    }

    public void setEndIndex(final int endIndex) {
        this.endIndex = endIndex;
    }

    private int endIndex = 0;

    // Object...........................................................................................................

    @Override
    public int hashCode() {
        return Objects.hash(this.field,
                this.attribute,
                this.beginIndex,
                this.endIndex);
    }

    public boolean equals(final Object other) {
        return this == other || other instanceof FieldPosition && this.equals0((FieldPosition) other);
    }

    private boolean equals0(final FieldPosition other) {
        return this.field == other.field &&
                Objects.equals(this.attribute, other.attribute) &&
                this.beginIndex == other.beginIndex &&
                this.endIndex == other.endIndex;
    }

    @Override
    public String toString() {
        return ToStringBuilder.empty()
                .label("field").value(this.field)
                .label("attribute").value(this.attribute)
                .label("beginIndex").value(this.beginIndex)
                .label("endIndex").value(this.endIndex)
                .build();
    }
}
