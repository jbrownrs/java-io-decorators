package j.brown;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class AlternatingCaseInputStream extends FilterInputStream {
    private static int charPosition = 0;

    public AlternatingCaseInputStream(InputStream in) {
        super(in);
    }

    public int read() throws IOException {
        int c = in.read();

        if (c != -1) {
            c = alternateCase((char) c);
        }
        return c;
    }

    public int read(byte[] b, int offset, int len) throws IOException {
        int result = in.read(b, offset, len);
        for (int i = offset; i < len - offset; i++) {
            if (charPosition % 2 == 0) {
                b[i] = (byte) Character.toUpperCase((char) b[i]);
            } else {
                b[i] = (byte) Character.toLowerCase((char) b[i]);
            }
            charPosition++;
        }
        return result;
    }

    private char alternateCase(char c) {
        if (Character.isLetter(c) && charPosition % 2 == 0) {
            c = (char) Character.toUpperCase((int) c);
            charPosition++;
        } else if (Character.isLetter(c)) {
            c = (char) Character.toLowerCase((int) c);
            charPosition++;
        }
        return c;
    }
}