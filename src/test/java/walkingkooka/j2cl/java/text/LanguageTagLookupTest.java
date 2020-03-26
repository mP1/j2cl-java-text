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
import walkingkooka.Cast;
import walkingkooka.ToStringTesting;
import walkingkooka.reflect.ClassTesting2;
import walkingkooka.reflect.JavaVisibility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public final class LanguageTagLookupTest implements ClassTesting2<LanguageTagLookup<Integer>>,
        ToStringTesting<LanguageTagLookup<Integer>> {

    private final static String EN = "en";
    private final static String FR = "fr";
    private final static Integer VALUE1 = 1;

    @Test
    public void testGetStringOrFailFails() {
        assertThrows(IllegalArgumentException.class, () -> LanguageTagLookup.empty().getOrFail(EN));
    }

    @Test
    public void testGetStringOrFailFails2() {
        final LanguageTagLookup<Integer> lookup = LanguageTagLookup.empty();
        lookup.add(EN, VALUE1);
        assertThrows(IllegalArgumentException.class, () -> LanguageTagLookup.empty().getOrFail(FR));
    }

    @Test
    public void testGetStringOrFail() {
        final LanguageTagLookup<Integer> lookup = LanguageTagLookup.empty();
        lookup.add(EN, VALUE1);

        assertEquals(VALUE1,
                lookup.getOrFail(EN),
                () -> lookup + " getOrFail " + EN);
    }

    // toString.........................................................................................................

    @Test
    public void testToString() {
        final LanguageTagLookup<Integer> lookup = LanguageTagLookup.empty();
        lookup.add("en", 1);
        this.toStringAndCheck(lookup, "{en=1}");
    }

    // ClassTesting.....................................................................................................

    @Override
    public Class<LanguageTagLookup<Integer>> type() {
        return Cast.to(LanguageTagLookup.class);
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PACKAGE_PRIVATE;
    }
}
