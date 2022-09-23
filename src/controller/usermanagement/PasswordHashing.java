package controller.usermanagement;

import java.util.Base64;

public class PasswordHashing {

    public static String encryptedPassword (String plainText) throws Exception {
        byte[] cText = plainText.getBytes();
        // return an ISO-8859-1 encoded String
        return Base64.getEncoder().encodeToString(cText);
    }

    public static String decrypt(String encryptedText) throws Exception {
        return new String((Base64.getDecoder().decode(encryptedText)));
    }

    public static boolean checkPassword(String encrypted, String enteredPassword) throws Exception {
        String decryptedPassword = decrypt(encrypted);
        return decryptedPassword.equals(enteredPassword);
    }

}
