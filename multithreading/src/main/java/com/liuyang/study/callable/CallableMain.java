package com.liuyang.study.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author LeonWillow | LiuYang | LanWu114
 * @date 2020/8/13 17:45
 * @des FutrueTask是Futrue接口的唯一实现类
 */
public class CallableMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableTest ct = new CallableTest();
        //此时没有start()方法，需要用到Future接口实现的FutureTask
        FutureTask<Integer> futureTask = new FutureTask<>(ct);
        new Thread(futureTask).start();
        int sum = futureTask.get();
        System.out.println(sum);
    }
}
