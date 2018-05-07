package com.noriental.book3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author dongyl
 * @date 14:50 2/20/18
 * @project study-demo
 */
public class CPUNotUseEffectiveDemo {
    private static int executeTimes = 10;
    private static int taskCount = 200;

    public static void main(String[] args) {
        if(args.length==1||args.length==2){
            taskCount=Integer.parseInt(args[0]);
        }
        if(args.length==2){
            executeTimes = Integer.parseInt(args[1]);
        }
        //TASK_THREAD_COUNT
        Task task = new Task();
        for (int i = 0; i < taskCount; i++) {
            task.addTask(Integer.toString(i));
        }
    }
    static class Task implements Runnable{
        List<String> tasks = new ArrayList<>();
        Random random = new Random();
        boolean exitFlag = false;
        public void addTask(String task){
            List<String> copyTasks = new ArrayList<>();
            copyTasks.add(task);
            tasks = copyTasks;
        }
        @Override
        public void run() {
            List<String> runTasks = tasks;
            List<String> removeTasks = new ArrayList<>();
            for (String task:runTasks){
                try{
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                removeTasks.add(task);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
