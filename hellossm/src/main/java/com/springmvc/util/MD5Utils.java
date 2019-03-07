package com.springmvc.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    public static String encryption(String password) {

        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            byte[] arrays = md5.digest(password.getBytes());
            StringBuilder str = new StringBuilder();
            for (byte i : arrays) {
                String toHexStr = Integer.toHexString(i & 0xff);
                str.append(toHexStr.length() == 1 ? 0 + toHexStr : toHexStr);
            }
//            System.out.println(str);
            return str.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
