package com.ethanzyc.allinone.guava;

import java.util.Optional;

/**
 * @author ethan
 * @date 2019/8/23 17:38
 */
public class OptionalTest {

    public static void main(String[] args) {
        Integer a = null;
        Optional<Integer> op = Optional.ofNullable(a);
        System.out.println(op.orElse(1));
        Integer integer = op.orElse(1);

        System.out.println(integer);
    }
}
