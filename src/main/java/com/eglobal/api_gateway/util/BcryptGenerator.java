package com.eglobal.api_gateway.util;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BcryptGenerator {

    public static void main(String[] args) {

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        String adminHash = encoder.encode("admin123");
        String marcoHash = encoder.encode("marco123");

        System.out.println("Admin: " + adminHash);
        System.out.println("Marco: " + marcoHash);
    }
}