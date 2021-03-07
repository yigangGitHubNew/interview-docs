package com.example.demo;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class ShareProdConsumer {

    BlockingQueue<Integer> queue = null;
    volatile boolean flag = true;
    AtomicInteger atomicInteger = new AtomicInteger();

    public ShareProdConsumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void increate() throws InterruptedException {
        boolean flagOffer = false;
        while (flag){
            flagOffer = queue.offer(atomicInteger.incrementAndGet());
            if (!flagOffer){
                System.out.println(Thread.currentThread().getName()+"\t已经达到队列的极限了，不能再进行生产");
                continue;
            }
            System.out.println(Thread.currentThread().getName() + "\t开始生产："+flagOffer);
        }
    }

    public void decrease() throws InterruptedException {
        Integer count = null;
        while (flag){
            count = queue.poll();
            if(count == null){
                System.out.println(Thread.currentThread().getName()+"\t队列中数据为空需要等待生产者生产");
                continue;
            }
            System.out.println(Thread.currentThread().getName() + "\t开始消费："+count);
        }
    }

    public void stop(){
        System.out.println(Thread.currentThread().getName()+"\t主线程将生产者消费者停止");
        flag = false;
    }
}


/**
 * 使用阻塞队列模拟生产者消费者模式
 */
public class TestProdConsumer_New {

    public static void main(String[] args) throws InterruptedException {
        prodConsumer4New();
    }


    private static void prodConsumer4New() throws InterruptedException {
        System.out.println("进入生产者和消费者模型中");
        ShareProdConsumer shareProdConsumer = new ShareProdConsumer(new ArrayBlockingQueue<Integer>(6));
        new Thread(()->{
            System.out.println("生产者开始生产");
            try {
                shareProdConsumer.increate();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"product").start();

        new Thread(()->{
            System.out.println("消费者开始消费");
            try {
                shareProdConsumer.decrease();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"consumer").start();

        TimeUnit.MILLISECONDS.sleep(100);
        shareProdConsumer.stop();
    }
}
