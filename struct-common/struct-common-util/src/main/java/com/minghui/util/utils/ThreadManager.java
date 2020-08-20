package com.minghui.util.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author:chenql
 * @Description: 提供统一的线程池管理工具类
 * @Date:Created in 13:57 2018-09-13
 * @Modified By:
 */
@Slf4j
public final class ThreadManager {

    /**
     * 每次CPU最多100个线程
     */
    private int poolSize = 40;

    /**
     * 默认最大线程为CPU个数 * 单个CPU的线程数
     */
    private int defaultMaxPoolSize = Runtime.getRuntime().availableProcessors() * poolSize;

    /**
     * 自定义设置线程个数
     */
    private int corePoolSize=Runtime.getRuntime().availableProcessors() * poolSize;

    /**
     * 持续活动时间,毫秒级
     */
    private long keepAliveTime=60000;

    private ThreadManager(){
        synchronized (ThreadManager.class){
            poolExecutor = new ThreadPoolExecutor(
                    // 核心线程数量
                    corePoolSize,
                    // 最大线程数量
                    defaultMaxPoolSize,
                    // 当线程空闲时,保持活跃的时间
                    keepAliveTime,
                    // 时间单元,毫秒级
                    TimeUnit.MILLISECONDS,
                    // 线程任务队列
                    new LinkedBlockingQueue<>()
            );
        }
    }

    private static ThreadManager instance;

    public synchronized static ThreadManager getInstance(){
        if(instance == null){
            instance = new ThreadManager();
        }
        return instance;
    }

    private ThreadPoolExecutor poolExecutor;

    public void shutdown(){
        if (instance != null){
            instance.poolExecutor.shutdown();
        }
    }

    public void shutdownNow(){
        if (instance != null){
            instance.poolExecutor.shutdownNow();
        }
    }

    /**
     * 对外提供一个执行任务的方法
     * @param runnable
     */
    public void execute(Runnable runnable){
        if(log.isDebugEnabled()){
            log.debug("{}----当前线程池活动的线程数为:{},目前还有{}数据在队列中,已完成的任务数{}",Thread.currentThread().getName()
                    ,poolExecutor.getActiveCount(),poolExecutor.getQueue().size(),poolExecutor.getCompletedTaskCount());
        }
        poolExecutor.execute(runnable);
    }

    /**
     * 对外提供多个执行任务的方法
     * @param runnables
     */
    public void execute(List<Runnable> runnables){
        Collections.synchronizedCollection(runnables).parallelStream().forEach(runnable -> {
            if(log.isDebugEnabled()){
                log.debug("{}----当前线程池活动的线程数为:{},目前还有{}数据在队列中,已完成的任务数{}",Thread.currentThread().getName()
                        ,poolExecutor.getActiveCount(),poolExecutor.getQueue().size(),poolExecutor.getCompletedTaskCount());
            }
            poolExecutor.execute(runnable);
        });
    }

    public Future submitCallable(Callable callable,boolean isSysc) {
        Future future = poolExecutor.submit(callable);
        if(log.isDebugEnabled()){
            log.debug("{}----当前线程池活动的线程数为:{},目前还有{}数据在队列中,已完成的任务数{}",Thread.currentThread().getName()
                    ,poolExecutor.getActiveCount(),poolExecutor.getQueue().size(),poolExecutor.getCompletedTaskCount());
        }
        if(isSysc){
            try {
                future.get();
            } catch (Exception e) {
               log.error("{}",Thread.currentThread().getName(),e);
            }
        }
        return future;
    }

    /**
     * 对外提供有返回内容的方法
     * @param callables
     * @return
     */
    public List<Future> submitCallables(List<Callable> callables, boolean isSysc){
        List<Future> futures = new ArrayList<>();
        Collections.synchronizedCollection(callables).parallelStream().forEach(callable -> {
            if(log.isDebugEnabled()){
                log.debug("{}----当前线程池活动的线程数为:{},目前还有{}数据在队列中,已完成的任务数{}",Thread.currentThread().getName()
                        ,poolExecutor.getActiveCount(),poolExecutor.getQueue().size(),poolExecutor.getCompletedTaskCount());
            }
            futures.add(poolExecutor.submit(callable));
        });
        if(isSysc){
            futures.forEach(future -> {
                try {
                    future.get();
                } catch (Exception e) {
                    log.error("执行线程出错..",e);
                }
            });
        }
        return futures;
    }

}
