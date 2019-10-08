package com.ethanzyc.allinone.thread.ch3.consumer.six;

/**
 * @author ethan
 * @date 2019/10/7 09:33
 */
public class ThreadC extends Thread {
    private C c;

    public ThreadC(C c) {
        super();
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            c.popService();
        }
    }
}
