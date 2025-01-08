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
import walkingkooka.collect.list.Lists;
import walkingkooka.collect.set.Sets;
import walkingkooka.reflect.ConstantsTesting;
import walkingkooka.text.CharSequences;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimpleDateFormatComponentTest extends SimpleDateFormatComponentTestCase<SimpleDateFormatComponent>
    implements ConstantsTesting<SimpleDateFormatComponent> {

    @Test
    public void testParseInvalidFails() {
        this.parseFails("Q");
    }

    @Test
    public void testParseInvalidFails2() {
        this.parseFails("GQ");
    }

    @Test
    public void testParseTooManyTimeZoneIsoFails() {
        this.parseFails("XXXXX");
    }

    @Test
    public void testParseUndeterminedQuoteFails() {
        this.parseFails("'unterminated");
    }

    private void parseFails(final String pattern) {
        assertThrows(IllegalArgumentException.class, () -> new java.text.SimpleDateFormat(pattern));
        assertThrows(IllegalArgumentException.class, () -> SimpleDateFormatComponent.parsePattern(pattern));
    }

    @Test
    public void testParseEmpty() {
        this.parseAndCheck("");
    }

    @Test
    public void testParseEra() {
        this.parseAndCheck(SimpleDateFormatComponent.ERA, SimpleDateFormatComponent.era(1));
    }

    @Test
    public void testParseEraEra() {
        this.parseAndCheck("" + SimpleDateFormatComponent.ERA + SimpleDateFormatComponent.ERA, SimpleDateFormatComponent.era(2));
    }

    @Test
    public void testParseYear() {
        this.parseAndCheck(SimpleDateFormatComponent.YEAR, SimpleDateFormatComponent.year(1));
    }

    @Test
    public void testParseWeekYear() {
        this.parseAndCheck(SimpleDateFormatComponent.WEEK_YEAR, SimpleDateFormatComponent.weekYear(1));
    }

    @Test
    public void testParseMonthInYear() {
        this.parseAndCheck(SimpleDateFormatComponent.MONTH_IN_YEAR, SimpleDateFormatComponent.monthInYear(1));
    }

    @Test
    public void testParseWeekInYear() {
        this.parseAndCheck(SimpleDateFormatComponent.WEEK_IN_YEAR, SimpleDateFormatComponent.weekInYear(1));
    }

    @Test
    public void testParseDayInYear() {
        this.parseAndCheck(SimpleDateFormatComponent.DAY_IN_YEAR, SimpleDateFormatComponent.dayInYear(1));
    }

    @Test
    public void testParseDayInYear5() {
        final int length = 5;
        this.parseAndCheck(CharSequences.repeating(SimpleDateFormatComponent.DAY_IN_YEAR, length).toString(), SimpleDateFormatComponent.dayInYear(length));
    }

    @Test
    public void testParseDayInMonth() {
        this.parseAndCheck(SimpleDateFormatComponent.DAY_IN_MONTH, SimpleDateFormatComponent.dayInMonth(1));
    }

    @Test
    public void testParseDayOfWeekInMonth() {
        this.parseAndCheck(SimpleDateFormatComponent.DAY_OF_WEEK_IN_MONTH, SimpleDateFormatComponent.dayOfWeekInMonth(1));
    }

    @Test
    public void testParseDayNameInWeek() {
        this.parseAndCheck(SimpleDateFormatComponent.DAY_NAME_IN_WEEK, SimpleDateFormatComponent.dayNameInWeek(1));
    }

    @Test
    public void testParseDayNumberOfWeek() {
        this.parseAndCheck(SimpleDateFormatComponent.DAY_NUMBER_OF_WEEK, SimpleDateFormatComponent.dayNumberOfWeek(1));
    }

    @Test
    public void testParseAmpm() {
        this.parseAndCheck(SimpleDateFormatComponent.AMPM, SimpleDateFormatComponent.ampm(1));
    }

    @Test
    public void testParseHourInDay023() {
        this.parseAndCheck(SimpleDateFormatComponent.HOUR_IN_DAY_0_23, SimpleDateFormatComponent.hourInDay023(1));
    }

    @Test
    public void testParseHourInDay124() {
        this.parseAndCheck(SimpleDateFormatComponent.HOUR_IN_DAY_1_24, SimpleDateFormatComponent.hourInDay124(1));
    }

    @Test
    public void testParseHourAmPm011() {
        this.parseAndCheck(SimpleDateFormatComponent.HOUR_AM_PM_0_11, SimpleDateFormatComponent.hourAmPm011(1));
    }

    @Test
    public void testParseHourAmPm112() {
        this.parseAndCheck(SimpleDateFormatComponent.HOUR_AM_PM_1_12, SimpleDateFormatComponent.hourAmPm112(1));
    }

    @Test
    public void testParseMinuteInHour() {
        this.parseAndCheck(SimpleDateFormatComponent.MINUTE_IN_HOUR, SimpleDateFormatComponent.minuteInHour(1));
    }

    @Test
    public void testParseSecondInMinute() {
        this.parseAndCheck(SimpleDateFormatComponent.SECOND_IN_MINUTE, SimpleDateFormatComponent.secondInMinute(1));
    }

    @Test
    public void testParseMilli() {
        this.parseAndCheck(SimpleDateFormatComponent.MILLI, SimpleDateFormatComponent.milli(1));
    }

    @Test
    public void testParseTimeZoneGeneral() {
        this.parseAndCheck(SimpleDateFormatComponent.TIME_ZONE_GENERAL, SimpleDateFormatComponent.timeZoneGeneral(1));
    }

    @Test
    public void testParseTimeZoneIso8601() {
        this.parseAndCheck(SimpleDateFormatComponent.TIME_ZONE_ISO8601, SimpleDateFormatComponent.timeZoneIso8601(1));
    }

    @Test
    public void testParseTimeZoneRfc822() {
        this.parseAndCheck(SimpleDateFormatComponent.TIME_ZONE_RFC822, SimpleDateFormatComponent.timeZoneRfc822(1));
    }

    @Test
    public void testParseQuoteQuote() {
        this.parseAndCheck("''", SimpleDateFormatComponent.literal('\''));
    }

    @Test
    public void testParsePattern() {
        this.parseAndCheck("Gy", SimpleDateFormatComponent.era(1), SimpleDateFormatComponent.year(1));
    }

    @Test
    public void testParsePattern2() {
        this.parseAndCheck("GGy", SimpleDateFormatComponent.era(2), SimpleDateFormatComponent.year(1));
    }

    @Test
    public void testParsePattern3() {
        this.parseAndCheck("GGyy", SimpleDateFormatComponent.era(2), SimpleDateFormatComponent.year(2));
    }

    @Test
    public void testParsePatternQuoteMillis() {
        this.parseAndCheck("''S", SimpleDateFormatComponent.literal('\''), SimpleDateFormatComponent.milli(1));
    }

    @Test
    public void testParsePatternQuoteMillisLiteral() {
        this.parseAndCheck("''S'Q'", SimpleDateFormatComponent.literal('\''), SimpleDateFormatComponent.milli(1), SimpleDateFormatComponent.literal('Q'));
    }

    @Test
    public void testParsePatternOClick() {
        this.parseAndCheck("'o''clock'", SimpleDateFormatComponent.literal('o'), SimpleDateFormatComponent.literal('\''), SimpleDateFormatComponent.literal('c'), SimpleDateFormatComponent.literal('l'), SimpleDateFormatComponent.literal('o'), SimpleDateFormatComponent.literal('c'), SimpleDateFormatComponent.literal('k'));
    }

    @Test
    public void testParsePatternWithQuotes() {
        this.parseAndCheck("d MMMM 'de' y",
            SimpleDateFormatComponent.dayInMonth(1),
            SimpleDateFormatComponent.literal(' '),
            SimpleDateFormatComponent.monthInYear(4),
            SimpleDateFormatComponent.literal(' '),
            SimpleDateFormatComponent.literal('d'),
            SimpleDateFormatComponent.literal('e'),
            SimpleDateFormatComponent.literal(' '),
            SimpleDateFormatComponent.year(1));
    }

    @Test
    public void testParseYearMonthDay() {
        this.parseAndCheck("yyyyMMdd",
            SimpleDateFormatComponent.year(4).setNumberNext(),
            SimpleDateFormatComponent.monthInYear(2).setNumberNext(),
            SimpleDateFormatComponent.dayInMonth(2));
    }

    @Test
    public void testParseYearMonthDay2() {
        this.parseAndCheck("yyyyMMMdd", SimpleDateFormatComponent.year(4), SimpleDateFormatComponent.monthInYear(3), SimpleDateFormatComponent.dayInMonth(2));
    }

    @Test
    public void testParseHourMinuteSecond() {
        this.parseAndCheck("Kms",
            SimpleDateFormatComponent.hourAmPm011(1).setNumberNext(),
            SimpleDateFormatComponent.minuteInHour(1).setNumberNext(),
            SimpleDateFormatComponent.secondInMinute(1));
    }

    @Test
    public void testParseHourMinuteSecond2() {
        this.parseAndCheck("KKmss",
            SimpleDateFormatComponent.hourAmPm011(2).setNumberNext(),
            SimpleDateFormatComponent.minuteInHour(1).setNumberNext(),
            SimpleDateFormatComponent.secondInMinute(2));
    }

    @Test
    public void testParseHourMinuteSecondMilli() {
        this.parseAndCheck("KKmssSSS",
            SimpleDateFormatComponent.hourAmPm011(2).setNumberNext(),
            SimpleDateFormatComponent.minuteInHour(1).setNumberNext(),
            SimpleDateFormatComponent.secondInMinute(2).setNumberNext(),
            SimpleDateFormatComponent.milli(3));
    }

    @Test
    public void testParseHourMinuteSecondAmpm() {
        this.parseAndCheck("Kmsaa",
            SimpleDateFormatComponent.hourAmPm011(1).setNumberNext(),
            SimpleDateFormatComponent.minuteInHour(1).setNumberNext(),
            SimpleDateFormatComponent.secondInMinute(1),
            SimpleDateFormatComponent.ampm(2));
    }

    @Test
    public void testParseHourColonMinute() {
        this.parseAndCheck("K:m", SimpleDateFormatComponent.hourAmPm011(1), SimpleDateFormatComponent.literal(':'), SimpleDateFormatComponent.minuteInHour(1));
    }

    @Test
    public void testParseHourColonMinuteCommaSec() {
        this.parseAndCheck("K:m,s", SimpleDateFormatComponent.hourAmPm011(1), SimpleDateFormatComponent.literal(':'), SimpleDateFormatComponent.minuteInHour(1), SimpleDateFormatComponent.literal(','), SimpleDateFormatComponent.secondInMinute(1));
    }

    @Test
    public void testParseQuotes() {
        this.parseAndCheck("'h'", SimpleDateFormatComponent.literal('h'));
    }

    @Test
    public void testParseQuotes2() {
        this.parseAndCheck("'hello'", SimpleDateFormatComponent.literal('h'), SimpleDateFormatComponent.literal('e'), SimpleDateFormatComponent.literal('l'), SimpleDateFormatComponent.literal('l'), SimpleDateFormatComponent.literal('o'));
    }

    private void parseAndCheck(final char pattern, final SimpleDateFormatComponent component) {
        this.parseAndCheck(String.valueOf(pattern), component);
    }

    private void parseAndCheck(final String pattern, final SimpleDateFormatComponent... components) {
        new java.text.SimpleDateFormat(pattern); // verify pattern is valid.

        this.checkEquals(Lists.of(components),
            SimpleDateFormatComponent.parsePattern(pattern),
            () -> "parsePattern " + CharSequences.quoteAndEscape(pattern));
    }

    // ClassTesting.....................................................................................................

    @Override
    public Class<SimpleDateFormatComponent> type() {
        return SimpleDateFormatComponent.class;
    }

    // ConstantTesting..................................................................................................

    @Override
    public Set<SimpleDateFormatComponent> intentionalDuplicateConstants() {
        return Sets.empty();
    }
}
