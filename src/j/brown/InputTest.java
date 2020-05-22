package j.brown;

import java.io.*;
import java.nio.file.Files;

public class InputTest {
    public static void main(String[] args) {
        testInputTextFile("LOWER");
        testInputTextFile("ALTERNATING");
        testInputTextFile("REVERSE");
        testInputTextFile("L33T");

        testInputByteArray("LOWER");
        testInputByteArray("ALTERNATING");
        testInputByteArray("REVERSE");
        testInputByteArray("L33T");
    }

    private static void testInputByteArray(String stream) {
        try {
            InputStream in;
            // TODO: Make ENUM
            switch (stream.toUpperCase()) {
                case "LOWER":
                    in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
                    System.out.println(stream + " from byte array");
                    getInputFromByteArray(in);
                    break;
                case "ALTERNATING":
                    in = new AlternatingCaseInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
                    System.out.println(stream + " from byte array");
                    getInputFromByteArray(in);
                    break;
                case "REVERSE":
                    in = new ReverseCaseInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
                    System.out.println(stream + " from byte array");
                    getInputFromByteArray(in);
                    break;
                case "L33T":
                    in = new L33tSpeakInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
                    System.out.println(stream + " from byte array");
                    getInputFromByteArray(in);
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

    private static void testInputTextFile(String stream) {
        try {
            InputStream in;
            // TODO: Make ENUM
            switch (stream.toUpperCase()) {
                case "LOWER":
                    in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
                    System.out.println(stream + " from file");
                    getInputFromFile(in);
                    break;
                case "ALTERNATING":
                    in = new AlternatingCaseInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
                    System.out.println(stream + " from file");
                    getInputFromFile(in);
                    break;
                case "REVERSE":
                    in = new ReverseCaseInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
                    System.out.println(stream + " from file");
                    getInputFromFile(in);
                    break;
                case "L33T":
                    in = new L33tSpeakInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
                    System.out.println(stream + " from file");
                    getInputFromFile(in);
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
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