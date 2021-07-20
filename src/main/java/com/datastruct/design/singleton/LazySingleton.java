package com.datastruct.design.singleton;


/***
 * 懒汉模式 线程不安全
 */
public class LazySingleton {
    private static LazySingleton lazySingleton = null;
    private LazySingleton(){

    }
    public static LazySingleton getInstance(){
        if(lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

    /**改进方案*/
//    public synchronized static LazySingleton getInstance(){
//        if(lazySingleton == null){
//            lazySingleton = new LazySingleton();
//        }
//        return lazySingleton;
//    }
}
