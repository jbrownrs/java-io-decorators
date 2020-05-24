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
            char in = (char) input.read();
            assertEquals(expected.charAt(i), in);
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

    @org.junit.jupiter.api.Test
    void testDoubleFlipRead() throws IOException {
        String expected = "I know the Decorator Pattern therefore I RULE!";
        testStream = new FlipCaseInputStream(new FlipCaseInputStream(fBaseStream));
        compare(expected, testStream);
    }

    @org.junit.jupiter.api.Test
    void testDoubleAlternatingRead() throws IOException {
        String expected = "I kNoW tHe DeCoRaToR pAtTeRn ThErEfOrE i RuLe!";
        testStream = new AlternatingCaseInputStream(new AlternatingCaseInputStream(fBaseStream));
        compare(expected, testStream);
    }

    @org.junit.jupiter.api.Test
    void testDoubleL33tSpeakRead() throws IOException {
        String expected = "1 kn0w th3 D3c0r4t0r P4tt3rn th3r3f0r3 1 RUL3!";
        testStream = new L33tSpeakInputStream(new L33tSpeakInputStream(fBaseStream));
        compare(expected, testStream);
    }

    @org.junit.jupiter.api.Test
    void testDoubleLowerCaseRead() throws IOException {
        String expected = "i know the decorator pattern therefore i rule!";
        testStream = new LowerCaseInputStream(new LowerCaseInputStream(fBaseStream));
        compare(expected, testStream);
    }

    @org.junit.jupiter.api.Test
    void testDoubleFlipReadByte() throws IOException {
        String expected = "I know the Decorator Pattern therefore I RULE!";
        testStream = new FlipCaseInputStream(new FlipCaseInputStream(fBaseStream));
        compareByte(expected, testStream);
    }

    @org.junit.jupiter.api.Test
    void testDoubleAlternatingReadByte() throws IOException {
        String expected = "I kNoW tHe DeCoRaToR pAtTeRn ThErEfOrE i RuLe!";
        testStream = new AlternatingCaseInputStream(new AlternatingCaseInputStream(fBaseStream));
        compareByte(expected, testStream);
    }

    @org.junit.jupiter.api.Test
    void testDoubleL33tSpeakReadByte() throws IOException {
        String expected = "1 kn0w th3 D3c0r4t0r P4tt3rn th3r3f0r3 1 RUL3!";
        testStream = new L33tSpeakInputStream(new L33tSpeakInputStream(fBaseStream));
        compareByte(expected, testStream);
    }

    @org.junit.jupiter.api.Test
    void testDoubleLowerCaseReadByte() throws IOException {
        String expected = "i know the decorator pattern therefore i rule!";
        testStream = new LowerCaseInputStream(new LowerCaseInputStream(fBaseStream));
        compareByte(expected, testStream);
    }

    @org.junit.jupiter.api.Test
    void testCombineLowerCaseAndL33tSpeakRead() throws IOException {
        String expected = "1 kn0w th3 d3c0r4t0r p4tt3rn th3r3f0r3 1 rul3!";
        testStream = new LowerCaseInputStream(new L33tSpeakInputStream(fBaseStream));
        compare(expected, testStream);
    }

    @org.junit.jupiter.api.Test
    void testCombineLowerCaseAndL33tSpeakReadByte() throws IOException {
        String expected = "1 kn0w th3 d3c0r4t0r p4tt3rn th3r3f0r3 1 rul3!";
        testStream = new LowerCaseInputStream(new L33tSpeakInputStream(fBaseStream));
        compareByte(expected, testStream);
    }

    @org.junit.jupiter.api.Test
    void testCombineFlipCaseAndL33tSpeakRead() throws IOException {
        String expected = "1 KN0W TH3 d3C0R4T0R p4TT3RN TH3R3F0R3 1 rul3!";
        testStream = new FlipCaseInputStream(new L33tSpeakInputStream(fBaseStream));
        compare(expected, testStream);
    }

    @org.junit.jupiter.api.Test
    void testCombineFlipCaseAndL33tSpeakReadByte() throws IOException {
        String expected = "1 KN0W TH3 d3C0R4T0R p4TT3RN TH3R3F0R3 1 rul3!";
        testStream = new FlipCaseInputStream(new L33tSpeakInputStream(fBaseStream));
        compareByte(expected, testStream);
    }

    @org.junit.jupiter.api.Test
    void testCombineAlternatingCaseAndL33tSpeakRead() throws IOException {
        String expected = "1 Kn0W tH3 d3C0r4T0r P4tT3rN tH3r3F0r3 1 RuL3!";
        testStream = new AlternatingCaseInputStream(new L33tSpeakInputStream(fBaseStream));
        compare(expected, testStream);
    }

    @org.junit.jupiter.api.Test
    void testCombineAlternatingCaseAndL33tSpeakReadByte() throws IOException {
        String expected = "1 Kn0W tH3 d3C0r4T0r P4tT3rN tH3r3F0r3 1 RuL3!";
        testStream = new AlternatingCaseInputStream(new L33tSpeakInputStream(fBaseStream));
        compareByte(expected, testStream);
    }

    @org.junit.jupiter.api.Test
    void testCombineFlipAndLowerCaseRead() throws IOException {
        String expected = "I KNOW THE DECORATOR PATTERN THEREFORE I RULE!";
        testStream = new FlipCaseInputStream(new LowerCaseInputStream(fBaseStream));
        compare(expected, testStream);
    }

    @org.junit.jupiter.api.Test
    void testCombineFlipAndLowerCaseReadByte() throws IOException {
        String expected = "I KNOW THE DECORATOR PATTERN THEREFORE I RULE!";
        testStream = new FlipCaseInputStream(new LowerCaseInputStream(fBaseStream));
        compareByte(expected, testStream);
    }
}