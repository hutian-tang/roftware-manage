package com.njust.roftwaremanage.LabManagement.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密类
 * 用于加密用户输入的密码
 */
public class MD5Encoder {
    public static String encode(String str) {
        byte[] b = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            b = digest.digest(str.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String s = "";
        for (int i = 0; i < b.length; i++) {
            String temp = Integer.toHexString(0xff & b[i]);
            if (temp.length() == 1)
                temp = '0' + temp;
            s += temp;
        }
        return s;
    }
}
