package j.brown;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class L33tSpeakInputStream extends FilterInputStream {

    public L33tSpeakInputStream(InputStream in) {
        super(in);
    }

    public int read() throws IOException {
        int c = in.read();
        return (c == -1 ? c : translateToL33t((char) c));
    }

    public int read(byte[] b, int offset, int len) throws IOException {
        int result = in.read(b, offset, len);
        for (int i = offset; i < offset + result; i++) {
            b[i] = (byte) translateToL33t((char) b[i]);
        }
        return result;
    }

    private char translateToL33t(char c) {
        // simple l33t speak only so replace  the 4 main vowels
        // a = 4, e = 3, i = 1, o = 0
        switch (Character.toUpperCase(c)) {
            case 'A':
                c = '4';
                break;
            case 'E':
                c = '3';
                break;
            case 'I':
                c = '1';
                break;
            case 'O':
                c = '0';
                break;
        }
        return c;
    }
}