package com.example.demo;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

class CallableClass implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"\t调用callable接口");
        return 5;
    }
}



/**
 *  测试callable
 */
public class TestCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new CallableClass());
        new Thread(futureTask,"AA").start();

        System.out.println(Thread.currentThread().getName()+"取出callable的值为："+futureTask.get());
    }
}
