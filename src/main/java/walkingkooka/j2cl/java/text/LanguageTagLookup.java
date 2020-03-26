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

import walkingkooka.collect.map.Maps;
import walkingkooka.text.CharSequences;

import java.util.Locale;
import java.util.Map;

/**
 * A mapping between language tags to values with extra support methods that are common to {@link DateFormatSymbols},
 * {@link DecimalFormatSymbols} and {@link DecimalFormat}.
 */
final class LanguageTagLookup<T> {

    static <T> LanguageTagLookup<T> empty() {
        return new LanguageTagLookup<>();
    }

    /**
     * Language tag to symbols, this is used internally to "get" the symbols for a given Locale.
     */
    private final Map<String, T> mappings = Maps.ordered();

    private LanguageTagLookup() {
        super();
    }

    void add(final String tag, final T value) {
        this.mappings.put(tag, value);
    }

    T getOrFail(final Locale locale) {
        return this.getOrFail(locale.toLanguageTag());
    }

    T getOrFail(final String tag) {
        final T value = this.mappings.get(tag);
        if (null == value) {
            throw new IllegalArgumentException("Unknown locale " + CharSequences.quote(tag));
        }
        return value;
    }

    Locale[] availableLocales() {
        return this.mappings.keySet()
                .stream()
                .map(Locale::forLanguageTag)
                .sorted((l, r) -> l.toLanguageTag().compareTo(r.toLanguageTag()))
                .toArray(Locale[]::new);
    }

    @Override
    public String toString() {
        return this.mappings.toString();
    }
}
