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

public final class SimpleDateFormatComponentTimeZoneIso8601Test extends SimpleDateFormatComponentTestCase2<SimpleDateFormatComponentTimeZoneIso8601> {
    @Override
    SimpleDateFormatComponentTimeZoneIso8601 createComponent(final int length) {
        return SimpleDateFormatComponentTimeZoneIso8601.with(length);
    }

    @Override
    public Class<SimpleDateFormatComponentTimeZoneIso8601> type() {
        return SimpleDateFormatComponentTimeZoneIso8601.class;
    }
}
