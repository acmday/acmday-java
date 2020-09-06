package com.acmday.java.server.java;

import org.junit.jupiter.api.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author acmday.
 * @date 2020/9/5.
 */
public class LongUnit {

    @Test
    public void valueOf() {
        Long value = 911L;
        System.out.println(value.valueOf(10));
    }

    @Test
    public void getValue() {
        Long a = 911L;
        Long b = 911L;
        System.out.println(a.equals(b));

        Long c = 11L;
        Long d = 11L;
        System.out.println(c.equals(d));
    }

    @Test
    public void oneThread() {
//        Long a = 911L;
//        Long b = 911L;

        Long a = 11L;
        Long b = 11L;

        /**
         * 这个不能验证可重入性，因为是对同一个方法串行执行。如果要验证可重入性，可以再创建一个方法让sync去调用
         */
        sync(a);
        sync(a);
    }

    /**
     * 测试对a、b加锁，看synchronized是否能让两个线程互斥访问。答案是：不能。
     */
    @Test
    public void testSync() {
        Long a = 911L;
        Long b = 911L;

        CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("___________ over! ___________");
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                sync(a);
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }, "one").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                sync(b);
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }, "second").start();

        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void sync(Long value) {
        synchronized (value) {
            System.out.println("ThreadName="+Thread.currentThread().getName() + " sysTime=" + System.currentTimeMillis());
            try {
                //Thread.sleep(1000*60*60);
                Thread.sleep(1000*5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
