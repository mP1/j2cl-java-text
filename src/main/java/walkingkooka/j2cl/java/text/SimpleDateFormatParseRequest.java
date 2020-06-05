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

import walkingkooka.text.CharSequences;

import java.util.Calendar;

/**
 * Holds state about a single {@link SimpleDateFormat#parse(String, ParsePosition)} request.
 */
final class SimpleDateFormatParseRequest {

    static SimpleDateFormatParseRequest with(
            final String text,
            final ParsePosition position,
            final Calendar calendar,
            final int twoDigitDate,
            final DateFormatSymbols symbols) {
        return new SimpleDateFormatParseRequest(text, position, calendar, twoDigitDate, symbols);
    }

    private SimpleDateFormatParseRequest(
            final String text,
            ParsePosition position,
            final Calendar calendar,
            final int twoDigitDate,
            final DateFormatSymbols symbols) {
        super();
        this.text = text;
        this.position = position;
        this.calendar = calendar;

        final int century = twoDigitDate / 100 * 100;
        this.twoDigitRollOver = twoDigitDate - century;
        this.twoDigitCentury = twoDigitDate - this.twoDigitRollOver;

        this.symbols = symbols;
    }

    final String text;

    boolean isError() {
        return this.position.getErrorIndex() >= 0;
    }

    final ParsePosition position;

    final Calendar calendar;

    final int adjustTwoDigitYear(final int value) {
        return value +
                this.twoDigitCentury +
                (value < this.twoDigitRollOver ?
                        100 :
                        0);
    }

    final int twoDigitCentury;

    final int twoDigitRollOver;

    // parse............................................................................................................

    final DateFormatSymbols symbols;

    /**
     * Returns true if a colon is found and the position advanced
     */
    boolean parseColonOrError() {
        final String text = this.text;
        final ParsePosition position = this.position;
        final int pos = position.getIndex();

        final boolean matched = pos < text.length() && ':' == text.charAt(pos);
        if (matched) {
            position.setIndex(pos + 1);
        } else {
            position.setErrorIndex(pos);
        }
        return matched;
    }

    /**
     * Returns a sign value for minus or plus or {@link Integer#MIN_VALUE} in other cases.
     */
    int parsePlusOrMinusSign() {
        final String text = this.text;
        final ParsePosition position = this.position;
        final int pos = position.getIndex();

        final int sign;

        if (pos < text.length()) {
            switch (text.charAt(pos)) {
                case '-':
                    sign = PARSE_MINUS;
                    position.setIndex(pos + 1);
                    break;
                case '+':
                    sign = PARSE_PLUS;
                    position.setIndex(pos + 1);
                    break;
                default:
                    sign = PARSE_FAIL;
                    break;
            }
        } else {
            sign = PARSE_FAIL;
        }
        return sign;
    }

    /**
     * Returns a sign value for zero, minus or plus or {@link Integer#MIN_VALUE} in other cases.
     */
    int parseZeroOrPlusOrMinusSign() {
        final String text = this.text;
        final ParsePosition position = this.position;
        final int pos = position.getIndex();

        final int sign;

        if (pos < text.length()) {
            switch (text.charAt(pos)) {
                case '-':
                    sign = PARSE_MINUS;
                    position.setIndex(pos + 1);
                    break;
                case '+':
                    sign = PARSE_PLUS;
                    position.setIndex(pos + 1);
                    break;
                case 'Z':
                    sign = PARSE_ZERO;
                    position.setIndex(pos + 1);
                    break;
                default:
                    sign = PARSE_FAIL;
                    break;
            }
        } else {
            sign = PARSE_FAIL;
        }
        return sign;
    }

    final static int PARSE_PLUS = 1;
    final static int PARSE_ZERO = 0;
    final static int PARSE_MINUS = -1;
    final static int PARSE_FAIL = Integer.MIN_VALUE;

    /**
     * Parses a two digit hours or fails and sets the error index
     */
    final int parseTwoDigitHoursOrError(final int errorIndex) {
        return this.parseTwoDigitNumberOrError(24, errorIndex);
    }

    /**
     * Parses a two digit minutes or fails and sets the error index
     */
    final int parseTwoDigitMinutesOrError(final int errorIndex) {
        return this.parseTwoDigitNumberOrError(60, errorIndex);
    }

    /**
     * Parses a two digit value between 0 and the maxValue or fails and sets the error index
     */
    final int parseTwoDigitNumberOrError(final int maxValue,
                                         final int errorIndex) {
        return this.parseNumberWithMaxValueOrError(2,
                maxValue,
                errorIndex);
    }

    /**
     * Parses a two digit value between 0 and the maxValue or fails and sets the error index
     */
    final int parseNumberWithMaxValueOrError(final int minLength,
                                             final int maxValue,
                                             final int errorIndex) {
        final ParsePosition position = this.position;
        final int start = position.getIndex();

        final int value = this.parseNumberOrError(minLength, 2, errorIndex);
        if (false == this.isError()) {
            if (value < 0 || value >= maxValue) {
                position.setErrorIndex(start + 1);
            }
        }
        return value;
    }

    /**
     * Attempts to parse the given text at the position for a maximum number of characters only updating the position.
     */
    final int parseNumberOrError(final int minLength,
                                 final int maxLength,
                                 final int errorIndex) {
        final ParsePosition position = this.position;
        final int startPos = position.getIndex();

        final String text = this.text;
        final int end = Integer.MAX_VALUE == maxLength ?
                text.length() :
                Math.min(startPos + maxLength, text.length());

        int pos = startPos;
        int value = 0;
        boolean abort = false;

        for(;;) {
            if (abort || pos == end) {
                if(pos - startPos < minLength) {
                    position.setErrorIndex(/*startPos*/errorIndex);
                } else {
                    position.setIndex(pos);
                }
                break;
            }
            final int digitValue = Character.digit(text.charAt(pos), 10);
            if (digitValue < 0) {
                abort = true;
                continue;
            }
            value = value * 10 + digitValue;
            pos++;
        }

        return value;
    }

    /**
     * Tries all the given possible text to get the best longest match.
     */
    final int bestMatch(final String[] possibles,
                        final int possibleStartIndex) {
        final String text = this.text;
        final int textLength = text.length();

        final ParsePosition position = this.position;
        final int i = position.getIndex();

        int bestMatchIndex = -1;
        int bestMatchLength = 0;

        for (int j = possibleStartIndex; j < possibles.length; j++) {
            final String possibleText = possibles[j];
            final int possibleTextLength = possibleText.length();
            if (possibleTextLength > 0 &&
                    i + possibleTextLength <= textLength &&
                    textLength > bestMatchLength &&
                    text.regionMatches(IGNORE_CASE, i, possibleText, 0, possibleTextLength)) {
                bestMatchIndex = j;
                bestMatchLength = possibleTextLength;
            }
        }

        return bestMatchIndex;
    }

    private final static boolean IGNORE_CASE = true;

    // Object...........................................................................................................

    @Override
    public String toString() {
        return CharSequences.quoteAndEscape(this.text) + " " + this.position + " " + this.calendar.getTime().toGMTString() + " twoDigitCentury: " + twoDigitCentury + " twoDigitRollOver: " + this.twoDigitRollOver;
    }
}
