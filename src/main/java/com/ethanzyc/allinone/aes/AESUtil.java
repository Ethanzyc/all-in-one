package com.ethanzyc.allinone.aes;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author ethan
 * @date 2019/12/3 16:48
 */
public class AESUtil {

    public static final String KEY_ALGORITHM = "AES";
    public static final String KEY_ALGORITHM_MODE = "AES/CBC/PKCS5Padding";

    /**
     * AES加密
     *
     * @param data
     * @param key  key需要16位
     * @return
     */
    public static String encrypt(String data, String key) {
        try {
            SecretKeySpec spec = new SecretKeySpec(key.getBytes("UTF-8"), KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM_MODE);
            cipher.init(Cipher.ENCRYPT_MODE, spec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
            byte[] bs = cipher.doFinal(data.getBytes("UTF-8"));
            // base64 主要是为了转码，方便传输
            return Base64Util.encode(bs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * AES 解密
     *
     * @param data
     * @param key  key需要16位
     * @return
     */
    public static String decrypt(String data, String key) {
        try {
            SecretKeySpec spec = new SecretKeySpec(key.getBytes("UTF-8"), KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM_MODE);
            cipher.init(Cipher.DECRYPT_MODE, spec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
            byte[] originBytes = Base64Util.decode(data);
            byte[] result = cipher.doFinal(originBytes);
            return new String(result, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        String key = "5BCP5BEL6JQBMAYI";
        String data = "2020";
        // 用 AES 加密 data
        String encryptResult = AESUtil.encrypt(data, key);
        System.out.println(encryptResult);
        /**
         * 因为 key 十分关键，一旦有 key，别人就能解码，所以需要把 key 用 RSA 非对称加密算法来加密，
         * 即现在前端用公钥加密，然后把加密后的 key 传输到后端，因为是非对称加密，别人就算有公钥，也不能解密，
         * 必须用用私钥来解密，而私钥值只会在更安全的后端有。
         */
        // 用 RSA 加密 key
//        byte[] rsaKey = RSAUtil.encryptByPublicKey(key.getBytes("UTF-8"),RSAUtil.PUBLIC_KEY);
//        String baseKey = Base64Util.encode(rsaKey);
//        System.out.println(encryptResult);
//        System.out.println(baseKey);
//
        String s = decrypt("jCU7sdvz56GCk4OxVoUaNw==", key);
        System.out.println(s);

    }
}
