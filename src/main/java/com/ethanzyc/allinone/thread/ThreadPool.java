package com.ethanzyc.allinone.thread;

import com.google.common.util.concurrent.Uninterruptibles;
import org.aspectj.weaver.ast.Var;

import java.util.concurrent.*;

/**
 * @author ethan
 * @date 2019/8/14 11:19
 */
public class ThreadPool {
//    public static void main(String[] args) {
//        Thread thread = new Thread(() -> {
//            Thread nowThread = Thread.currentThread();
//            System.out.println("线程id-" + nowThread.getId() + "-name-" + nowThread.getName());
//            Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
//            System.out.println(1 / 0); // 这行会导致报错！
//        });
//        thread.setUncaughtExceptionHandler((t, e) -> {
//            e.printStackTrace(); //如果你把这一行注释掉，这个程序将不会抛出任何异常.
//
//
//        });
//
//        thread.start();
//
//
//
//    }

    public static void main(String[] args) {
//        ExecutorService executor = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 20, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        for (int i = 0; i < 10000; i++) {
            threadPoolExecutor.execute(() -> System.out.println(Thread.currentThread().getName()));
            threadPoolExecutor.shutdown();
        }
    }


}
