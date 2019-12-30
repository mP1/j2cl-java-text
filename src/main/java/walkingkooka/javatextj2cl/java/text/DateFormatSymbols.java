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
import walkingkooka.javautillocalej2cl.WalkingkookaDateFormatSymbols;
import walkingkooka.javautillocalej2cl.WalkingkookaLanguageTag;
import walkingkooka.javautillocalej2cl.WalkingkookaLocale;

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

/**
 * A very much simplified {@link java.text.DateFormatSymbols}.
 */
public class DateFormatSymbols {

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

    public DateFormatSymbols(final WalkingkookaLocale locale) {
        super();

        final WalkingkookaDateFormatSymbols symbols = locale.dateFormatSymbols();
        this.ampm = symbols.ampm();
        this.eras = symbols.eras();
        this.months = symbols.months();
        this.shortMonths = symbols.shortMonths();
        this.shortWeekdays = symbols.shortWeekdays();
        this.weekdays = symbols.weekdays();
    }

    public String[] getAmPmStrings() {
        return this.copyOf(this.ampm);
    }

    public void setAmPmStrings(final String[] ampm) {
        this.ampm = this.copyOf(ampm);
    }

    private String[] ampm;

    public String[] getEras() {
        return this.copyOf(this.eras);
    }

    public void setEras(final String[] eras) {
        this.eras = this.copyOf(eras);
    }

    private String[] eras;

    public String[] getMonths() {
        return this.copyOf(this.months);
    }

    public void setMonths(final String[] months) {
        this.months = this.copyOf(months);
    }

    private String[] months;

    public String[] getShortMonths() {
        return this.copyOf(this.shortMonths);
    }

    public void setShortMonths(final String[] shortMonths) {
        this.shortMonths = this.copyOf(shortMonths);
    }

    private String[] shortMonths;

    public String[] getShortWeekdays() {
        return this.copyOf(this.shortWeekdays);
    }

    public void setShortWeekdays(final String[] shortWeekdays) {
        this.shortWeekdays = this.copyOf(shortWeekdays);
    }

    private String[] shortWeekdays;

    public String[] getWeekdays() {
        return this.copyOf(this.weekdays);
    }

    public void setWeekdays(final String[] weekdays) {
        this.weekdays = this.copyOf(weekdays);
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
