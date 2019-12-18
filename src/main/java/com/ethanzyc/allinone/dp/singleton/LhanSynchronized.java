package com.ethanzyc.allinone.dp.singleton;

/**
 * 懒汉模式（线程安全）
 *
 * @author ethan
 * @date 2019/12/17 13:52
 */
public class LhanSynchronized {
    private static LhanSynchronized lhan = null;

    public static synchronized LhanSynchronized getInstance() {
        if (lhan == null) {
            lhan = new LhanSynchronized();
        }
        return lhan;
    }
}
