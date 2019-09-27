package com.ethanzyc.allinone.thread.ch1;

/**
 * @author ethan
 * @date 2019/9/26 20:41
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int value = (int) Math.random() * 1000;
                Thread.sleep(value);
                System.out.println("run=" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.setName("myThread");
            myThread.start();
            for (int i = 0; i < 10; i++) {

                int value = (int) Math.random() * 1000;
                Thread.sleep(value);
                System.out.println("main=" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
