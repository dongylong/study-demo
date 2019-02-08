package com.designpattern;

/**
 * @author dongyl
 * @date 16:12 5/11/18
 * @project study-demo
 */
public class SingletonDemo {
    private static SingletonDemo singletonStack = null;
    private volatile static SingletonDemo singletonDoubleCheckLockPattern = null;
    private static SingletonDemo singletonStarving = new SingletonDemo();

    private static class SingletonHolder {
        private static final SingletonDemo SINGLETON_NESTED_CLASS = new SingletonDemo();
    }

    public enum singletonEnum {
        SINGLETON_ENUM;
    }

    public SingletonDemo() {
        System.out.println("单例模式开始调用构造函数");
    }

    public static SingletonDemo getInstanceStacking() {
        System.out.println("-->懒汉式单例模式开始调用公有方法返回实例");
        if (singletonStack == null) {
            System.out.println("-->懒汉式构造函数的实例当前并没有被创建");
            singletonStack = new SingletonDemo();
        } else {
            System.out.println("-->懒汉式构造函数的实例已经被创建");
        }
        System.out.println("-->方法调用结束，返回单例");
        return singletonStack;
    }

    public static synchronized SingletonDemo getInstanceSynchronizedStacking() {
        return getInstanceStacking();
    }

    /**
     * 给 instance 分配内存
     * 调用 Singleton 的构造函数来初始化成员变量
     * 将instance对象指向分配的内存空间（执行完这步 instance 就为非 null 了）
     * 但是在 JVM 的即时编译器中存在指令重排序的优化。
     * 上面的第二步和第三步的顺序是不能保证的,最终的执行顺序可能是1-2-3也可能是1-3-2.
     * 如果是后者,则在3执行完毕、2未执行之前，被线程二抢占了，这时instance已经是非null了（但却没有初始化），所以线程二会直接返回 instance，然后使用，然后顺理成章地报错。
     * 我们只需要将 instance 变量声明成 volatile 就可以了。volatile 的主要原因是其另一个特性：禁止指令重排序优化
     *
     * @return
     */
    public static SingletonDemo getInstanceDoubleCheckLockPattern() {
        if (singletonDoubleCheckLockPattern == null) {
            synchronized (SingletonDemo.class) {
                if (singletonDoubleCheckLockPattern == null) {
                    singletonDoubleCheckLockPattern = new SingletonDemo();
                }
            }
        }
        return singletonDoubleCheckLockPattern;
    }

    public static SingletonDemo getInstanceStarving() {
        System.out.println("-->饿汉式单例模式开始调用公有方法返回实例");
        return singletonStarving;
    }

    public static SingletonDemo getInstanceNestedClass() {
        return SingletonHolder.SINGLETON_NESTED_CLASS;
    }
}
