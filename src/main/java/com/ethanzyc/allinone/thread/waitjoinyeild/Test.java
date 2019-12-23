package com.ethanzyc.allinone.thread.waitjoinyeild;

/**
 * @author ethan
 * @date 2019/12/22 11:08
 */
public class Test {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("t1");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("t2");

            for (int i = 0; i < 100; i++) {
                System.out.println(i);
                if (i == 50) {
                    System.out.println("======50======");
                    Thread.yield();
                }
            }
        });

        t2.start();
        t1.start();

    }
}
