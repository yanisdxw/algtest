package com.datastruct.design.singleton;


/**
 * 双重检查：减少锁的使用
 */
public class LazyDoubleCheckSingleton {

    private static LazyDoubleCheckSingleton lazyDoubleCheckSingleton;
    //改进：内存可见性-->缓存一直性
    //private volatile static LazyDoubleCheckSingleton lazyDoubleCheckSingleton;

    private LazyDoubleCheckSingleton(){};

    public static LazyDoubleCheckSingleton getInstance(){
        if(lazyDoubleCheckSingleton==null){
            synchronized (LazyDoubleCheckSingleton.class){
                if(lazyDoubleCheckSingleton==null){
                    //指令重排 可以变成 1 3 2
                    //1. 分配内存对象
                    //2. 初始化对象
                    //3. 设置对象 指向刚分配的内存地址
                    lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazyDoubleCheckSingleton;
    }

}
