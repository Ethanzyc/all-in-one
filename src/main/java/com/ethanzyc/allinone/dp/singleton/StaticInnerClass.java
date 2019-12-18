package com.ethanzyc.allinone.dp.singleton;

/**
 * 静态内部类
 *
 * @author ethan
 * @date 2019/12/17 14:05
 */
public class StaticInnerClass {

    public static StaticInnerClass getInstance() {
        return StaticInnerClassHolder.STATIC_INNER_CLASS;
    }

    public static class StaticInnerClassHolder {
        private static final StaticInnerClass STATIC_INNER_CLASS = new StaticInnerClass();
    }
}
