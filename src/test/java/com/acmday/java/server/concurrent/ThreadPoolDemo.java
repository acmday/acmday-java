package com.acmday.java.server.concurrent;

import com.acmday.java.server.util.ThreadPoolUtil;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;

/**
 * @author acmday.
 * @date 2020/8/31.
 */
public class ThreadPoolDemo {

    @Test
    public void tPool() {
        ThreadPoolUtil.executor.submit(new Runnable() {
            @Override
            public void run() {
                //不能抛出异常
                //throw new Exception("");
                System.out.println("runnable");
            }
        });

        ThreadPoolUtil.executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "callable";
            }
        });
    }
}
