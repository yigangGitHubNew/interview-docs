package com.example.demo.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class DeadLockDemo implements Runnable{

    Object lockA = new Object();
    Object lockB = new Object();

    public DeadLockDemo(Object lockA, Object lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"被lockA锁持有");
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"被lockB锁持有");
            }
        }
    }
}


/**
 * 测试死锁 如果发生死锁，检查方法 jps -l 查看线程的运行的进程编号  jstack +进程编号 查看死锁的具体信息
 */
public class TestDeadLock {
    public static void main(String[] args) {

        Object lock1 = new Object();
        Object lock2 = new Object();

        DeadLockDemo deadLockDemo1 = new DeadLockDemo(lock1,lock2);
        DeadLockDemo deadLockDemo2 = new DeadLockDemo(lock2,lock1);
        new Thread(deadLockDemo1,"AA").start();
        new Thread(deadLockDemo2,"BB").start();


    }
}
