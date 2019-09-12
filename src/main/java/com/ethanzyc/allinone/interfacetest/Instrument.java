package com.ethanzyc.allinone.interfacetest;

/**
 * @author ethan
 * @date 2019/9/12 08:20
 */
public interface Instrument {
    /**
     * 自动加 static final
     */
    int A = 3;

    default void play() {
        System.out.println("Instrument play");
        Inner inner = new Inner() {
            @Override
            public String getName() {
                return getClass().getName();
            }
        };
        String name = inner.getName();
        System.out.println("name:" + name);
    }

    void stop();

    Object start();

    interface Inner {
        String getName();
    }
}
