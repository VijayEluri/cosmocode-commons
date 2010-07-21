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

package de.cosmocode.collections.event;

import java.util.Iterator;

import com.google.common.base.Preconditions;

/**
 * An {@link Iterator} composed with an {@link EventListener}.
 *
 * @since 1.5
 * @author Willi Schoenborn
 * @param <E> generic element type
 */
final class EventIterator<E> implements Iterator<E> {

    private final Iterator<? extends E> iterator;
    
    private final EventListener<? super E> listener;
    
    private E last;
    
    public EventIterator(Iterator<? extends E> iterator, EventListener<? super E> listener) {
        this.iterator = Preconditions.checkNotNull(iterator, "Iterator");
        this.listener = Preconditions.checkNotNull(listener, "Listener");
    }

    @Override
    public E next() {
        final E next = iterator.next();
        last = next;
        return next;
    }
    
    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }
    
    @Override
    public void remove() {
        iterator.remove();
        listener.removed(last);
        // prevent memory leak
        last = null;
    }
    
}
