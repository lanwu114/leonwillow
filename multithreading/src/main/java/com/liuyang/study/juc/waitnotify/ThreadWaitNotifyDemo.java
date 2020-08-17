package com.liuyang.study.juc.waitnotify;

/**
 * @author LeonWillow | LiuYang | LanWu114
 * @date 2020/8/16 18:47
 * @des 现在两个线程，可以操作初始值为0的一个变量，
 * 实现一个线程对该变量加1
 * 另一个线程对该变量减1
 * 实现交替
 * 变量初始值为0
 * <p>
 * <p>
 * 线程       操作      资源类
 * 判断       干活      通知
 */
class AirConditioner {//资源类
    private Integer number = 0;

    public synchronized void increment() throws InterruptedException {
        //判断
        if (number != 0) {
            this.wait();
        }

        //干活
        number++;
        System.out.println(Thread.currentThread().getName() + "\t" + number);

        //通知
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        //判断
        if (number == 0) {
            this.wait();
        }

        //干活
        number--;
        System.out.println(Thread.currentThread().getName() + "\t" + number);

        //通知
        this.notifyAll();
    }
}

public class ThreadWaitNotifyDemo {
    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();
        new Thread(()->{
            for (int i = 0 ; i <= 10; i++){
                try {
                    airConditioner.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0 ; i <= 10; i++){
                try {
                    airConditioner.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
    }
}
