package com.ethanzyc.allinone.thread.happensbefore;

/**
 * @author ethan
 * @date 2019/8/29 12:49
 */
public class TestVolatile {

    public static void main(String[] args) {
        VolatileExample example = new VolatileExample();
        new Thread(new Runnable() {
            @Override
            public void run() {
                example.writer();
                example.reader();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                example.reader();
                example.writer();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                example.writer();
                example.reader();
            }
        }).start();
    }

}
