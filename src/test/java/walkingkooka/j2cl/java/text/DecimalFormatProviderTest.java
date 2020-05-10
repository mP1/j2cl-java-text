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
import walkingkooka.j2cl.java.io.string.StringDataInputDataOutput;
import walkingkooka.reflect.ClassTesting;
import walkingkooka.reflect.JavaVisibility;

import java.io.DataInput;
import java.io.EOFException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public final class DecimalFormatProviderTest implements ClassTesting<DecimalFormatProvider> {

    @Test
    public void testRegisterThenDataInputThrowsEOF() throws Exception {
        final String dataString = DecimalFormatProvider.DATA;
        try {
            final DataInput data = StringDataInputDataOutput.input(dataString);
            DecimalFormat.register(data);
            assertThrows(EOFException.class, () -> data.readBoolean(), dataString);
        } catch (final Exception rethrow) {
            System.err.println(dataString);
            throw rethrow;
        }
    }

    @Override
    public Class<DecimalFormatProvider> type() {
        return DecimalFormatProvider.class;
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PACKAGE_PRIVATE;
    }
}
