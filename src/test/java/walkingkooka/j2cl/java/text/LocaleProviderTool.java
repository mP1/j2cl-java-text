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

import walkingkooka.j2cl.locale.WalkingkookaLanguageTag;
import walkingkooka.text.CharSequences;
import walkingkooka.text.printer.IndentingPrinter;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

abstract class LocaleProviderTool {

    LocaleProviderTool(final IndentingPrinter printer) {
        super();
        this.printer = printer;
    }

    final void print() {
        this.printLocales(WalkingkookaLanguageTag.all());
    }

    abstract void printLocales(final Set<String> languageTags);

    static String toString(final String[] array) {
        return Arrays.toString(array);
    }

    final void indent() {
        this.printer.indent();
    }

    final void outdent() {
        this.printer.outdent();
    }

    final void emptyLine() {
        this.printer.print(this.printer.lineEnding());
    }

    final void line(final CharSequence text) {
        this.printer.print(text);
        this.printer.lineStart();
    }

    final IndentingPrinter printer;

    static CharSequence type(final Class<?> type) {
        return type.getSimpleName();
    }

    static CharSequence quote(final char value) {
        return CharSequences.quoteAndEscape(value);
    }

    static CharSequence quote(final String value) {
        return CharSequences.quoteAndEscape(value);
    }

    static CharSequence tabbed(final Collection<String> values) {
        return tabbed(values.toArray(new String[0]));
    }

    static CharSequence tabbed(final String[] values) {
        return null == values ?
                "" :
                quote(Arrays.stream(values).collect(Collectors.joining("\t", "", "")));
    }
}
