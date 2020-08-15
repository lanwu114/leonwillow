package com.liuyang.study.threadpool;

import com.liuyang.study.callable.CallableMain;
import com.liuyang.study.callable.CallableTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author LeonWillow | LiuYang | LanWu114
 * @date 2020/8/13 18:32
 * @des 线程池，JDK5.0新增创建多线程方式之二
 * 优点：
 * 1.方便线程管理
 * 2.减小性能的开销
 * 3.提高响应的速度
 */
public class ThreadPool {
    public static void main(String[] args) {
        //提供指定线程数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //执行指定的线程的操作，需要提供实现Runnable或者Callable
        executorService.execute(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        });
        executorService.shutdown();
    }
}

class ThreadPoolRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}
