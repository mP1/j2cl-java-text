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
import walkingkooka.j2cl.locale.WalkingkookaLanguageTag;
import walkingkooka.text.CharSequences;

import java.util.Locale;
import java.util.Map;

/**
 * A mapping between language tags to values with extra support methods that are common to {@link DateFormatSymbols},
 * {@link DecimalFormatSymbols} and {@link DecimalFormat}.
 */
final class LocaleLookup<T> {

    static <T> LocaleLookup<T> empty() {
        return new LocaleLookup<>();
    }

    /**
     * Locale to symbols, this is used internally to "get" the symbols for a given Locale.
     */
    private final Map<Locale, T> mappings = Maps.ordered();

    private LocaleLookup() {
        super();
    }

    /**
     * Some locales have alternate forms, if any of these special locales are encountered add both. This assumes
     * alternate forms have the same value.
     */
    void add(final Locale locale, final T value) {
        this.mappings.put(locale, value);

        final String language = locale.getLanguage();
        final String newLanguage = WalkingkookaLanguageTag.oldToNewLanguage(language);
        if(false == language.isEmpty() && false == language.equals(newLanguage)) {
            try {
                final String tag = locale.toLanguageTag();
                final Locale newLocale = Locale.forLanguageTag(newLanguage + tag.substring(language.length())); // replace $oldLanguage with $newLanguage
                this.mappings.putIfAbsent(newLocale, value);
            } catch (final IllegalArgumentException unknown) {
            }
        }
    }

    /**
     * Note a special case exists for "no_NO_NY" if that fails a retry will occur with "nn-NO".
     */
    T getOrFail(final Locale locale) {
        T value = this.mappings.get(locale);
        if (null == value) {
            switch(locale.toString()) {
                case "no_NO_NY":
                    try {
                        value = this.mappings.get(Locale.forLanguageTag("nn-NO"));
                    } catch (final IllegalArgumentException unknownLocale) {
                    }
                    break;
                default:
                    break;
            }
        }
        if(null==value) {
            throw new IllegalArgumentException("Unknown locale " + CharSequences.quote(locale.toString()));
        }
        return value;
    }

    Locale[] availableLocales() {
        return this.mappings.keySet()
                .stream()
                .sorted((l, r) -> l.toString().compareTo(r.toString()))
                .toArray(Locale[]::new);
    }

    @Override
    public String toString() {
        return this.mappings.toString();
    }
}
