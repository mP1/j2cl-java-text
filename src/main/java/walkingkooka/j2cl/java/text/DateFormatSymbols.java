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

import walkingkooka.ToStringBuilder;
import walkingkooka.collect.list.Lists;
import walkingkooka.j2cl.java.io.string.StringDataInputDataOutput;
import walkingkooka.j2cl.locale.LocaleAware;

import java.io.DataInput;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/**
 * A very much simplified {@link java.text.DateFormatSymbols}.
 */
@LocaleAware
public class DateFormatSymbols {

    /**
     * Language tag to symbols, this is used internally to "get" the symbols for a given Locale.
     */
    private final static LanguageTagLookup<DateFormatSymbols> LANGUAGE_TAG_TO_SYMBOLS = LanguageTagLookup.empty();

    /**
     * Loads all the {@link DateFormatSymbols} data and creates constants.
     */
    static {
        try {
            register(StringDataInputDataOutput.input(DateFormatSymbolsProvider.DATA));
        } catch (final IOException cause) {
            throw new Error(cause);
        }
    }

    /**
     * Intended to only be called by the static init above. A test exists to verify the {@link DataInput} is consumed
     * and further operations will fail with an {@link java.io.EOFException}.
     */
    static void register(final DataInput data) throws IOException {
        final int count = data.readInt();

        for (int i = 0; i < count; i++) {
            final int localeCount = data.readInt();
            final List<String> locales = Lists.array();
            for (int j = 0; j < localeCount; j++) {
                locales.add(data.readUTF());
            }

            final DateFormatSymbols symbols = new DateFormatSymbols(readStringArray(data, 0),
                    readStringArray(data, 0),
                    readStringArray(data, 0),
                    readStringArray(data, 0),
                    readStringArray(data, 1),
                    readStringArray(data, 1));

            for (final String locale : locales) {
                LANGUAGE_TAG_TO_SYMBOLS.add(locale, symbols);
            }
        }
    }

    private static String[] readStringArray(final DataInput data,
                                            final int leadingEmpty) throws IOException {
        final int count = data.readInt();

        final String[] array = new String[leadingEmpty + count];
        Arrays.fill(array, 0, leadingEmpty, "");

        for(int i = 0; i < count; i++) {
            array[leadingEmpty + i] = data.readUTF();
        }
        return array;
    }

    private DateFormatSymbols(final String[] ampms,
                              final String[] eras,
                              final String[] months,
                              final String[] shortMonths,
                              final String[] shortWeekdays,
                              final String[] weekdays) {
        super();
        this.ampm = ampms;
        this.eras = eras;
        this.months = months;
        this.shortMonths = shortMonths;
        this.shortWeekdays = shortWeekdays;
        this.weekdays = weekdays;
    }

    /**
     * All available {@link Locale locales} also provide date format symbols.
     */
    public static Locale[] getAvailableLocales() {
        return LANGUAGE_TAG_TO_SYMBOLS.availableLocales();
    }

    public static DateFormatSymbols getInstance() {
        if (null == DEFAULT) {
            DEFAULT = new DateFormatSymbols();
        }
        return DEFAULT.cloneState();
    }

    // @VisibleForTestin
    static DateFormatSymbols DEFAULT;

    public static DateFormatSymbols getInstance(final Locale locale) {
        return new DateFormatSymbols(locale);
    }

    public DateFormatSymbols() {
        this(Locale.getDefault());
    }

    public DateFormatSymbols(final Locale locale) {
        this(LANGUAGE_TAG_TO_SYMBOLS.getOrFail(locale));
    }

    private DateFormatSymbols(final DateFormatSymbols source) {
        super();

        this.ampm = source.ampm;
        this.eras = source.eras;
        this.months = source.months;
        this.shortMonths = source.shortMonths;
        this.shortWeekdays = source.shortWeekdays;
        this.weekdays = source.weekdays;
    }

    public String[] getAmPmStrings() {
        return copyOf(this.ampm);
    }

    public void setAmPmStrings(final String[] ampm) {
        this.ampm = copyOf(ampm);
    }

    private String[] ampm;

    public String[] getEras() {
        return copyOf(this.eras);
    }

    public void setEras(final String[] eras) {
        this.eras = copyOf(eras);
    }

    private String[] eras;

    public String[] getMonths() {
        return copyOf(this.months);
    }

    public void setMonths(final String[] months) {
        this.months = copyOf(months);
    }

    private String[] months;

    public String[] getShortMonths() {
        return copyOf(this.shortMonths);
    }

    public void setShortMonths(final String[] shortMonths) {
        this.shortMonths = copyOf(shortMonths);
    }

    private String[] shortMonths;

    public String[] getShortWeekdays() {
        return copyOf(this.shortWeekdays);
    }

    public void setShortWeekdays(final String[] shortWeekdays) {
        this.shortWeekdays = copyOf(shortWeekdays);
    }

    private String[] shortWeekdays;

    public String[] getWeekdays() {
        return copyOf(this.weekdays);
    }

    public void setWeekdays(final String[] weekdays) {
        this.weekdays = copyOf(weekdays);
    }

    private String[] weekdays;

    private static String[] copyOf(final String[] array) {
        return Arrays.copyOf(array, array.length);
    }

    // clone...........................................................................................................

    final DateFormatSymbols cloneState() {
        return new DateFormatSymbols(this);
    }

    // Object...........................................................................................................

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(this.ampm),
                Arrays.hashCode(this.eras),
                Arrays.hashCode(this.months),
                Arrays.hashCode(this.shortMonths),
                Arrays.hashCode(this.shortWeekdays),
                Arrays.hashCode(this.weekdays));
    }

    public boolean equals(final Object other) {
        return this == other || other instanceof DateFormatSymbols && this.equals0((DateFormatSymbols) other);
    }

    private boolean equals0(final DateFormatSymbols other) {
        return Arrays.equals(this.ampm, other.ampm) &&
                Arrays.equals(this.eras, other.eras) &&
                Arrays.equals(this.months, other.months) &&
                Arrays.equals(this.shortMonths, other.shortMonths) &&
                Arrays.equals(this.shortWeekdays, other.shortWeekdays) &&
                Arrays.equals(this.weekdays, other.weekdays);
    }

    @Override
    public String toString() {
        return ToStringBuilder.empty()
                .label("ampm").value(this.ampm)
                .label("eras").value(this.eras)
                .label("months").value(this.months)
                .label("shortMonths").value(this.shortMonths)
                .label("shortWeekdays").value(this.shortWeekdays)
                .label("weekdays").value(this.weekdays)
                .build();
    }
}
