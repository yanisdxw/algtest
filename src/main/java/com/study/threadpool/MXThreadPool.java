package com.study.threadpool;

import com.study.blockingqueue.BlockingQueue;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ThreadFactory;

public class MXThreadPool extends Thread implements ThreadPool {


    //任务【阻塞】队列，被提交但尚未被执行的任务
    private BlockingQueue<Runnable> taskQueue;
    //表示生成线程池中工作线程的线程工厂
    private ThreadFactory threadFactory;
    //最大线程数
    private int maxSize;
    //核心线程数
    private int coreSize;
    //线程存活时间
    private long keepAliveTime;
    //当前活跃线程的数量
    private int activeCount;
    //存放工作线程的容器
    private final Set<WorkerThread> workers = new HashSet();

    //初始化线程池
    public MXThreadPool(int maxSize, int coreSize, BlockingQueue blockingQueue,
                        ThreadFactory threadFactory, long keepAliveTime){
        this.maxSize = maxSize;
        this.coreSize = coreSize;
        this.taskQueue = blockingQueue;
        this.threadFactory = threadFactory;
        this.keepAliveTime = keepAliveTime;
        this.activeCount = 0;
    }

    //创建新的任务线程并启动
    private void newThread() {
        WorkerThread workThread = new WorkerThread("thead_"+this.activeCount++, threadFactory);
        workThread.start();
        workers.add(workThread);
    }

    //移除一个工作线程
    private void removeThread() {
        Iterator<WorkerThread> iterator = workers.iterator();
        if(iterator.hasNext()){
            WorkerThread workerThread = iterator.next();
            workerThread.stopWork();
            this.activeCount--;
        }
    }

    @Override
    public void run() {
        //自动维护线程池
        while (!isInterrupted()) {
            try {
                Thread.sleep(keepAliveTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
            synchronized (this) {
                //当任务队列大于0，活跃线程小于核心线程的时候，扩容线程
                if (taskQueue.size() > 0 && activeCount < coreSize) {
                    for (int i = 0; i < coreSize-activeCount; i++) {
                        newThread();
                    }
                    continue;
                }
                if (taskQueue.size() > 0 && activeCount < maxSize) {
                    for (int i = 0; i < maxSize-activeCount; i++) {
                        newThread();
                    }
                }
                if (taskQueue.size() == 0 && activeCount > coreSize) {
                    for (int i = 0; i < activeCount-coreSize; i++) {
                        removeThread();
                    }
                }

            }
        }
    }


    //工作线程类
    private class WorkerThread extends Thread{

        public WorkerThread(String name, ThreadFactory factory){
            setName(name);
            factory.newThread(this);
        }

        @Override
        public void run() {
            Runnable runnable = null;
            try {
                while (! isInterrupted()) {  //如果没有被标记中断，则从对阻塞队列中取出任务执行
                    runnable = taskQueue.get();  //take：阻塞接口的移除方法
                    if (runnable != null) {
                        System.out.println("Thread ID:" + getName() + " ready exec:" + runnable.toString());
                        runnable.run();
                    }
                    runnable = null;  //help gc
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        //线程停止工作
        public void stopWork() {
            interrupt();
        }
    }

    @Override
    public void excute(Runnable task) {

        try {
            taskQueue.put(task);   //put:阻塞接口的插入
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public void destory() {
        for(WorkerThread workerThread:workers){
            workerThread.stopWork();
        }
    }

}
