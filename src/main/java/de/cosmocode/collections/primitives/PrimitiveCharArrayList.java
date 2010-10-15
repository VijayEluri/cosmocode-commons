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

package de.cosmocode.collections.primitives;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.google.common.base.Preconditions;

import de.cosmocode.collections.RealAbstractList;

/**
 * {@link List} implementation backed by a primitive {@code char[]}.
 *
 * @since 1.19
 * @author Willi Schoenborn
 */
final class PrimitiveCharArrayList extends RealAbstractList<Character> {

    private final char[] array;
    
    PrimitiveCharArrayList(char[] array) {
        this.array = Preconditions.checkNotNull(array, "Array");
    }
    
    @Override
    public Character set(int index, Character element) {
        Preconditions.checkNotNull(element, "Element");
        final Character old = array[index];
        array[index] = element;
        return old;
    }

    @Override
    public void add(int index, Character element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Character remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Character get(int index) {
        return array[index];
    }
    
    @Override
    public int indexOf(Object o) {
        // we only contain non null chars
        if (o instanceof Character) {
            for (int i = 0; i < array.length; i++) {
                if (o.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    @Override
    public int lastIndexOf(Object o) {
        // we only contain non null chars
        if (o instanceof Character) {
            for (int i = array.length - 1; i >= 0; i -= 1) {
                if (o.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }
    
    @Override
    public int size() {
        return array.length;
    }
    
    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

}