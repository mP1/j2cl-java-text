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

/**
 * Place holder for a percent value, which multiplies the value by 100 before formatting.
 */
final class DecimalFormatPatternComponentPerMille extends DecimalFormatPatternComponent {

    /**
     * Singleton
     */
    final static DecimalFormatPatternComponentPerMille INSTANCE = new DecimalFormatPatternComponentPerMille();

    private DecimalFormatPatternComponentPerMille() {
        super();
    }

    @Override
    boolean isCurrency() {
        return false;
    }

    @Override
    int multiplier() {
        return PER_MILLE_MULTIPLIER;
    }

    @Override
    void toPattern(final StringBuilder pattern) {
        pattern.append(DecimalFormat.PER_MILLE);
    }

    @Override
    void toPatternLocalized(final DecimalFormatSymbols symbols,
                            final StringBuilder pattern) {
        pattern.append(symbols.getPerMill());
    }

    @Override
    public String toString() {
        return "" + DecimalFormat.PER_MILLE;
    }
}
