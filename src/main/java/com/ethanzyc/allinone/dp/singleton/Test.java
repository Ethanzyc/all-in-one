package com.ethanzyc.allinone.dp.singleton;

import org.springframework.util.Assert;

/**
 * @author ethan
 * @date 2019/12/17 13:35
 */
public class Test {
    public static void main(String[] args) {
        Ehan ehan1 = Ehan.getInstance();
        Ehan ehan2 = Ehan.getInstance();
        Assert.isTrue(ehan1 == ehan2, "ehan1 == ehan2 不是单例");
        Lhan lhan1 = Lhan.getInstance();
        Lhan lhan2 = Lhan.getInstance();
        Assert.isTrue(lhan1 == lhan2, "lhan1 == lhan2 不是单例");
        LhanSynchronized lhanSynchronized1 = LhanSynchronized.getInstance();
        LhanSynchronized lhanSynchronized2 = LhanSynchronized.getInstance();
        Assert.isTrue(lhanSynchronized1 == lhanSynchronized2, "lhanSynchronized1 == lhanSynchronized2 不是单例");
        LhanDoubleCheck lhanDoubleCheck1 = LhanDoubleCheck.getInstance();
        LhanDoubleCheck lhanDoubleCheck2 = LhanDoubleCheck.getInstance();
        Assert.isTrue(lhanDoubleCheck1 == lhanDoubleCheck2, "lhanDoubleCheck1 == lhanDoubleCheck2 不是单例");
        StaticInnerClass staticInnerClass1 = StaticInnerClass.getInstance();
        StaticInnerClass staticInnerClass2 = StaticInnerClass.getInstance();
        Assert.isTrue(staticInnerClass1 == staticInnerClass2, "staticInnerClass1 == staticInnerClass2 不是单例");
        EnumSingleton enumSingleton1 = EnumSingleton.SINGLETON;
        EnumSingleton enumSingleton2 = EnumSingleton.SINGLETON;
        Assert.isTrue(enumSingleton1 == enumSingleton2, "enumSingleton1 == enumSingleton2 不是单例");
    }
}
