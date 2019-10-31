package com.ethanzyc.allinone;

import org.junit.Test;

/**
 * @author ethan
 * @date 2019/10/10 08:52
 */
public class WhileTest {
    boolean a = true;

    @Test
    public void testWhile() {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    a = false;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        int count = 0;
        while (a) {
            count++;
            System.out.println("a=" + a);
        }
        System.out.println("a=" + a);
        System.out.println("count=" + count);
        System.out.println("=========end==========");
    }
}
