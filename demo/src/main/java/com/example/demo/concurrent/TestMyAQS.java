package com.example.demo.concurrent;

public class TestMyAQS {

    int count = 1;

    public void addCount(){
        count++;
        System.out.println(Thread.currentThread().getName()+"\t 打印"+count);
    }

    public static void main(String[] args) {
        MyAQS myAQS = new MyAQS();
        myAQS.lock();
        try {
            TestMyAQS testMyAQS = new TestMyAQS();
            for (int i = 0; i < 100; i++) {
                new Thread(()->{
                    for (int j = 0; j < 100; j++) {
                        testMyAQS.addCount();
                    }
                },i+"").start();
            }
        }finally {
            myAQS.unlock();
        }
    }



}
