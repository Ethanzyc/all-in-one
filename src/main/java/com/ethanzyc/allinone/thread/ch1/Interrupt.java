package com.ethanzyc.allinone.thread.ch1;

/**
 * @author ethan
 * @date 2019/9/27 08:27
 */
public class Interrupt extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 500000; i++) {
                if (this.isInterrupted()) {
                    System.out.println("退出");
                    //                break;
                    throw new InterruptedException();
                }
                System.out.println("i=" + (i + 1));
            }
            System.out.println("for 外面");
        } catch (InterruptedException e) {
            System.out.println("catch");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Interrupt interrupt = new Interrupt();
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
