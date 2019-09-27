package com.ethanzyc.allinone.thread.ch1;

/**
 * @author ethan
 * @date 2019/9/27 09:24
 */
public class Yield extends Thread {
    @Override
    public void run() {
        super.run();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Thread.yield();
        }
        long end = System.currentTimeMillis();
        System.out.println("消耗时间：" + (end - start));
    }

    public static void main(String[] args) {
        Yield yield = new Yield();
        yield.start();
    }
}
