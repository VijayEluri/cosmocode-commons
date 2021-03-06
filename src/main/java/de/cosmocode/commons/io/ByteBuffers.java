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

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/**
 * Static utility class for {@link ByteBuffer}s.
 *
 * @author Willi Schoenborn
 */
public final class ByteBuffers {

    private ByteBuffers() {
        
    }
    
    /**
     * Adapts a {@link ByteBuffer} to an {@link InputStream}.
     * 
     * @param buffer the underlying byte buffer
     * @return an inputstream which reads from the given byte buffer
     * @throws NullPointerException if buffer is null
     */
    public static InputStream asInputStream(final ByteBuffer buffer) {
        return new ByteBufferInputStream(buffer);
    }

    /**
     * Adapts a {@link ByteBuffer} to an {@link OutputStream}.
     * 
     * @param buffer the underlying byte buffer
     * @return an outputstream which writes to the given byte buffer
     * @throws NullPointerException if buffer is null
     */
    public static OutputStream asOutputStream(final ByteBuffer buffer) {
        return new ByteBufferOutputStream(buffer);
    }
    
}
