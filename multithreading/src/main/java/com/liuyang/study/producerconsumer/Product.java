package com.liuyang.study.producerconsumer;

import lombok.Data;


/**
 * Author: LeonWillow | LiuYang | lanwu114
 * Date: 2020/8/10 20:24
 * Des:
 * 生产者消费者问题
 * <p>
 * 生产者将产品交给店员，消费者从店员处取走产品，电源一次只能持有固定数量的产品
 * 如果生产者试图生产更多的产品，店员会让生产者停一下，等到殿中有空位放产品了再通知生产者生产
 * 如果殿中没有产品了，店员会告诉消费者停一下，如果殿中有产品了再通知消费者来取走产品
 */
@Data
public class Product {
    public Integer productNum = 0;
    //当商品数量小于limit的时候，停止销售；当商品数量大于limit的时候，停止生产
    public Integer limit = 100;
    public Integer n = 0;

    //生产产品
    public synchronized void add(Integer num) {
        if (productNum > limit) {
            this.stop();
        }
        this.productNum += num;
        System.out.println(Thread.currentThread().getName()+"生产"+num+"个商品，"+"剩余"+productNum+"个商品");
        if (productNum <= limit) {
            this.goon();
        }
    }

    //消费产品
    public synchronized void subtract(Integer num) {
        if (productNum < limit) {
            this.stop();
        }
        this.productNum -= num;
        this.n++;
        System.out.println(Thread.currentThread().getName()+"消费"+num+"个商品，"+"剩余"+productNum+"个商品，消费了"+n+"次");
        if (productNum >= limit) {
            this.goon();
        }
    }

    private void stop() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void goon() {
        notify();
    }
}