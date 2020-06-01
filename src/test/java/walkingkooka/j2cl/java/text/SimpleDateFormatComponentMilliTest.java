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

public final class SimpleDateFormatComponentMilliTest extends SimpleDateFormatComponentNumberTestCase<SimpleDateFormatComponentMilli> {

    @Override
    SimpleDateFormatComponentMilli createComponent(final int length) {
        return SimpleDateFormatComponentMilli.with(length);
    }

    @Override
    public Class<SimpleDateFormatComponentMilli> type() {
        return SimpleDateFormatComponentMilli.class;
    }
}
