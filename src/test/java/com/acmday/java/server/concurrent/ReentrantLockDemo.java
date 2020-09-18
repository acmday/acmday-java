package com.acmday.java.server.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author acmday.
 * @date 2020/8/30.
 */
public class ReentrantLockDemo {

    @Test
    public void reLock() {
        ReentrantLock lock = new ReentrantLock();
        try {
            lock.lock();
        }finally {
            lock.unlock();
        }
    }

    @Test
    public void condition() {
        ReentrantLock lock = new ReentrantLock();
        Condition producer = lock.newCondition();
        Condition consumer = lock.newCondition();

        try {
            // wait和await的区别: wait是Object类中的，await()相当于synchronized等待唤醒机制中的wait()方法
            producer.wait();
            producer.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
