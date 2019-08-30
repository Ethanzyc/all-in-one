package com.ethanzyc.allinone.thread.happensbefore;

/**
 * @author ethan
 * @date 2019/8/29 12:54
 */
public class CounterTest {

    public static void main(String[] args) {

        Counter counter = new Counter();

        new Thread(new Runnable() {
            @Override
            public void run() {
                counter.add();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                counter.add();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                counter.add();
            }
        }).start();

    }


}
