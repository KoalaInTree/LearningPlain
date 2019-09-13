package com.djcao.encryption;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
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
 * @date 2019-09-13
 */
public class RSAService {
    private static String PASSWORD = "1234";
    private static final String ALGORITHM = "RSA";
    private static final SecureRandom sr = new SecureRandom();
    private static Cipher encryptCipher;
    private static Cipher decryptCipher;

    public RSAService(String password) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException {
        PASSWORD = password;
        KeyPairGenerator instance = KeyPairGenerator.getInstance(ALGORITHM);
        KeyPair secretKey = instance.generateKeyPair();
        PrivateKey aPrivate = secretKey.getPrivate();
        PublicKey aPublic = secretKey.getPublic();
        encryptCipher = Cipher.getInstance(ALGORITHM);
        decryptCipher = Cipher.getInstance(ALGORITHM);
        encryptCipher.init(Cipher.ENCRYPT_MODE,aPublic);
        decryptCipher.init(Cipher.DECRYPT_MODE,aPrivate);
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
        RSAService aesService = new RSAService("1234");
        String encode = aesService.encode("哈哈哈");
        System.out.println(encode);
        String decode = aesService.decode(encode);
        System.out.println(decode);

        String encode1 = aesService.encode("哈哈哈");
        System.out.println(encode1);
        String decode1 = aesService.decode(encode1);
        System.out.println(decode1);
    }
}
