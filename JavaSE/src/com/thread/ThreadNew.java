package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Description:线程池
 * 好处：①提高响应速度
 *      ②降低资源消耗
 *      ③便于线程管理
 *
 *
 *
 * date:2020-08-12 11:23
 *
 * @Author helaxest  @mail:
 * @Version
 * @Since JDK 1.8
 */
class SuperThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            if(i%2==0){
                System.out.println(i);
            }

        }

    }
}
public class ThreadNew {
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1= (ThreadPoolExecutor) service;

        service1.setCorePoolSize(15);
        service.execute(new SuperThread());//适用于Runnable
      //  service.submit(Callable callable);//适用于Callable
        service.shutdown();

    }
}
