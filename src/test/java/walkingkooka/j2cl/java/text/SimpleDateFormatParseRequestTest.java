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
import walkingkooka.ToStringTesting;
import walkingkooka.reflect.ClassTesting2;
import walkingkooka.reflect.JavaVisibility;
import walkingkooka.text.CharSequences;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final class SimpleDateFormatParseRequestTest implements ClassTesting2<SimpleDateFormatParseRequest>, ToStringTesting<SimpleDateFormatParseRequest> {

    private final static DateFormatSymbols SYMBOLS = DateFormatSymbols.getInstance(Locale.ENGLISH);

    @Test
    public void testWith() {
        final String text = "abc123";
        final ParsePosition position = new ParsePosition(123);
        final Calendar calendar = Calendar.getInstance();
        final int twoDigitDate = 1920;

        final SimpleDateFormatParseRequest parser = SimpleDateFormatParseRequest.with(text, position, calendar, twoDigitDate, SYMBOLS);
        this.checkEquals(text, parser.text, "text");
        this.checkEquals(position, parser.position, "position");
        this.checkEquals(calendar, parser.calendar, "calendar");
        this.checkEquals(1900, parser.twoDigitCentury, "twoDigitCentury");
        this.checkEquals(20, parser.twoDigitRollOver, "twoDigitRollOver");
    }

    // adjustYear.......................................................................................................

    @Test
    public void testAdjustYearBefore() {
        this.adjustYearAndCheck(1920, 10, 2010);
    }

    @Test
    public void testAdjustYearSame() {
        this.adjustYearAndCheck(1920, 20, 1920);
    }

    @Test
    public void testAdjustYearAfter() {
        this.adjustYearAndCheck(1920, 30, 1930);
    }

    private void adjustYearAndCheck(final int twoDigitDate, final int year, final int expected) {
        this.checkEquals(expected,
                SimpleDateFormatParseRequest.with("123", new ParsePosition(123), Calendar.getInstance(), twoDigitDate, SYMBOLS).adjustTwoDigitYear(year),
                () -> "adjustTwoDigitDate " + year + " twoDigitDate: " + twoDigitDate);
    }

    // parseColonOrError................................................................................................

    @Test
    public void testParseColonOrErrorEmpty() {
        this.parseColonOrErrorAndCheck("", 0, false);
    }

    @Test
    public void testParseColonOrErrorEmpty2() {
        this.parseColonOrErrorAndCheck("abc", 3, false);
    }

    @Test
    public void testParseColonOrErrorFails() {
        this.parseColonOrErrorAndCheck("abc", 0, false);
    }

    @Test
    public void testParseColonOrErrorMatch() {
        this.parseColonOrErrorAndCheck(":abc", 0, true);
    }

    @Test
    public void testParseColonOrErrorMatch2() {
        this.parseColonOrErrorAndCheck("a:bc", 1, true);
    }

    private void parseColonOrErrorAndCheck(final String text,
                                    final int pos,
                                    final boolean expected) {
        final ParsePosition parsePosition = new ParsePosition(pos);

        this.checkEquals(expected,
                this.request(text, parsePosition).parseColonOrError(),
                () -> "parseColonOrError " + CharSequences.quoteAndEscape(text) + " pos " + pos);
        this.checkEquals(pos + (expected ? 1 : 0),
                parsePosition.getIndex(),
                "index");
        this.checkEquals(expected ? -1 : pos,
                parsePosition.getErrorIndex(),
                "errorIndex");
    }

    // parsePlusOrMinusSign.......................................................................................................

    @Test
    public void testParsePlusOrMinusSignEmpty() {
        this.parsePlusOrMinusSignAndCheck("", 0, SimpleDateFormatParseRequest.PARSE_FAIL);
    }

    @Test
    public void testParsePlusOrMinusSignEmpty2() {
        this.parsePlusOrMinusSignAndCheck("abc", 3, SimpleDateFormatParseRequest.PARSE_FAIL);
    }

    @Test
    public void testParsePlusOrMinusSignFails() {
        this.parsePlusOrMinusSignAndCheck("abc", 0, SimpleDateFormatParseRequest.PARSE_FAIL);
    }

    @Test
    public void testParsePlusOrMinusSignMatchPlusSign() {
        this.parsePlusOrMinusSignAndCheck("+", 0, SimpleDateFormatParseRequest.PARSE_PLUS);
    }

    @Test
    public void testParsePlusOrMinusSignMatchPlusSign2() {
        this.parsePlusOrMinusSignAndCheck("a+bc", 1, SimpleDateFormatParseRequest.PARSE_PLUS);
    }

    @Test
    public void testParsePlusOrMinusSignMatchMinusSign() {
        this.parsePlusOrMinusSignAndCheck("0-", 1, SimpleDateFormatParseRequest.PARSE_MINUS);
    }

    @Test
    public void testParsePlusOrMinusSignMatchZeroFails() {
        this.parsePlusOrMinusSignAndCheck("Z-", 0, SimpleDateFormatParseRequest.PARSE_FAIL);
    }

    private void parsePlusOrMinusSignAndCheck(final String text,
                                              final int pos,
                                              final int expected) {
        final ParsePosition parsePosition = new ParsePosition(pos);
        final int errorIndex = 999;
        parsePosition.setErrorIndex(errorIndex);

        this.checkEquals(expected,
                this.request(text, parsePosition).parsePlusOrMinusSign(),
                () -> "parsePlusOrMinusSign " + CharSequences.quoteAndEscape(text) + " pos " + pos);
        this.checkEquals(pos + (expected == Integer.MIN_VALUE ? 0 : 1),
                parsePosition.getIndex(),
                "index");
        this.checkEquals(errorIndex,
                parsePosition.getErrorIndex(),
                "errorIndex");
    }

    // parseZeroOrPlusOrMinusSign.......................................................................................................

    @Test
    public void testParseZeroOrPlusOrMinusSignEmpty() {
        this.parseZeroOrPlusOrMinusSignAndCheck("", 0, SimpleDateFormatParseRequest.PARSE_FAIL);
    }

    @Test
    public void testParseZeroOrPlusOrMinusSignEmpty2() {
        this.parseZeroOrPlusOrMinusSignAndCheck("abc", 3, SimpleDateFormatParseRequest.PARSE_FAIL);
    }

    @Test
    public void testParseZeroOrPlusOrMinusSignFails() {
        this.parseZeroOrPlusOrMinusSignAndCheck("abc", 0, SimpleDateFormatParseRequest.PARSE_FAIL);
    }

    @Test
    public void testParseZeroOrPlusOrMinusSignMatchPlusSign() {
        this.parseZeroOrPlusOrMinusSignAndCheck("+", 0, SimpleDateFormatParseRequest.PARSE_PLUS);
    }

    @Test
    public void testParseZeroOrPlusOrMinusSignMatchPlusSign2() {
        this.parseZeroOrPlusOrMinusSignAndCheck("a+bc", 1, SimpleDateFormatParseRequest.PARSE_PLUS);
    }

    @Test
    public void testParseZeroOrPlusOrMinusSignMatchMinusSign() {
        this.parseZeroOrPlusOrMinusSignAndCheck("0-", 1, SimpleDateFormatParseRequest.PARSE_MINUS);
    }

    @Test
    public void testParseZeroOrPlusOrMinusSignMatchZero() {
        this.parseZeroOrPlusOrMinusSignAndCheck("Z-", 0, SimpleDateFormatParseRequest.PARSE_ZERO);
    }

    @Test
    public void testParseZeroOrPlusOrMinusSignMatchZero2() {
        this.parseZeroOrPlusOrMinusSignAndCheck("AZ-", 1, SimpleDateFormatParseRequest.PARSE_ZERO);
    }

    private void parseZeroOrPlusOrMinusSignAndCheck(final String text,
                                                    final int pos,
                                                    final int expected) {
        final ParsePosition parsePosition = new ParsePosition(pos);
        final int errorIndex = 999;
        parsePosition.setErrorIndex(errorIndex);

        this.checkEquals(expected,
                this.request(text, parsePosition).parseZeroOrPlusOrMinusSign(),
                () -> "parseZeroOrPlusOrMinusSign " + CharSequences.quoteAndEscape(text) + " pos " + pos);
        this.checkEquals(pos + (expected == Integer.MIN_VALUE ? 0 : 1),
                parsePosition.getIndex(),
                "index");
        this.checkEquals(errorIndex,
                parsePosition.getErrorIndex(),
                "errorIndex");
    }

    // parseTwoDigitNumber.......................................................................................................

    @Test
    public void testParseTwoDigitNumberEmpty() {
        this.parseTwoDigitNumberAndCheck("", 0, 60, 999, 0, 0, 999);
    }

    @Test
    public void testParseTwoDigitNumberEmpty2() {
        this.parseTwoDigitNumberAndCheck("abc", 3, 60, 999, 0, 3, 999);
    }

    @Test
    public void testParseTwoDigitNumberNonNumberFails() {
        this.parseTwoDigitNumberAndCheck("abc", 0, 60, 999, 0, 0, 999);
    }

    @Test
    public void testParseTwoDigitNumberInvalidNumberFails() {
        this.parseTwoDigitNumberAndCheck("99!", 0, 60, 999, 99, 2, 1);
    }

    @Test
    public void testParseTwoDigitNumberNumber1() {
        this.parseTwoDigitNumberAndCheck("00", 0, 60, 999, 0, 2, -1);
    }

    @Test
    public void testParseTwoDigitNumberNumber2() {
        this.parseTwoDigitNumberAndCheck("59", 0, 60, 999, 59, 2, -1);
    }

    @Test
    public void testParseTwoDigitNumberNumber3() {
        this.parseTwoDigitNumberAndCheck("A30", 1, 60, 999, 30, 3, -1);
    }

    @Test
    public void testParseTwoDigitNumberNumber4() {
        this.parseTwoDigitNumberAndCheck("A30Z", 1, 60, 999, 30, 3, -1);
    }

    private void parseTwoDigitNumberAndCheck(final String text,
                                             final int pos,
                                             final int max,
                                             final int failErrorIndex,
                                             final int expected,
                                             final int index,
                                             final int expectedErrorIndex) {
        final ParsePosition parsePosition = new ParsePosition(pos);

        this.checkEquals(expected,
                this.request(text, parsePosition).parseTwoDigitNumberOrError(max, failErrorIndex),
                () -> "parseTwoDigitNumber " + CharSequences.quoteAndEscape(text) + ", pos " + pos + ", max: " + max + ", errorIndex " + failErrorIndex);
        this.checkEquals(index,
                parsePosition.getIndex(),
                "index");
        this.checkEquals(expectedErrorIndex,
                parsePosition.getErrorIndex(),
                "errorIndex");
    }

    // parseNumberOrError...............................................................................................

    @Test
    public void testParseNumberOrErrorOneDigit() {
        this.parseNumberOrErrorAndCheck("0", 0, 1, 100, 0, 1);
    }

    @Test
    public void testParseNumberOrErrorOneDigit2() {
        this.parseNumberOrErrorAndCheck("1", 0, 1, 100, 1, 1);
    }

    @Test
    public void testParseNumberOrErrorOneDigit3() {
        this.parseNumberOrErrorAndCheck("9", 0, 1, 100, 9, 1);
    }

    @Test
    public void testParseNumberOrErrorStartPosition() {
        this.parseNumberOrErrorAndCheck("123", 2, 1, 100, 3, 3);
    }

    @Test
    public void testParseNumberOrErrorManyDigits() {
        this.parseNumberOrErrorAndCheck("123456", 0, 1, 100, 123456, 6);
    }

    @Test
    public void testParseNumberOrErrorManyDigits2() {
        this.parseNumberOrErrorAndCheck("123xyz", 0, 1, 100, 123, 3);
    }

    @Test
    public void testParseNumberOrErrorMaxLength() {
        this.parseNumberOrErrorAndCheck("123456", 1, 1, 2, 23, 3);
    }

    @Test
    public void testParseNumberOrErrorMinLength() {
        this.parseNumberOrErrorAndCheck("ABC", 0, 2, 3, 0, 0, 0, 0);
    }

    @Test
    public void testParseNumberOrErrorMinLength2() {
        this.parseNumberOrErrorAndCheck("12ABC", 0, 3, 3, 0, 12, 0, 0);
    }

    @Test
    public void testParseNumberOrErrorMinAndMaxLength() {
        this.parseNumberOrErrorAndCheck("12345ABC", 0, 1, 2, 0, 12, 2, -1);
    }

    @Test
    public void testParseNumberOrErrorMinAndMaxLength2() {
        this.parseNumberOrErrorAndCheck("12345ABC", 1, 1, 2, 23, 3);
    }

    private void parseNumberOrErrorAndCheck(final String text,
                                            final int position,
                                            final int minLength,
                                            final int maxLength,
                                            final int number,
                                            final int positionAfter) {
        this.parseNumberOrErrorAndCheck(text,
                position,
                minLength,
                maxLength,
                999,
                number,
                positionAfter,
                -1);
    }

    private void parseNumberOrErrorAndCheck(final String text,
                                            final int position,
                                            final int minLength,
                                            final int maxLength,
                                            final int failErrorIndex,
                                            final int number,
                                            final int positionAfter,
                                            final int errorIndexAfter) {
        final ParsePosition parsePosition = new ParsePosition(position);
        this.checkEquals(number,
                request(text, parsePosition).parseNumberOrError(minLength, maxLength, failErrorIndex),
                () -> "bad number, parseNumberOrError " + CharSequences.quoteAndEscape(text) + ", start pos " + position + ", minLength " + minLength + ", maxLength " + maxLength + ", errorIndex: " + failErrorIndex);
        this.checkEquals(positionAfter,
                parsePosition.getIndex(),
                () -> "bad positionAfter, parseNumberOrError " + CharSequences.quoteAndEscape(text) + ", start pos " + position + ", minLength " + minLength + ", maxLength " + maxLength + ", number: " + number + ", errorIndex: " + failErrorIndex);
        this.checkEquals(errorIndexAfter,
                parsePosition.getErrorIndex(),
                () -> "bad errorIndex, parseNumberOrError " + CharSequences.quoteAndEscape(text) + ", start pos " + position + ", minLength " + minLength + ", maxLength " + maxLength + ", number: " + number + ", errorIndex: " + failErrorIndex);
    }

    // bestMatch........................................................................................................

    @Test
    public void testBestMatchFails() {
        this.bestMatchAndCheck("abc",
                0,
                new String[]{"hello"},
                0,
                -1);
    }

    @Test
    public void testBestMatchStartIndexFails() {
        this.bestMatchAndCheck("abc",
                0,
                new String[]{"abc"},
                1,
                -1);
    }

    @Test
    public void testBestMatchPartialFails() {
        this.bestMatchAndCheck("hel",
                0,
                new String[]{"hello"},
                0,
                -1);
    }

    @Test
    public void testBestMatchOnly() {
        this.bestMatchAndCheck("abcdef",
                0,
                new String[]{"abc"},
                0,
                0);
    }

    @Test
    public void testBestMatchOnly2() {
        this.bestMatchAndCheck("abcdef",
                0,
                new String[]{"x", "abc"},
                0,
                1);
    }

    @Test
    public void testBestMatchOnly3() {
        this.bestMatchAndCheck("!abcdef",
                1,
                new String[]{"x", "abc"},
                0,
                1);
    }

    @Test
    public void testBestMatchIgnoresEmpties() {
        this.bestMatchAndCheck("!abcdef",
                1,
                new String[]{"", "", "abc"},
                0,
                2);
    }

    @Test
    public void testBestMatchBetter() {
        this.bestMatchAndCheck("!abcdef",
                1,
                new String[]{"x", "abc", "y", "abcd"},
                0,
                3);
    }

    @Test
    public void testBestMatchBetter2() {
        this.bestMatchAndCheck("!abcdef",
                1,
                new String[]{"x", "abc", "y", "abcd"},
                1,
                3);
    }

    private void bestMatchAndCheck(final String text,
                                   final int position,
                                   final String[] possibles,
                                   final int possibleStartIndex,
                                   final int expected) {
        this.checkEquals(expected,
                request(text, new ParsePosition(position)).bestMatch(possibles, possibleStartIndex),
                () -> "bestMatch " + CharSequences.quoteAndEscape(text) + " position: " + position + " possibles: " + Arrays.toString(possibles) + " possibleStartIndex: " + possibleStartIndex);
    }

    private SimpleDateFormatParseRequest request(final String text,
                                                 final ParsePosition parsePosition) {
        return SimpleDateFormatParseRequest.with(text, parsePosition, Calendar.getInstance(), 1920, SYMBOLS);
    }

    // Object...........................................................................................................

    @Test
    public void testToString() {
        final String text = "abc123";
        final ParsePosition position = new ParsePosition(123);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(1234567890123L));
        final int twoDigitDate = 1920;

        this.toStringAndCheck(SimpleDateFormatParseRequest.with(text, position, calendar, twoDigitDate, SYMBOLS),
                "\"abc123\" index=123 errorIndex=-1 13 Feb 2009 23:31:30 GMT twoDigitCentury: 1900 twoDigitRollOver: 20");
    }

    @Override
    public Class<SimpleDateFormatParseRequest> type() {
        return SimpleDateFormatParseRequest.class;
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PACKAGE_PRIVATE;
    }
}
