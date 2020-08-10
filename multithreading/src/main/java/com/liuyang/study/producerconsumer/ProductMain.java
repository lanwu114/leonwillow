package com.liuyang.study.producerconsumer;

/**
 * Author: LeonWillow | LiuYang | lanwu114
 * Date: 2020/8/10 20:58
 * Des:
 */
public class ProductMain {
    public static void main(String[] args) {
        Product p = new Product();
        Consumer c1 = new Consumer(p);
        Producer p1 = new Producer(p);


        Thread ct1 = new Thread(c1,"生产者一号");
        Thread ct2 = new Thread(c1,"生产者二号");
        Thread ct3 = new Thread(c1,"生产者三号");


        Thread pt1 = new Thread(p1,"消费者一号");
        Thread pt2 = new Thread(p1,"消费者二号");
        Thread pt3 = new Thread(p1,"消费者三号");
        Thread pt4 = new Thread(p1,"消费者四号");
        ct1.start();
        ct2.start();
        ct3.start();
        pt1.start();
        pt2.start();
        pt3.start();
        pt4.start();
    }
}
