package com.study.blockingqueue;

public interface BlockingQueue<E> {
    /**
     * 往队列尾部添加一个元素，当队列满时阻塞当前线程
     * @param e
     */
    void put(E e);

    /**
     * 从队列首部取走一个元素，当队列为空时阻塞当前线程
     * @return
     */
    E get();

    // 返回队列中元素的数量
    int size();
}
