package com.liuyang.study.communication;

/**
 * Author: LeonWillow | LiuYang | lanwu114
 * Date: 2020/8/10 12:31
 * Des:
 */
public class CommunicationMain {
    public static void main(String[] args) {
        Communication c = new Communication();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
    }
}
