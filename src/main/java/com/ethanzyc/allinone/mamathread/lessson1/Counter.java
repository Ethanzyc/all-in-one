package com.ethanzyc.allinone.mamathread.lessson1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ethan
 * @date 2019/11/8 08:58
 */
public class Counter {
    private AtomicInteger count = new AtomicInteger();

    public void add() {
        try {
            for (int i = 0; i < 100; i++) {
                Thread.sleep(100);
//                synchronized (this) {
//                count = count + 1;
                count.incrementAndGet();
                System.out.println(this.count);
//                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
