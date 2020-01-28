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

package walkingkooka.javatextj2cl.java.text;

import org.junit.jupiter.api.Test;
import walkingkooka.HashCodeEqualsDefinedTesting2;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class DecimalFormatPatternComponentTextLiteralTest extends DecimalFormatPatternComponentTestCase<DecimalFormatPatternComponentTextLiteral>
        implements HashCodeEqualsDefinedTesting2<DecimalFormatPatternComponentTextLiteral> {

    @Test
    public void testIsCurrency() {
        this.isCurrencyAndCheck(DecimalFormatPatternComponentTextLiteral.with("abc"), false);
    }

    @Test
    public void testDifferentCase() {
        this.checkNotEquals(DecimalFormatPatternComponentTextLiteral.with("abC"));
    }

    @Test
    public void testDifferentText() {
        this.checkNotEquals(DecimalFormatPatternComponentTextLiteral.with("DEF"));
    }

    @Test
    public void testToString() {
        final String text = "abc123";
        this.toStringAndCheck(DecimalFormatPatternComponentTextLiteral.with(text), "'" + text + "'");
    }

    @Override
    public Class<DecimalFormatPatternComponentTextLiteral> type() {
        return DecimalFormatPatternComponentTextLiteral.class;
    }

    // HashCodeEqualsDefinedTesting2....................................................................................

    @Override
    public DecimalFormatPatternComponentTextLiteral createObject() {
        return DecimalFormatPatternComponentTextLiteral.with("abc");
    }
}
