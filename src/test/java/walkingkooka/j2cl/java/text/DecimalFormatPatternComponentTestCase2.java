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

public abstract class DecimalFormatPatternComponentTestCase2<C extends DecimalFormatPatternComponent> extends DecimalFormatPatternComponentTestCase<C> {

    DecimalFormatPatternComponentTestCase2() {
        super();
    }

    @Test
    public final void testIsCurrency() {
        this.isCurrencyAndCheck(this.component(),
                this.type().getSimpleName().contains("Currency"));
    }

    @Test
    public final void testMultiplier() {
        final int multiplier;

        switch (this.type().getSimpleName()) {
            case "DecimalFormatPatternComponentPercent":
                multiplier = 100;
                break;
            case "DecimalFormatPatternComponentPerMille":
                multiplier = 1000;
                break;
            default:
                multiplier = 0;
                break;
        }

        this.multiplierAndCheck(this.component(), multiplier);
    }

    @Override
    final C component() {
        try {
            return (C) this.type().getDeclaredField("INSTANCE").get(null);
        } catch (final Exception cause) {
            throw new RuntimeException(cause);
        }
    }

    @Test
    public final void testToString() throws Exception {
        final String literal = this.literal();
        this.toStringAndCheck(literal, this.type().getDeclaredField("INSTANCE").get(null).toString());
    }

    abstract String literal();
}
