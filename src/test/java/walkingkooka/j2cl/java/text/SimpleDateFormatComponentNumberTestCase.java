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

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import walkingkooka.HashCodeEqualsDefinedTesting2;
import walkingkooka.ToStringTesting;
import walkingkooka.text.CharSequences;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public abstract class SimpleDateFormatComponentNumberTestCase<C extends SimpleDateFormatComponent2> extends SimpleDateFormatComponentTestCase2<C> {

    SimpleDateFormatComponentNumberTestCase() {
        super();
    }

    // formatCalendarFieldNumericValue.......................................................................................................

    @Test
    public final void testFormatDate5() {
        this.formatDateAndCheck(5, DATE);
    }

    @Test
    public final void testFormatDate6() {
        this.formatDateAndCheck(6, DATE);
    }
}
