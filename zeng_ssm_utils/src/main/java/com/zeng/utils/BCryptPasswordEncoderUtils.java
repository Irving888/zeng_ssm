package com.zeng.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    private static String passwordEncode(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password = "123";
        String encode = passwordEncode(password);
        //$2a$10$PtIpHC1rJWFs5IDl.ZnNresALpZNo7aFKiL/D5AuZPKRQq7KXs1r.
        //$2a$10$hQScTM7dBYOlYfT1v4yqc.76ePllzp30ndhnqxIF01ZtZfPK9tL6G
        System.out.println(encode);
    }
}
