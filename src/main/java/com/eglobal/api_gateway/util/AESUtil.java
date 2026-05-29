package com.eglobal.api_gateway.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESUtil {

    private AESUtil() {}

    public static String encrypt(String secretKey, String plainText) throws Exception {
        SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static String decrypt(String secretKey, String encrypted) throws Exception {
        SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decoded = Base64.getDecoder().decode(encrypted);
        return new String(cipher.doFinal(decoded));
    }

    public static void main(String[] args) throws Exception {
        String key = "claveSecreta1234"; // 16 chars exactos
        String secretoPlano = "prueba123";

        String secretoCifrado = encrypt(key, secretoPlano);
        System.out.println("Secreto válido: " + secretoCifrado);

        // prueba descifrado
        String descifrado = decrypt(key, secretoCifrado);
        System.out.println("Descifrado: " + descifrado);
    }
}
