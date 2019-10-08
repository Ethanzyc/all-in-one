package com.ethanzyc.allinone.thread.ch3.consumer.six;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ethan
 * @date 2019/10/8 08:04
 */
public class MyStack {
    private List list = new ArrayList();

    synchronized public void push() {
        try {
            while (list.size() == 1) {
                this.wait();
            }
            list.add("anyString=" + Math.random());
            this.notifyAll();
            System.out.println("push=" + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public String pop() {
        String returnValue = "";
        try {
            while (list.size() == 0) {
                System.out.println("pop 操作中的：" + Thread.currentThread().getName() + " 线程呈 wait 状态");
                this.wait();
            }
            returnValue = "" + list.get(0);
            list.remove(0);
            this.notifyAll();
            System.out.println("pop=" + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return returnValue;
    }
}
