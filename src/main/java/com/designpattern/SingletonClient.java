package com.designpattern;

public class SingletonClient {
    public static void main(String[] args) {
        slackSingleton();
    }

    private static void staringSingleton(){
        System.out.println("-----------------饿汉式单例模式----------------");
        System.out.println("第一次取得实例（饿汉式）");
        SingletonDemo s1 = SingletonDemo.getInstanceStarving();
        System.out.println("第二次取得实例（饿汉式）");
        SingletonDemo s2 = SingletonDemo.getInstanceStarving();
        if(s1==s2){
            System.out.println(">>>>>s1,s2为同一实例（饿汉式）<<<<<");
        }
        System.out.println();
    }
    private static void slackSingleton(){
        System.out.println("-----------------懒汉式单例模式----------------");
        System.out.println("第一次取得实例（懒汉式）");
        SingletonDemo slacker1 = SingletonDemo.getInstanceStacking();
        System.out.println("第二次取得实例（懒汉式）");

        SingletonDemo slacker2 = SingletonDemo.getInstanceStacking();
        if (slacker1 == slacker2) {
            System.out.println(">>>>>slacker1,slacker2为同一实例（懒汉式）<<<<<");
        }
        System.out.println();
    }
}
