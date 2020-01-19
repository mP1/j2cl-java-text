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
import walkingkooka.collect.map.Maps;
import walkingkooka.javautillocalej2cl.WalkingkookaLanguageTag;
import walkingkooka.javautillocalej2cl.WalkingkookaLocale;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * A very much simplified {@link java.text.DateFormatSymbols}.
 */
public class DateFormatSymbols {

    /**
     * Language tag to symbols, this is used internally to "get" the symbols for a given Locale.
     */
    private final static Map<String, DateFormatSymbols> LANGUAGE_TAG_TO_SYMBOLS = Maps.ordered();

    static {
        DateFormatSymbolsProvider.register();
    }

    /**
     * Used by {@link DateFormatSymbolsProvider#register()} to register individual symbols
     */
    static void register(final String locales,
                         final String ampms,
                         final String eras,
                         final String months,
                         final String shortMonths,
                         final String shortWeekdays,
                         final String weekdays) {
        final DateFormatSymbols symbols = new DateFormatSymbols(ampms,
                eras,
                months,
                shortMonths,
                shortWeekdays,
                weekdays);

        for(final String locale : extractTokens(locales)) {
            LANGUAGE_TAG_TO_SYMBOLS.put(locale, symbols);
        }
    }

    private DateFormatSymbols(final String ampms,
                              final String eras,
                              final String months,
                              final String shortMonths,
                              final String shortWeekdays,
                              final String weekdays) {
        super();
        this.ampm = extractTokens(ampms);
        this.eras = extractTokens(eras);
        this.months = extractMonths(months);
        this.shortMonths = extractMonths(shortMonths);
        this.shortWeekdays = extractWeekdays(shortWeekdays);
        this.weekdays = extractWeekdays(weekdays);
    }

    private static String[] extractTokens(final String text) {
        return text.split("\t");
    }

    private static String[] extractMonths(final String text) {
        final String[] months = extractTokens(text);
        final String[] array = new String[13];
        array[12] = ""; // restore empty string in slot 12
        System.arraycopy(months, 0, array, 0, months.length);
        return array;
    }

    private static String[] extractWeekdays(final String text) {
        final String[] weekdays = extractTokens(text);
        final String[] array = new String[weekdays.length + 1];
        array[0] = ""; // restore the empty String at slot zero
        System.arraycopy(weekdays, 0, array, 1, weekdays.length);
        return array;
    }

    /**
     * All available {@link Locale locales} also provide date format symbols.
     */
    public static Locale[] getAvailableLocales() {
        return Locale.getAvailableLocales();
    }

    public DateFormatSymbols() {
        this(Locale.getDefault());
    }

    public DateFormatSymbols(final Locale locale) {
        this(toWalkingkookaLocale(locale).orElse(toWalkingkookaLocale(Locale.getDefault()).orElseThrow(() -> new IllegalStateException())));
    }

    private static Optional<WalkingkookaLocale> toWalkingkookaLocale(final Locale locale) {
        // TODO extract a js version that calls Locale#toWalkingkookaLanguageTag
        return WalkingkookaLocale.forLanguageTag(WalkingkookaLanguageTag.parse(locale.toLanguageTag()));
    }

    private DateFormatSymbols(final WalkingkookaLocale locale) {
        super();

        final DateFormatSymbols symbols = LANGUAGE_TAG_TO_SYMBOLS.get(locale.languageTag().toLanguageTag());
        this.ampm = symbols.ampm;
        this.eras = symbols.eras;
        this.months = symbols.months;
        this.shortMonths = symbols.shortMonths;
        this.shortWeekdays = symbols.shortWeekdays;
        this.weekdays = symbols.weekdays;
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
