package com.acmday.java.server.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author acmday.
 * @date 2020/9/3.
 * 合并线程执行的结果.
 * 问题: countDown和await执行的先后顺序有影响吗？
 */
public class CountDownLatchDemo {

    private static Result result = new Result();

    @Test
    public void getResult() {
        //通过修改这个参数可以测试一直阻塞的场景
        CountDownLatch latch = new CountDownLatch(3);
        calculate(latch);
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //主线程合并结果
        System.out.println("合并的结果是：" + result.resultOne+"|"+result.resultTwo+"|"+result.resultThree+"|"/*+result.resultFour*/);
    }

    private static void calculate(CountDownLatch latch) {

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                /*try {
                    //避免在主线程执行wait方法之前已经执行完。(await先执行也没问题)
                    Thread.sleep(10000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                result.resultOne = "one";
                latch.countDown();
            }
        }, "ThreadOne");

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                /*try {
                    Thread.sleep(10000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                result.resultTwo = "two";
                latch.countDown();
            }
        }, "ThreadTwo");
        Thread threadThree = new Thread(new Runnable() {
            @Override
            public void run() {
                /*try {
                    Thread.sleep(10000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                result.resultThree = "three";
                latch.countDown();
            }
        }, "threadThree");

        //启动线程
        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }

    static class Result {
        String resultOne;
        String resultTwo;
        String resultThree;
        String resultFour;
    }
}
