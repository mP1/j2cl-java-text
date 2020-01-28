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

import walkingkooka.ToStringTesting;
import walkingkooka.reflect.ClassTesting2;
import walkingkooka.reflect.JavaVisibility;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class DecimalFormatPatternComponentTestCase<C extends DecimalFormatPatternComponent> implements ClassTesting2<C>,
        ToStringTesting<C> {

    DecimalFormatPatternComponentTestCase() {
        super();
    }

    final void isCurrencyAndCheck(final C component,
                                  final boolean currency) {
        assertEquals(currency,
                component.isCurrency(),
                () -> component.toString());
    }

    final void multiplierAndCheck(final C component,
                                  final int multipler) {
        assertEquals(component.multiplier(),
                multipler,
                () -> component.toString());
    }

    // ClassTesting2....................................................................................................

    @Override
    public final JavaVisibility typeVisibility() {
        return JavaVisibility.PACKAGE_PRIVATE;
    }
}
