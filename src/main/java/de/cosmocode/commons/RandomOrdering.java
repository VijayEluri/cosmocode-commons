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

package de.cosmocode.commons;

import java.io.Serializable;
import java.util.Random;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentMap;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;

/**
 * Implementation for {@link Orderings#random()}.
 * 
 * @since 1.9
 * @author Willi Schoenborn
 * @param <T> generic type parameter
 */
final class RandomOrdering<T> extends Ordering<T> implements Serializable {
    
    private static final long serialVersionUID = 1463223861679378549L;

    /**
     * Reusable constant for "left-greater-right" to prevent autoboxing.
     */
    private static final Integer LEFT_IS_GREATER = 1;
    
    /**
     * Reusable constant for "right-greater-left" to prevent autoboxing.
     */
    private static final Integer RIGHT_IS_GREATER = -1;
    
    private final ConcurrentMap<Entry<T, T>, Integer> values;
    
    public RandomOrdering() {
        this.values = new MapMaker().makeComputingMap(new Function<Entry<T, T>, Integer>() {
            
            private final Random random = new Random();
            
            @Override
            public Integer apply(Entry<T, T> entry) {
                final Entry<T, T> reverseEntry = Maps.immutableEntry(
                    entry.getValue(), entry.getKey()
                );
                
                // whenever this function is being called neither (x,y) nor (y,x) has been compared yet
                final Integer value = choose(random);
                final Integer reverse = invert(value);
                // sgn(compare(x, y)) == -sgn(compare(y, x))
                values.put(reverseEntry, reverse);
                return value;
            }
            
        });
    }
    
    @Override
    public int compare(T left, T right) {
        if (Objects.equal(left, right)) {
            // compare(x, y)==0) == (x.equals(y)
            return 0;
        } else {
            // will either return a cached value or compute a new one
            return values.get(Maps.immutableEntry(left, right));
        }
    }
    
    @Override
    public String toString() {
        return "Orderings.random()";
    }
    
    private static Integer choose(Random random) {
        return random.nextInt(2) == 0 ? LEFT_IS_GREATER : RIGHT_IS_GREATER;
    }
    
    private static Integer invert(Integer value) {
        return value == LEFT_IS_GREATER ? RIGHT_IS_GREATER : LEFT_IS_GREATER;
    }
    
}