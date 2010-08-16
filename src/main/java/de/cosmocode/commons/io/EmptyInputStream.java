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

package de.cosmocode.commons.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * {@link InputStream} implementation which mimics the behaviour of an empty stream.
 *
 * @since 1.13
 * @author Willi Schoenborn
 */
final class EmptyInputStream extends InputStream {

    static final InputStream INSTANCE = new EmptyInputStream();
    
    private EmptyInputStream() {
        
    }
    
    @Override
    public int read() throws IOException {
        return -1;
    }
    
    @Override
    public int read(byte[] b) throws IOException {
        return -1;
    }
    
    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return -1;
    }
    
    @Override
    public long skip(long n) throws IOException {
        return 0;
    }
    
    @Override
    public String toString() {
        return "InputStreams.empty()";
    }

}
