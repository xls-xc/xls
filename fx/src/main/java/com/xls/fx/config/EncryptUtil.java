package com.xls.fx.config;

import java.security.MessageDigest;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.fx.config
 * @ClassName: EncryptUtil
 * @Description: 还没有添加类的描述信息
 * @Author: SkyChen
 * @Create: 2020-04-13 20:58
 * @Version: v1.0
 **/
public class EncryptUtil {
    /** 16进制 : 16 */
    private static final int HEX = 16;
    /** SHA: 0xFF  */
    private static final int SHA_FF = 0xFF;
    /** SHA: 0x100   */
    private static final int SHA_100 = 0x100;

    /**
     * SHA（Secure Hash Algorithm，安全散列算法）是消息摘要算法的一种，被广泛认可的MD5算法的继任者。
     * SHA算法家族目前共有SHA-0、SHA-1、SHA-224、SHA-256、SHA-384和SHA-512五种算法，
     * 通常将后四种算法并称为SHA-2算法
     * @param msg 明文
     * @param salt 盐
     * @return 密文
     */
    public static String encryptSHA(final String msg, String salt) {

        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(msg.getBytes());
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & SHA_FF) + SHA_100, HEX).substring(1));
            }
        } catch (final Exception e) {
           e.printStackTrace();
        }

        return sb.toString();
    }
}
