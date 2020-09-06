package com.acmday.java.server.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author acmday.
 * @date 2019/5/15.
 */
@Slf4j
public class ThreadPoolUtil {

    public static ExecutorService executor= new ThreadPoolExecutor(64, 64, 10L,
            TimeUnit.MINUTES,
            new LinkedBlockingQueue<>(256),
            new ThreadFactoryBuilder().setNameFormat(" thread_%d").build(),
            new AbortPolicy()
    );

    /**
     * 线程池队列满后的拒绝策略
     */
    private static class AbortPolicy implements RejectedExecutionHandler {
        // 抛出异常
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            throw new RejectedExecutionException("Task " + r.toString() +  " rejected from " +  e.toString());
        }
    }


}
