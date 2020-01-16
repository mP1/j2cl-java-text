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

import org.junit.jupiter.api.Test;
import walkingkooka.HashCodeEqualsDefinedTesting2;

import java.util.Currency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public final class NumberFormatTest extends FormatTestCase<NumberFormat> implements HashCodeEqualsDefinedTesting2<NumberFormat> {

    @Test
    public void testDefaultGroupingUsed() {
        assertEquals(new TestJdkNumberFormat().isGroupingUsed(),
                new TestNumberFormat().isGroupingUsed(),
                "groupingUsed");
    }

    @Test
    public void testDefaultIsParseIntegerOnly() {
        assertEquals(new TestJdkNumberFormat().isParseIntegerOnly(),
                new TestNumberFormat().isParseIntegerOnly(),
                "parseIntegerOnly");
    }

    @Test
    public void testDefaultMaximumFractionDigits() {
        assertEquals(new TestJdkNumberFormat().getMaximumFractionDigits(),
                new TestNumberFormat().getMaximumFractionDigits(),
                "getMaximumFractionDigits");
    }

    @Test
    public void testDefaultMaximumIntegerDigits() {
        assertEquals(new TestJdkNumberFormat().getMaximumIntegerDigits(),
                new TestNumberFormat().getMaximumIntegerDigits(),
                "getMaximumIntegerDigits");
    }

    @Test
    public void testDefaultMinimumFractionDigits() {
        assertEquals(new TestJdkNumberFormat().getMinimumFractionDigits(),
                new TestNumberFormat().getMinimumFractionDigits(),
                "getMinimumFractionDigits");
    }

    @Test
    public void testDefaultMinimumIntegerDigits() {
        assertEquals(new TestJdkNumberFormat().getMinimumIntegerDigits(),
                new TestNumberFormat().getMinimumIntegerDigits(),
                "getMinimumIntegerDigits");
    }

    @Test
    public void testGetCurrencyFails() {
        assertThrows(UnsupportedOperationException.class, () -> new TestJdkNumberFormat().getCurrency());
        assertThrows(UnsupportedOperationException.class, () -> new TestNumberFormat().getCurrency());
    }

    @Test
    public void testSetCurrencyFails() {
        final Currency currency = Currency.getInstance("AUD");
        assertThrows(UnsupportedOperationException.class, () -> new TestJdkNumberFormat().setCurrency(currency));
        assertThrows(UnsupportedOperationException.class, () -> new TestNumberFormat().setCurrency(currency));
    }

    // equals...........................................................................................................

    @Test
    public void testDifferentGroupingUsed() {
        final TestJdkNumberFormat jdk = new TestJdkNumberFormat();
        jdk.setGroupingUsed(!jdk.isGroupingUsed());
        this.checkNotEquals(new TestJdkNumberFormat(), jdk);

        final TestNumberFormat format = new TestNumberFormat();
        format.setGroupingUsed(!format.isGroupingUsed());
        this.checkNotEquals(format);
    }

    @Test
    public void testDifferentMaximumFractionDigits() {
        final TestJdkNumberFormat jdk = new TestJdkNumberFormat();
        jdk.setMaximumFractionDigits(10);
        this.checkNotEquals(new TestJdkNumberFormat(), jdk);

        final TestNumberFormat format = new TestNumberFormat();
        format.setMaximumFractionDigits(10);
        this.checkNotEquals(format);
    }

    @Test
    public void testDifferentMaximumIntegerDigits() {
        final TestJdkNumberFormat jdk = new TestJdkNumberFormat();
        jdk.setMaximumIntegerDigits(5);
        this.checkNotEquals(new TestJdkNumberFormat(), jdk);

        final TestNumberFormat format = new TestNumberFormat();
        format.setMaximumIntegerDigits(5);
        this.checkNotEquals(format);
    }

    @Test
    public void testDifferentMinimumFractionDigits() {
        final TestJdkNumberFormat jdk = new TestJdkNumberFormat();
        jdk.setMinimumFractionDigits(1);
        this.checkNotEquals(new TestJdkNumberFormat(), jdk);

        final TestNumberFormat format = new TestNumberFormat();
        format.setMinimumFractionDigits(1);
        this.checkNotEquals(format);
    }

    @Test
    public void testDifferentMinimumIntegerDigits() {
        final TestJdkNumberFormat jdk = new TestJdkNumberFormat();
        jdk.setMinimumIntegerDigits(5);
        this.checkNotEquals(jdk, new TestJdkNumberFormat());

        final TestNumberFormat format = new TestNumberFormat();
        format.setMinimumIntegerDigits(5);
        this.checkNotEquals(format);
    }

    @Test
    public void testDifferentParseIntegerOnly() {
        final TestJdkNumberFormat jdk = new TestJdkNumberFormat();
        jdk.setParseIntegerOnly(true);
        this.checkNotEquals(new TestJdkNumberFormat(), jdk);


        final TestNumberFormat format = new TestNumberFormat();
        format.setParseIntegerOnly(true);
        this.checkNotEquals(format);
    }

    private class TestJdkNumberFormat extends java.text.NumberFormat {

        private static final long serialVersionUID = 3196001817329349707L;

        @Override
        public StringBuffer format(final double number,
                                   final StringBuffer append,
                                   final java.text.FieldPosition pos) {
            throw new UnsupportedOperationException();
        }

        @Override
        public StringBuffer format(final long number,
                                   final StringBuffer append,
                                   final java.text.FieldPosition pos) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Number parse(final String source,
                            final java.text.ParsePosition pos) {
            throw new UnsupportedOperationException();
        }
    }

    private class TestNumberFormat extends NumberFormat {

        @Override
        public StringBuffer format(final double number,
                                   final StringBuffer append,
                                   final FieldPosition pos) {
            throw new UnsupportedOperationException();
        }

        @Override
        public StringBuffer format(final long number,
                                   final StringBuffer append,
                                   final FieldPosition pos) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Number parse(final String source,
                            final ParsePosition pos) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Class<NumberFormat> type() {
        return NumberFormat.class;
    }

    @Override
    public NumberFormat createObject() {
        return new TestNumberFormat();
    }
}
