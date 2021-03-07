package com.example.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareParam {

    private int count = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increase(){
        try{
            lock.lock();
            while(count < 5){
                System.out.println(Thread.currentThread().getName() + " 开始生产："+count);
                count++;
                condition.signal();
            }
            System.out.println(Thread.currentThread().getName()+" 开始等待生产");
            condition.await();
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }
    }

    public void decrease(){
        try{
            lock.lock();
            while(count != 1){
                System.out.println(Thread.currentThread().getName() + " 开始消费："+count);
                count--;
            }
            System.out.println(Thread.currentThread().getName()+" 开始等待消费");
            condition.signal();
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }
    }

}


public class TestProductConsumer_Tradition {

    public static void main(String[] args) {
        ShareParam shareParam = new ShareParam();
        new Thread(()->{
            System.out.println("生产者开始生产");
            shareParam.increase();
        },"product").start();

        new Thread(()->{
            System.out.println("消费者开始消费");
            shareParam.decrease();
        },"consumer").start();
    }
}
