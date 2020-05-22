package j.brown;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReverseCaseInputStream extends FilterInputStream {

    public ReverseCaseInputStream(InputStream in) {
        super(in);
    }

    public int read() throws IOException {
        int c = in.read();
        return (c == -1 ? c : reverseCase((char) c));
    }

    public int read(byte[] b, int offset, int len) throws IOException {
        int result = in.read(b, offset, len);
        for (int i = offset; i < offset + result; i++) {
            b[i] = (byte) reverseCase((char) b[i]);
        }
        return result;
    }

    private char reverseCase(char c) {
        if (Character.isUpperCase(c)) {
            c = (char) Character.toLowerCase((int) c);
        } else {
            c = (char) Character.toUpperCase((int) c);
        }
        return c;
    }
}