package com.ethanzyc.allinone;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * @author ethan
 * @date 2019/8/6 14:56
 */
public class MapTest {

    @Test
    public void testMapKeySet() {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, UUID.randomUUID().toString());
        }

        // error UnsupportedOperationException
        Set<Integer> integers = map.keySet();
        integers.add(123);
    }
}
