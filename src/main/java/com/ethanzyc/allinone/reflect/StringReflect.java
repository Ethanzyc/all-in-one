package com.ethanzyc.allinone.reflect;

import java.lang.reflect.Field;

/**
 * @author ethan
 * @date 2019/8/30 12:40
 */
public class StringReflect {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String str1 = "hello";
        String str2 = new String("123");


        System.out.println(str1);
        System.out.println(str2);

        Field field = String.class.getDeclaredField("value");

        field.setAccessible(true);

        field.set(str2, "world".toCharArray());

        System.out.println(str1);
        System.out.println(str2);
    }
}
