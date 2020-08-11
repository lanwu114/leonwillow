package com.liuyang.study.producerconsumer;

import lombok.Data;

/**
 * Author: LeonWillow | LiuYang | lanwu114
 * Date: 2020/8/10 20:16
 * Des:消费者类
 */
@Data
public class Consumer implements Runnable {
    //定义subtractNum 为一个消费者一次消费的数量，默认为1
    private Integer subtractNum = 1;
    private Product product;

    public Consumer(Integer addNum, Product product) {
        this.subtractNum = addNum;
        this.product = product;
    }

    public Consumer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        this.product.subtract(subtractNum);
    }
}
