package com.ethanzyc.allinone.interfacetest;

/**
 * @author ethan
 * @date 2019/9/12 08:20
 */
public interface Instrument2 {
    default void play() {
        System.out.println("Instrument2 play");
    }

    void stop2();

    Object start();
}
