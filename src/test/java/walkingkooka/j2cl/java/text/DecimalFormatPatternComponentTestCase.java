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

import walkingkooka.HashCodeEqualsDefinedTesting2;
import walkingkooka.ToStringTesting;
import walkingkooka.predicate.Predicates;
import walkingkooka.reflect.IsMethodTesting;

import java.util.function.Predicate;

public abstract class DecimalFormatPatternComponentTestCase<C extends DecimalFormatPatternComponent> extends DecimalFormatPatternTestCase<C>
        implements HashCodeEqualsDefinedTesting2<C>,
        IsMethodTesting<C>,
        ToStringTesting<C> {

    DecimalFormatPatternComponentTestCase() {
        super();
    }

    final void isCurrencyAndCheck(final C component,
                                  final boolean currency) {
        this.checkEquals(currency,
                component.isCurrency(),
                () -> component.toString());
    }

    final void multiplierAndCheck(final C component,
                                  final int multipler) {
        this.checkEquals(component.multiplier(),
                multipler,
                () -> component.toString());
    }

    abstract C component();

    // HashCodeEqualsDefinedTesting2....................................................................................

    @Override
    public final C createObject() {
        return this.component();
    }

    // IsMethodTesting..................................................................................................

    @Override
    public final C createIsMethodObject() {
        return this.component();
    }

    @Override
    public String isMethodTypeNamePrefix() {
        return DecimalFormatPatternComponent.class.getSimpleName();
    }

    @Override
    public String isMethodTypeNameSuffix() {
        return "";
    }

    @Override
    public Predicate<String> isMethodIgnoreMethodFilter() {
        return Predicates.never();
    }

    // TypeNameTesting..................................................................................................

    @Override
    public final String typeNamePrefix() {
        return DecimalFormatPatternComponent.class.getSimpleName();
    }

    @Override
    public final String typeNameSuffix() {
        return "";
    }
}
