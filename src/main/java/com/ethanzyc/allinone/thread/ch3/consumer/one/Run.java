package com.ethanzyc.allinone.thread.ch3.consumer.one;

/**
 * @author ethan
 * @date 2019/10/7 09:39
 */
public class Run {
    public static void main(String[] args) {
        String lock = new String("");
        P p = new P(lock);
        C c = new C(lock);
        ThreadP threadP = new ThreadP(p);
        ThreadC threadC = new ThreadC(c);
        threadP.start();
        threadC.start();
    }
}
