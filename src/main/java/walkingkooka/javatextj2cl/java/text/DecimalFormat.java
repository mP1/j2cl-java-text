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

final class DecimalFormat extends NumberFormat {

    static DecimalFormat with(final DecimalFormatSymbols symbols) {
        return new DecimalFormat(symbols);
    }

    private DecimalFormat(final DecimalFormatSymbols symbols) {
        this.symbols = symbols;
    }

    @Override
    public StringBuffer format(final double number,
                               final StringBuffer append,
                               final FieldPosition position) {
        throw new UnsupportedOperationException();
    }

    @Override
    public StringBuffer format(final long number,
                               final StringBuffer append,
                               final FieldPosition position) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Number parse(final String source,
                        final ParsePosition position) {
        throw new UnsupportedOperationException();
    }

    private final DecimalFormatSymbols symbols;

    // Object...........................................................................................................

    @Override
    public int hashCode() {
        return super.hashCode() ^ this.symbols.hashCode();
    }

    @Override
    boolean canBeEqual(final Object other) {
        return other instanceof DecimalFormat;
    }

    @Override
    boolean equals0(final NumberFormat other) {
        return super.equals0(other) && this.equals1((DecimalFormat) other);
    }

    private boolean equals1(final DecimalFormat other) {
        return this.symbols.equals(other.symbols);
    }

    @Override
    public String toString() {
        return this.symbols.toString();
    }
}
