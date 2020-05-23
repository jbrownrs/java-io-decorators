package j.brown;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FlipCaseInputStream extends FilterInputStream {

    public FlipCaseInputStream(InputStream in) {
        super(in);
    }

    public int read() throws IOException {
        int c = in.read();
        return (c == -1 ? c : flipCase((char) c));
    }

    public int read(byte[] b, int offset, int len) throws IOException {
        int result = in.read(b, offset, len);
        for (int i = offset; i < offset + result; i++) {
            b[i] = (byte) flipCase((char) b[i]);
        }
        return result;
    }

    private char flipCase(char c) {
        if (Character.isUpperCase(c)) {
            c = (char) Character.toLowerCase((int) c);
        } else {
            c = (char) Character.toUpperCase((int) c);
        }
        return c;
    }
}