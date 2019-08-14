package com.ethanzyc.allinone.thread;

/**
 * @author ethan
 * @date 2019/8/14 11:53
 */
public class TestThread extends Thread {
    @Override
    public void run() {
        System.out.println("这里是线程的执行方法");
    }

    public static void main(String[] args) {
        TestThread thread = new TestThread();
        thread.start();
    }
}
