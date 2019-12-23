package com.ethanzyc.allinone.map;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @author ethan
 * @date 2019/12/23 08:54
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(null, null);
        System.out.println(hashMap.get(null));
        System.out.println(hashMap.containsKey(null));
        System.out.println(hashMap.containsValue(null));
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        hashtable.put(1, null);
        System.out.println(hashtable.get(null));
        System.out.println(hashtable.containsKey(null));
        System.out.println(hashtable.containsValue(null));
    }
}
