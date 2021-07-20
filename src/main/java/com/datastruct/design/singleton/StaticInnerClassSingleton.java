package com.datastruct.design.singleton;

/**
 * 静态内部类单例模式：基于类初始化的延迟加载方案
 * Class 对象的初始化锁
 */
public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton(){}

    /**
     * 静态内部类和非静态内部类一样，都不会因为外部内的加载而加载，同时静态内部类的加载不需要依附外部类，
     * 在使用时才加载，不过在加载静态内部类的过程中也会加载外部类
     */
    private static class InnerClass { // InnerClass 静态内部类的初始化锁被谁拿到
        private static StaticInnerClassSingleton staticInnerClassSingleton;
    }
    public static StaticInnerClassSingleton getInstance(){
        return InnerClass.staticInnerClassSingleton;
    }
}
