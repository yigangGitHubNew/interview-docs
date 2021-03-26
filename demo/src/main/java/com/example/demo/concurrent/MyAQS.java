package com.example.demo.concurrent;

import sun.misc.Unsafe;

import java.math.BigDecimal;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class MyAQS extends AbstractQueuedSynchronizer {

    public static void main(String[] args) {
        System.out.println(BigDecimal.ONE);
    }

    /**
     * 是否处于占用状态
     * @return
     */
    @Override
    protected boolean isHeldExclusively() {
        return getState() == 1;
    }

    @Override
    protected boolean tryAcquire(int arg) {
        if(compareAndSetState(0,1)){
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }

        Unsafe.getUnsafe();
        return false;

    }

    @Override
    protected boolean tryRelease(int arg) {
        if(getState() == 0){
            throw new RuntimeException("the state is unlock");
        }
        setExclusiveOwnerThread(null);
        setState(0);
        return true;
    }

    public void lock(){
        acquire(1);
    }

    public void unlock(){
        tryRelease(1);
    }
}
