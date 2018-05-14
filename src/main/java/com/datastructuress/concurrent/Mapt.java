package com.datastructuress.concurrent;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dongyl
 * @date 15:08 5/12/18
 * @project study-demo
 */
public class Mapt {
    public static void main(String[] args) {
        Map map = new HashMap(16);
        Map<Object, Object> xxx = Collections.synchronizedMap(map);
    }
}
