package com.performance.optimization.chp4;

/**
 * @author dongyl
 * @date 13:32 10/27/18
 * @project study-demo
 */
public class PlusWorker extends Worker{
    @Override
    public Object handle(Object input) {
        Integer i = (Integer) input;
        System.out.println("thread:"+Thread.currentThread().getName()+",i:"+i);
        return i;
    }

}
