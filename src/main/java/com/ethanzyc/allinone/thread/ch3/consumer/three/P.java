package com.ethanzyc.allinone.thread.ch3.consumer.three.two;

/**
 * @author ethan
 * @date 2019/10/6 21:16
 */
public class P {
    private String lock;

    public P(String lock) {
        super();
        this.lock = lock;
    }

    public void setValue() {
        try {
            synchronized (lock) {
                while (!ValueObject.value.equals("")) {
                    System.out.println("生产者 " + Thread.currentThread().getName() + "WAITING 了⭐️");
                    lock.wait();
                }
                System.out.println("生产者 " + Thread.currentThread().getName() + "RUNNING 了️️");
                String value = System.currentTimeMillis() + "_" + System.nanoTime();
//                System.out.println("set的值是 " + value);
                ValueObject.value = value;
                lock.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
