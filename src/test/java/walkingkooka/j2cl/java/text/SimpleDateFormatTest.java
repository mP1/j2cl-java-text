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
import walkingkooka.HashCodeEqualsDefinedTesting2;
import walkingkooka.NeverError;
import walkingkooka.ToStringTesting;
import walkingkooka.j2cl.locale.WalkingkookaLanguageTag;
import walkingkooka.text.CharSequences;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class SimpleDateFormatTest extends FormatTestCase<SimpleDateFormat> implements HashCodeEqualsDefinedTesting2<SimpleDateFormat>,
        ToStringTesting<SimpleDateFormat> {

    private final static Locale EN_AU = Locale.forLanguageTag("en-AU");

    // getDateInstance..................................................................................................

    @Test
    public void testGetDateInstanceShortENAU() {
        this.getDateInstanceAndCheck(DateFormat.SHORT, EN_AU);
    }

    @Test
    public void testGetDateInstanceMediumENAU() {
        this.getDateInstanceAndCheck(DateFormat.MEDIUM, EN_AU);
    }

    @Test
    public void testGetDateInstanceLongENAU() {
        this.getDateInstanceAndCheck(DateFormat.LONG, EN_AU);
    }

    @Test
    public void testGetDateInstanceFullENAU() {
        this.getDateInstanceAndCheck(DateFormat.FULL, EN_AU);
    }

    @Test
    public void testGetDateInstanceShort() {
        this.allLocalesAndCheck(locale -> this.getDateInstanceAndCheck(DateFormat.SHORT, locale));
    }

    @Test
    public void testGetDateInstanceMedium() {
        this.allLocalesAndCheck(locale -> this.getDateInstanceAndCheck(DateFormat.MEDIUM, locale));
    }

    @Test
    public void testGetDateInstanceLong() {
        this.allLocalesAndCheck(locale -> this.getDateInstanceAndCheck(DateFormat.LONG, locale));
    }

    @Test
    public void testGetDateInstanceFull() {
        this.allLocalesAndCheck(locale -> this.getDateInstanceAndCheck(DateFormat.FULL, locale));
    }

    @Test
    public void testGetDateInstanceAllLocales() {
        this.allLocalesAndCheck((style, locale) -> this.getDateInstanceAndCheck(style, locale));
    }

    private void getDateInstanceAndCheck(final int style,
                                         final Locale locale) {
        this.getInstanceAndCheck(style,
                locale,
                java.text.DateFormat::getDateInstance,
                DateFormat::getDateInstance);
    }

    // getTimeInstance..................................................................................................

    @Test
    public void testGetTimeInstanceShortENAU() {
        this.getTimeInstanceAndCheck(DateFormat.SHORT, EN_AU);
    }

    @Test
    public void testGetTimeInstanceMediumENAU() {
        this.getTimeInstanceAndCheck(DateFormat.MEDIUM, EN_AU);
    }

    @Test
    public void testGetTimeInstanceLongENAU() {
        this.getTimeInstanceAndCheck(DateFormat.LONG, EN_AU);
    }

    @Test
    public void testGetTimeInstanceFullENAU() {
        this.getTimeInstanceAndCheck(DateFormat.FULL, EN_AU);
    }

    @Test
    public void testGetTimeInstanceShort() {
        this.allLocalesAndCheck(locale -> this.getTimeInstanceAndCheck(DateFormat.SHORT, locale));
    }

    @Test
    public void testGetTimeInstanceMedium() {
        this.allLocalesAndCheck(locale -> this.getTimeInstanceAndCheck(DateFormat.MEDIUM, locale));
    }

    @Test
    public void testGetTimeInstanceLong() {
        this.allLocalesAndCheck(locale -> this.getTimeInstanceAndCheck(DateFormat.LONG, locale));
    }

    @Test
    public void testGetTimeInstanceFull() {
        this.allLocalesAndCheck(locale -> this.getTimeInstanceAndCheck(DateFormat.FULL, locale));
    }

    @Test
    public void testGetTimeInstanceAllLocales() {
        this.allLocalesAndCheck((style, locale) -> this.getTimeInstanceAndCheck(style, locale));
    }

    private void getTimeInstanceAndCheck(final int style,
                                         final Locale locale) {
        this.getInstanceAndCheck(style,
                locale,
                java.text.DateFormat::getTimeInstance,
                DateFormat::getTimeInstance);
    }

    // getInstance......................................................................................................

    private void getInstanceAndCheck(final int style,
                                     final Locale locale,
                                     final BiFunction<Integer, Locale, java.text.DateFormat> jre,
                                     final BiFunction<Integer, Locale, DateFormat> emulated) {
        this.getInstanceAndCheck(style,
                locale,
                (java.text.SimpleDateFormat) jre.apply(style, locale),
                (SimpleDateFormat) emulated.apply(style, locale));
    }

    private void getInstanceAndCheck(final int style,
                                     final Locale locale,
                                     final java.text.SimpleDateFormat jre,
                                     final SimpleDateFormat emulated) {
        assertEquals(jre.toPattern(),
                emulated.toPattern(),
                () -> "pattern for style=" + toStringStyle(style) + " locale=" + locale);
    }

    // getDateTimeInstance..................................................................................................

    @Test
    public void testGetDateTimeInstanceShortShortENAU() {
        this.getDateTimeInstanceAndCheck(DateFormat.SHORT, DateFormat.SHORT, EN_AU);
    }

    @Test
    public void testGetDateTimeInstanceMediumMediumENAU() {
        this.getDateTimeInstanceAndCheck(DateFormat.MEDIUM, DateFormat.MEDIUM, EN_AU);
    }

    @Test
    public void testGetDateTimeInstanceLongLongENAU() {
        this.getDateTimeInstanceAndCheck(DateFormat.LONG, DateFormat.LONG, EN_AU);
    }

    @Test
    public void testGetDateTimeInstanceFullENAU() {
        this.getDateTimeInstanceAndCheck(DateFormat.FULL, DateFormat.FULL, EN_AU);
    }

    @Test
    public void testGetDateTimeInstanceShortShort() {
        this.allLocalesAndCheck(locale -> this.getDateTimeInstanceAndCheck(DateFormat.SHORT, DateFormat.SHORT, locale));
    }

    @Test
    public void testGetDateTimeInstanceMediumMedium() {
        this.allLocalesAndCheck(locale -> this.getDateTimeInstanceAndCheck(DateFormat.MEDIUM, DateFormat.MEDIUM, locale));
    }

    @Test
    public void testGetDateTimeInstanceLongLong() {
        this.allLocalesAndCheck(locale -> this.getDateTimeInstanceAndCheck(DateFormat.LONG, DateFormat.LONG, locale));
    }

    @Test
    public void testGetDateTimeInstanceFullFull() {
        this.allLocalesAndCheck(locale -> this.getDateTimeInstanceAndCheck(DateFormat.FULL, DateFormat.FULL, locale));
    }

    @Test
    public void testGetDateTimeInstanceAllLocales() {
        this.allLocalesAndCheck((dateStyle, locale) -> {
            for (final int timeStyle : styles()) {
                this.getDateTimeInstanceAndCheck(dateStyle, timeStyle, locale);
            }
        });
    }

    private void getDateTimeInstanceAndCheck(final int dateStyle,
                                             final int timeStyle,
                                             final Locale locale) {
        this.getDateTimeInstanceAndCheck(dateStyle,
                timeStyle,
                locale,
                (java.text.SimpleDateFormat) java.text.DateFormat.getDateTimeInstance(dateStyle, timeStyle, locale),
                (SimpleDateFormat) DateFormat.getDateTimeInstance(dateStyle, timeStyle, locale));
    }

    private void getDateTimeInstanceAndCheck(final int dateStyle,
                                             final int timeStyle,
                                             final Locale locale,
                                             final java.text.SimpleDateFormat jre,
                                             final SimpleDateFormat emulated) {
        assertEquals(jre.toPattern(),
                emulated.toPattern(),
                () -> "pattern for dateStyle=" + toStringStyle(dateStyle) + " timeStyle=" + toStringStyle(timeStyle) + " locale=" + locale);
    }

    private void allLocalesAndCheck(final BiConsumer<Integer, Locale> test) {
        this.allLocalesAndCheck(locale -> {
            for (int style : styles()) {
                test.accept(style, locale);
            }
        });
    }

    private void allLocalesAndCheck(final Consumer<Locale> test) {
        for (final Locale locale : WalkingkookaLanguageTag.locales("EN*")) {
            test.accept(locale);
        }
    }

    private static int[] styles() {
        return new int[]{DateFormat.SHORT, DateFormat.MEDIUM, DateFormat.LONG, DateFormat.FULL};
    }

    private static String toStringStyle(final int style) {
        final String toString;

        switch (style) {
            case DateFormat.SHORT:
                toString = "SHORT";
                break;
            case DateFormat.MEDIUM:
                toString = "MEDIUM";
                break;
            case DateFormat.LONG:
                toString = "LONG";
                break;
            case DateFormat.FULL:
                toString = "FULL";
                break;
            default:
                NeverError.unhandledCase(style, DateFormat.SHORT, DateFormat.MEDIUM, DateFormat.LONG, DateFormat.FULL);
                toString = null;
        }

        return toString;
    }

    // format...........................................................................................................

    @Test
    public void testFormat24Hour() {
        this.formatHourAndCheck("kk");
    }

    @Test
    public void testFormat23Hour() {
        this.formatHourAndCheck("HH");
    }

    @Test
    public void testFormat11Hour() {
        this.formatHourAndCheck("KK");
    }

    @Test
    public void testFormat12Hour() {
        this.formatHourAndCheck("hh");
    }

    private void formatHourAndCheck(final String pattern) {
        for (int i = 0; i < 23; i++) {
            this.formatAndCheck(pattern,
                    LocalDateTime.of(2020, 6, 2, i, 58, 59, 123));
        }
    }

    @Test
    public void testFormatMinute0() {
        this.formatMinuteAndCheck("m", 0);
    }

    @Test
    public void testFormatMinuteMinute0() {
        this.formatMinuteAndCheck("mm", 0);
    }

    @Test
    public void testFormatMinuteMinute10() {
        this.formatMinuteAndCheck("mm", 10);
    }

    @Test
    public void testFormatMinuteMinute59() {
        this.formatMinuteAndCheck("mm", 59);
    }

    @Test
    public void testFormatMinutesAll() {
        this.formatMinuteAndCheck("mm");
    }

    private void formatMinuteAndCheck(final String pattern) {
        for (int i = 0; i < 59; i++) {
            this.formatMinuteAndCheck(pattern, i);
        }
    }

    private void formatMinuteAndCheck(final String pattern,
                                      final int minute) {
        this.formatAndCheck(pattern,
                LocalDateTime.of(2020, 6, 2, 12, minute, 59, 123));
    }

    @Test
    public void testFormatSecond0() {
        this.formatSecondAndCheck("s", 0);
    }

    @Test
    public void testFormatSecondSecond0() {
        this.formatSecondAndCheck("ss", 0);
    }

    @Test
    public void testFormatSecondSecond10() {
        this.formatSecondAndCheck("ss", 10);
    }

    @Test
    public void testFormatSecondSecond59() {
        this.formatSecondAndCheck("ss", 59);
    }

    @Test
    public void testFormatSecondsAll() {
        this.formatSecondAndCheck("ss");
    }

    private void formatSecondAndCheck(final String pattern) {
        for (int i = 0; i < 59; i++) {
            this.formatSecondAndCheck(pattern, i);
        }
    }

    private void formatSecondAndCheck(final String pattern,
                                      final int second) {
        this.formatAndCheck(pattern,
                LocalDateTime.of(2020, 6, 2, 12, 1, second, 999));
    }

    @Test
    public void testFormatMilli0() {
        this.formatMilliAndCheck("S", 0);
    }

    @Test
    public void testFormatMilliMilli0() {
        this.formatMilliAndCheck("SS", 0);
    }

    @Test
    public void testFormatMilliMilli10() {
        this.formatMilliAndCheck("SS", 10);
    }

    @Test
    public void testFormatMilliMilli59() {
        this.formatMilliAndCheck("SS", 59);
    }

    @Test
    public void testFormatMillisAll() {
        this.formatMilliAndCheck("SS");
    }

    private void formatMilliAndCheck(final String pattern) {
        for (int i = 0; i < 59; i++) {
            this.formatMilliAndCheck(pattern, i);
        }
    }

    private void formatMilliAndCheck(final String pattern,
                                      final int millis) {
        this.formatAndCheck(pattern,
                LocalDateTime.of(2020, 6, 2, 0, 1, 59, millis));
    }

    @Test
    public void testFormat23HourMinute() {
        this.formatAndCheck("HHmm", LocalDateTime.of(2020,6,2,12,58,59));
    }

    @Test
    public void testFormat24HourMinute() {
        this.formatAndCheck("kkmm", LocalDateTime.of(2020,6,2,12,58,59));
    }

    @Test
    public void testFormat11HourMinute() {
        this.formatAndCheck("KKKmm", LocalDateTime.of(2020,6,2,12,58,59));
    }

    @Test
    public void testFormat12HourMinute() {
        this.formatAndCheck("hhmm", LocalDateTime.of(2020,6,2,12,58,59));
    }

    @Test
    public void testFormatYearMonthDay() {
        this.formatAndCheck("yyyyMMdd", LocalDateTime.of(2020, 6, 2, 12, 58, 59));
    }

    @Test
    public void testFormatYearSlashMonthSlashDay() {
        this.formatAndCheck("yyyy/MM/dd", LocalDateTime.of(2020, 6, 2, 12, 58, 59));
    }

    @Test
    public void testFormatYearMonthDayHourMinuteSecMilli() {
        this.formatAndCheck("yyyyMMddHHmmssSS", LocalDateTime.of(2020,6,2,12,58,59, 123));
    }

    private void formatAndCheck(final String pattern,
                                final java.time.LocalDateTime localDateTime) {
        this.formatAndCheck(pattern,
                java.util.Date.from(localDateTime
                        .atZone(ZoneId.of("Australia/Sydney"))
                        .toInstant()));
    }

    private void formatAndCheck(final String pattern,
                                final Date date) {
        final java.text.SimpleDateFormat jre = new java.text.SimpleDateFormat(pattern);
        final SimpleDateFormat emul = new SimpleDateFormat(pattern);

        assertEquals(jre.format(date),
                emul.format(date),
                () -> "pattern=" + CharSequences.quoteAndEscape(emul.toPattern()) + " date=" + new java.text.SimpleDateFormat("yyyy/MM/dd kk:mm:ss:SSS aaa").format(date));
    }

    // ClassTesting.....................................................................................................

    @Override
    public Class<SimpleDateFormat> type() {
        return SimpleDateFormat.class;
    }

    // HashCodeEquals...................................................................................................

    @Override
    public SimpleDateFormat createObject() {
        return new SimpleDateFormat("dd/MM/yyy");
    }
}
