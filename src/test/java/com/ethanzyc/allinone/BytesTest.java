package com.ethanzyc.allinone;

import org.junit.Test;
import org.springframework.util.Base64Utils;

/**
 * @author ethan
 * @date 2019/7/4 11:31
 */
public class BytesTest {

    @Test
    public void test() {
        String s1 = "{\"errcode\":40001,\"errmsg\":\"invalid credential, access_token is invalid or not latest hint: [RCZfwa07482920!]\"}";
        System.out.println(s1.length());
        String s = "asdsadasdasd";
        byte[] bytes = Base64Utils.decodeFromString(s);
        System.out.println(bytes.length);
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }
    }
}
