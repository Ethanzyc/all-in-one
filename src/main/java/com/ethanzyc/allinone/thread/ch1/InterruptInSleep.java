package com.ethanzyc.allinone.thread.ch1;

/**
 * @author ethan
 * @date 2019/9/27 08:27
 */
public class InterruptInSleep extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            System.out.println("run begin");
            Thread.sleep(20000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("catch");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            InterruptInSleep interrupt = new InterruptInSleep();
            interrupt.start();
            System.out.println("是否停止1：" + interrupt.isInterrupted());
            System.out.println("========start==========");
            Thread.sleep(20);
            System.out.println("========end==========");
            interrupt.interrupt();
            System.out.println("是否停止2：" + interrupt.isInterrupted());
            System.out.println("是否停止3：" + interrupt.isInterrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
