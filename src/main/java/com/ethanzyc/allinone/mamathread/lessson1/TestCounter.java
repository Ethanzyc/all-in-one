package com.ethanzyc.allinone.mamathread.lessson1;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ethan
 * @date 2019/11/8 09:01
 */
public class TestCounter {

//    public static void main(String[] args) {
//        Counter counter = new Counter();
//        new Thread(() -> {
//            counter.add();
//        }).start();
//        new Thread(() -> {
//            counter.add();
//        }).start();
//        new Thread(() -> {
//            counter.add();
//        }).start();
//    }

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("1", "a", "b");
        List<String> a = list.parallelStream().filter(item -> {
            return item.equals("a");
        }).collect(Collectors.toList());
        System.out.println(a);
        System.out.println(BigDecimal.valueOf(-2).compareTo(BigDecimal.ZERO));
        System.out.println(BigDecimal.valueOf(0).compareTo(BigDecimal.ZERO));
        System.out.println(BigDecimal.valueOf(2).compareTo(BigDecimal.ZERO));
    }
}
