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
    public String toString() {
        final String text = this.text;
        return text.equals("'") ?
                "''" :
                "'" + text.replace("'", "''") + "'";
    }
}
