package com.liuyang.study.producerconsumer;

import lombok.Data;

/**
 * Author: LeonWillow | LiuYang | lanwu114
 * Date: 2020/8/10 19:47
 * Des:
 */
@Data
public class Producer implements Runnable {
    private Integer addNum = 10;
    private Product product;

    public Producer(Integer addNum, Product product) {
        this.addNum = addNum;
        this.product = product;
    }

    public Producer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        while (product.n <= 100) {
            this.product.add(addNum);
        }
    }
}
