package com.jvm;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author dongyl
 * @date 18:34 5/13/18
 * @project study-demo
 */
public class ClassExecutor {

    private void exe() {
        Point point = new Point(1, 2);
        System.out.println("point.x: " + point.x + "point.y: " + point.y);
    }

    public static void main(String[] args) throws Exception {
        Class actionClass = Class.forName("com.jvm.interfaceDemo");
        Method method=null;
        try {
            method = actionClass.getMethod("demo1", null);
            Object action1 = actionClass.newInstance();
            method.invoke(action1, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Constructor constructor = actionClass.getConstructor(actionClass);
            Object action = constructor.newInstance();
            method.invoke(action, null);
        }catch (Exception e){
            e.printStackTrace();

        }
        System.out.println(method);
    }
//    private void reflect() throws Exception {
//        Class actionClass = Class.forName("ConcurrentStack");
//        Method method = actionClass.getMethod("name", null);
//        Constructor constructor = actionClass.getConstructor(actionClass);
//        Object action = constructor.newInstance();
//        Object action1 = actionClass.newInstance();
//        method.invoke(action, null);
//        method.invoke(action1, null);
//        System.out.println(method);
//    }
}
