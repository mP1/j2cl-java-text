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
import walkingkooka.collect.list.Lists;

import java.util.List;

/**
 * A parser that handles parsing the prefix or suffix with a pattern.
 */
final class DecimalFormatPatternParserPrefixSuffix extends DecimalFormatPatternParser {

    static DecimalFormatPatternParserPrefixSuffix with(final String pattern,
                                                       final int position) {
        return new DecimalFormatPatternParserPrefixSuffix(pattern, position);
    }

    private DecimalFormatPatternParserPrefixSuffix(final String pattern,
                                                   final int position) {
        super(pattern, position);
    }

    @Override
    void handle(final char c) {
        switch (c) {
            case DecimalFormat.CURRENCY:
                this.currency();
                break;
            case DecimalFormat.DECIMAL_SEPARATOR:
            case DecimalFormat.HASH:
            case DecimalFormat.ZERO:
            case DecimalFormat.GROUPING_SEPARATOR:
                this.addCharacterLiteral(c);
                break;
            case DecimalFormat.MINUS_SIGN:
                this.minusSign();
                break;
            case DecimalFormat.PERCENT:
                this.percent();
                break;
            case DecimalFormat.PER_MILLE:
                this.perMille();
                break;
            default:
                this.addCharacterLiteral(c);
                break;
        }
    }

    @Override
    boolean isFinished() {
        return false; // never
    }

    @Override
    void onComplete() {
        // nop
    }

    @Override
    void addNonNumberComponent(final DecimalFormatPatternComponent component) {
        this.components.add(component);
    }

    @Override
    List<DecimalFormatPatternComponent> nonNumberComponents() {
        return this.components;
    }

    /**
     * Contains the translated pattern into components in order.
     */
    final List<DecimalFormatPatternComponent> components = Lists.array();

    // Object...........................................................................................................

    @Override
    public String toString() {
        return ToStringBuilder.empty()
                .value(this.position)
                .value(this.components)
                .build();
    }
}
