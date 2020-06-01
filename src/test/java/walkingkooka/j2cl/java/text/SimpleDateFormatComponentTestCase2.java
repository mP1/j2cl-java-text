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
import walkingkooka.ToStringTesting;
import walkingkooka.text.CharSequences;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class SimpleDateFormatComponentTestCase2<C extends SimpleDateFormatComponent2> extends SimpleDateFormatComponentTestCase<C>
        implements HashCodeEqualsDefinedTesting2<C>,
        ToStringTesting<C> {

    SimpleDateFormatComponentTestCase2() {
        super();
    }

    final static int YEAR = 2020;
    final static int MONTH = Calendar.JUNE;
    final static int DAY = 30;
    final static int HOURS = 12;
    final static int MINUTES = 58;
    final static int SECONDS = 59;
    final static int MILLI = 987654321;

    final static Date DATE = new Date(Date.UTC(YEAR - 1900, MONTH, DAY, HOURS, MINUTES, SECONDS) + MILLI);

    // formatCalendarFieldNumericValue.......................................................................................................

    @Test
    public final void testFormatDate1() {
        this.formatDateAndCheck(1, DATE);
    }

    @Test
    public final void testFormatDate2() {
        this.formatDateAndCheck(2, DATE);
    }

    @Test
    public final void testFormatDate3() {
        this.formatDateAndCheck(3, DATE);
    }

    @Test
    public final void testFormatDate4() {
        // YUCK!!!
        if(false == this instanceof SimpleDateFormatComponentTimeZoneIso8601Test) {
            this.formatDateAndCheck(4, DATE);
        }
    }

    final void formatDateAndCheck(final int length,
                                  final Date date) {
        this.formatDateAndCheck(length,
                date,
                Locale.forLanguageTag("EN-AU"),
                false);
    }

    final void formatDateAndCheck(final int length,
                                  final Date date,
                                  final Locale locale) {
        this.formatDateAndCheck(length,
                date,
                locale,
                false);
    }

    final void formatDateAndCheck(final int length,
                                  final Date date,
                                  final Locale locale,
                                  final boolean daylightSavingTime) {
        final C component = this.createComponent(length);
        this.formatDateAndCheck(component,
                date,
                daylightSavingTime,
                new java.text.SimpleDateFormat(CharSequences.repeating(component.letter(), length).toString(), locale).format(date));
    }

    @Test
    public final void testDifferentLength() {
        this.checkNotEquals(this.createComponent(5));
    }

    @Test
    public final void testDifferentComponent() {
        this.checkNotEquals(SimpleDateFormatComponent.literal('\''));
    }

    @Test
    public final void testToString() throws Exception {
        final Character letter = (Character) this.type()
                .getDeclaredField("LETTER")
                .get(null);
        final int length = 3;
        this.toStringAndCheck(this.createComponent(length), CharSequences.repeating(letter, length).toString());
    }


    abstract C createComponent(final int length);

    @Override
    public final C createObject() {
        return this.createComponent(2);
    }
}
