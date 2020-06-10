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

public abstract class SimpleDateFormatComponentNumberTestCase<C extends SimpleDateFormatComponent2> extends SimpleDateFormatComponentTestCase2<C> {

    SimpleDateFormatComponentNumberTestCase() {
        super();
    }

    // formatCalendarFieldNumericValue.......................................................................................................

    @Test
    public final void testFormatDate5() {
        this.formatDateAndCheck(5, DATE);
    }

    @Test
    public final void testFormatDate6() {
        this.formatDateAndCheck(6, DATE);
    }

    // parseText........................................................................................................

    @Test
    public final void testParse1Zero() {
        this.parseTextAndCheck(1, "0");
    }

    @Test
    public final void testParse1Five() {
        this.parseTextAndCheck(1, "5");
    }

    @Test
    public final void testParse1Six() {
        this.parseTextAndCheck(1, "6");
    }

    @Test
    public final void testParse1Seven() {
        this.parseTextAndCheck(1, "7");
    }

    @Test
    public final void testParse1Eight() {
        this.parseTextAndCheck(1, "8");
    }

    @Test
    public final void testParse1Nine() {
        this.parseTextAndCheck(1, "9");
    }

    @Test
    public final void testParse1TwoDigits() {
        this.parseTextAndCheck(1, 9, 20);
    }

    @Test
    public final void testParse1ThreeDigits() {
        this.parseTextAndCheck(1, 9, 200);
    }

    @Test
    public final void testParse2() {
        this.parseTextAndCheck(2, "1");
    }

    @Test
    public final void testParse2TwoDigits() {
        this.parseTextAndCheck(2, 9, 20);
    }

    @Test
    public final void testParse2ThreeDigits() {
        this.parseTextAndCheck(2, 9, 200);
    }

    @Test
    public final void testParse3ZeroOne() {
        this.parseTextAndCheck(3, "01");
    }

    @Test
    public final void testParse3ZeroThree() {
        this.parseTextAndCheck(3, "03");
    }

    @Test
    public final void testParse3TwoDigits() {
        this.parseTextAndCheck(3, 10, 20);
    }

    @Test
    public final void testParse3ThreeDigits() {
        this.parseTextAndCheck(3, 10, 200);
    }

    @Test
    public final void testParse4() {
        this.parseTextAndCheck(4, "1");
    }

    @Test
    public final void testParse4TwoDigits() {
        this.parseTextAndCheck(4, 0, 20);
    }

    @Test
    public final void testParse4ThreeDigits() {
        this.parseTextAndCheck(4, 9, 200);
    }

    @Test
    public final void testParse4FourDigits() {
        this.parseTextAndCheck(4, 9, 2000);
    }

    @Test
    public final void testParse4With() {
        this.parseTextAndCheck(this.createComponent(4, 1),
                "9",
                "999",
                1920,
                TIMEZONE,
                LOCALE);
    }

    final void parseTextAndCheck(final int length,
                                 final int minValue,
                                 final int maxValue) {
        this.parseTextAndCheck(length, minValue, maxValue, "");
    }

    final void parseTextAndCheck(final int length,
                                 final int minValue,
                                 final int maxValue,
                                 final String after) {
        for(int i = minValue; i < maxValue; i++) {
            this.parseTextAndCheck(length, i + after);
        }
    }

    final void parseTextAndCheck(final int length,
                                 final String text) {
        this.parseTextAndCheck(this.createComponent(length), text);
    }

    @Test
    public final void testDifferentMaxDigitLength() {
        final int patternLength = 1;

        this.checkNotEquals(this.createComponent(patternLength, 2),
                this.createComponent(patternLength, 99));
    }

    @Override
    final C createComponent(final int length) {
        return this.createComponent(length, SimpleDateFormatComponent2.UNLIMITED_MAX_DIGIT_LENGTH);
    }

    abstract C createComponent(final int patternLength,
                               final int maxDigitLength);
}
