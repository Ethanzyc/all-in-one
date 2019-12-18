package com.ethanzyc.allinone.dp.singleton;

/**
 * 双重校验锁（DCL）线程安全
 *
 * @author ethan
 * @date 2019/12/17 13:52
 */
public class LhanDoubleCheck {
    private volatile static LhanDoubleCheck lhan = null;

    public static LhanDoubleCheck getInstance() {
        if (lhan == null) {
            synchronized (LhanDoubleCheck.class) {
                if (lhan == null) {
                    lhan = new LhanDoubleCheck();
                }
            }
        }
        return lhan;
    }
}
