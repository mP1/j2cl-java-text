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

import walkingkooka.ToStringBuilder;

import java.util.Objects;

public class ParsePosition {

    public ParsePosition(final int index) {
        super();
        this.setIndex(index);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    private int index;

    public int getErrorIndex() {
        return errorIndex;
    }

    public void setErrorIndex(int errorIndex) {
        this.errorIndex = errorIndex;
    }

    private int errorIndex = -1;

    // Object...........................................................................................................

    @Override
    public int hashCode() {
        return Objects.hash(this.index, this.errorIndex);
    }

    public boolean equals(final Object other) {
        return this == other || other instanceof ParsePosition && this.equals0((ParsePosition) other);
    }

    private boolean equals0(final ParsePosition other) {
        return this.index == other.index &&
                this.errorIndex == other.errorIndex;
    }

    @Override
    public String toString() {
        return ToStringBuilder.empty()
                .label("index").value(this.index)
                .label("errorIndex").value(this.errorIndex)
                .build();
    }
}
