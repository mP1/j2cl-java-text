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

import org.junit.jupiter.api.Test;
import walkingkooka.InvalidCharacterException;
import walkingkooka.ToStringTesting;
import walkingkooka.text.CharSequences;

import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class DecimalFormatPatternParserTestCase<P extends DecimalFormatPatternParser> extends DecimalFormatPatternTestCase<P>
    implements ToStringTesting<P> {

    DecimalFormatPatternParserTestCase() {
        super();
    }

    @Test
    public final void testUnclosedQuoteFails() {
        this.parseFails("'A", 1);
    }

    @Test
    public final void testUnclosedQuoteFails2() {
        this.parseFails("AB'C", 3);
    }

    @Test
    public final void testUnclosedQuoteFails3() {
        this.parseFails("#'A#", 3);
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
        final String pattern = parser.pattern;

        assertThrows(IllegalArgumentException.class,
            () -> new java.text.DecimalFormat(pattern),
            () -> "pattern " + CharSequences.quoteAndEscape(pattern) + " by java.text.DecimalFormat");

        final InvalidCharacterException thrown = assertThrows(InvalidCharacterException.class,
            () -> parser.parse(),
            () -> "pattern " + CharSequences.quoteAndEscape(pattern) + " by " + DecimalFormat.class.getName() + " " + parser);

        this.checkEquals(position, thrown.position(), () -> "position in " + CharSequences.quoteAndEscape(pattern));
        this.checkEquals(pattern, thrown.text(), () -> "text in " + CharSequences.quoteAndEscape(pattern));
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

        this.checkEquals(positivePrefix, jdk.getPositivePrefix(), "positivePrefix");
    }

    final void checkPositiveSuffix(final String pattern,
                                   final String positiveSuffix) {
        final java.text.DecimalFormat jdk = new java.text.DecimalFormat(pattern);

        this.checkEquals(positiveSuffix, jdk.getPositiveSuffix(), "positiveSuffix");
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

        this.checkEquals(negativePrefix, jdk.getNegativePrefix(), "negativePrefix");
    }

    final void checkNegativeSuffix(final String pattern,
                                   final String negativeSuffix) {
        final java.text.DecimalFormat jdk = new java.text.DecimalFormat(pattern);

        this.checkEquals(negativeSuffix, jdk.getNegativeSuffix(), "negativeSuffix");
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
