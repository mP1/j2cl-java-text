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

import walkingkooka.text.CharSequences;

/**
 *
 */
final class SimpleDateFormatComponentLiteral extends SimpleDateFormatComponent {

    static SimpleDateFormatComponentLiteral with(final char c) {
        return new SimpleDateFormatComponentLiteral(c);
    }

    private SimpleDateFormatComponentLiteral(final char c) {
        super();
        this.c = c;
    }

    @Override
    void formatDate(final SimpleDateFormatFormatRequest request) {
        request.text.append(this.c);
    }

    @Override
    void parseText(final SimpleDateFormatParseRequest request) {
        final int position = request.position.getIndex();

        // check enought text left to match literal
        if (position <= request.text.length() && this.c == request.text.charAt(position)) {
            request.position.setIndex(position + 1);
        } else {
            request.position.setErrorIndex(position);
        }
    }

    // Object...........................................................................................................

    @Override
    public int hashCode() {
        return c;
    }

    @Override
    public boolean equals(final Object other) {
        return this == other || (other instanceof SimpleDateFormatComponentLiteral && this.equals0((SimpleDateFormatComponentLiteral) other));
    }

    private boolean equals0(final SimpleDateFormatComponentLiteral other) {
        return this.c == other.c;
    }

    private final char c;

    @Override
    public String toString() {
        return CharSequences.quoteIfChars(this.c).toString();
    }
}
