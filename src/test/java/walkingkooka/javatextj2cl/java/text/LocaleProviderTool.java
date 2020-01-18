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

import walkingkooka.collect.list.Lists;
import walkingkooka.collect.map.Maps;
import walkingkooka.javautillocalej2cl.WalkingkookaLocale;
import walkingkooka.text.CharSequences;
import walkingkooka.text.printer.IndentingPrinter;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

abstract class LocaleProviderTool {

    LocaleProviderTool(final IndentingPrinter printer) {
        super();
        this.printer = printer;
    }

    final void print() {
        final List<Locale> locales = Lists.array();
        locales.addAll(Lists.of(Locale.getAvailableLocales()));
        locales.removeIf(l -> {
            return WalkingkookaLocale.isUnsupported(l.toLanguageTag());
        });
        locales.sort((l, r) -> l.toLanguageTag().compareTo(r.toLanguageTag()));

        this.printLocales(locales);
    }

    abstract void printLocales(final List<Locale> locales);

    static String toString(final String[] array) {
        return Arrays.toString(array);
    }

    static String javaMethodNameSafe(final String tag) {
        return tag.replace('-', '_').replace("#", "");
    }

    final void indent() {
        this.printer.indent();
    }

    final void outdent() {
        this.printer.outdent();
    }

    final void line(final CharSequence text) {
        this.printer.print(text);
        this.printer.lineStart();
    }

    final IndentingPrinter printer;

    final static CharSequence type(final Class<?> type) {
        return type.getSimpleName();
    }

    final static CharSequence quote(final char value) {
        return CharSequences.quoteAndEscape(value);
    }

    final static CharSequence quote(final String value) {
        return CharSequences.quoteAndEscape(value);
    }

    final static CharSequence tabbed(final String[] values) {
        return null == values ?
                "" :
                quote(Arrays.stream(values).collect(Collectors.joining("\t", "", "")));
    }
}
