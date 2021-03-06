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

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * Rule implementation which always evaluates to {@code true}.
 *
 * @since 1.13
 * @author Willi Schoenborn
 */
enum TrueRule implements Rule<Object> {

    INSTANCE;
    
    @Override
    public boolean apply(Object input) {
        return true;
    }
    
    @Override
    public Object checkElement(Object element) {
        return element;
    }
    
    @Override
    public boolean all(Iterable<? extends Object> inputs) {
        Preconditions.checkNotNull(inputs, "Inputs");
        return true;
    }
    
    @Override
    public boolean any(Iterable<? extends Object> inputs) {
        Preconditions.checkNotNull(inputs, "Inputs");
        return inputs.iterator().hasNext();
    }
    
    @Override
    public boolean none(Iterable<? extends Object> inputs) {
        Preconditions.checkNotNull(inputs, "Inputs");
        return Iterables.isEmpty(inputs);
    }
    
    @Override
    public Iterable<Object> filter(Iterable<Object> unfiltered) {
        return Preconditions.checkNotNull(unfiltered, "Unfiltered");
    }

    @Override
    public Object find(Iterable<? extends Object> iterable) {
        Preconditions.checkNotNull(iterable, "Iterable");
        return iterable.iterator().next();
    }
    
    @Override
    public Object find(Iterable<Object> iterable, Object defaultValue) {
        Preconditions.checkNotNull(iterable, "Iterable");
        return Iterables.getFirst(iterable, defaultValue);
    }
    
    @Override
    public boolean removeIf(Iterable<? extends Object> removeFrom) {
        Preconditions.checkNotNull(removeFrom, "RemoveFrom");
        return Iterables.removeIf(removeFrom, this);
    }
    
    @Override
    public <S> Rule<S> and(Rule<? super Object> that) {
        Preconditions.checkNotNull(that, "That");
        return Rules.of(that);
    }
    
    @Override
    public <S> Rule<S> and(Predicate<? super Object> that) {
        Preconditions.checkNotNull(that, "That");
        return Rules.of(that);
    }
    
    @Override
    public <S> Rule<S> or(Rule<? super Object> that) {
        return Rules.of(this);
    }
    
    @Override
    public <S> Rule<S> or(Predicate<? super Object> that) {
        return Rules.of(this);
    }
    
    @Override
    public <S> Rule<S> negate() {
        return Rules.alwaysFalse();
    }
    
    @Override
    public <S> Rule<S> not() {
        return negate();
    }
    
    @Override
    public <S> Rule<S> xor(Rule<? super Object> that) {
        Preconditions.checkNotNull(that, "That");
        return that.negate();
    }
    
    @Override
    public <S> Rule<S> xor(Predicate<? super Object> that) {
        Preconditions.checkNotNull(that, "That");
        return xor(Rules.of(that));
    }
    
    @Override
    public <S> Rule<S> compose(Function<? super S, ? extends Object> function) {
        return new ComposedRule<Object, S>(this, function);
    }
    
    @Override
    public String toString() {
        return "Rules.alwaysTrue()";
    }
    
}
