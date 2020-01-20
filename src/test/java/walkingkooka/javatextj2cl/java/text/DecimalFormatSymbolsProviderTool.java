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
import walkingkooka.text.Indentation;
import walkingkooka.text.printer.IndentingPrinter;
import walkingkooka.text.printer.Printers;

import java.text.DateFormatSymbols;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * This tool prints to sysout, the {@link DecimalFormatSymbolProvider#register}
 */
public final class DecimalFormatSymbolsProviderTool extends LocaleProviderTool {

    public static void main(final String[] args) {
        new DecimalFormatSymbolsProviderTool(Printers.sysOut()
                .indenting(Indentation.with("  ")))
                .print();
    }

    private DecimalFormatSymbolsProviderTool(final IndentingPrinter printer) {
        super(printer);
    }

    @Override
    void printLocales(final List<Locale> locales) {
        final Map<DecimalFormatSymbols, Set<String>> symbolToLanguageTags = Maps.sorted(DecimalFormatSymbolsProviderTool::decimalFormatSymbolsComparator);

        for (final Locale locale : locales) {
            final DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(locale);

            Set<String> symbolLocales = symbolToLanguageTags.get(symbols);
            if (null == symbolLocales) {
                symbolLocales = Sets.sorted();
                symbolToLanguageTags.put(symbols, symbolLocales);
            }
            symbolLocales.add(locale.toLanguageTag());
        }

        final Map<String, java.text.DecimalFormatSymbols> languageTagToSymbols = Maps.sorted();
        for(final Entry<DecimalFormatSymbols, Set<String>> languageTagAndSymbol : symbolToLanguageTags.entrySet()) {
            languageTagToSymbols.put(languageTagAndSymbol.getValue().iterator().next(), languageTagAndSymbol.getKey());
        }

        this.line("static void register() {");
        this.indent();
        {
            for (final DecimalFormatSymbols symbols : languageTagToSymbols.values()) {
                final Set<String> languageTags = symbolToLanguageTags.get(symbols);

                this.line(type(walkingkooka.javatextj2cl.java.text.DecimalFormatSymbols.class) + ".register(");
                this.indent();
                {
                    this.line(tabbed(languageTags) + ", // locales");

                    this.line(quote(symbols.getCurrency().toString()) + ", // currency");
                    this.line(quote(symbols.getCurrencySymbol()) + ", // currencySymbols");
                    this.line(quote(symbols.getDecimalSeparator()) + ", // decimalSeparator");
                    this.line(quote(symbols.getDigit()) + ", // digit");
                    this.line(quote(symbols.getExponentSeparator()) + ", // exponentSeparator");
                    this.line(quote(symbols.getGroupingSeparator()) + ", // groupingSeparator");
                    this.line(quote(symbols.getInfinity()) + ", // inifinity");
                    this.line(quote(symbols.getInternationalCurrencySymbol()) + ", // internationalCurrencySymbol");
                    this.line(quote(symbols.getMinusSign()) + ", // minusSign");
                    this.line(quote(symbols.getMonetaryDecimalSeparator()) + ", // monetaryDecimalSeparator");
                    this.line(quote(symbols.getNaN()) + ", // nan");
                    this.line(quote(symbols.getPatternSeparator()) + ", // patternSeparator");
                    this.line(quote(symbols.getPercent()) + ", // percent");
                    this.line(quote(symbols.getPerMill()) + ", // perMill");
                    this.line(quote(symbols.getZeroDigit()) + " // zeroDigit");
                }
                this.outdent();

                this.line(");");

                this.emptyLine();
            }
        }
        this.outdent();
        this.line("}");
    }

    private static int decimalFormatSymbolsComparator(final DecimalFormatSymbols left,
                                                      final DecimalFormatSymbols right) {
        return toString(left).compareTo(toString(right));
    }

    private static String toString(final DecimalFormatSymbols symbols) {
        return symbols.toString();
    }
}
