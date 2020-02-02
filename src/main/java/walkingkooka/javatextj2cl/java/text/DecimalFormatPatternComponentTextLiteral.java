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

/**
 * THe only non singleton component and holds a non empty string literal.
 */
final class DecimalFormatPatternComponentTextLiteral extends DecimalFormatPatternComponent {

    /**
     * Factory that creates a text literal.
     */
    final static DecimalFormatPatternComponentTextLiteral with(final String text) {
        return new DecimalFormatPatternComponentTextLiteral(text);
    }

    private DecimalFormatPatternComponentTextLiteral(final String text) {
        super();
        this.text = text;
    }

    private final String text;

    @Override
    boolean isCurrency() {
        return false;
    }

    @Override
    int multiplier() {
        return 0;
    }

    // Object...........................................................................................................

    @Override
    public int hashCode() {
        return this.text.hashCode();
    }

    @Override
    public boolean equals(final Object other) {
        return this == other || other instanceof DecimalFormatPatternComponentTextLiteral && this.equals0((DecimalFormatPatternComponentTextLiteral) other);
    }

    private boolean equals0(final DecimalFormatPatternComponentTextLiteral other) {
        return this.text.equals(other.text);
    }

    @Override
    public String toString() {
        final StringBuilder b = new StringBuilder();

        char previous = 0;
        for(final char c : this.text.toCharArray()) {
            switch(c) {
                case '\'':
                    if(0 == previous) {
                        b.append('\'');
                        previous = c;
                    } else {
                        previous = 0;
                    }
                    break;
                case '.':
                case '#':
                case '0':
                case ',':
                    case '-':
                case '%':
                case '\u2030':
                    b.append('\'');
                    b.append(c);
                    b.append('\'');
                    previous = 0;
                    break;
                default:
                    b.append(c);
                    previous = c;
                    break;
            }
        }

        return b.toString();
    }
}
