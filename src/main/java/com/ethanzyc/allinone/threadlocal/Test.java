package com.ethanzyc.allinone.threadlocal;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author ethan
 * @date 2019/12/18 08:15
 */
public class Test {
    public static final String lock = "aaa";

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                User user = new User();
                user.setId(finalI);
                user.setName("" + finalI);
                UserContext.setUserThreadlocal(user);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                User userThreadlocal = UserContext.getUserThreadlocal();
                synchronized (lock) {
                    System.out.println("i:" + finalI);
                    System.out.println("user:" + userThreadlocal);
                    System.out.println("threadLocal:" + UserContext.USER_THREAD_LOCAL.hashCode());
                }
            }).start();
        }
    }
}
