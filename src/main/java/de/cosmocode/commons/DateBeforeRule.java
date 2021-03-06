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

import de.cosmocode.commons.validation.AbstractRule;

import javax.annotation.Nullable;
import java.util.Date;

/**
 * Before date predicate implementation.
 *
 * @since 1.6
 * @see Dates#before(Date)
 * @author Willi Schoenborn
 */
final class DateBeforeRule extends AbstractRule<Date> {
    
    private final Date when;
    
    public DateBeforeRule(Date when) {
        this.when = when;
    }
    
    @Override
    public boolean apply(@Nullable Date input) {
        return input != null && input.before(when);
    }
    
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        } else if (that instanceof DateBeforeRule) {
            final DateBeforeRule other = DateBeforeRule.class.cast(that);
            return when.equals(other.when);
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        return when.hashCode() ^ -852724785;
    }
    
    @Override
    public String toString() {
        return String.format("Dates.before(%s)", when);
    }
    
}
