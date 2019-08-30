package com.ethanzyc.allinone.thread.happensbefore;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ethan
 * @date 2019/8/29 12:52
 */
public class Counter {

    private AtomicInteger count = new AtomicInteger(0);

    public void add() {
        for (int i = 0; i < 200; i++) {
            try {
                Thread.sleep(20);
                System.out.println(this.count.incrementAndGet());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
