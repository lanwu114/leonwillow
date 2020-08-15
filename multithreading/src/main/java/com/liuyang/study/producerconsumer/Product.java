package com.liuyang.study.producerconsumer;

import lombok.Data;
import lombok.SneakyThrows;


/**
 * Author: LeonWillow | LiuYang | lanwu114
 * Date: 2020/8/10 20:24
 * Des:
 * 生产者消费者问题
 * <p>
 * 生产者将产品交给店员，消费者从店员处取走产品，店员一次只能持有固定数量的产品
 * 如果生产者试图生产更多的产品，店员会让生产者停一下，等到店中有空位了再通知生产者生产
 * 如果店中没有产品了，店员会告诉消费者停一下，如果店中有产品了再通知消费者来取走产品
 */
@Data
public class Product {
    /**
     * 定义商品的数量，默认为0
     */
    private Integer productNum = 0;
    /**
     * 当商品数量小于等于limit的时候，停止销售；
     * 当商品数量大于limit的时候，停止生产
     */
    private Integer limit = 40;
    /**
     * 定义消费次数n
     */
    private Integer n = 0;

    /**
     * 增加商品数量的方法
     *
     * @param num 作为将要增加的数量
     */
    public synchronized void add(Integer num) {
        if (this.productNum > limit) {
            System.out.println(Thread.currentThread().getName()+"停止生产，此时货物还有"+productNum+"个");
            stop();
        }
        this.productNum += num;
        System.out.println(Thread.currentThread().getName() + "生产" + num + "个商品，还有" + productNum + "个商品");
        if (this.productNum > limit) {
            goon();
        }
    }

    /**
     * 定义减少商品数量的方法
     *
     * @param num 作为将要减少的数量
     */
    public synchronized void subtract(Integer num) {
        //如果卖出去物品后数量少于limit，则停止消费
        if (this.productNum <= limit) {
            System.out.println(Thread.currentThread().getName()+"停止消费，此时货物只剩"+productNum+"个");
            stop();
        }
        this.productNum -= num;
        n++;
        System.out.println(Thread.currentThread().getName() + "消费" + num + "个商品，还剩余" + this.productNum + "个商品,共消费了" + n + "次.");
        if (this.productNum <= limit) {
            goon();
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