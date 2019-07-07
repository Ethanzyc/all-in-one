package com.ethanzyc.allinone;

import java.math.BigDecimal;

/**
 * @author ethan
 * @date 2019/7/3 07:24
 */
public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal a = BigDecimal.valueOf(-12.445);
        BigDecimal bigDecimal = a.setScale(2, BigDecimal.ROUND_DOWN);
        BigDecimal bigDecimal1 = a.setScale(2, BigDecimal.ROUND_FLOOR);
        System.out.println(bigDecimal);
        System.out.println(bigDecimal1);
    }
}
