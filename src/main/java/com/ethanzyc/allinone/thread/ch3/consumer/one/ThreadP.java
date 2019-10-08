package com.ethanzyc.allinone.thread.ch3.consumer.one;

/**
 * @author ethan
 * @date 2019/10/7 09:33
 */
public class ThreadP extends Thread {
    private P p;

    public ThreadP(P p) {
        super();
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            p.setValue();
        }
    }
}
