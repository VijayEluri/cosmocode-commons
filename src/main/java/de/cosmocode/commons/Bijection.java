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

import com.google.common.base.Function;

/**
 * A {@link Bijection} is a invertible {@link Function}.
 *
 * @since 1.8
 * @author Willi Schoenborn
 * @param <F> the source type
 * @param <T> the target type
 */
public interface Bijection<F, T> extends Function<F, T> {

    /**
     * Provides the inverse function of this bijection.
     * 
     * @since 1.8
     * @return a bijection which defines the inversion of this bijection
     */
    Bijection<T, F> inverse();
    
}
