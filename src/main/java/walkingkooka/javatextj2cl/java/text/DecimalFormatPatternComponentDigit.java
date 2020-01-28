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

final class DecimalFormatPatternComponentDigit extends DecimalFormatPatternComponent {

    /**
     * Singleton
     */
    final static DecimalFormatPatternComponentDigit INSTANCE = new DecimalFormatPatternComponentDigit();

    private DecimalFormatPatternComponentDigit() {
        super();
    }

    @Override
    boolean isCurrency() {
        return false;
    }

    @Override
    int multiplier() {
        return 0;
    }

    final static char LITERAL = '#';

    @Override
    public String toString() {
        return "" + LITERAL;
    }
}
