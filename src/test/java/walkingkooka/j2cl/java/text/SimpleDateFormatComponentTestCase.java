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

import org.junit.jupiter.api.BeforeAll;
import walkingkooka.reflect.ClassTesting;
import walkingkooka.reflect.JavaVisibility;
import walkingkooka.text.CharSequences;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public abstract class SimpleDateFormatComponentTestCase<C extends SimpleDateFormatComponent> implements ClassTesting<C> {

    final static Locale LOCALE = Locale.forLanguageTag("EN-AU");
    final static TimeZone TIMEZONE = TimeZone.getTimeZone("UTC");

    final static int YEAR = 2020;
    final static int MONTH = Calendar.JUNE;
    final static int DAY = 30;
    final static int HOURS = 12;
    final static int MINUTES = 58;
    final static int SECONDS = 59;
    final static int MILLI = 98765;

    static Date DATE;

    SimpleDateFormatComponentTestCase() {
        super();
    }

    @BeforeAll
    public static void beforeAll() {
        Locale.setDefault(LOCALE);
        TimeZone.setDefault(TIMEZONE);
        DATE = new Date(Date.UTC(YEAR - 1900, MONTH, DAY, HOURS, MINUTES, SECONDS) + MILLI);
    }

    // format............................................................................................................

    final void formatDateAndCheck(final C component,
                                  final Date date,
                                  final boolean daylightSavingTime,
                                  final String expected) {
        this.formatDateAndCheck(component,
                date,
                new DateFormatSymbols(LOCALE),
                daylightSavingTime,
                expected);
    }

    final void formatDateAndCheck(final C component,
                                  final Date date,
                                  final DateFormatSymbols symbols,
                                  final boolean daylightSavingTime,
                                  final String expected) {
        final Calendar calendar = Calendar.getInstance(TIMEZONE, LOCALE);
        calendar.setTime(date);

        this.formatDateAndCheck(component,
                calendar,
                symbols,
                daylightSavingTime,
                expected);
    }

    final void formatDateAndCheck(final C component,
                                  final Calendar calendar,
                                  final DateFormatSymbols symbols,
                                  final boolean daylightSavingTime,
                                  final String expected) {
        final StringBuffer text = new StringBuffer();
        component.formatDate(SimpleDateFormatFormatRequest.with(calendar, text, symbols, daylightSavingTime));
        this.checkEquals(expected,
                text.toString(),
                () -> component + " format " + calendar.getTime() + " symbols=" + symbols + " daylightSavingTime: " + daylightSavingTime + " tz " + TimeZone.getDefault());
    }

    // parse............................................................................................................

    final void parseTextAndCheck(final C component,
                                 final String text) {
        this.parseTextAndCheck(component,
                text,
                TIMEZONE,
                LOCALE);
    }

    final void parseTextAndCheck(final C component,
                                 final String text,
                                 final TimeZone timeZone,
                                 final Locale locale) {
        this.parseTextAndCheck(component,
                text,
                2000,
                timeZone,
                locale);
    }

    final void parseTextAndCheck(final C component,
                                 final String text,
                                 final int twoDigitYear,
                                 final TimeZone timeZone,
                                 final Locale locale) {
        this.parseTextAndCheck(component,
                text,
                text,
                twoDigitYear,
                timeZone,
                locale);
    }

    final void parseTextAndCheck(final C component,
                                 final String jreText,
                                 final String emulText,
                                 final int twoDigitYear,
                                 final TimeZone timeZone,
                                 final Locale locale) {
        final ParsePosition position = new ParsePosition(0);
        final Calendar calendar = Calendar.getInstance(timeZone, locale);
        calendar.clear();
        component.parseText(SimpleDateFormatParseRequest.with(emulText, position, calendar, twoDigitYear, DateFormatSymbols.getInstance(LOCALE)));

        final java.text.ParsePosition jrePosition = new java.text.ParsePosition(0);
        final java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(component.toString(), locale);
        simpleDateFormat.set2DigitYearStart(new Date(Date.UTC(twoDigitYear - 1900, Calendar.JANUARY, 1, 0, 0, 0)));
        simpleDateFormat.setLenient(true);
        final Date expected = simpleDateFormat.parse(jreText, jrePosition);

        this.checkEquals(jrePosition.getIndex(),
                position.getIndex(),
                () -> "index, " + component + " text=" + CharSequences.quoteAndEscape(emulText) + " errorIndex: " + jrePosition.getErrorIndex() + " expected date: " + expected);
        this.checkEquals(jrePosition.getErrorIndex(),
                position.getErrorIndex(),
                () -> "errorIndex, " + component + " text=" + CharSequences.quoteAndEscape(emulText) + " index: " + position.getIndex() + " expected date: " + expected);

        // TODO https://github.com/mP1/j2cl-java-text/issues/219
        if(false == this instanceof SimpleDateFormatComponentWeekYearTest) {
            this.checkEquals(null != expected ?
                    expected :
                    new Date(0), calendar.getTime(), () -> "date, " + component + " text=" + CharSequences.quoteAndEscape(emulText) + " jre pattern: " + simpleDateFormat.toPattern() + " 2digitYear: " + simpleDateFormat.get2DigitYearStart() + " pattern: " + component + " twoDigitYear: " + twoDigitYear);
        }
    }

    // ClassTesting.....................................................................................................

    @Override
    public final JavaVisibility typeVisibility() {
        return JavaVisibility.PACKAGE_PRIVATE;
    }
}
