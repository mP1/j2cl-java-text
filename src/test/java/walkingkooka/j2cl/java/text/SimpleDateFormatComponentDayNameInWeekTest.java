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

public final class SimpleDateFormatComponentDayNameInWeekTest extends SimpleDateFormatComponentTestCase2<SimpleDateFormatComponentDayNameInWeek> {

    @Test
    public void testParseFails() {
        this.parseTextAndCheck(this.createComponent(1), "XYZ");
    }

    @Test
    public void testParseIncompleteFails() {
        this.parseTextAndCheck(this.createComponent(1), "Mon");
    }

    @Test
    public void testParseIncompleteFails2() {
        this.parseTextAndCheck(this.createComponent(1), "Mond");
    }

    @Test
    public void testParse1Short() {
        this.parseTextAndCheck(this.createComponent(1),
                "Mon.");
    }

    @Test
    public void testParse1Long() {
        this.parseTextAndCheck(this.createComponent(1),
                "Monday");
    }

    @Test
    public void testParse1ShortCaseInsensitive() {
        this.parseTextAndCheck(this.createComponent(1),
                "MON.");
    }

    @Test
    public void testParse1LongCaseInsensitive() {
        this.parseTextAndCheck(this.createComponent(1),
                "MONDAY");
    }

    @Test
    public void testParse2Short() {
        this.parseTextAndCheck(this.createComponent(2),
                "Mon.");
    }

    @Test
    public void testParse2Long() {
        this.parseTextAndCheck(this.createComponent(2),
                "Monday");
    }

    @Test
    public void testParse3Short() {
        this.parseTextAndCheck(this.createComponent(3),
                "Mon.");
    }

    @Test
    public void testParse3Long() {
        this.parseTextAndCheck(this.createComponent(3),
                "Monday");
    }

    @Test
    public void testParse4Short() {
        this.parseTextAndCheck(this.createComponent(4),
                "Mon.");
    }

    @Test
    public void testParse4Long() {
        this.parseTextAndCheck(this.createComponent(4),
                "Monday");
    }
    
    @Override
    SimpleDateFormatComponentDayNameInWeek createComponent(final int length) {
        return SimpleDateFormatComponentDayNameInWeek.with(length);
    }

    @Override
    public Class<SimpleDateFormatComponentDayNameInWeek> type() {
        return SimpleDateFormatComponentDayNameInWeek.class;
    }
}
