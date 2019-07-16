package com.design_patterns.singleton.type1;

public class SingletonTest01 {

    public static void main(String[] args) {
        //测试
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }

}

/**
 *     饿汉式(静态变量)
 *
 * 缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始
 至终从未使用过这个实例，则会造成内存的浪费

 这种方式基于classloder机制避免了多线程的同步问题，

 这种单例模式可用，可能造成内存浪费

 *     */

class Singleton {

    //1. 构造器私有化, 外部能new
    private Singleton() {

    }

    //2.本类内部创建对象实例
    private final static Singleton instance = new Singleton();

    //3. 提供一个公有的静态方法，返回实例对象
    public static Singleton getInstance() {
        return instance;
    }

}