package com.ethanzyc.allinone.jvm;

/**
 * @author ethan
 * @date 2019/9/9 23:37
 */
public class TestJvm {
    public static void main(String[] args) {
        String str = System.getProperty("str");
        if (str == null) {
            System.out.println("is null");
        } else {
            System.out.println(str);
        }
    }
}
