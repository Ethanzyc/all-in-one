package com.ethanzyc.allinone;

import org.junit.Test;

/**
 * @author ethan
 * @date 2019/8/6 10:47
 */
public class TimeTest {

    @Test
    public void getTime() {
        int i = 1000;
        long l = System.currentTimeMillis() / i;
        System.out.println(l);
    }
}
