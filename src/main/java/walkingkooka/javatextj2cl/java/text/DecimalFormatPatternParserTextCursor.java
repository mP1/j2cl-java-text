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

import walkingkooka.InvalidCharacterException;
import walkingkooka.text.CharSequences;

/**
 * A cursor which holds the pattern being parsed.
 */
final class DecimalFormatPatternParserTextCursor {

    static DecimalFormatPatternParserTextCursor with(final String text,
                                         final int position) {
        return new DecimalFormatPatternParserTextCursor(text, position);
    }

    private DecimalFormatPatternParserTextCursor(final String text,
                                         final int position) {
        super();
        this.text = text;
        this.position = position;
    }

    boolean hasMore() {
        return this.position < this.text.length();
    }

    void next() {
        this.position++;
    }

    char charAt() {
        return this.text.charAt(this.position);
    }

    /**
     * Used to report an invalid pattern character.
     */
    final void failInvalidCharacter() {
        throw new InvalidCharacterException(this.text, this.position);
    }

    /**
     * The pattern text being parsed.
     */
    final String text;

    /**
     * Points to the current character in the pattern. This is used to build fail messages.
     */
    int position;

    @Override
    public String toString() {
        return "pos: " + this.position + " in " + CharSequences.quoteAndEscape(this.text);
    }
}
