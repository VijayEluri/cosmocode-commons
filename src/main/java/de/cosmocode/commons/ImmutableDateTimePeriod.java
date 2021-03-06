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

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;

import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Immutable implementation of {@link TimePeriod} using {@link Date}s.
 *
 * @since 1.21
 * @author Oliver Lorenz
 */
@Immutable
@ThreadSafe
@Beta
final class ImmutableDateTimePeriod implements TimePeriod {

    private static final Date REFERENCE = new ImmutableDate(0);

    private final Date start;
    private final Date end;

    public ImmutableDateTimePeriod(final Date start, final Date end) {
        Preconditions.checkNotNull(start, "Start");
        Preconditions.checkNotNull(end, "End");

        // create new Date objects from given parameters to prevent later modifications
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
    }

    @Override
    public Date getReference() {
        return REFERENCE;
    }

    @Override
    public long getStart() {
        return start.getTime();
    }

    @Override
    public long getEnd() {
        return end.getTime();
    }

    @Override
    public TimeUnit getPrecision() {
        return TimeUnit.MILLISECONDS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof ImmutableDateTimePeriod) {
            final ImmutableDateTimePeriod that = ImmutableDateTimePeriod.class.cast(o);
            return start.equals(that.start) && end.equals(that.end);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = start.hashCode();
        result = 31 * result + end.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ImmutableDateTimePeriod[" + "start=" + start + ", end=" + end + ']';
    }

}
