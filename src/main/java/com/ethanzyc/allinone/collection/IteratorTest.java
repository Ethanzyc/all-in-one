package com.ethanzyc.allinone.collection;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author ethan
 * @date 2019/10/31 09:35
 */
public class IteratorTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Iterator<Integer> iterator = list.iterator();
        System.out.println(list);

        iterator.next();
        System.out.println(list);
        iterator.remove();
        System.out.println(list);
    }
}
