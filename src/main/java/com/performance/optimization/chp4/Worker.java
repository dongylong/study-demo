package com.performance.optimization.chp4;

import java.util.Map;
import java.util.Queue;

/**
 * @author dongyl
 * @date 13:32 10/27/18
 * @project study-demo
 */
public class Worker implements Runnable {
    /**
     * 任务队列，用于取得子任务
     */
    protected Queue<Object> workQueue;
    protected Map<String, Object> resultMap;

    public void setWorkQueue(Queue<Object> workQueue) {
        this.workQueue = workQueue;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    public Object handle(Object input) {
        return input;
    }

    @Override
    public void run() {
        while (true) {
            //获取子任务
            Object input = workQueue.poll();
            if (input == null) {
                break;
            }
            Object re = handle(input);
            resultMap.put(Integer.toString(input.hashCode()), re);
        }

    }
}