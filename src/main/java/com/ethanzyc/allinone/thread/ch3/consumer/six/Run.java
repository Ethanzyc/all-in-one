package com.ethanzyc.allinone.thread.ch3.consumer.six;

/**
 * @author ethan
 * @date 2019/10/7 09:39
 */
public class Run {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        P p1 = new P(myStack);
        P p2 = new P(myStack);
        P p3 = new P(myStack);
        P p4 = new P(myStack);
        P p5 = new P(myStack);
        C c1 = new C(myStack);
        ThreadP threadP1 = new ThreadP(p1);
        ThreadP threadP2 = new ThreadP(p2);
        ThreadP threadP3 = new ThreadP(p3);
        ThreadP threadP4 = new ThreadP(p4);
        ThreadP threadP5 = new ThreadP(p5);
        threadP1.start();
        threadP2.start();
        threadP3.start();
        threadP4.start();
        threadP5.start();
        ThreadC threadC1 = new ThreadC(c1);
        threadC1.start();
    }
}
