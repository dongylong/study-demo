package com.jvm.thread;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dongyl
 * @date 18:17 6/7/18
 * @project study-demo
 */
public class Top100 {

    private Map<Integer, Integer> hashMap = new HashMap();

    private void put(int i) {
        int sum = 1;
        if (hashMap.containsKey(i)) {
            sum = hashMap.get(i);
        }
        hashMap.put(i, sum);
    }
}
