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
package de.cosmocode.commons.validation;

import com.google.common.collect.Lists;

/**
 * Tests {@link LessThanRule}.
 *
 * @since 1.21
 * @author Willi Schoenborn
 */
public final class LessThanRuleTest extends AbstractRuleTest<String> {

    @Override
    public Rule<String> unit() {
        return Rules.lessThan("b");
    }
    
    @Override
    protected Iterable<String> validInputs() {
        return Lists.newArrayList("a", "Z", "A");
    }
    
    @Override
    protected Iterable<String> invalidInputs() {
        return Lists.newArrayList("b", "c", "d", null);
    }
    
    @Override
    protected boolean satisfiedByNull() {
        return false;
    }
    
    @Override
    protected String defaultValueForFind() {
        return "default";
    }
    
}
