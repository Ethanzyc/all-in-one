package com.ethanzyc.allinone;

import org.junit.Test;

/**
 * @author ethan
 * @date 2019/8/26 07:45
 */
public class StringTest {

    @Test
    public void testSplit() {
        String str = "SELECT * FROM t_test LIMIT ?, ?";
        String[] split = str.split("\\?");
        System.out.println(split);
    }
}
