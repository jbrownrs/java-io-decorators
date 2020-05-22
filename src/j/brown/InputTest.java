package j.brown;

import java.io.*;
import java.nio.file.Files;

public class InputTest {
    public static void main(String[] args) throws IOException {
        int c;
        byte[] buffer = Files.readAllBytes(new File("test.txt").toPath());

        try {
            InputStream in = new ReverseCaseInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
            System.out.println("Reverse case: ");
            while ((c = in.read()) >= 0) {
                System.out.print((char) c);
            }
            System.out.println();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            InputStream in =
                    new ReverseCaseInputStream(new BufferedInputStream(new ByteArrayInputStream(buffer)));
            System.out.println("Reverse case with byte array: ");
            while (in.read(buffer, 0, buffer.length) >= 0) {
                for (byte b : buffer) {
                    System.out.print((char) b);
                }
            }
            System.out.println();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
            System.out.println("Lower case: ");
            while ((c = in.read()) >= 0) {
                System.out.print((char) c);
            }
            System.out.println();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            InputStream in =
                    new LowerCaseInputStream(new BufferedInputStream(new ByteArrayInputStream(buffer)));
            System.out.println("Lower case with byte array: ");
            while (in.read(buffer, 0, buffer.length) >= 0) {
                for (byte b : buffer) {
                    System.out.print((char) b);
                }
            }
            System.out.println();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            InputStream in = new AlternatingCaseInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
            System.out.println("Alternating case: ");
            while ((c = in.read()) >= 0) {
                System.out.print((char) c);
            }
            System.out.println();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            InputStream in =
                    new AlternatingCaseInputStream(new ByteArrayInputStream(buffer));
            System.out.println("Alternating case with byte array: ");
            while (in.read(buffer, 0, buffer.length) >= 0) {
                for (byte b : buffer) {
                    System.out.print((char) b);
                }
            }
            System.out.println();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}