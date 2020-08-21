package sample.concurrent;

/**
 * Created by mzxiao on 2020/7/23 10:54
 * 双重校验锁实现对象单例（线程安全）
 * uniqueInstance声明为volatile很有必要，uniqueInstance = new Singleton()是分三步执行的。
 * 1. 分配内存空间
 * 2. 初始化uniqueInstance
 * 3. 将uniqueInstance指向内存地址
 *
 * 因为JVM有指令重排的特性，可能会变成3,1,2。在单线程的环境没有问题，若在多线程的环境则可能出错，
 * 加volatile禁止指令重排，保证在多线程环境也能正常运行。
 *
 */
public class Singleton {
    private static volatile Singleton uniqueInstance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
