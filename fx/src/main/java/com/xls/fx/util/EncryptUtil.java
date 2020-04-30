package com.xls.fx.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.util
 * @ClassName: EncryptUtil
 * @Description: 加密工具
 * @Author: SkyChen
 * @Create: 2020-04-30 09:29
 * @Version: v1.0
 **/
public class EncryptUtil {
    /**
     * 16进制 : 16
     */
    private static final int HEX = 16;
    /**
     * SHA: 0xFF
     */
    private static final int SHA_FF = 0xFF;
    /**
     * SHA: 0x100
     */
    private static final int SHA_100 = 0x100;

    /**
     * SHA（Secure Hash Algorithm，安全散列算法）是消息摘要算法的一种，被广泛认可的MD5算法的继任者。
     * SHA算法家族目前共有SHA-0、SHA-1、SHA-224、SHA-256、SHA-384和SHA-512五种算法，
     * 通常将后四种算法并称为SHA-2算法
     *
     * @param msg  明文
     * @param salt 盐
     * @return 密文
     */
    public static String encryptSHA(final String msg, String salt) throws NoSuchAlgorithmException {
        StringBuilder sb = new StringBuilder();
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(salt.getBytes());
        byte[] bytes = md.digest(msg.getBytes());
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & SHA_FF) + SHA_100, HEX).substring(1));
        }
        return sb.toString();
    }

    /**
     * 加密字符串
     *
     * @param str
     * @return
     */
    public static String md5Base64Url(String str) {
        String res = "";
        //先进行MD5加密
        byte[] bytesMd5 = DigestUtils.md5(str);
        Base64 base64 = new Base64();
        //base64 加密
        byte[] byteBase64 = base64.encode(bytesMd5);
        res = new String(byteBase64);
        return res.replace("\r\n", "");
    }
}
