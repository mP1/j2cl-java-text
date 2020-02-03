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
import walkingkooka.collect.list.Lists;
import walkingkooka.text.CharSequences;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class DecimalFormatPatternParserTestCase<P extends DecimalFormatPatternParser> extends DecimalFormatPatternTestCase<P> {

    DecimalFormatPatternParserTestCase() {
        super();
    }

    final void parseAndCheck(final String text,
                             final DecimalFormatPatternComponent... components) {
        this.parseAndCheck(this.createParser(text, 0),
                "",
                components);
    }

    final void parseAndCheck(final P parser,
                             final DecimalFormatPatternComponent... components) {
        this.parseAndCheck(parser,
                "",
                components);
    }

    final void parseAndCheck(final String pattern,
                             final String left,
                             final DecimalFormatPatternComponent... components) {
        final P parser = this.createParser(pattern, 0);

        assertEquals(Lists.of(components),
                parser.parse(),
                "components parse " + CharSequences.quoteAndEscape(pattern));

        assertEquals(left,
                parser.pattern.substring(parser.position),
                () -> "remaining pattern, parse " + CharSequences.quoteAndEscape(pattern) + " components: " + Arrays.toString(components));
    }

    final void parseAndCheck(final P parser,
                             final String left,
                             final DecimalFormatPatternComponent... components) {
        assertEquals(Lists.of(components),
                parser.parse(),
                "components parse " + CharSequences.quoteAndEscape(parser.pattern));

        assertEquals(left,
                parser.pattern.substring(parser.position),
                () -> "remaining pattern, parse " + CharSequences.quoteAndEscape(parser.pattern) + " components: " + Arrays.toString(components));
    }

    final void parseFails(final String pattern,
                          final int position) {
        this.parseFails(pattern,
                0,
                position);
    }

    final void parseFails(final String pattern,
                          final int offset,
                          final int position) {
        this.parseFails(this.createParser(pattern, offset),
                position);
    }

    final void parseFails(final P parser,
                          final int position) {
        assertThrows(IllegalArgumentException.class,
                () -> new java.text.DecimalFormat());
        final InvalidCharacterException thrown = assertThrows(InvalidCharacterException.class,
                () -> parser.parse());
        assertEquals(position, thrown.position(), "position");
        assertEquals(parser.pattern, thrown.text(), "text");
    }

    // helpers..........................................................................................................

    final P createParser(final String pattern) {
        return this.createParser(pattern, 0);
    }

    abstract P createParser(final String pattern,
                            final int position);


    final void checkPrefixAndSuffix(final String pattern,
                                    final String prefix,
                                    final String suffix) {
        this.checkPositivePrefixAndSuffix(pattern, prefix, suffix);
        this.checkNegativePrefixAndSuffix(pattern, prefix, suffix);
    }

    final void checkPositivePrefixAndSuffix(final String pattern,
                                            final String positivePrefix,
                                            final String positiveSuffix) {
        this.checkPositivePrefix(pattern, positivePrefix);
        this.checkPositiveSuffix(pattern, positiveSuffix);
    }

    final void checkPositivePrefix(final String pattern,
                                   final String positivePrefix) {
        final java.text.DecimalFormat jdk = new java.text.DecimalFormat(pattern);

        assertEquals(positivePrefix, jdk.getPositivePrefix(), "positivePrefix");
    }

    final void checkPositiveSuffix(final String pattern,
                                   final String positiveSuffix) {
        final java.text.DecimalFormat jdk = new java.text.DecimalFormat(pattern);

        assertEquals(positiveSuffix, jdk.getPositiveSuffix(), "positiveSuffix");
    }

    final void checkNegativePrefixAndSuffix(final String pattern,
                                            final String negativePrefix,
                                            final String negativeSuffix) {
        this.checkNegativePrefix(pattern, negativePrefix);
        this.checkNegativeSuffix(pattern, negativeSuffix);
    }

    final void checkNegativePrefix(final String pattern,
                                   final String negativePrefix) {
        final java.text.DecimalFormat jdk = new java.text.DecimalFormat(pattern);

        assertEquals(negativePrefix, jdk.getNegativePrefix(), "negativePrefix");
    }

    final void checkNegativeSuffix(final String pattern,
                                   final String negativeSuffix) {
        final java.text.DecimalFormat jdk = new java.text.DecimalFormat(pattern);

        assertEquals(negativeSuffix, jdk.getNegativeSuffix(), "negativeSuffix");
    }

    // TypeNameTesting..................................................................................................

    @Override
    public final String typeNamePrefix() {
        return DecimalFormatPatternParser.class.getSimpleName();
    }

    @Override
    public final String typeNameSuffix() {
        return "";
    }
}
