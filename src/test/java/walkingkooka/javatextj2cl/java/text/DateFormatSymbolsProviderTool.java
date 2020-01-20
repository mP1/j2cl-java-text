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

import walkingkooka.collect.map.Maps;
import walkingkooka.collect.set.Sets;
import walkingkooka.javautillocalej2cl.WalkingkookaLocale;
import walkingkooka.text.Indentation;
import walkingkooka.text.printer.IndentingPrinter;
import walkingkooka.text.printer.Printers;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This tool prints to sysout, that prints a {@link DateFormatSymbolsProvider#register()}
 */
public final class DateFormatSymbolsProviderTool extends LocaleProviderTool {

    public static void main(final String[] args) {
        new DateFormatSymbolsProviderTool(Printers.sysOut()
                .indenting(Indentation.with("  ")))
                .print();
    }

    private DateFormatSymbolsProviderTool(final IndentingPrinter printer) {
        super(printer);
    }

    @Override
    void printLocales(final List<Locale> locales) {
        final Map<DateFormatSymbols, Set<String>> symbolToLanguageTags = Maps.sorted(DateFormatSymbolsProviderTool::dateFormatSymbolsComparator);

        for (final Locale locale : locales) {
            final DateFormatSymbols symbols = DateFormatSymbols.getInstance(locale);

            Set<String> symbolLocales = symbolToLanguageTags.get(symbols);
            if (null == symbolLocales) {
                symbolLocales = Sets.sorted();
                symbolToLanguageTags.put(symbols, symbolLocales);
            }
            symbolLocales.add(locale.toLanguageTag());
        }

        final Map<String, DateFormatSymbols> languageTagToSymbols = Maps.sorted();
        for(final Entry<DateFormatSymbols, Set<String>> languageTagAndSymbol : symbolToLanguageTags.entrySet()) {
            languageTagToSymbols.put(languageTagAndSymbol.getValue().iterator().next(), languageTagAndSymbol.getKey());
        }

        this.line("static void register() {");
        this.indent();
        {
            for (final DateFormatSymbols symbols : languageTagToSymbols.values()) {
                final Set<String> languageTags = symbolToLanguageTags.get(symbols);

                this.line(type(walkingkooka.javatextj2cl.java.text.DateFormatSymbols.class) + ".register(");
                this.indent();
                {
                    this.line(tabbed(languageTags) + ", // locales");

                    this.line(tabbed(symbols.getAmPmStrings()) + ", // ampm");
                    this.line(tabbed(symbols.getEras()) + ", // eras");
                    this.line(months(symbols.getMonths()) + ", // months"); // add extra 13th
                    this.line(months(symbols.getShortMonths()) + ", // shortMonths");
                    this.line(weekdays(symbols.getShortWeekdays()) + ", // shortWeekdays"); // add empty 1st.
                    this.line(weekdays(symbols.getWeekdays()) + " // weekdays");
                }
                this.outdent();

                this.line(");");

                this.emptyLine();
            }
        }
        this.outdent();
        this.line("}");
    }

    private static int dateFormatSymbolsComparator(final DateFormatSymbols left,
                                                   final DateFormatSymbols right) {
        return toString(left).compareTo(toString(right));
    }

    final static CharSequence months(final String[] values) {
        final int last = values.length - 1;

        return tabbed(values[last].isEmpty() ?
                Arrays.copyOf(values, values.length - 1) :
                values);
    }

    /**
     * Remove the first empty String.
     */
    final static CharSequence weekdays(final String[] values) {
        final String[] without = new String[values.length - 1];
        System.arraycopy(values, 1, without, 0, values.length - 1);
        return tabbed(without);
    }

    private static String toString(final DateFormatSymbols symbols) {
        return toString(symbols.getAmPmStrings()) + "," +
                toString(symbols.getEras()) + "," +
                toString(symbols.getMonths()) + "," +
                toString(symbols.getShortMonths()) + "," +
                toString(symbols.getShortWeekdays()) + "," +
                toString(symbols.getWeekdays());
    }
}
