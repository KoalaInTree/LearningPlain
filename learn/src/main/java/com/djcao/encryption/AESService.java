package com.djcao.encryption;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019-09-12
 */
public class AESService {
    private static final String ALGORITHM = "AES";// DES AES
    private static final SecureRandom sr = new SecureRandom();
    private static Cipher encryptCipher;
    private static Cipher decryptCipher;

    public AESService() throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException {
        KeyGenerator instance = KeyGenerator.getInstance(ALGORITHM);
        SecretKey secretKey = instance.generateKey();
        encryptCipher = Cipher.getInstance(ALGORITHM);
        decryptCipher = Cipher.getInstance(ALGORITHM);
        encryptCipher.init(Cipher.ENCRYPT_MODE,secretKey,sr);
        decryptCipher.init(Cipher.DECRYPT_MODE,secretKey,sr);
    }

    public String encode(String raw) throws UnsupportedEncodingException, BadPaddingException,
        IllegalBlockSizeException {
        return Base64.getEncoder().encodeToString(encryptCipher.doFinal(raw.getBytes("UTF-8")));
    }

    public String decode(String raw) throws UnsupportedEncodingException, BadPaddingException,
        IllegalBlockSizeException {
        return new String(decryptCipher.doFinal(Base64.getDecoder().decode(raw.getBytes("UTF-8"))),"UTF-8");
    }

    public static void main(String[] args)
        throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException,
        IllegalBlockSizeException, BadPaddingException {
        AESService aesService = new AESService();
        String encode = aesService.encode("哈哈哈");
        System.out.println(encode);
        String decode = aesService.decode(encode);
        System.out.println(decode);
    }
}
