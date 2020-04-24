package com.xls.zc.http.base;

import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * @ClassName: MD5Util
 * @Description: MD5Util
 * @Author: lcyuan
 * @Date: 2019/2/22 13:42
 * @Version: 1.0
 **/

public class MD5Util {
	 private static final String hexDigIts[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
         "a", "b", "c", "d", "e", "f"};
 private static final String DEFAULT_CHARSET = "UTF-8";

 public static String encodeOaUser(String user, String salt) {
     if (StringUtils.isEmpty(user) || StringUtils.isEmpty(salt)) return null;
     return encode(user + salt, 10, DEFAULT_CHARSET);
 }

 public static String encode(String origin, int encCount, String charset) {
     if (StringUtils.isEmpty(origin)) return null;
     byte[] originBytes;
     try {
         MessageDigest digest = MessageDigest.getInstance("MD5");
         for (int i = 0; i < encCount; i++) {
             if (StringUtils.isEmpty(charset)) {
                 originBytes = origin.getBytes();
             } else {
                 originBytes = origin.getBytes(charset);
             }
             digest.update(originBytes);
             origin = byteArrayToHexString(digest.digest());
         }
         return origin;
     } catch (Exception e) {
         e.printStackTrace();
     }
     return null;
 }

 public static String encode(String origin, String salt, String charset) {
     if (StringUtils.isEmpty(origin)) return null;
     byte[] originBytes;
     byte[] saltBytes;
     try {
         if (StringUtils.isEmpty(charset)) {
             originBytes = origin.getBytes();
             saltBytes = StringUtils.isEmpty(salt) ? null : salt.getBytes();
         } else {
             originBytes = origin.getBytes(charset);
             saltBytes = StringUtils.isEmpty(salt) ? null : salt.getBytes(charset);
         }
         MessageDigest digest = MessageDigest.getInstance("MD5");
         if (saltBytes != null) {
             digest.reset();
             digest.update(saltBytes);
         }
         return byteArrayToHexString(digest.digest(originBytes));
     } catch (Exception e) {
         e.printStackTrace();
     }
     return null;
 }

 private static String byteArrayToHexString(byte b[]) {
     StringBuffer resultSb = new StringBuffer();
     for (int i = 0; i < b.length; i++) {
         resultSb.append(byteToHexString(b[i]));
     }
     return resultSb.toString();
 }

 private static String byteToHexString(byte b) {
     int n = b;
     if (n < 0) {
         n += 256;
     }
     int d1 = n / 16;
     int d2 = n % 16;
     return hexDigIts[d1] + hexDigIts[d2];
 }
 public static String stringToMD5(String plainText) {
     byte[] secretBytes = null;
     try {
         secretBytes = MessageDigest.getInstance("md5").digest(
                 plainText.getBytes());
     } catch (NoSuchAlgorithmException e) {
         throw new RuntimeException("没有这个md5算法！");
     }
     String md5code = new BigInteger(1, secretBytes).toString(16);
     for (int i = 0; i < 32 - md5code.length(); i++) {
         md5code = "0" + md5code;
     }
     return md5code;
 }

 public static void main(String[] args) {
     String key = MD5Util.encodeOaUser("yunmeng_order01", "yunmeng_123");
     System.out.println(key);
 }
}
