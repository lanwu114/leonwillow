package com.liuyang.study.producerconsumer;

import lombok.Data;

/**
 * Author: LeonWillow | LiuYang | lanwu114
 * Date: 2020/8/10 19:47
 * Des: 生产者类
 */
@Data
public class Producer implements Runnable {
    //定义生产者一次生产的数量，默认为1
    private Integer addNum = 1;
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
        while(product.getN()<=100){
            this.product.add(addNum);
        }
    }
}
