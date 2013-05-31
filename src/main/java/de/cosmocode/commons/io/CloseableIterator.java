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
package de.cosmocode.commons.io;

import java.io.Closeable;
import java.util.Iterator;

/**
 * A {@link Closeable} {@link Iterator}.
 *
 * @since 1.19
 * @author Willi Schoenborn
 * @param <T> generic value type
 */
public interface CloseableIterator<T> extends Iterator<T>, Closeable {

}
