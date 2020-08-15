package com.liuyang.study.thread;

/**
 * @author LeonWillow | LiuYang | LanWu114
 * @date 2020/8/12 18:49
 * @des
 */
public class ThreadTest {
    public static void main(String[] args) {
        Runnable target = ()-> System.out.println("线程");
        /**
         * 通过源码，可以看出来在init()方法调用后，如果传进了Runnable对象，
         * 最终还是会调用Runnable对象的run()方法
         * 如果没有传入Runnable对象，则会去调用本身的run()方法
         */
        Thread t = new Thread(target);

    }
}
