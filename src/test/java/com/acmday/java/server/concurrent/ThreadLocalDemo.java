package com.acmday.java.server.concurrent;

import org.junit.jupiter.api.Test;

/**
 * @author acmday.
 * @date 2020/8/27.
 */
public class ThreadLocalDemo {

    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    @Test
    void threadLocal() {
        new Thread(() -> {
            set(1L);
            set(2L);
            set(3L);
            System.out.println(get());
        }).start();
        try {
            // 让子线程先运行完
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // threadLocal.set(5L);
        // System.out.println(get());
    }

    public static void set(long v) {
        threadLocal.set(v);
    }

    public static long get() {
        return threadLocal.get();
    }
}
