package j.brown;

import org.junit.jupiter.api.AfterEach;

import java.io.*;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputStreamTests {

    private final InputStream fBaseStream;
    private final byte[] fBuffer;
    private InputStream testStream;

    InputStreamTests() throws IOException {
        fBaseStream = new BufferedInputStream(new FileInputStream("test.txt"));
        fBuffer = Files.readAllBytes(new File("test.txt").toPath());
    }

    private void compare(String expected, InputStream input) throws IOException {
        for (int i = 0; i < expected.length(); i++) {
            assertEquals(expected.charAt(i), input.read());
        }
    }

    private void compareByte(String expected, InputStream testStream) throws IOException {
        while (testStream.read(fBuffer, 0, fBuffer.length) >= 0) {
            for (int i = 0; i < fBuffer.length; i++) {
                assertEquals(expected.charAt(i), (char) fBuffer[i]);
            }
        }
    }

    @AfterEach
    void tearDown() {
        try {
            testStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @org.junit.jupiter.api.Test
    void testFlipRead() throws IOException {
        String expected = "i KNOW THE dECORATOR pATTERN THEREFORE i rule!";
        testStream = new FlipCaseInputStream(fBaseStream);
        compare(expected, testStream);
    }

    @org.junit.jupiter.api.Test
    void testLowerCaseRead() throws IOException {
        String expected = "i know the decorator pattern therefore i rule!";
        testStream = new LowerCaseInputStream(fBaseStream);
        compare(expected, testStream);
    }

    @org.junit.jupiter.api.Test
    void testAlternatingCaseRead() throws IOException {
        String expected = "I kNoW tHe DeCoRaToR pAtTeRn ThErEfOrE i RuLe!";
        testStream = new AlternatingCaseInputStream(fBaseStream);
        compare(expected, testStream);
    }

    @org.junit.jupiter.api.Test
    void testL33tSpeakRead() throws IOException {
        String expected = "1 kn0w th3 D3c0r4t0r P4tt3rn th3r3f0r3 1 RUL3!";
        testStream = new L33tSpeakInputStream(fBaseStream);
        compare(expected, testStream);
    }

    @org.junit.jupiter.api.Test
    void testFlipReadByteArray() throws IOException {
        String expected = "i KNOW THE dECORATOR pATTERN THEREFORE i rule!";
        testStream = new FlipCaseInputStream(fBaseStream);
        compareByte(expected, testStream);
    }

    @org.junit.jupiter.api.Test
    void testLowerCaseByteArray() throws IOException {
        String expected = "i know the decorator pattern therefore i rule!";
        testStream = new LowerCaseInputStream(fBaseStream);
        compareByte(expected, testStream);
    }

    @org.junit.jupiter.api.Test
    void testAlternatingCaseReadByteArray() throws IOException {
        String expected = "I kNoW tHe DeCoRaToR pAtTeRn ThErEfOrE i RuLe!";
        testStream = new AlternatingCaseInputStream(fBaseStream);
        compareByte(expected, testStream);
    }

    @org.junit.jupiter.api.Test
    void testL33tSpeakReadByteArray() throws IOException {
        String expected = "1 kn0w th3 D3c0r4t0r P4tt3rn th3r3f0r3 1 RUL3!";
        testStream = new L33tSpeakInputStream(fBaseStream);
        compareByte(expected, testStream);
    }

    // TODO :
    // 1) tests for combining decorators
}