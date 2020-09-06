package com.acmday.java.server.concurrent;

/**
 * @author acmday.
 * @date 2020/8/30.
 */
public class ThreadDemo {
    /*
     实现线程的两种方式：
     首先我们要知道两点：启动一个线程最终还是得走Thread的start0方法。
     然后，Thread类也是实现自Runnable方法。

     第一种是实现Runnable，这种方法的优势是可以多继承，实现更多的功能。不过这种方法还是得依赖Thread类，因为要启动一个线程，
     最终还是得走Thread类的start0方法。

     第二种是继承Thread，这种方式，可以直接start，底层也还是走的start0方法。当然，也可以作为Thread的构造函数参数传入给
     Thread，然后再start。
     */
    public static class ThreadTest1 implements Runnable {

        private int num = 100;

        @Override
        public void run() {
            for (int i = 0; i <= 100; i++) {
                if (num > 0) {
                    System.out.println(Thread.currentThread().getName()+"执行结果：" + (num--));
                }
            }

        }

        public static void main(String[] args) {
            ThreadTest1 t1 = new ThreadTest1();

            Thread t01 = new Thread(t1, "线程1");
            Thread t02 = new Thread(t1, "线程2");
            Thread t03 = new Thread(t1, "线程3");

            t01.start();
            t02.start();
            t03.start();
        }
    }

    public static class ThreadTest2 extends Thread{

        private int num = 100;

        @Override
        public void run() {

            for(int i =0; i <=100; i++) {
                if(num >0) {
                    System.out.println(Thread.currentThread().getName()+"执行结果:"+(num--));
                }
            }
        }

        public static void main(String[] args) {
            ThreadTest2 t = new ThreadTest2();

            Thread t01 = new Thread(t, "01线程");
            Thread t02 = new Thread(t, "02线程");
            Thread t03 = new Thread(t, "03线程");
            t01.start();
            t02.start();
            t03.start();
        /*
        ThreadTest2 t02 = new ThreadTest2();
        ThreadTest2 t03 = new ThreadTest2();
        t.start();
        t02.start();
        t03.start();*/
        }
    }
}
