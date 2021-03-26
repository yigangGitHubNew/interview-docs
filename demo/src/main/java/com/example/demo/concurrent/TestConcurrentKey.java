package com.example.demo.concurrent;


import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 测试关键字Synchronized 是通过JVM的字节吗中的montior.enter进入，然后通过montior.exit退出
 * Java对象头和monitor实现Synchronized的基础
 */
public class TestConcurrentKey {

    static void testSyn(){
        synchronized (TestConcurrentKey.class){
            System.out.println("static synchronized");
        }
    }
    int count = 1;
    public void addCount(){
        count++;
        System.out.println(Thread.currentThread().getName()+"\t"+count);
    }


    public static void main(String[] args) throws InterruptedException {

        String str1 = "1";
        String str2 = "3";
        System.out.println(str1 == str2);
        String str3 = new String("3");
        String str4 = new String("3");
        System.out.println(str2 == str3);
        System.out.println(str3.intern() == str2);
        System.out.println(str2 == str3);
//        testSyn();

//        threadKeyWord();

//        TestConcurrentKey testConcurrentKey = new TestConcurrentKey();
//
//        for (int i = 0; i < 100; i++) {
//            new Thread(()->{
//                for(int j = 0;j<100;j++){
//                    testConcurrentKey.addCount();
//                }
//            },i+"").start();
//        }
//
//
//        System.out.println(Thread.currentThread().getName()+"\t"+testConcurrentKey.count);


    }

    private static void threadKeyWord() {
        Thread threadA = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"打印线程AA");
            try {
                TimeUnit.MILLISECONDS.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AA");
        threadA.start();

        Thread threadB = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"打印线程BB");
        },"BB");
        threadA.interrupt();
//        threadA.join();
        threadB.start();
    }
}
