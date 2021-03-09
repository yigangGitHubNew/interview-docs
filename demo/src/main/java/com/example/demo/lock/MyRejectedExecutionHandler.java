package com.example.demo.lock;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class MyRejectedExecutionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("My rejectedExecution is start");
        r.run();
        System.out.println("My rejectedExecution is shutdown");
        executor.shutdown();
    }
}
