/**
 * Copyright 2010 CosmoCode GmbH
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

package de.cosmocode.commons.validation;

import javax.annotation.Nullable;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

/**
 * Implementation of {@link Rules#equalTo(Object)}.
 *
 * @since 1.21
 * @author Willi Schoenborn
 * @param <T> generic parameter type
 */
public final class EqualToRule<T> extends AbstractRule<T> {

    private final T target;
    
    EqualToRule(T target) {
        this.target = Preconditions.checkNotNull(target, "Target");
    }
    
    @Override
    public boolean apply(@Nullable T input) {
        return target.equals(input);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        } else if (that instanceof EqualToRule<?>) {
            final EqualToRule<?> other = EqualToRule.class.cast(that);
            return target.equals(other.target);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return target.hashCode() ^ 858345845;
    }
    
    @Override
    public String toString() {
        return "Rules.equalTo(" + target + ")";
    }

}
