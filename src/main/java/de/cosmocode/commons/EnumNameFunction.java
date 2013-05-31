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

import com.google.common.base.Function;
import com.google.common.base.Preconditions;

import javax.annotation.Nullable;

/**
 * Implementation of {@link Enums#name()}.
 *
 * @since 1.9
 * @author Willi Schoenborn
 */
enum EnumNameFunction implements Function<Enum<?>, String> {
    
    INSTANCE;
    
    @Override
    public String apply(@Nullable Enum<?> from) {
        Preconditions.checkNotNull(from, "From");
        return from.name();
    }
    
    @Override
    public String toString() {
        return "Enums.name()";
    }
    
}
