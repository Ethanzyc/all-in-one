package com.ethanzyc.allinone;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.SecretKey;

/**
 * @author ethan
 * @date 2019/7/28 09:29
 */
public class PasswordEncodeTest {

    @Test
    public void test() {
        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
        String format = secretKey.getEncoded().toString();
        System.out.println(format);
        System.out.println(secretKey.toString());

    }


}
