package com.liuyang.study.callable;

import java.util.concurrent.Callable;

/**
 * @author LeonWillow | LiuYang | LanWu114
 * @date 2020/8/13 17:39
 * @des 第三种线程创建方式，JDK5.0之后增加  Callable
 *
 * 相比 Runnable，Callable功能更强大
 * 其中的call()方法，相比Runnable接口的run()方法，可以有支持泛型的返回值
 *
 * 需要借助FutureTask类去运行call
 */
public class CallableTest implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0 ;
        for (int i = 0; i <=100 ; i++) {
            if(i%2 == 0){
                System.out.println(i);
                sum+=i;
            }
        }
        return sum;
    }
}
