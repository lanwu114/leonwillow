package com.liuyang.study.communication;

/**
 * Author: LeonWillow | LiuYang | lanwu114
 * Date: 2020/8/10 12:08
 * Des:
 * 线程通信学习中的一个简单例子，使用两个线程打印1-100.线程1和线程2一个一个交替执行
 *
 * 主要涉及到三个方法
 * wait():执行此方法，当前线程进入阻塞状态，并且释放锁
 * notify():执行此方法，就会唤醒被wait()的一个线程，如果有多个线程wait()，就唤醒优先级高的线程
 * notifyAll():执行此方法，唤醒所有wait()的线程
 *
 *
 * 重点：
 * 1.这三个方法只能用在synchronized代码块或者synchronized方法中
 * 2.这三个方法的【调用者】必须是同步代码块或同步方法中的同步监视器，否则出现异常
 *      也就是说，锁和调用这三个方法的对象必须是同一个
 * 3.这三个方法定义在java.lang.Object下（因为所有对象都可以充当同步监视器）
 *
 *
 *
 *
 *
 */
public class Communication implements Runnable{
    private int number = 1;
    private final Object obj = new Object();
    @Override
    public void run() {
        while(true){
            synchronized (obj){
                System.out.println(Thread.currentThread().getName()+"打印："+number++);
                //Thread.sleep(100);
                obj.notify();
                if(number>=100) {
                    break;
                }
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
