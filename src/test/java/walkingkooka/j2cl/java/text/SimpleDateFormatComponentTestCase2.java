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

public abstract class SimpleDateFormatComponentTestCase2<C extends SimpleDateFormatComponent2> extends SimpleDateFormatComponentTestCase<C>
        implements HashCodeEqualsDefinedTesting2<C>,
        ToStringTesting<C> {

    SimpleDateFormatComponentTestCase2() {
        super();
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
