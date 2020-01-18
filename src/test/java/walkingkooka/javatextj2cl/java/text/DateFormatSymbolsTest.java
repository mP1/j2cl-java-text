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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import walkingkooka.HashCodeEqualsDefinedTesting2;
import walkingkooka.ToStringTesting;
import walkingkooka.reflect.ClassTesting;
import walkingkooka.reflect.JavaVisibility;

import java.util.Locale;

public final class DateFormatSymbolsTest implements ClassTesting<DateFormatSymbols>,
        HashCodeEqualsDefinedTesting2<DateFormatSymbols>,
        ToStringTesting<DateFormatSymbols> {

    @Test
    public void testNew() {
        final java.util.Locale locale = Locale.FRENCH;
        java.util.Locale.setDefault(locale);
        Locale.setDefault(Locale.forLanguageTag(locale.toLanguageTag()));

        this.check(new DateFormatSymbols(), new java.text.DateFormatSymbols());
    }

    @Test
    public void testNewLocale() {
        final java.util.Locale locale = Locale.FRENCH;
        java.util.Locale.setDefault(locale);
        Locale.setDefault(Locale.forLanguageTag(locale.toLanguageTag()));

        this.check(new DateFormatSymbols(Locale.getDefault()), new java.text.DateFormatSymbols(locale));
    }

    private void check(final DateFormatSymbols emulated,
                       final java.text.DateFormatSymbols expected) {

        Assertions.assertArrayEquals(expected.getAmPmStrings(), emulated.getAmPmStrings(), "ampm");
        Assertions.assertArrayEquals(expected.getEras(), emulated.getEras(), "eras");
        Assertions.assertArrayEquals(expected.getMonths(), emulated.getMonths(), "months");
        Assertions.assertArrayEquals(expected.getShortMonths(), emulated.getShortMonths(), "shortMonths");
        Assertions.assertArrayEquals(expected.getShortWeekdays(), emulated.getShortWeekdays(), "shortWeekdays");
        Assertions.assertArrayEquals(expected.getWeekdays(), emulated.getWeekdays(), "weekdays");
    }

    @Test
    public void testDifferentLocale() {
        this.checkNotEquals(new DateFormatSymbols(Locale.FRANCE));
    }

    @Test
    public void testDifferentAmpm() {
        final DateFormatSymbols symbols = this.createObject();
        symbols.setAmPmStrings(new String[]{"X", "Y"});
        this.checkNotEquals(symbols);
    }

    @Test
    public void testDifferentEra() {
        final DateFormatSymbols symbols = this.createObject();
        symbols.setEras(new String[]{"X", "Y"});
        this.checkNotEquals(symbols);
    }

    @Test
    public void testDifferentMonths() {
        final DateFormatSymbols symbols = this.createObject();
        symbols.setMonths(new String[]{"X", "Y"});
        this.checkNotEquals(symbols);
    }

    @Test
    public void testDifferentShortMonths() {
        final DateFormatSymbols symbols = this.createObject();
        symbols.setShortMonths(new String[]{"X", "Y"});
        this.checkNotEquals(symbols);
    }

    @Test
    public void testDifferentShortWeekdays() {
        final DateFormatSymbols symbols = this.createObject();
        symbols.setShortWeekdays(new String[]{"X", "Y"});
        this.checkNotEquals(symbols);
    }

    @Test
    public void testDifferentWeekdays() {
        final DateFormatSymbols symbols = this.createObject();
        symbols.setWeekdays(new String[]{"X", "Y"});
        this.checkNotEquals(symbols);
    }

    // ToString.........................................................................................................

    @Test
    public void testToString() {
        this.toStringAndCheck(this.createObject(),
                "ampm=\"AM\", \"PM\" eras=\"BC\", \"AD\" months=\"January\", \"February\", \"March\", \"April\", \"May\", \"June\", \"July\", \"August\", \"September\", \"October\", \"November\", \"December\", \"\" shortMonths=\"Jan\", \"Feb\", \"Mar\", \"Apr\", \"May\", \"Jun\", \"Jul\", \"Aug\", \"Sep\", \"Oct\", \"Nov\", \"Dec\", \"\" shortWeekdays=\"\", \"Sun\", \"Mon\", \"Tue\", \"Wed\", \"Thu\", \"Fri\", \"Sat\" weekdays=\"\", \"Sunday\", \"Monday\", \"Tuesday\", \"Wednesday\", \"Thursday\", \"Friday\", \"Saturday\"");
    }

    // ClassTesting.....................................................................................................

    @Override
    public Class<DateFormatSymbols> type() {
        return DateFormatSymbols.class;
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PUBLIC;
    }

    // HashCodeEqualsDefinedTesting2....................................................................................

    @Override
    public DateFormatSymbols createObject() {
        return new DateFormatSymbols(Locale.ENGLISH);
    }
}
