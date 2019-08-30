package com.ethanzyc.allinone.thread.happensbefore;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author ethan
 * @date 2019/8/29 09:13
 */
public class VolatileExample {
    int x = 0;
    boolean v = false;

    public void writer() {
        x = 42;
        v = true;
    }

    public void reader() {
        if (v == true) {
            if (x == 0) {
                System.out.println(x);
            }
        }
    }
}
