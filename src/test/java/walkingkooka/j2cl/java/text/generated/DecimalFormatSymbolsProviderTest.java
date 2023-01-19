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

package walkingkooka.j2cl.java.text.generated;

import org.junit.jupiter.api.Test;
import walkingkooka.j2cl.java.io.string.StringDataInputDataOutput;
import walkingkooka.j2cl.java.text.DecimalFormatSymbols;
import walkingkooka.reflect.ClassTesting;
import walkingkooka.reflect.JavaVisibility;

import java.io.DataInput;
import java.io.EOFException;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertThrows;

public final class DecimalFormatSymbolsProviderTest implements ClassTesting<DecimalFormatSymbolsProvider> {

    @Test
    public void testRegisterThenDataInputThrowsEOF() throws Exception {
        final String dataString = DecimalFormatSymbolsProvider.DATA;
        try {
            final DataInput data = StringDataInputDataOutput.input(dataString);
            DecimalFormatSymbols.register(data);
            assertThrows(EOFException.class, () -> data.readBoolean(), dataString);
        } catch (final Exception rethrow) {
            System.err.println(dataString);
            throw rethrow;
        }
    }

    @Test
    public void testENAUCurrencySymbol() {
        getCurrencySymbolAndCheck("EN-AU", "$");
    }

    @Test
    public void testFRFRCurrencySymbol() {
        getCurrencySymbolAndCheck("FR-FR", "€");
    }

    private void getCurrencySymbolAndCheck(final String locale, final String expected) {
        this.checkEquals(expected, symbols(locale).getCurrencySymbol());
    }

    @Test
    public void testENAUDecimalSeparator() {
        getDecimalSeparatorAndCheck("EN-AU", '.');
    }

    @Test
    public void testFRFRDecimalSeparator() {
        getDecimalSeparatorAndCheck("FR-FR", ',');
    }

    private void getDecimalSeparatorAndCheck(final String locale, final char expected) {
        this.checkEquals(expected, symbols(locale).getDecimalSeparator());
    }

    private static DecimalFormatSymbols symbols(final String locale) {
        return DecimalFormatSymbols.getInstance(Locale.forLanguageTag(locale));
    }

    @Override
    public Class<DecimalFormatSymbolsProvider> type() {
        return DecimalFormatSymbolsProvider.class;
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PUBLIC;
    }
}
