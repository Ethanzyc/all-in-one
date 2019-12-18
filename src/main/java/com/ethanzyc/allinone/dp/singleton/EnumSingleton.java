package com.ethanzyc.allinone.dp.singleton;

/**
 * 枚举
 *
 * @author ethan
 * @date 2019/12/17 14:10
 */
public enum EnumSingleton {
    SINGLETON;

    EnumSingleton() {
    }

    public void test() {
        System.out.println("test EnumSingleton");
    }
}
