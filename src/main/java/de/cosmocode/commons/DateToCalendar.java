/**
 * Copyright 2010 - 2013 CosmoCode GmbH
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
 */
package de.cosmocode.commons;

import javax.annotation.Nullable;
import java.util.Calendar;
import java.util.Date;

/**
 * Implementation for {@link CalendarToDate#inverse()}.
 *
 * @since 1.9
 * @author Willi Schoenborn
 */
enum DateToCalendar implements Bijection<Date, Calendar> {
    
    INSTANCE;
    
    @Override
    public Calendar apply(@Nullable Date from) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(from);
        return calendar;
    }
    
    @Override
    public Bijection<Calendar, Date> inverse() {
        return CalendarToDate.INSTANCE;
    }
    
    @Override
    public String toString() {
        return CalendarToDate.INSTANCE.toString() + ".inverse()";
    }
    
}
