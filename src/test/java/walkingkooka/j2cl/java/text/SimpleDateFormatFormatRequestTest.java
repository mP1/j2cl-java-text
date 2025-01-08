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
import walkingkooka.ToStringTesting;
import walkingkooka.reflect.ClassTesting2;
import walkingkooka.reflect.JavaVisibility;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class SimpleDateFormatFormatRequestTest implements ClassTesting2<SimpleDateFormatFormatRequest>,
    ToStringTesting<SimpleDateFormatFormatRequest> {

    private final static Date DATE = new Date(Date.UTC(2000 - 1900, 1, 31, 12, 58, 59));

    @Test
    public void testToString() {
        final Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Australia/Sydney"), Locale.forLanguageTag("EN-AU"));
        calendar.setTime(DATE);

        this.toStringAndCheck(SimpleDateFormatFormatRequest.with(calendar,
                new StringBuffer(),
                new DateFormatSymbols(Locale.forLanguageTag("EN-AU")),
                false),
            "java.util.GregorianCalendar[time=952001939000,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"Australia/Sydney\",offset=36000000,dstSavings=3600000,useDaylight=true,transitions=142,lastRule=java.util.SimpleTimeZone[id=Australia/Sydney,offset=36000000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=9,startDay=1,startDayOfWeek=1,startTime=7200000,startTimeMode=1,endMode=3,endMonth=3,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=1]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2000,MONTH=2,WEEK_OF_YEAR=10,WEEK_OF_MONTH=1,DAY_OF_MONTH=2,DAY_OF_YEAR=62,DAY_OF_WEEK=5,DAY_OF_WEEK_IN_MONTH=1,AM_PM=1,HOUR=11,HOUR_OF_DAY=23,MINUTE=58,SECOND=59,MILLISECOND=0,ZONE_OFFSET=36000000,DST_OFFSET=3600000] \"\" ampm=\"am\", \"pm\" eras=\"BC\", \"AD\" months=\"January\", \"February\", \"March\", \"April\", \"May\", \"June\", \"July\", \"August\", \"September\", \"October\", \"November\", \"December\", \"\" shortMonths=\"Jan.\", \"Feb.\", \"Mar.\", \"Apr.\", \"May\", \"Jun.\", \"Jul.\", \"Aug.\", \"Sep.\", \"Oct.\", \"Nov.\", \"Dec.\", \"\" shortWeekdays=\"\", \"Sun.\", \"Mon.\", \"Tue.\", \"Wed.\", \"Thu.\", \"Fri.\", \"Sat.\" weekdays=\"\", \"Sunday\", \"Monday\", \"Tuesday\", \"Wednesday\", \"Thursday\", \"Friday\", \"Saturday\" false");
    }

    @Override
    public Class<SimpleDateFormatFormatRequest> type() {
        return SimpleDateFormatFormatRequest.class;
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PACKAGE_PRIVATE;
    }
}
