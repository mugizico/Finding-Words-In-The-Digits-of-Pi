package piwords;

public class Randompizer {
    /**
     * Given a password string, determine the key (start and skip)
     * to use for randomization.
     *
     * The start parameter is extracted from the bottom 12 bits of
     * the string's hashCode, and the skip parameter is extracted
     * from the next 4 bits.
     *
     * @param password String from which to derive the key.
     * @return key A pair (start, skip) of integers representing the key.
     */
    public static Pair<Integer, Integer> passwordToKey(String password) {
        // Implement for challenge problem
        throw new RuntimeException("not implemented");
    }
    
    /**
     * Given a key, generate `n' Pi-based random bytes.
     *
     * The algorithm is specified in the "Generating Randomness" section of
     * the problem set.
     *
     * @param key A pair (start, skip) of integers representing the key.
     * @param n The number of random bytes to generate.
     * @return A array of the random bytes generated.
     */
    public static int[] generatePiBasedRandomBytes(Pair<Integer, Integer> key,
                                                   int n) {
        // Implement for challenge problem
        throw new RuntimeException("not implemented");
    }

    /**
     * Given a message, determine the number of random bytes necessary
     * to encrypt it without using any piece of randomness more than
     * once.
     *
     * Each alphabetic character in the message (A-Z and a-z) will
     * require 1/1.7 byte to scramble. All other characters will not
     * be scrambled.
     *
     * @param message The message to determine the random byte count for.
     * @return The number of random bytes required.
     */
    public static int bytesToEncrypt(String message) {
        // Implement for challenge problem
        throw new RuntimeException("not implemented");
    }

    /**
     * Given a message and a sufficient number of random bytes,
     * reversibly scramble the alphabetic characters in the message
     * according to the values of the random bytes.
     *
     * The algorithm is detailed in the problem set; the random
     * bytes are converted from base 256 to base 26, and added
     * to the corresponding alphabetic characters of the string.
     *
     * @param message The message to scramble.
     * @param pad The array of random bytes to use. Must contain at
     *            least bytesToEncrypt(message) bytes.
     * @return The scrambled message.
     */
    public static String scrambleMessage(String message, int[] pad) {
        // Implement for challenge problem
        throw new RuntimeException("not implemented");
    }

    /**
     * Given the same pad as was passed to scrambleMessage(),
     * reverse that function's effects, recovering the original
     * message.
     *
     * unscrambleMessage(scrambleMessage(str, pad), pad) should
     * always return str.
     *
     * @param message The message to unscramble.
     * @param pad The array of random bytes to use. Must contain at
     *            least bytesToEncrypt(message) bytes.
     * @return The unscrambled message.
     */
    public static String unscrambleMessage(String message, int[] pad) {
        // Implement for challenge problem
        throw new RuntimeException("not implemented");
    }

    /**
     * Main function for testing.
     */
    public static void main(String[] args) {
        String passphrase = "secret42";
        String plain_message =
            "Thank you for noticing this notice. Your noticing it has been noted.";
        String crypt_message =
            "Ftva'q w lyw qywxlcy:\n" +
            "Mklp'h msj asubu ymma qfn w gbv, jui aogpl yooi aen tgjevfi. --Jflr Qltpreerw\n" +
            "E zctl vqj imh; tossh q jdvsq gebgwz, rswc zojdpt, ufzt uhrq lv dois! Yb ow Cmdm!";
        int[] pad;

        System.out.println("Passphrase to key:");
        Pair<Integer, Integer> key = passwordToKey(passphrase);
        System.out.printf("'%s' => [%d, %d]\n\n", passphrase, key.first, key.second);

        System.out.println("Key to random bytes: (may take several seconds...)");
        pad = generatePiBasedRandomBytes(key, 256);
        System.out.printf("%02x %02x %02x %02x %02x %02x %02x %02x ...\n\n",
                          pad[0], pad[1], pad[2], pad[3], pad[4], pad[5], pad[6], pad[7]);

        System.out.println("Scrambling string:");
        System.out.printf("original:  %s\n", plain_message);
        System.out.printf("scrambled: %s\n\n", scrambleMessage(plain_message, pad));

        System.out.println("Unscrambling string:");
        System.out.printf("original:\n%s\n", crypt_message);
        System.out.printf("unscrambled:\n%s\n", unscrambleMessage(crypt_message, pad));
    }
}
