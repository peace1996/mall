package com.mall.mallcenter.pojo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomBlockThreadPoolExecutor {
    private ThreadPoolExecutor pool = null;
    private final  int  poolSize=10;
    private final  int  maxPoolSize=15;
    private final  Long  keepAliveTime=30L;
    private final  int  arrayBlockingQueueSize=30;

    /**
     * 线程池初始化方法
     *
     * corePoolSize 核心线程池大小----2
     * maximumPoolSize 最大线程池大小----4
     * keepAliveTime 线程池中超过corePoolSize数目的空闲线程最大存活时间----30+单位TimeUnit
     * TimeUnit keepAliveTime时间单位----TimeUnit.MINUTES
     * workQueue 阻塞队列----new ArrayBlockingQueue<Runnable>(10)==== 10容量的阻塞队列
     * threadFactory 新建线程工厂----new CustomThreadFactory()====定制的线程工厂
     * rejectedExecutionHandler 当提交任务数超过maxmumPoolSize+workQueue之和时,
     * 即当提交第15个任务时(前面线程都没有执行完,此测试方法中用sleep(100)),任务会交给RejectedExecutionHandler来处理
     */

    public void init() {
        pool = new ThreadPoolExecutor(poolSize,maxPoolSize,keepAliveTime,
                TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(arrayBlockingQueueSize),new CustomThreadFactory(), new CustomRejectedExecutionHandler());
    }

    public void destory() {
        if(pool !=null) {
            pool.shutdownNow();
        }
    }

    public ExecutorService getCustomThreadPoolExecutor() {
        return this.pool;
    }


    /**
     * 自定义线程工厂类
     * 生成的线程名词前缀、是否为守护线程以及优先级等
     */
    private class CustomThreadFactory implements ThreadFactory {

        private AtomicInteger count = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            String threadName =  CustomBlockThreadPoolExecutor.class.getSimpleName()+count.addAndGet(1);
            t.setName(threadName);
            return t;
        }
    }


    /**
     * 自定义拒绝策略对象
     */
    private class CustomRejectedExecutionHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            //核心改造点,将blockingqueue的offer改成put阻塞提交
            try {
                executor.getQueue().put(r);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
