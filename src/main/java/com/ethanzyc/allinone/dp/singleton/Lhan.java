package com.ethanzyc.allinone.dp.singleton;

/**
 * 懒汉模式（非线程安全）
 *
 * @author ethan
 * @date 2019/12/17 13:52
 */
public class Lhan {
    private static Lhan lhan = null;

    public static Lhan getInstance() {
        if (lhan == null) {
            lhan = new Lhan();
        }
        return lhan;
    }
}
