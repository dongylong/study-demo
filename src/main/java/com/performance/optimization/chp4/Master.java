package com.performance.optimization.chp4;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author dongyl
 * @date 13:28 10/27/18
 * @project study-demo
 */
public class Master {
    protected Queue<Object> workQueue = new ConcurrentLinkedDeque<>();
    protected Map<String, Thread> threadMap = new HashMap<>();
    protected Map<String, Object> resultMap = new ConcurrentHashMap<>();

    public boolean isComplete() {
        for (Map.Entry<String, Thread> entyry : threadMap.entrySet()) {
            if (entyry.getValue().getState() != Thread.State.TERMINATED) {
                return false;
            }
        }
        return true;
    }

    public Master(Worker worker, int countWorker) {
        worker.setWorkQueue(workQueue);
        worker.setResultMap(resultMap);
        for (int i = 0; i < countWorker; i++) {
            threadMap.put(Integer.toString(i), new Thread(worker, Integer.toString(i)));
        }
    }

    /**
     * 提交一个任务
     */
    public void submit(Object job) {
        workQueue.add(job);
    }

    /**
     * 返回任务结果集
     */
    public Map<String, Object> getResultMap() {
        return resultMap;
    }

    /**
     * 开始国有Worker进程，进行处理
     */
    public void execute() {
        for (Map.Entry<String, Thread> entry : threadMap.entrySet()) {
            entry.getValue().start();
        }
    }

    public static void main(String[] args) {
        Master m = new Master(new PlusWorker(), 5);
        for (int i = 1; i < 101; i++) {
            m.submit(i);
        }
        m.execute();
        int re = 0;
        Map<String, Object> resultMap = m.getResultMap();
        while (resultMap.size() > 0 || !m.isComplete()) {
            Set<String> keys = resultMap.keySet();
            String key = null;
            for (String k : keys) {
                key = k;
                break;
            }
            Integer i = null;
            if (key != null) {
                i = (Integer) resultMap.get(key);
            }
            if (i != null) {
                Integer before = re;
                re += i;
                System.out.println("thread: " + Thread.currentThread().getName() + " before:" + before + "+ i : " + i + " = re : " + re);
            }
            if (key != null) {
                resultMap.remove(key);
            }
        }
        System.out.println("re:" + re);
    }
}