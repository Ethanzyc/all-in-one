package com.ethanzyc.allinone.thinkInJava.reload;

/**
 * @author ethan
 * @date 2019/8/4 09:05
 */
public class Reload {

    public static void main(String[] args) {

        Print print = new Print();

        print.f1((short) 1);
        print.f1((byte) 1);
        print.f1(1);
        print.f1((char) 1);

        print.f2((short) 1);
        print.f2((byte) 1);
        print.f2(1);
        print.f2((char) 1);

        /**
         * f1 short:1
         * f1 byte:1
         * f1 int:1
         * f1 char:
         * f2 int:1
         * f2 int:1
         * f2 int:1
         * f2 int:1
         *
         * 结论：如果重载方法有对应的类型，
         *      就直接匹配对应的类型，如果没有，
         *      就找大于实参类型的
         */

    }
}
