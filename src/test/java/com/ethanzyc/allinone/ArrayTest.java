package com.ethanzyc.allinone;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ethan
 * @date 2019/7/8 22:30
 */
public class ArrayTest {
    @Test
    public void test2Array() {
        Map<String, Object> returnMap = new HashMap<>();
        String[][] strings = new String[1][2];
        strings[0][0] = "活动未开始";
        strings[0][1] = "开始时间: 2019-8-1 08：00";
        returnMap.put("content", strings);
        System.out.println(returnMap);
    }

    @Test
    public void testArray() {
        List<String> list = Arrays.asList("1", "2", "3");
        List<String> strings = list.subList(1, 3);
        System.out.println(strings);
    }
}

