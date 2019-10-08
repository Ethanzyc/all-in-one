package com.ethanzyc.allinone.thread.ch3.consumer.two;

/**
 * @author ethan
 * @date 2019/10/7 09:31
 */
public class C {
    private String lock;

    public C(String lock) {
        super();
        this.lock = lock;
    }

    public void getValue() {
        try {
            synchronized (lock) {
                while (ValueObject.value.equals("")) {
                    System.out.println("消费者 " + Thread.currentThread().getName() + "WAITING 了⭐️");
                    lock.wait();
                }
                System.out.println("消费者 " + Thread.currentThread().getName() + "RUNNING 了️");
//                System.out.println("get的值是 " + ValueObject.value);
                ValueObject.value = "";
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
