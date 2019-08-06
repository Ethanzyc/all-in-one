package com.ethanzyc.allinone;

import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * @author ethan
 * @date 2019/8/6 08:49
 */
public class RamdomTest {

    @Test
    public void testRandom() {
        IntStream ints = ThreadLocalRandom.current().ints(1, 9).limit(10);
        ints.forEach(item -> {
            System.out.println(item);
        });
    }
}
