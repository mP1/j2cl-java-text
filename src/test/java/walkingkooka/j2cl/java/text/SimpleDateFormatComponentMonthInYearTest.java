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

public final class SimpleDateFormatComponentMonthInYearTest extends SimpleDateFormatComponentTestCase2<SimpleDateFormatComponentMonthInYear> {

    @Test
    public void testParseFails() {
        this.parseTextAndCheck(this.createComponent(3), "XYZ");
    }

    @Test
    public void testParseIncompleteFails() {
        this.parseTextAndCheck(this.createComponent(3), "J");
    }

    @Test
    public void testParseIncompleteFails2() {
        this.parseTextAndCheck(this.createComponent(3), "Ja");
    }

    @Test
    public void testParse1Number() {
        this.parseTextAndCheck(this.createComponent(1),
                "10");
    }

    @Test
    public void testParse1NumberLeadingZero() {
        this.parseTextAndCheck(this.createComponent(1),
                "00010");
    }

    @Test
    public void testParse2Number() {
        this.parseTextAndCheck(this.createComponent(2),
                "10");
    }

    @Test
    public void testParse3Short() {
        this.parseTextAndCheck(this.createComponent(3),
                "Oct.");
    }

    @Test
    public void testParse3Long() {
        this.parseTextAndCheck(this.createComponent(3),
                "October");
    }

    @Test
    public void testParse4Short() {
        this.parseTextAndCheck(this.createComponent(4),
                "Oct.");
    }

    @Test
    public void testParse4Long() {
        this.parseTextAndCheck(this.createComponent(4),
                "October");
    }

    @Override
    SimpleDateFormatComponentMonthInYear createComponent(final int length) {
        return SimpleDateFormatComponentMonthInYear.with(length, SimpleDateFormatComponent2.UNLIMITED_MAX_DIGIT_LENGTH);
    }

    @Override
    public Class<SimpleDateFormatComponentMonthInYear> type() {
        return SimpleDateFormatComponentMonthInYear.class;
    }
}
