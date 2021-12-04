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

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertThrows;

public final class LocaleLookupTest implements ClassTesting2<LocaleLookup<Integer>>,
        ToStringTesting<LocaleLookup<Integer>> {

    private final static Locale EN = Locale.forLanguageTag("en");
    private final static Locale FR = Locale.forLanguageTag("fr");
    private final static Integer VALUE1 = 1;

    @Test
    public void testAddHeAndIw() {
        final LocaleLookup<Integer> lookup = LocaleLookup.empty();

        final Locale he = Locale.forLanguageTag("HE");
        lookup.add(he, VALUE1);
        this.checkEquals(VALUE1, lookup.getOrFail(he));
        this.checkEquals(VALUE1, lookup.getOrFail(Locale.forLanguageTag("iw")));
    }

    @Test
    public void testAddHeAndIw2() {
        final LocaleLookup<Integer> lookup = LocaleLookup.empty();

        final Locale he = Locale.forLanguageTag("HE-IL");
        lookup.add(he, VALUE1);
        this.checkEquals(VALUE1, lookup.getOrFail(he));
        this.checkEquals(VALUE1, lookup.getOrFail(Locale.forLanguageTag("iw-IL")));
    }

    @Test
    public void testAddNoNo() {
        final LocaleLookup<Integer> lookup = LocaleLookup.empty();

        final Locale noNo = Locale.forLanguageTag("no_NO");
        lookup.add(noNo, VALUE1);
        this.checkEquals(VALUE1, lookup.getOrFail(noNo));
        this.checkEquals(VALUE1, lookup.getOrFail(Locale.forLanguageTag("no_NO")));
    }

    @Test
    public void testGetStringOrFailFails() {
        assertThrows(IllegalArgumentException.class, () -> LocaleLookup.empty().getOrFail(EN));
    }

    @Test
    public void testGetStringOrFailFails2() {
        final LocaleLookup<Integer> lookup = LocaleLookup.empty();
        lookup.add(EN, VALUE1);
        assertThrows(IllegalArgumentException.class, () -> LocaleLookup.empty().getOrFail(FR));
    }

    @Test
    public void testGetStringOrFail() {
        final LocaleLookup<Integer> lookup = LocaleLookup.empty();
        lookup.add(EN, VALUE1);

        this.checkEquals(VALUE1,
                lookup.getOrFail(EN),
                () -> lookup + " getOrFail " + EN);
    }

    // toString.........................................................................................................

    @Test
    public void testToString() {
        final LocaleLookup<Integer> lookup = LocaleLookup.empty();
        lookup.add(EN, 1);
        this.toStringAndCheck(lookup, "{en=1}");
    }

    // ClassTesting.....................................................................................................

    @Override
    public Class<LocaleLookup<Integer>> type() {
        return Cast.to(LocaleLookup.class);
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PACKAGE_PRIVATE;
    }
}
