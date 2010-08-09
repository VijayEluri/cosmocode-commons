package de.cosmocode.commons.io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import com.google.common.base.Preconditions;

/**
 * {@link ByteBuffer} backed {@link InputStream}.
 *
 * @since 1.13
 * @author Willi Schoenborn
 */
final class ByteBufferInputStream extends InputStream {
    
    private final ByteBuffer buffer;

    public ByteBufferInputStream(ByteBuffer buffer) {
        this.buffer = Preconditions.checkNotNull(buffer, "Buffer");
    }

    @Override
    public int read() throws IOException {
        if (buffer.hasRemaining()) {
            return buffer.get();
        } else {
            return -1;
        }
    }
    
    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        if (buffer.hasRemaining()) {
            final int length = Math.min(len, buffer.remaining());
            buffer.get(b, off, length);
            return length;
        } else {
            return -1;
        }
    }
    
    @Override
    public boolean markSupported() {
        return true;
    }
    
    @Override
    public void mark(int readlimit) {
        buffer.mark();
    }
    
    @Override
    public int available() throws IOException {
        return buffer.remaining();
    }
    
    @Override
    public void reset() throws IOException {
        buffer.reset();
    }
    
    @Override
    public long skip(long n) throws IOException {
        final int skipped = (int) (Math.min(n, buffer.remaining()));
        buffer.position(skipped);
        return skipped;
    }
    
    @Override
    public String toString() {
        return String.format("ByteBuffers.asInputStream(%s)", buffer);
    }
    
}
