package com.study.threadpool;

import com.study.blockingqueue.BlockingQueue;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadFactory;

public class MThreadPool implements ThreadPool {

    //线程数量
    private int workNum;
    //任务数量
    private int taskNum;
    //任务【阻塞】队列，被提交但尚未被执行的任务
    private BlockingQueue<Runnable> taskQueue;
    //表示生成线程池中工作线程的线程工厂
    private ThreadFactory threadFactory;


    //存放工作线程的容器
    private final Set<WorkerThread> workers = new HashSet();

    //初始化线程池
    public MThreadPool(int workNum, BlockingQueue blockingQueue, ThreadFactory threadFactory){
        this.workNum = workNum;
        this.taskQueue = blockingQueue;
        this.threadFactory = threadFactory;
        initWorker();
    }

    public void initWorker(){
        //启动一定数量的线程数，从队列中获取任务处理
        for (int i=0;i<workNum;i++) {
            WorkerThread workThread = new WorkerThread("thead_"+i, threadFactory);
            workThread.start();
            workers.add(workThread);
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
