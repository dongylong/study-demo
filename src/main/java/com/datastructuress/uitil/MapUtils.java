package com.datastructuress.uitil;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author dongyl
 * @date 18:12 5/8/18
 * @project study-demo
 */
public class MapUtils {
    /**
     * +Map 接口
     * -HashMap 类 (除了不同步和允许使用 null 键/值之外,与 Hashtable 大致相同.)
     * -Hashtable 类 此类是实现同步的,不允许使用 null 键值
     * +SortedMap 接口
     * -TreeMap 类
     *
     * @param hashMap
     */
    private static void MapIterator(HashMap hashMap) {
        Set<Map.Entry<String, String>> entries = hashMap.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String content = entry.getValue();
        }
    }
}
