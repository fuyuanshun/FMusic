package com.fys.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 将密码进行MD5加密的辅助类
 */
public class MD5Util {

    public static String getMD5(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("字符串不能为空!");
        }
        StringBuffer hexString = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] hash = md.digest();
            for (int i = 0; i < hash.length; i++) {
                if ((0xff & hash[i]) < 0x10) {
                    hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
                } else {
                    hexString.append(Integer.toHexString(0xFF & hash[i]));
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hexString.toString();
    }
}