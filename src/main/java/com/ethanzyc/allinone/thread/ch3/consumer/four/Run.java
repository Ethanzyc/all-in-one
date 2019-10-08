package com.ethanzyc.allinone.thread.ch3.consumer.four;

/**
 * @author ethan
 * @date 2019/10/7 09:39
 */
public class Run {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        P p = new P(myStack);
        C c = new C(myStack);
        ThreadP threadP = new ThreadP(p);
        ThreadC threadC = new ThreadC(c);
        threadP.start();
        threadC.start();
    }
}
