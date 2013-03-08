package piwords;

import static org.junit.Assert.*;

import org.junit.Test;

public class RandompizerTest {
    @Test
    public void testPasswordToKey() {
        String passphrase = "testing";
        Pair<Integer, Integer> expectedKey = new Pair<Integer, Integer>(passphrase.hashCode() & 0xFFF,
                ((passphrase.hashCode() >> 12) & 0xF) + 1);
        assertEquals(expectedKey, Randompizer.passwordToKey(passphrase));
    }

    @Test
    public void testGenerateRandomBytes() {
        Pair<Integer, Integer> key = new Pair<Integer, Integer>(2350, 7);
        int[] expectedBytes = {0xf2, 0x0f, 0x2d, 0x6e};
        assertArrayEquals(expectedBytes, Randompizer.generatePiBasedRandomBytes(key, 4));
    }
    
    @Test
    public void testCountBytesToEncrypt() {
        assertEquals(10, Randompizer.bytesToEncrypt("ABC-def-GhIjK! AAAAa?"));
    }
    
    @Test
    public void testScrambleUnscrambleMessage() {
        int[] pad = {1, 2, 3, 4, 5, 6, 7, 8};
        assertEquals("testing this",
                Randompizer.unscrambleMessage(Randompizer.scrambleMessage("testing this", pad), pad));
    }
    
    @Test
    public void testScrambleMessage() {
        int[] pad = {0xf2, 0x0f, 0x2d, 0x6e, 0x8a};
        assertEquals("rweji uuy", Randompizer.scrambleMessage("thank you", pad));
    }
    
    // Write more tests for challenge problem
}
