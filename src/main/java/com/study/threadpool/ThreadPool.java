package com.study.threadpool;

public interface ThreadPool {
    /**
     * 执行具体的task
     */
    void excute(Runnable task);

    /**
     * 销毁线程池
     */
    void destory();
}
