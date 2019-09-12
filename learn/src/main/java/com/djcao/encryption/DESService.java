package com.djcao.encryption;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.omg.PortableServer.ThreadPolicy;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019-09-11
 */
public class DESService {

    private String secretKeyString;
    private SecretKey secretKey;
    private final static String ALGORITHM = "DES";
    private final static String CIPHER_ALGORITHM = "DES/ECB/PKCS5Padding";
    private final static SecureRandom secureRandom = new SecureRandom();
    private static Cipher encryptCipher;
    private static Cipher decryptCipher;
    public DESService(String secretKeyString) throws Exception {
        this.secretKeyString = secretKeyString;
        DESKeySpec desKeySpec = new DESKeySpec(secretKeyString.getBytes("UTF-8"));
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        secretKey = secretKeyFactory.generateSecret(desKeySpec);
        encryptCipher = Cipher.getInstance(CIPHER_ALGORITHM);
        encryptCipher.init(Cipher.ENCRYPT_MODE,secretKey);
        decryptCipher = Cipher.getInstance(CIPHER_ALGORITHM);
        decryptCipher.init(Cipher.DECRYPT_MODE,secretKey);
    }

    public String encode(String raw) throws Exception {
        return Base64.getEncoder().encodeToString((encryptCipher.doFinal(raw.getBytes())));
    }

    public String decode(String encryption) throws Exception {
        return new String(decryptCipher.doFinal(
            Base64.getDecoder().decode(encryption.getBytes("UTF-8")))
            ,"UTF-8");
    }

    public static void main(String[] args) throws Exception {
        DESService service = new DESService("12345678");

        ExecutorService pool = Executors.newFixedThreadPool(20);
        for (int i = 0; i< 10 ; i++){
            pool.execute(() -> {
                String sss = "哈哈哈" + Thread.currentThread().getId();
                String encode = null;
                try {
                    encode = service.encode(sss);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(encode);
                String decode = null;
                try {
                    decode = service.decode(encode);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(decode);
            });
        }
        pool.shutdown();

    }
}