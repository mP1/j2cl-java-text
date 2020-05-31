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

public class SimpleDateFormatComponentLiteralTest extends SimpleDateFormatComponentTestCase<SimpleDateFormatComponentLiteral>
        implements HashCodeEqualsDefinedTesting2<SimpleDateFormatComponentLiteral>,
        ToStringTesting<SimpleDateFormatComponentLiteral> {

    @Test
    public void testDifferentLiteral() {
        this.checkNotEquals(SimpleDateFormatComponentLiteral.with('!'));
    }

    @Test
    public void testToString() {
        this.toStringAndCheck(SimpleDateFormatComponentLiteral.with('!'), "\'!\'");
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
