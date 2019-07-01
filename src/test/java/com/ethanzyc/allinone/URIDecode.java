package com.ethanzyc.allinone;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author ethan
 * @date 2019/7/1 20:00
 */
public class URIDecode {

    @Test
    public void uriDecode() {
        String decode = null;
        try {
            decode = URLDecoder.decode("%E6%9C%B1%E5%AE%87%E6%99%A8", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(decode);
    }
}
