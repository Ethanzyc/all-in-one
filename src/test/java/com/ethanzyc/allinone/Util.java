package com.ethanzyc.allinone;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

/**
 * @author ethan
 * @date 2019/8/24 15:27
 */
public class Util {

    public static void test1(Stopwatch stopwatch) throws InterruptedException {

        String className = Thread.currentThread().getStackTrace()[2].getClassName();
        System.out.println(className);
        Thread.sleep(1000);

        long elapsed = stopwatch.elapsed(TimeUnit.MILLISECONDS);
        System.out.println(elapsed);

        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        System.out.println(methodName);
        Thread.sleep(3000);

        long elapsed2 = stopwatch.elapsed(TimeUnit.MILLISECONDS);

        System.out.println(elapsed2);
        stopwatch.reset();
    }
}
