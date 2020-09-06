package com.acmday.java.server.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author acmday.
 * @date 2020/8/30.
 */
public class ReentrantLockDemo {

    @Test
    public void reLock() {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
    }
}
