package СomputerScienceProblemsJava.chapter1;

import java.util.Random;

public class UnbreakableEncryption {

    public static void main(String[] args) {
        KeyPair kp = encrypt("One Time Pad!");
        String result = decrypt(kp);
        System.out.println(result);
    }
    private static byte[] randomKey(int length) {
        //генерировать length случайных байтов
        byte[] dummy = new byte[length];
        Random random = new Random();
        random.nextBytes(dummy);
        return dummy;
    }

    public static KeyPair encrypt(String original) {
        byte[] originalBytes = original.getBytes();
        byte[] dummyKey = randomKey(originalBytes.length);
        byte[] encryptedKey = new byte[originalBytes.length];
        for (int i = 0; i < originalBytes.length; i++) {
            //побитовая операция XOR
            encryptedKey[i] = (byte) (originalBytes[i] ^ dummyKey[i]);
        }
        return new KeyPair(dummyKey, encryptedKey);
    }

    public static String decrypt(KeyPair kp) {
        byte[] decrypted = new byte[kp.key1.length];
        for (int i = 0; i < kp.key1.length; i++) {
            //побитовая операция XOR
            decrypted[i] = (byte) (kp.key1[i] ^ kp.key2[i]);
        }
        return new String(decrypted);
    }

}
