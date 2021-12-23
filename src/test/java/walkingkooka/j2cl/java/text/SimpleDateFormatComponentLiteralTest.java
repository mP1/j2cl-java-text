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

import java.util.Date;

public final class SimpleDateFormatComponentLiteralTest extends SimpleDateFormatComponentTestCase<SimpleDateFormatComponentLiteral>
        implements HashCodeEqualsDefinedTesting2<SimpleDateFormatComponentLiteral>,
        ToStringTesting<SimpleDateFormatComponentLiteral> {

    @Test
    public void testFormat() {
        this.formatDateAndCheck(SimpleDateFormatComponentLiteral.with('!'),
             new Date(),
             false,
             "!");
    }

    @Test
    public void testParseFails() {
        this.parseTextAndCheck(SimpleDateFormatComponentLiteral.with('A'), "Z");
    }

    @Test
    public void testParseFails2() {
        this.parseTextAndCheck(SimpleDateFormatComponentLiteral.with('A'), "a");
    }

    @Test
    public void testParse() {
        this.parseTextAndCheck(SimpleDateFormatComponentLiteral.with('!'), "!");
    }

    @Test
    public void testParse2() {
        this.parseTextAndCheck(SimpleDateFormatComponentLiteral.with('A'), "A");
    }

    @Test
    public void testDifferentLiteral() {
        this.checkNotEquals(SimpleDateFormatComponentLiteral.with('!'));
    }

    @Test
    public void testToString() {
        this.toStringAndCheck(SimpleDateFormatComponentLiteral.with('!'), "'!'");
    }

    @Override
    public SimpleDateFormatComponentLiteral createObject() {
        return SimpleDateFormatComponentLiteral.with('a');
    }

    @Override
    public Class<SimpleDateFormatComponentLiteral> type() {
        return SimpleDateFormatComponentLiteral.class;
    }
}
