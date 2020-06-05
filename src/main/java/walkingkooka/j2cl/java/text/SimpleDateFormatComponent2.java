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

import java.sql.Date;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.IntUnaryOperator;

/**
 * Base class for most {@link SimpleDateFormatComponent} holding a run count for the length of that pattern.
 */
abstract class SimpleDateFormatComponent2 extends SimpleDateFormatComponent {

    /**
     * Package private to limit sub classing.
     */
    SimpleDateFormatComponent2(final int length) {
        super();
        this.length = length;
    }

    // format...........................................................................................................

    final void formatCalendarFieldNumericValue(final SimpleDateFormatFormatRequest request,
                                               final int calendarField,
                                               final IntUnaryOperator adjustValue,
                                               final int maxLength) {
        final int value = request.calendar.get(calendarField);
        this.formatNumericValue(request,
                adjustValue.applyAsInt(value),
                maxLength);
    }

    final void formatNumericValue(final SimpleDateFormatFormatRequest request,
                                  final int value,
                                  final int maxLength) {
        final String text = String.valueOf(value);

        // pad as necessary
        request.text.append(text.length() >= maxLength ?
                text :
                CharSequences.padLeft(text, maxLength, '0'));
    }

    final void formatCalendarFieldName(final SimpleDateFormatFormatRequest request,
                                       final int calendarField,
                                       final String[] names) {
        this.formatName(request,
                request.calendar.get(calendarField),
                names);
    }

    final void formatName(final SimpleDateFormatFormatRequest request,
                          final int value,
                          final String[] names) {
        request.text.append(names[value]);
    }

    // parse............................................................................................................

    /**
     * Attempts to parse the given text at the position for a maximum number of characters, and updating the calendar field
     * with support for adjusting the new value of the calendar field.
     */
    final void parseNumberAndUpdateCalendar(final SimpleDateFormatParseRequest request,
                                            final int calendarField,
                                            final int maxLength,
                                            final BiFunction<Integer, SimpleDateFormatParseRequest, Integer> adjustWriteValue) {
        final int value = request.parseNumberOrError(1, maxLength, 9999);
        if (false == request.isError()) {
            request.calendar.set(calendarField, adjustWriteValue.apply(value, request));
        }
    }

    /**
     * Attempts to best match any of hte possible options and then update the calendar field and position index or error index.
     */
    final void parseFromOptionsAndUpdateCalendar(final SimpleDateFormatParseRequest request,
                                                 final int calendarField,
                                                 final int optionStartIndex,
                                                 final String[]... options) {
        int best = -1;

        for (final String[] possible : options) {
            best = request.bestMatch(possible, optionStartIndex);
            if (-1 != best) {
                final String bestMatch = possible[best];
                final ParsePosition position = request.position;
                position.setIndex(position.getIndex() + bestMatch.length());
                request.calendar.set(calendarField, best);
                break;
            }
        }

        if (-1 == best) {
            final ParsePosition position = request.position;
            position.setErrorIndex(position.getIndex());
        }
    }

    /**
     * Helper that converts an hours and minutes to millis, basically useful when parsing timezones.
     */
    static int hoursMinutesToMillis(final int hours, final int minutes) {
        return (int) Date.UTC(70, 0, 1, hours, minutes, 0);
    }

    // SimpleDateFormatComponent2.......................................................................................

    final int length;

    abstract char letter();

    // Object...........................................................................................................

    @Override
    public final int hashCode() {
        return Objects.hash(this.letter(), this.length);
    }

    @Override
    public final boolean equals(final Object other) {
        return this == other || (other instanceof SimpleDateFormatComponent2 && this.equals0((SimpleDateFormatComponent2) other));
    }

    private boolean equals0(final SimpleDateFormatComponent2 other) {
        return this.length == other.length &&
                this.letter() == other.letter();
    }

    @Override
    public final String toString() {
        return CharSequences.repeating(this.letter(), this.length).toString();
    }
}
