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

public abstract class SimpleDateFormatComponentTimeZoneGeneralRfc822TestCase<C extends SimpleDateFormatComponentTimeZoneGeneralRfc822>
        extends SimpleDateFormatComponentTestCase2<C> {

    SimpleDateFormatComponentTimeZoneGeneralRfc822TestCase() {
        super();
    }

    @Test
    public final void testParseTextInvalidOffset() {
        this.parseTextAndCheck("Q");
    }

    @Test
    public final void testParseTextMissingHours() {
        this.parseTextAndCheck("-");
    }

    @Test
    public final void testParseTextMissingMinutes() {
        this.parseTextAndCheck("-12");
    }

    @Test
    public final void testParseTextGMT() {
        this.parseTextAndCheck("GMT");
    }

    @Test
    public final void testParseTextGMTInvalid() {
        this.parseTextAndCheck("GMT!");
    }

    @Test
    public final void testParseTextGMTWhitespace() {
        this.parseTextAndCheck("GMT ");
    }

    @Test
    public final void testParseTextGMTWhitespaceInvalid() {
        this.parseTextAndCheck("GMT !");
    }

    @Test
    public final void testParseTextGMTWhitespaceWhitespace() {
        this.parseTextAndCheck("GMT  ");
    }

    @Test
    public final void testParseTextGMTPlusSignMissingHoursFails() {
        this.parseTextAndCheck("GMT+");
    }

    @Test
    public final void testParseTextGMTPlusSignMissingHoursFails2() {
        this.parseTextAndCheck("GMT+!");
    }

    @Test
    public final void testParseTextGMTMinusSignMissingHoursFails() {
        this.parseTextAndCheck("GMT-");
    }

    @Test
    public final void testParseTextGMTMinusSignMissingHoursFails2() {
        this.parseTextAndCheck("GMT-!");
    }

    @Test
    public final void testParseTextGMTMissingColonFails() {
        this.parseTextAndCheck("GMT+1");
    }

    @Test
    public final void testParseTextGMTInvalidHoursFails() {
        this.parseTextAndCheck("GMT+99");
    }

    @Test
    public final void testParseTextGMTInvalidHoursFails2() {
        this.parseTextAndCheck("GMT+99:");
    }

    @Test
    public final void testParseTextGMTMissingMinutesFails() {
        this.parseTextAndCheck("GMT+1:");
    }

    @Test
    public final void testParseTextGMTIncompleteMinutesFails() {
        this.parseTextAndCheck("GMT+1:1");
    }

    @Test
    public final void testParseTextGMTInvalidMinutesFails() {
        this.parseTextAndCheck("GMT+1:99");
    }

    @Test
    public final void testParseTextGMTInvalidMinutesFails2() {
        this.parseTextAndCheck("GMT+1:99Q");
    }

    @Test
    public final void testParseTextGmtPlus100() {
        this.parseTextAndCheck("GMT+1:00");
    }

    @Test
    public final void testParseTextGmtPlus145() {
        this.parseTextAndCheck("GMT+1:45");
    }

    @Test
    public final void testParseTextGmtMinus200() {
        this.parseTextAndCheck("GMT-2:00");
    }

    @Test
    public final void testParseTextGmtMinus245() {
        this.parseTextAndCheck("GMT-2:45");
    }

    @Test
    public final void testParseTextGmtPlus0300() {
        this.parseTextAndCheck("GMT+03:00");
    }

    @Test
    public final void testParseTextGmtMinus0600() {
        this.parseTextAndCheck("GMT-06:00");
    }

    @Test
    public final void testParseTextGmtMinus0900() {
        this.parseTextAndCheck("GMT-09:00");
    }

    @Test
    public final void testParseTextGmtPlus1030() {
        this.parseTextAndCheck("GMT+10:30");
    }

    // RFC822...........................................................................................................

    @Test
    public final void testParseTextPlus0300() {
        this.parseTextAndCheck("+0300");
    }

    @Test
    public final void testParseTextMinus0600() {
        this.parseTextAndCheck("-0600");
    }

    @Test
    public final void testParseTextMinus0900() {
        this.parseTextAndCheck("-0900");
    }

    @Test
    public final void testParseTextPlus1030() {
        this.parseTextAndCheck("+1030");
    }

    // helper...........................................................................................................

    private void parseTextAndCheck(final String text) {
        for (int i = 1; i <= 3; i++) {
            this.parseTextAndCheck(this.createComponent(i),
                    text);
        }
    }
}
