package com.outsourcing.combat.ShiroConfig;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

/*
 * 创建用户的时候进行的密码加密*/
public class ShiroEncryption {
    public static String shiroEncryption(String password, String salt) {
        //shiro自带的工具类生成的salt
//        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
//        System.out.println(salt);
        //设置加密次数
        int times = 1;
        //算法名称
        String algoritName = "md5";

        String encodedPassword = new SimpleHash(algoritName, password, salt, times).toString();
        return encodedPassword;
    }
}
