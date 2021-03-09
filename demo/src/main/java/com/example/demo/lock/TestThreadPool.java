package com.example.demo.lock;

import java.util.concurrent.*;

/**
 * 测试线程池的相关案例
 * 根据工具创建一些线程池
 * 使用new ThreadPoolExecutor方式创建线程池
 */
public class TestThreadPool {

    public static void main(String[] args) {
//        usePoolUntil();

        ExecutorService executorService = new ThreadPoolExecutor(2,
                4,
                1,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(5),
                Executors.defaultThreadFactory(),
                new MyRejectedExecutionHandler());
        try {
            for (int i = 0; i < 10; i++) {
                executorService.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 正在办理业务");
                });
            }
        }finally {
            executorService.shutdown();
        }

    }


    /**
     * 使用工具生成线程池
     */
    private static void usePoolUntil() {
        //        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            for (int i = 0; i < 10; i++) {
                executorService.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 正在办理业务");
                });
            }
        }finally {
            executorService.shutdown();
        }
    }
}
