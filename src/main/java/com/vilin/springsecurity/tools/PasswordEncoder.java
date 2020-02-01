package com.vilin.springsecurity.tools;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

public class PasswordEncoder {
    public static void main(String[] args) {
        org.springframework.security.crypto.password.PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String password = "123456";
        String password2 = encoder.encode(password);
        System.out.println(password2);
        System.out.println(encoder.matches(password, password2));

        BCryptPasswordEncoder encoder2 = new BCryptPasswordEncoder();
        String password3 = encoder2.encode(password);
        System.out.println(password3);
        System.out.println(encoder2.matches(password, password3));
    }
}
