package j.brown;

import java.io.*;
import java.nio.file.Files;

public class InputTest {
    public static void main(String[] args) {
        testInputTextFile(StreamTypes.LOWER);
        testInputTextFile(StreamTypes.ALTERNATING);
        testInputTextFile(StreamTypes.FLIP);
        testInputTextFile(StreamTypes.L33T);

        testInputByteArray(StreamTypes.LOWER);
        testInputByteArray(StreamTypes.ALTERNATING);
        testInputByteArray(StreamTypes.FLIP);
        testInputByteArray(StreamTypes.L33T);
    }

    private static void testInputByteArray(StreamTypes stream) {
        try {
            InputStream in;
            switch (stream) {
                case ALTERNATING:
                    in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
                    System.out.println(stream.description + " from byte array");
                    getInputFromByteArray(in);
                    break;
                case LOWER:
                    in = new AlternatingCaseInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
                    System.out.println(stream.description + " from byte array");
                    getInputFromByteArray(in);
                    break;
                case FLIP:
                    in = new FlipCaseInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
                    System.out.println(stream.description + " from byte array");
                    getInputFromByteArray(in);
                    break;
                case L33T:
                    in = new L33tSpeakInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
                    System.out.println(stream.description + " from byte array");
                    getInputFromByteArray(in);
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testInputTextFile(StreamTypes stream) {
        try {
            InputStream in;
            switch (stream) {
                case LOWER:
                    in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
                    System.out.println(stream.description + " from file");
                    getInputFromFile(in);
                    break;
                case ALTERNATING:
                    in = new AlternatingCaseInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
                    System.out.println(stream.description + " from file");
                    getInputFromFile(in);
                    break;
                case FLIP:
                    in = new FlipCaseInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
                    System.out.println(stream.description + " from file");
                    getInputFromFile(in);
                    break;
                case L33T:
                    in = new L33tSpeakInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
                    System.out.println(stream.description + " from file");
                    getInputFromFile(in);
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getInputFromByteArray(InputStream in) throws IOException {
        byte[] buffer = Files.readAllBytes(new File("test.txt").toPath());
        while (in.read(buffer, 0, buffer.length) >= 0) {
            for (byte b : buffer) {
                System.out.print((char) b);
            }
        }
        System.out.println();
        in.close();
    }

    private enum StreamTypes {
        LOWER("Lowercase stream"),
        ALTERNATING("Alternating case stream"),
        FLIP("Flip case stream"),
        L33T("Basic l33t stream");

        private String description;

        StreamTypes(String description) {
            this.description = description;
        }
    }

    private static void getInputFromFile(InputStream inputStream) throws IOException {
        int c;
        while ((c = inputStream.read()) >= 0) {
            System.out.print((char) c);
        }
        System.out.println();
        inputStream.close();
    }
}