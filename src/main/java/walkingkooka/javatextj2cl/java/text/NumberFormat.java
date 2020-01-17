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

import java.math.BigInteger;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public abstract class NumberFormat extends Format {

    /**
     * All available {@link Locale locales} also provide number format symbols.
     */
    public static Locale[] getAvailableLocales() {
        return Locale.getAvailableLocales();
    }

    // factory..........................................................................................................

    /**
     * Returns a {@code NumberFormat} for formatting and parsing currency values
     * for the default locale.
     *
     * @return a {@code NumberFormat} for handling currency values.
     */
    public final static NumberFormat getCurrencyInstance() {
        return getCurrencyInstance(Locale.getDefault());
    }

    /**
     * Returns a {@code NumberFormat} for formatting and parsing currency values
     * for the specified locale.
     *
     * @param locale the locale to use.
     * @return a {@code NumberFormat} for handling currency values.
     */
    public static NumberFormat getCurrencyInstance(Locale locale) {
//        com.ibm.icu.text.DecimalFormat icuFormat = (com.ibm.icu.text.DecimalFormat) com.ibm.icu.text.NumberFormat
//                .getCurrencyInstance(locale);
//        String pattern = icuFormat.toPattern();
//        return new java.text.DecimalFormat(pattern, new java.text.DecimalFormatSymbols(locale));
        throw new UnsupportedOperationException();
    }

    /**
     * Returns a {@code NumberFormat} for formatting and parsing numbers for the
     * default locale.
     *
     * @return a {@code NumberFormat} for handling {@code Number} objects.
     */
    public static final NumberFormat getInstance() {
        return getInstance(Locale.getDefault());
    }

    /**
     * Returns a {@code NumberFormat} for formatting and parsing numbers for the
     * specified locale.
     *
     * @param locale the locale to use.
     * @return a {@code NumberFormat} for handling {@code Number} objects.
     */
    public static NumberFormat getInstance(final Locale locale) {
        return DecimalFormat.with(new DecimalFormatSymbols(locale));
    }

    /**
     * Returns a {@code NumberFormat} for formatting and parsing numbers for the
     * default locale.
     *
     * @return a {@code NumberFormat} for handling {@code Number} objects.
     */
    public static final NumberFormat getNumberInstance() {
        return getInstance();
    }

    /**
     * Returns a {@code NumberFormat} for formatting and parsing numbers for the
     * specified locale.
     *
     * @param locale the locale to use.
     * @return a {@code NumberFormat} for handling {@code Number} objects.
     */
    public static NumberFormat getNumberInstance(final Locale locale) {
        return getInstance(locale);
    }

    /**
     * Returns a {@code NumberFormat} for formatting and parsing integers for the
     * default locale.
     *
     * @return a {@code NumberFormat} for handling integers.
     */
    public static final NumberFormat getIntegerInstance() {
        return getInstance(Locale.getDefault());
    }

    /**
     * Returns a {@code NumberFormat} for formatting and parsing integers for
     * the specified locale.
     *
     * @param locale the locale to use.
     * @return a {@code NumberFormat} for handling integers.
     */
    public static NumberFormat getIntegerInstance(final Locale locale) {
        final NumberFormat format = DecimalFormat.with(new DecimalFormatSymbols(locale));
        format.setParseIntegerOnly(true);
        return format;
    }

    /**
     * Returns a {@code NumberFormat} for formatting and parsing percentage
     * values for the default locale.
     *
     * @return a {@code NumberFormat} for handling percentage values.
     */
    public final static NumberFormat getPercentInstance() {
        return getPercentInstance(Locale.getDefault());
    }

    /**
     * Returns a {@code NumberFormat} for formatting and parsing percentage
     * values for the specified locale.
     *
     * @param locale the locale to use.
     * @return a {@code NumberFormat} for handling percentage values.
     */
    public static NumberFormat getPercentInstance(Locale locale) {
//        com.ibm.icu.text.DecimalFormat icuFormat = (com.ibm.icu.text.DecimalFormat) com.ibm.icu.text.NumberFormat
//                .getPercentInstance(locale);
//        String pattern = icuFormat.toPattern();
//        return new java.text.DecimalFormat(pattern, new java.text.DecimalFormatSymbols(locale));
        throw new UnsupportedOperationException();
    }

    protected NumberFormat() {
        super();
    }

    // format...........................................................................................................

    @Override
    public StringBuffer format(final Object number,
                               final StringBuffer target,
                               final FieldPosition pos) {
        if (false == number instanceof Number) {
            throw new IllegalArgumentException("Cannot format given Object as a Number");
        }

        if (number instanceof Byte ||
                number instanceof Short ||
                number instanceof Integer ||
                number instanceof Long ||
                number instanceof AtomicInteger || number instanceof AtomicLong ||
                (number instanceof BigInteger &&
                        ((BigInteger) number).bitLength() < 64)) {
            return format(((Number) number).longValue(), target, pos);
        } else {
            return format(((Number) number).doubleValue(), target, pos);
        }
    }

    public final String format(final double number) {
        return this.format(number,
                new StringBuffer(),
                FIELD_POSITION)
                .toString();
    }

    public final String format(final long number) {
        return this.format(number,
                new StringBuffer(),
                FIELD_POSITION)
                .toString();
    }

    /**
     * A dummy FieldPosition that will be updated by the {@link #format(long, StringBuffer, FieldPosition)} and ignored
     * because it is never known by callers.
     */
    private final static FieldPosition FIELD_POSITION = new FieldPosition(0);

    public abstract StringBuffer format(final double number,
                                        final StringBuffer append,
                                        final FieldPosition pos);

    public abstract StringBuffer format(final long number,
                                        final StringBuffer append,
                                        final FieldPosition pos);

    // parse............................................................................................................

    @Override
    public final Object parseObject(final String source,
                                    final ParsePosition pos) {
        return this.parse(source, pos);
    }

    public Number parse(final String source) throws ParseException {
        final ParsePosition pos = new ParsePosition(0);
        final Number value = this.parse(source, pos);
        if (pos.getIndex() == 0) {
            throw new ParseException("Unparseable number: \"" + source + "\"", pos.getErrorIndex());
        }
        return value;
    }

    public abstract Number parse(final String source,
                                 final ParsePosition pos);

    public static class Field extends Format.Field {

        protected Field(String name) {
            super(name);
        }
    }

    // properties.......................................................................................................

    // getters/setters copied from Apache Harmony

    /**
     * Returns the currency used by this number format.
     * <p>
     * This implementation throws {@code UnsupportedOperationException},
     * concrete subclasses should override this method if they support currency
     * formatting.
     * <p>
     *
     * @return the currency that was set in getInstance() or in setCurrency(),
     * or {@code null}.
     * @throws UnsupportedOperationException
     */
    public Currency getCurrency() {
        throw new UnsupportedOperationException();
    }

    /**
     * Sets the currency used by this number format when formatting currency
     * values. The min and max fraction digits remain the same.
     * <p>
     * This implementation throws {@code UnsupportedOperationException},
     * concrete subclasses should override this method if they support currency
     * formatting.
     *
     * @param currency the new currency.
     * @throws UnsupportedOperationException
     */
    public void setCurrency(Currency currency) {
        throw new UnsupportedOperationException();
    }

    /**
     * Indicates whether this number format formats and parses numbers using a
     * grouping separator.
     *
     * @return {@code true} if a grouping separator is used; {@code false}
     * otherwise.
     */
    public boolean isGroupingUsed() {
        return groupingUsed;
    }

    /**
     * Sets whether this number format formats and parses numbers using a
     * grouping separator.
     *
     * @param value {@code true} if a grouping separator is used; {@code false}
     *              otherwise.
     */
    public void setGroupingUsed(boolean value) {
        groupingUsed = value;
    }

    private boolean groupingUsed = true;

    /**
     * Indicates whether this number format only parses integer numbers. Parsing
     * stops if a decimal separator is encountered.
     *
     * @return {@code true} if this number format only parses integers,
     * {@code false} if it parses integers as well as fractions.
     */
    public boolean isParseIntegerOnly() {
        return parseIntegerOnly;
    }

    /**
     * Specifies if this number format should parse numbers only as integers or
     * else as any kind of number. If this method is called with a {@code true}
     * value then subsequent parsing attempts will stop if a decimal separator
     * is encountered.
     *
     * @param value {@code true} to only parse integers, {@code false} to parse
     *              integers as well as fractions.
     */
    public void setParseIntegerOnly(boolean value) {
        parseIntegerOnly = value;
    }

    private boolean parseIntegerOnly = false;

    /**
     * Returns the maximum number of fraction digits that are printed when
     * formatting. If the maximum is less than the number of fraction digits,
     * the least significant digits are truncated.
     *
     * @return the maximum number of fraction digits.
     */
    public int getMaximumFractionDigits() {
        return maximumFractionDigits;
    }

    /**
     * Sets the maximum number of fraction digits that are printed when
     * formatting. If the maximum is less than the number of fraction digits,
     * the least significant digits are truncated.
     *
     * @param value the maximum number of fraction digits.
     */
    public void setMaximumFractionDigits(int value) {
        maximumFractionDigits = value < 0 ? 0 : value;
        if (maximumFractionDigits < minimumFractionDigits) {
            minimumFractionDigits = maximumFractionDigits;
        }
    }

    private int maximumFractionDigits = 3;

    /**
     * Returns the maximum number of integer digits that are printed when
     * formatting. If the maximum is less than the number of integer digits, the
     * most significant digits are truncated.
     *
     * @return the maximum number of integer digits.
     */
    public int getMaximumIntegerDigits() {
        return maximumIntegerDigits;
    }

    /**
     * Sets the new maximum count of integer digits that are printed when
     * formatting. If the maximum is less than the number of integer digits, the
     * most significant digits are truncated.
     *
     * @param value the new maximum number of integer numerals for display.
     */
    public void setMaximumIntegerDigits(int value) {
        maximumIntegerDigits = value < 0 ? 0 : value;
        if (maximumIntegerDigits < minimumIntegerDigits) {
            minimumIntegerDigits = maximumIntegerDigits;
        }
    }

    private int maximumIntegerDigits = 40;


    /**
     * Returns the minimum number of fraction digits that are printed when
     * formatting.
     *
     * @return the minimum number of fraction digits.
     */
    public int getMinimumFractionDigits() {
        return minimumFractionDigits;
    }

    /**
     * Sets the minimum number of fraction digits that are printed when
     * formatting.
     *
     * @param value the minimum number of fraction digits.
     */
    public void setMinimumFractionDigits(int value) {
        minimumFractionDigits = value < 0 ? 0 : value;
        if (maximumFractionDigits < minimumFractionDigits) {
            maximumFractionDigits = minimumFractionDigits;
        }
    }

    private int minimumFractionDigits = 0;

    /**
     * Returns the minimum number of integer digits that are printed when
     * formatting.
     *
     * @return the minimum number of integer digits.
     */
    public int getMinimumIntegerDigits() {
        return minimumIntegerDigits;
    }

    /**
     * Sets the minimum number of integer digits that are printed when
     * formatting.
     *
     * @param value the minimum number of integer digits.
     */
    public void setMinimumIntegerDigits(int value) {
        minimumIntegerDigits = value < 0 ? 0 : value;
        if (maximumIntegerDigits < minimumIntegerDigits) {
            maximumIntegerDigits = minimumIntegerDigits;
        }
    }

    private int minimumIntegerDigits = 1;

    // Object...........................................................................................................

    @Override
    public int hashCode() {
        return Objects.hash(this.groupingUsed,
                this.parseIntegerOnly,
                this.maximumFractionDigits,
                this.maximumIntegerDigits,
                this.minimumFractionDigits,
                this.minimumIntegerDigits);
    }

    @Override
    public boolean equals(final Object other) {
        return this == other || this.canBeEqual(other) && this.equals0((NumberFormat) other);
    }

    boolean canBeEqual(final Object other) {
        return other instanceof NumberFormat;
    }

    boolean equals0(final NumberFormat other) {
        return this.groupingUsed == other.groupingUsed &&
                this.parseIntegerOnly == other.parseIntegerOnly &&
                this.maximumFractionDigits == other.maximumFractionDigits &&
                this.maximumIntegerDigits == other.maximumIntegerDigits &&
                this.minimumFractionDigits == other.minimumFractionDigits &&
                this.minimumIntegerDigits == other.minimumIntegerDigits;
    }
}
