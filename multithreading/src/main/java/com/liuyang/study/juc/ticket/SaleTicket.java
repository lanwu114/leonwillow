package com.liuyang.study.juc.ticket;

import lombok.Data;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LeonWillow | LiuYang | LanWu114
 * @date 2020/8/14 20:21
 * @des 买票复习
 * <p>
 * <p>
 * 多线程变成的企业级套路 + 模板
 * 在高内聚低耦合前提下，线程        操作(对外暴露的调用方法)     资源类
 */

//这个就是      资源
@Data
class Ticket {
    private Integer number = 30;
    private Lock lock = new ReentrantLock();

    public void saleTicket() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "\t卖出第：" + (number--) + "\t还剩下：" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class SaleTicket {
    public static void main(String[] args) throws Exception {
        Ticket ticket = new Ticket();
        new Thread(() -> {
            for (int i = 0; i <= 40; i++) {
                ticket.saleTicket();
            }
        }, "一号窗口").start();
        new Thread(() -> {
            for (int i = 0; i <= 40; i++) {
                ticket.saleTicket();
            }
        }, "二号窗口").start();
    }
}