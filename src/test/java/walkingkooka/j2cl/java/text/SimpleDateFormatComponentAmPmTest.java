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

public final class SimpleDateFormatComponentAmPmTest extends SimpleDateFormatComponentTestCase2<SimpleDateFormatComponentAmPm> {

    @Test
    public void testParseFails() {
        this.parseTextAndCheck(this.createComponent(1), "XYZ");
    }

    @Test
    public void testParseIncompleteFails() {
        this.parseTextAndCheck(this.createComponent(1), "A");
    }

    @Test
    public void testParseIncompleteFails2() {
        this.parseTextAndCheck(this.createComponent(1), "P");
    }

    @Test
    public void testParse1AM() {
        this.parseTextAndCheck(this.createComponent(1),
            "am");
    }

    @Test
    public void testParse1AMCaseInsensitive() {
        this.parseTextAndCheck(this.createComponent(1),
            "AM");
    }

    @Test
    public void testParse1PM() {
        this.parseTextAndCheck(this.createComponent(1),
            "PM");
    }

    @Test
    public void testParse2AM() {
        this.parseTextAndCheck(this.createComponent(2),
            "am");
    }

    @Test
    public void testParse2PM() {
        this.parseTextAndCheck(this.createComponent(2),
            "pm");
    }

    @Test
    public void testParse3AM() {
        this.parseTextAndCheck(this.createComponent(3),
            "am");
    }

    @Test
    public void testParse3PM() {
        this.parseTextAndCheck(this.createComponent(3),
            "pm");
    }

    @Test
    public void testParse4AM() {
        this.parseTextAndCheck(this.createComponent(4),
            "am");
    }

    @Test
    public void testParse4PM() {
        this.parseTextAndCheck(this.createComponent(4),
            "pm");
    }

    // SimpleDateFormatComponentTestCase2...............................................................................

    @Override
    SimpleDateFormatComponentAmPm createComponent(final int length) {
        return SimpleDateFormatComponentAmPm.with(length);
    }

    @Override
    public Class<SimpleDateFormatComponentAmPm> type() {
        return SimpleDateFormatComponentAmPm.class;
    }
}
