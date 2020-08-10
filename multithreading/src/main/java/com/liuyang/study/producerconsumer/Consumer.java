package com.liuyang.study.producerconsumer;

import lombok.Data;

/**
 * Author: LeonWillow | LiuYang | lanwu114
 * Date: 2020/8/10 20:16
 * Des:
 */
@Data
public class Consumer implements Runnable {
    public Integer subtractNum = 100;
    public Product product;

    public Consumer(Integer addNum, Product product) {
        this.subtractNum = addNum;
        this.product = product;
    }

    public Consumer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        while (product.n <= 100) {
            this.product.subtract(subtractNum);
        }
    }
}
