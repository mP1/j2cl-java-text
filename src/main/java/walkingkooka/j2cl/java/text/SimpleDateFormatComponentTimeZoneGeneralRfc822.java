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

import java.util.Calendar;

/**
 * Base class for both General and RFC822 timezones, holding a common/shared parseText.
 */
abstract class SimpleDateFormatComponentTimeZoneGeneralRfc822 extends SimpleDateFormatComponent2 {

    SimpleDateFormatComponentTimeZoneGeneralRfc822(final int length) {
        super(length);
    }

    @Override
    final boolean isNumber() {
        return false; // isnt number only will start with a letter or sign
    }

    @Override
    final SimpleDateFormatComponent setNumberNext() {
        return this; // dont care if followed by a number.
    }

    // parse............................................................................................................

    /**
     * Tries a general timezone followed by a RFC822 timezone offset.
     */
    @Override
    final void parseText(final SimpleDateFormatParseRequest request) {
        final ParsePosition position = request.position;

        final String text = request.text;
        final int length = text.length();

        final int start = position.getIndex();
        int index = start;

        // try GMT, GMT sign 1-or-2-digit-hours colon 2-digit-minutes, RFC 822

        if (0 == request.bestMatch(GMT, 0)) {
            index += 3; // GMT.length

            final int gmt = index;

            // skip whitespace
            while (index < length && text.charAt(index) == ' ') {
                index++;
            }

            position.setIndex(gmt);

            if (index < length) {
                switch (request.parsePlusOrMinusSign()) {
                    case SimpleDateFormatParseRequest.PARSE_PLUS:
                        this.parseHoursColonMinutesAndUpdateCalendar(request,
                                1);
                        break;
                    case SimpleDateFormatParseRequest.PARSE_MINUS:
                        this.parseHoursColonMinutesAndUpdateCalendar(request,
                                -1);
                        break;
                    default:
                        position.setIndex(gmt);
                        break;
                }

            } else {
                position.setIndex(gmt);
            }
        } else {
            // RFC822 = SIGN TWO-DIGIT-HOURS TWO-DIGIT-MINUTES
            switch (request.parsePlusOrMinusSign()) {
                case SimpleDateFormatParseRequest.PARSE_PLUS:
                    this.parseHoursMinutesAndUpdateCalendar(request,
                            1);
                    break;
                case SimpleDateFormatParseRequest.PARSE_MINUS:
                    this.parseHoursMinutesAndUpdateCalendar(request,
                            -1);
                    break;
                default:
                    position.setErrorIndex(position.getIndex());
                    break;
            }
        }

        if(request.isError()) {
            position.setIndex(start);
        }
    }

    private final static String[] GMT = new String[]{"GMT"};

    private void parseHoursColonMinutesAndUpdateCalendar(final SimpleDateFormatParseRequest request,
                                                         final int multiplier) {
        final ParsePosition position = request.position;
        final int textLength = request.text.length();

        final int hours = request.parseNumberWithMaxValueOrError(1,
                24,
                Math.min(position.getIndex(), textLength));
        if (false == request.isError()) {
            if(request.parseColonOrError()){
                final int minutes = request.parseTwoDigitMinutesOrError(Math.min(position.getIndex() + 2, textLength));
                if (false == request.isError()) {
                    request.calendar.set(CALENDAR_FIELD, hoursMinutesToMillis(hours, minutes) * multiplier);
                }
            }
        }
    }

    private void parseHoursMinutesAndUpdateCalendar(final SimpleDateFormatParseRequest request,
                                                    final int multiplier) {
        final int failErrorIndex = Math.min(request.position.getIndex() + 1 + 2 + 2, request.text.length());

        final int hours = request.parseTwoDigitHoursOrError(failErrorIndex);
        if (false == request.isError()) {
            final int minutes = request.parseTwoDigitMinutesOrError(failErrorIndex);
            if (false == request.isError()) {
                request.calendar.set(CALENDAR_FIELD, hoursMinutesToMillis(hours, minutes) * multiplier);
            }
        }
    }

    /**
     * The calendar field being read and updated.
     */
    final static int CALENDAR_FIELD = Calendar.ZONE_OFFSET;

    @Override
    final int maxDigitLength() {
        return 0;
    }
}
