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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.Currency;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

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

    // format...........................................................................................................
    // tests format overloads do the right thing.

    @Test
    public void testFormatByteFive() {
        this.formatObjectStringBufferFieldPositionAndCheck((byte) 5);
    }

    @Test
    public void testFormatShortFive() {
        this.formatObjectStringBufferFieldPositionAndCheck((short) 5);
    }

    @Test
    public void testFormatIntegerFive() {
        this.formatObjectStringBufferFieldPositionAndCheck(5);
    }

    @Test
    public void testFormatAtomicIntegerFive() {
        this.formatObjectStringBufferFieldPositionAndCheck(new AtomicInteger(5));
    }

    @Test
    public void testFormatAtomicLongFive() {
        this.formatObjectStringBufferFieldPositionAndCheck(new AtomicLong(5));
    }

    @Test
    public void testFormatBigDecimalHalf() {
        this.formatObjectStringBufferFieldPositionAndCheck(new BigDecimal(0.5));
    }

    @Test
    public void testFormatBigIntegerFive() {
        this.formatObjectStringBufferFieldPositionAndCheck(BigInteger.valueOf(5));
    }

    @Test
    public void testFormatDoubleHalf() {
        this.formatDoubleAndCheck(0.5);
    }

    @Test
    public void testFormatDoubleOneHalf() {
        this.formatDoubleAndCheck(1.5);
    }

    @Test
    public void testFormatDoubleTenHalf() {
        this.formatDoubleAndCheck(10.5);
    }

    @Test
    public void testFormatLongZero() {
        this.formatLongAndCheck(0L);
    }

    @Test
    public void testFormatLongOne() {
        this.formatLongAndCheck(1L);
    }

    @Test
    public void testFormatLongTen() {
        this.formatLongAndCheck(10L);
    }

    private void formatDoubleAndCheck(final double value) {
        final TestJdkNumberFormat jdk = new TestJdkNumberFormat();
        final TestNumberFormat format = new TestNumberFormat();

        assertEquals(jdk.format(value), format.format(value), "format(double) " + value);

        this.formatDoubleStringBufferFieldPositionAndCheck(value);
        this.formatObjectStringBufferFieldPositionAndCheck(value);
    }

    private void formatLongAndCheck(final long value) {
        final TestJdkNumberFormat jdk = new TestJdkNumberFormat();
        final TestNumberFormat format = new TestNumberFormat();

        assertEquals(jdk.format(value), format.format(value), "format(long) " + value);

        this.formatLongStringBufferFieldPositionAndCheck(value);
        this.formatObjectStringBufferFieldPositionAndCheck(value);
    }

    private void formatDoubleStringBufferFieldPositionAndCheck(final double value) {
        final TestJdkNumberFormat jdk = new TestJdkNumberFormat();
        final TestNumberFormat format = new TestNumberFormat();

        final StringBuffer jdkStringBuffer = new StringBuffer();
        final StringBuffer stringBuffer = new StringBuffer();

        final java.text.FieldPosition jdkFieldPosition = new java.text.FieldPosition(TestJdkNumberFormat.INTEGER_FIELD);
        final FieldPosition fieldPosition = new FieldPosition(TestJdkNumberFormat.INTEGER_FIELD);

        assertEquals(jdk.format(value, jdkStringBuffer, jdkFieldPosition).toString(),
                format.format(value, stringBuffer, fieldPosition).toString(),
                "format(double, StringBuilder, FieldPosition) " + value);
        this.checkFieldPosition(jdkFieldPosition, fieldPosition);
    }

    private void formatLongStringBufferFieldPositionAndCheck(final long value) {
        final TestJdkNumberFormat jdk = new TestJdkNumberFormat();
        final TestNumberFormat format = new TestNumberFormat();

        final StringBuffer jdkStringBuffer = new StringBuffer();
        final StringBuffer stringBuffer = new StringBuffer();

        final java.text.FieldPosition jdkFieldPosition = new java.text.FieldPosition(TestJdkNumberFormat.INTEGER_FIELD);
        final FieldPosition fieldPosition = new FieldPosition(TestJdkNumberFormat.INTEGER_FIELD);

        assertEquals(jdk.format(value, jdkStringBuffer, jdkFieldPosition).toString(),
                format.format(value, stringBuffer, fieldPosition).toString(),
                "format(long, StringBuilder, FieldPosition) " + value);
        this.checkFieldPosition(jdkFieldPosition, fieldPosition);
    }

    private void formatObjectStringBufferFieldPositionAndCheck(final Object value) {
        final TestJdkNumberFormat jdk = new TestJdkNumberFormat();
        final TestNumberFormat format = new TestNumberFormat();

        final StringBuffer jdkStringBuffer = new StringBuffer();
        final StringBuffer stringBuffer = new StringBuffer();

        final java.text.FieldPosition jdkFieldPosition = new java.text.FieldPosition(TestJdkNumberFormat.INTEGER_FIELD);
        final FieldPosition fieldPosition = new FieldPosition(TestJdkNumberFormat.INTEGER_FIELD);

        assertEquals(jdk.format(value, jdkStringBuffer, jdkFieldPosition).toString(),
                format.format(value, stringBuffer, fieldPosition).toString(),
                "format(Object, StringBuilder, FieldPosition) " + value);
        this.checkFieldPosition(jdkFieldPosition, fieldPosition);
    }

    private void checkFieldPosition(final java.text.FieldPosition jdkFieldPosition,
                                    final FieldPosition fieldPosition) {
        assertEquals(jdkFieldPosition.getBeginIndex(), fieldPosition.getBeginIndex(), "beginIndex");
        assertEquals(jdkFieldPosition.getEndIndex(), fieldPosition.getEndIndex(), "endIndex");
    }

    // parse............................................................................................................

    @Test
    public void testParseZero() throws ParseException {
        this.parseAndCheck("0");
    }

    @Test
    public void testParseOne() throws ParseException {
        this.parseAndCheck("1");
    }

    @Test
    public void testParseTenHalf() throws ParseException {
        this.parseAndCheck("10.5");
    }

    @Test
    public void testParseStringParsePosition() throws ParseException {
        this.parseStringAndCheck("10.5", new java.text.ParsePosition(1));
    }

    @Test
    public void testParseObjectParsePosition() throws ParseException {
        this.parseObjectAndCheck("10.5", new java.text.ParsePosition(1));
    }

    private void parseAndCheck(final String parse) throws ParseException {
        final TestJdkNumberFormat jdk = new TestJdkNumberFormat();
        final TestNumberFormat format = new TestNumberFormat();

        assertEquals(jdk.parse(parse),
                format.parse(parse),
                () -> "parse " + parse);

        this.parseStringAndCheck(parse,
                new java.text.ParsePosition(0));
        this.parseObjectAndCheck(parse,
                new java.text.ParsePosition(0));
    }

    private void parseStringAndCheck(final String parse,
                                     final java.text.ParsePosition jdkPosition) throws ParseException {
        final TestJdkNumberFormat jdk = new TestJdkNumberFormat();
        final TestNumberFormat format = new TestNumberFormat();

        final String jdkPositionToString = jdkPosition.toString();
        final ParsePosition position = new ParsePosition(jdkPosition.getIndex());

        assertEquals(jdk.parse(parse, jdkPosition),
                format.parse(parse, position),
                () -> "parse " + parse + "," + jdkPositionToString);
        checkParsePosition(jdkPosition, position);
    }

    private void parseObjectAndCheck(final String parse,
                                     final java.text.ParsePosition jdkPosition) throws ParseException {
        final TestJdkNumberFormat jdk = new TestJdkNumberFormat();
        final TestNumberFormat format = new TestNumberFormat();

        final ParsePosition position = new ParsePosition(jdkPosition.getIndex());
        final String jdkPositionToString = jdkPosition.toString();

        assertEquals(jdk.parseObject(parse, jdkPosition),
                format.parseObject(parse, position),
                () -> "parseObject " + parse + ", " + jdkPositionToString);
        checkParsePosition(jdkPosition, position);
    }

    private void checkParsePosition(final java.text.ParsePosition jdkParsePosition,
                                    final ParsePosition parsePosition) {
        assertEquals(jdkParsePosition.getIndex(), parsePosition.getIndex(), "index");
        assertEquals(jdkParsePosition.getErrorIndex(), parsePosition.getErrorIndex(), "errorIndex");
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
            final String formatted = String.valueOf(number);
            append.append("D").append(formatted);
            pos.setBeginIndex(0);
            pos.setEndIndex(formatted.length() + 1);
            return append;
        }

        @Override
        public StringBuffer format(final long number,
                                   final StringBuffer append,
                                   final java.text.FieldPosition pos) {
            final String formatted = String.valueOf(number);
            append.append("L").append(formatted);
            pos.setBeginIndex(0);
            pos.setEndIndex(formatted.length() + 1);
            return append;
        }

        @Override
        public Number parse(final String source,
                            final java.text.ParsePosition pos) {
            return java.text.NumberFormat.getInstance().parse(source, pos);
        }
    }

    private class TestNumberFormat extends NumberFormat {

        @Override
        public StringBuffer format(final double number,
                                   final StringBuffer append,
                                   final FieldPosition pos) {
            final String formatted = String.valueOf(number);
            append.append("D").append(formatted);
            pos.setBeginIndex(0);
            pos.setEndIndex(formatted.length() + 1);
            return append;
        }

        @Override
        public StringBuffer format(final long number,
                                   final StringBuffer append,
                                   final FieldPosition pos) {
            final String formatted = String.valueOf(number);
            append.append("L").append(formatted);
            pos.setBeginIndex(0);
            pos.setEndIndex(formatted.length() + 1);
            return append;
        }

        @Override
        public Number parse(final String source,
                            final ParsePosition pos) {
            final java.text.ParsePosition jdkParsePosition = new java.text.ParsePosition(pos.getIndex());
            final Number result = java.text.NumberFormat.getInstance().parse(source, jdkParsePosition);
            pos.setIndex(jdkParsePosition.getIndex());
            pos.setErrorIndex(jdkParsePosition.getErrorIndex());
            return result;
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
