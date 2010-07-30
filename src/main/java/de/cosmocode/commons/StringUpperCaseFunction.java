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
 * Implementation for {@link Strings#toUpperCase()}.
 *
 * @since 1.9
 * @author Willi Schoenborn
 */
enum StringUpperCaseFunction implements Function<String, String> {

    INSTANCE;
    
    @Override
    public String apply(String from) {
        return from == null ? null : from.toUpperCase();
    }
    
    @Override
    public String toString() {
        return "Strings.toUpperCase()";
    }
    
}