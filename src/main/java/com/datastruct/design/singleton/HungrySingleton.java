package com.datastruct.design.singleton;

/**
 * 饿汉模式：类加载时初始化
 */
public class HungrySingleton {
    private final static HungrySingleton hungrySingleton = new HungrySingleton();
    private HungrySingleton(){

    }
    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }
}
