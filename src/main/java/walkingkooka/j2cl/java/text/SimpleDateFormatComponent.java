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

import walkingkooka.collect.list.Lists;
import walkingkooka.text.CharSequences;

import java.util.Date;
import java.util.List;
import java.util.function.IntFunction;

/**
 * Each sub class corresponds to a {@link SimpleDateFormat} pattern letter.
 */
abstract class SimpleDateFormatComponent {

    final static char AMPM = 'a';
    final static char DAY_IN_MONTH = 'd';
    final static char DAY_IN_YEAR = 'D';
    final static char DAY_NAME_IN_WEEK = 'E';
    final static char DAY_NUMBER_OF_WEEK = 'u';
    final static char DAY_OF_WEEK_IN_MONTH = 'F';
    final static char ERA = 'G';
    final static char HOUR_AM_PM_0_11 = 'K';
    final static char HOUR_AM_PM_1_12 = 'h';
    final static char HOUR_IN_DAY_0_23 = 'H';
    final static char HOUR_IN_DAY_1_24 = 'k';
    final static char MILLI = 'S';
    final static char MINUTE_IN_HOUR = 'm';
    final static char MONTH_IN_YEAR = 'M';
    final static char SECOND_IN_MINUTE = 's';
    final static char TIME_ZONE_GENERAL = 'z';
    final static char TIME_ZONE_RFC822 = 'Z';
    final static char TIME_ZONE_ISO8601 = 'X';
    final static char WEEK_IN_MONTH = 'W';
    final static char WEEK_IN_YEAR = 'w';
    final static char WEEK_YEAR = 'Y';
    final static char YEAR = 'y';

    /**
     * Parses and validates the pattern creating a {@link List} of {@link SimpleDateFormatComponent}.
     */
    static List<SimpleDateFormatComponent> parsePattern(String pattern) {
        final List<SimpleDateFormatComponent> components = Lists.array();

        int previous = -1;
        int count = 0;
        IntFunction<SimpleDateFormatComponent> factory = null;
        boolean inQuotes = false;

        final int patternLength = pattern.length();
        for (int i = 0; i < patternLength; i++) {
            final char c = pattern.charAt(i);

            if (inQuotes) {
                switch (c) {
                    case '\'':
                        // if next is quote dont terminate its an escaped quote
                        i++;
                        if (i < patternLength && pattern.charAt(i) == '\'') {
                            components.add(literal(c)); // escaped quote within quotes...
                        } else {
                            i--;
                            inQuotes = false;
                            factory = null;
                            previous = -1;
                        }
                        break;
                    default:
                        components.add(literal(c));
                        break;
                }
                continue;
            }

            if ('\'' == previous) {
                components.add(literal(c)); // handles quote quote -> literal quote

                switch (c) {
                    case '\'':
                        inQuotes = false;
                        factory = null;
                        break;
                    default:
                        inQuotes = true;
                        break;
                }
                previous = -1;
                continue;
            }

            if (c == previous) {
                count++;
                if (TIME_ZONE_ISO8601 == c && count > 4) {
                    throw new IllegalArgumentException("Pattern " + CharSequences.quoteAndEscape(pattern) + " includes too many characters of " + CharSequences.quoteIfChars(c));
                }
                continue;
            }

            // terminate the previous string of $previous
            if (null != factory) {
                components.add(factory.apply(count));
            }

            if ('\'' == c) {
                if (previous == c) {
                    components.add(literal(c));
                }
                previous = c;
                continue;
            }

            previous = c;

            count = 1;
            factory = SimpleDateFormatComponent.factory(c);
            if (null == factory) {
                if (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z') {
                    throw new IllegalArgumentException("Pattern " + CharSequences.quoteAndEscape(pattern) + " contains invalid character " + CharSequences.quoteIfChars(c) + " at " + i);
                }
                components.add(literal(c));
                continue;
            }
        }

        if (inQuotes) {
            throw new IllegalArgumentException("Unterminated quote in pattern " + CharSequences.quoteAndEscape(pattern));
        }
        if (null != factory) {
            components.add(factory.apply(count));
        }

        prepareComponents(components);

        return components;
    }

    private static void prepareComponents(final List<SimpleDateFormatComponent> components) {
        // this helps support parsing of digit only patterns such as HOURS followed immediaately by MINUTES. In this case
        // HOURS will no longer be greedy and consume all digits but limit itself to 2.
        final int componentCount = components.size();
        if (componentCount > 1) {
            SimpleDateFormatComponent next = components.get(componentCount - 1); // last

            for (int i = componentCount - 2; i >= 0; i--) {
                final SimpleDateFormatComponent current = components.get(i);
                if (next.isNumber()) {
                    components.set(i, current.setNumberNext());
                }
                next = current; // walking list backwards
            }
        }
    }

    /**
     * Returns a factory that accepts the length of the character.
     */
    private static IntFunction<SimpleDateFormatComponent> factory(final char c) {
        final IntFunction<SimpleDateFormatComponent> created;

        switch (c) {
            case AMPM:
                created = SimpleDateFormatComponent::ampm;
                break;
            case DAY_IN_MONTH:
                created = SimpleDateFormatComponent::dayInMonth;
                break;
            case DAY_IN_YEAR:
                created = SimpleDateFormatComponent::dayInYear;
                break;
            case DAY_NAME_IN_WEEK:
                created = SimpleDateFormatComponent::dayNameInWeek;
                break;
            case DAY_NUMBER_OF_WEEK:
                created = SimpleDateFormatComponent::dayNumberOfWeek;
                break;
            case DAY_OF_WEEK_IN_MONTH:
                created = SimpleDateFormatComponent::dayOfWeekInMonth;
                break;
            case ERA:
                created = SimpleDateFormatComponent::era;
                break;
            case HOUR_AM_PM_0_11:
                created = SimpleDateFormatComponent::hourAmPm011;
                break;
            case HOUR_AM_PM_1_12:
                created = SimpleDateFormatComponent::hourAmPm112;
                break;
            case HOUR_IN_DAY_0_23:
                created = SimpleDateFormatComponent::hourInDay023;
                break;
            case HOUR_IN_DAY_1_24:
                created = SimpleDateFormatComponent::hourInDay124;
                break;
            case MILLI:
                created = SimpleDateFormatComponent::milli;
                break;
            case MINUTE_IN_HOUR:
                created = SimpleDateFormatComponent::minuteInHour;
                break;
            case MONTH_IN_YEAR:
                created = SimpleDateFormatComponent::monthInYear;
                break;
            case SECOND_IN_MINUTE:
                created = SimpleDateFormatComponent::secondInMinute;
                break;
            case TIME_ZONE_GENERAL:
                created = SimpleDateFormatComponent::timeZoneGeneral;
                break;
            case TIME_ZONE_ISO8601:
                created = SimpleDateFormatComponent::timeZoneIso8601;
                break;
            case TIME_ZONE_RFC822:
                created = SimpleDateFormatComponent::timeZoneRfc822;
                break;
            case WEEK_IN_MONTH:
                created = SimpleDateFormatComponent::weekInMonth;
                break;
            case WEEK_IN_YEAR:
                created = SimpleDateFormatComponent::weekInYear;
                break;
            case WEEK_YEAR:
                created = SimpleDateFormatComponent::weekYear;
                break;
            case YEAR:
                created = SimpleDateFormatComponent::year;
                break;
            default:
                created = null;
                break;
        }

        return created;
    }

    /**
     * {@see SimpleDateFormatComponentAmPm}
     */
    static SimpleDateFormatComponent ampm(final int length) {
        return SimpleDateFormatComponentAmPm.with(length);
    }

    /**
     * {@see SimpleDateFormatComponentDayInMonth}
     */
    static SimpleDateFormatComponent dayInMonth(final int length) {
        return SimpleDateFormatComponentDayInMonth.with(length, SimpleDateFormatComponent2.UNLIMITED_MAX_DIGIT_LENGTH);
    }

    /**
     * {@see SimpleDateFormatComponentDayInYear}
     */
    static SimpleDateFormatComponent dayInYear(final int length) {
        return SimpleDateFormatComponentDayInYear.with(length, SimpleDateFormatComponent2.UNLIMITED_MAX_DIGIT_LENGTH);
    }

    /**
     * {@see SimpleDateFormatComponentDayNameInWeek}
     */
    static SimpleDateFormatComponent dayNameInWeek(final int length) {
        return SimpleDateFormatComponentDayNameInWeek.with(length);
    }

    /**
     * {@see SimpleDateFormatComponentDayNumberOfWeek}
     */
    static SimpleDateFormatComponent dayNumberOfWeek(final int length) {
        return SimpleDateFormatComponentDayNumberOfWeek.with(length, SimpleDateFormatComponent2.UNLIMITED_MAX_DIGIT_LENGTH);
    }

    /**
     * {@see SimpleDateFormatComponentDayOfWeekInMonth}
     */
    static SimpleDateFormatComponent dayOfWeekInMonth(final int length) {
        return SimpleDateFormatComponentDayOfWeekInMonth.with(length, SimpleDateFormatComponent2.UNLIMITED_MAX_DIGIT_LENGTH);
    }

    /**
     * {@see SimpleDateFormatComponentEra}
     */
    static SimpleDateFormatComponent era(final int length) {
        return SimpleDateFormatComponentEra.with(length);
    }

    /**
     * {@see SimpleDateFormatComponentHourAmPm011}
     */
    static SimpleDateFormatComponent hourAmPm011(final int length) {
        return SimpleDateFormatComponentHourAmPm011.with(length, SimpleDateFormatComponent2.UNLIMITED_MAX_DIGIT_LENGTH);
    }

    /**
     * {@see SimpleDateFormatComponentHourAmPm112}
     */
    static SimpleDateFormatComponent hourAmPm112(final int length) {
        return SimpleDateFormatComponentHourAmPm112.with(length, SimpleDateFormatComponent2.UNLIMITED_MAX_DIGIT_LENGTH);
    }

    /**
     * {@see SimpleDateFormatComponentHourInDay023}
     */
    static SimpleDateFormatComponent hourInDay023(final int length) {
        return SimpleDateFormatComponentHourInDay023.with(length, SimpleDateFormatComponent2.UNLIMITED_MAX_DIGIT_LENGTH);
    }

    /**
     * {@see SimpleDateFormatComponentHourInDay124}
     */
    static SimpleDateFormatComponent hourInDay124(final int length) {
        return SimpleDateFormatComponentHourInDay124.with(length, SimpleDateFormatComponent2.UNLIMITED_MAX_DIGIT_LENGTH);
    }

    /**
     * {@see SimpleDateFormatComponentLiteral}
     */
    static SimpleDateFormatComponent literal(final char c) {
        return SimpleDateFormatComponentLiteral.with(c);
    }

    /**
     * {@see SimpleDateFormatComponentMinuteInHour}
     */
    static SimpleDateFormatComponent minuteInHour(final int length) {
        return SimpleDateFormatComponentMinuteInHour.with(length, SimpleDateFormatComponent2.UNLIMITED_MAX_DIGIT_LENGTH);
    }

    /**
     * {@see SimpleDateFormatComponentMilli}
     */
    static SimpleDateFormatComponent milli(final int length) {
        return SimpleDateFormatComponentMilli.with(length, SimpleDateFormatComponent2.UNLIMITED_MAX_DIGIT_LENGTH);
    }

    /**
     * {@see SimpleDateFormatComponentMonthInYear}
     */
    static SimpleDateFormatComponent monthInYear(final int length) {
        return SimpleDateFormatComponentMonthInYear.with(length, SimpleDateFormatComponent2.UNLIMITED_MAX_DIGIT_LENGTH);
    }

    /**
     * {@see SimpleDateFormatComponentSecondInMinute}
     */
    static SimpleDateFormatComponent secondInMinute(final int length) {
        return SimpleDateFormatComponentSecondInMinute.with(length, SimpleDateFormatComponent2.UNLIMITED_MAX_DIGIT_LENGTH);
    }

    /**
     * {@see SimpleDateFormatComponentWeekInMonth}
     */
    static SimpleDateFormatComponent weekInMonth(final int length) {
        return SimpleDateFormatComponentWeekInMonth.with(length, SimpleDateFormatComponent2.UNLIMITED_MAX_DIGIT_LENGTH);
    }

    /**
     * {@see SimpleDateFormatComponentWeekInYear}
     */
    static SimpleDateFormatComponent weekInYear(final int length) {
        return SimpleDateFormatComponentWeekInYear.with(length, SimpleDateFormatComponent2.UNLIMITED_MAX_DIGIT_LENGTH);
    }

    /**
     * {@see SimpleDateFormatComponentWeekYear}
     */
    static SimpleDateFormatComponent weekYear(final int length) {
        return SimpleDateFormatComponentWeekYear.with(length, SimpleDateFormatComponent2.UNLIMITED_MAX_DIGIT_LENGTH);
    }

    /**
     * {@see SimpleDateFormatComponentYear}
     */
    static SimpleDateFormatComponent year(final int length) {
        return SimpleDateFormatComponentYear.with(length, SimpleDateFormatComponent2.UNLIMITED_MAX_DIGIT_LENGTH);
    }

    /**
     * {@see SimpleDateFormatComponentTimeZoneGeneral}
     */
    static SimpleDateFormatComponent timeZoneGeneral(final int length) {
        return SimpleDateFormatComponentTimeZoneGeneral.with(length);
    }

    /**
     * {@see SimpleDateFormatComponentTimeZoneIso8601}
     */
    static SimpleDateFormatComponent timeZoneIso8601(final int length) {
        return SimpleDateFormatComponentTimeZoneIso8601.with(length);
    }

    /**
     * {@see SimpleDateFormatComponentTimeZoneRfc822}
     */
    static SimpleDateFormatComponent timeZoneRfc822(final int length) {
        return SimpleDateFormatComponentTimeZoneRfc822.with(length);
    }

    /**
     * Package private to limi sub classing.
     */
    SimpleDateFormatComponent() {
        super();
    }

    /**
     * Returns true if this component is represented when parsing as a sequence of digits, eg seconds is a number.
     */
    abstract boolean isNumber();

    /**
     * Notifies this component if it a number field, such as {@link SimpleDateFormatComponentNumber} following it.
     */
    abstract SimpleDateFormatComponent setNumberNext();

    /**
     * Formats a component of the given {@link Date} to the {@link StringBuilder}.
     */
    abstract void formatDate(final SimpleDateFormatFormatRequest request);

    /**
     * Consumes part of the text updating the calendar, position and error index as necessary
     */
    abstract void parseText(final SimpleDateFormatParseRequest request);
}
