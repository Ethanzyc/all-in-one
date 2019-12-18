package com.ethanzyc.allinone.dp.singleton;

/**
 * 饿汉模式
 *
 * @author ethan
 * @date 2019/12/17 13:29
 */
public class Ehan {
    private static Ehan ehan = new Ehan();

    public static Ehan getInstance() {
        return ehan;
    }
}
