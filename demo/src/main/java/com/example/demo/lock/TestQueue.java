package com.example.demo.lock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class TestQueue {

    public static void main(String[] args) throws InterruptedException {
        synchronous4Method();
//       new Thread(()->{
//           try {
//               blockingQueue.offer("1");
//               System.out.println(Thread.currentThread().getName()+"\t 正在写入1");
//               Thread.sleep(3000);
//               blockingQueue.offer("2");
//               System.out.println(Thread.currentThread().getName()+"\t 正在写入2");
//               Thread.sleep(3000);
//               blockingQueue.offer("3");
//               System.out.println(Thread.currentThread().getName()+"\t 正在写入3");
//               Thread.sleep(3000);
//           } catch (InterruptedException e) {
//               e.printStackTrace();
//           }
//       },"AA").start();
//        new Thread(()->{
//            try {
//                Thread.sleep(2000);
//                System.out.println(Thread.currentThread().getName()+"\t 取出"+blockingQueue.poll());
//                System.out.println(Thread.currentThread().getName()+"\t 取出"+blockingQueue.poll());
//                System.out.println(Thread.currentThread().getName()+"\t 取出"+blockingQueue.poll());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        },"BB").start();

    }

    private static void synchronous4Method() {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
        System.out.println("像队列中插入数据");
        blockingQueue.offer("1");
        blockingQueue.poll();
        System.out.println("已经移除队列中的数据");
    }

    /**
     * 如果超出队列的容量的时候，put和take方法会进行阻塞
     * @throws InterruptedException
     */
    private static void putAndTake4Queue() throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.put("1");
        System.out.println("1");
        blockingQueue.put("2");
        System.out.println("2");
        blockingQueue.put("3");
        System.out.println("3");
//        blockingQueue.put("4");
//        System.out.println("4");

        System.out.println("==============================");

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
    }

    /**
     * 主要是测试offer和poll方法，这种方法即使达到队列的容量也不会抛出异常信息
     */
    private static void offerAndRoll4Queue() {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("1"));
        System.out.println(blockingQueue.offer("2"));
        System.out.println(blockingQueue.offer("3"));
        System.out.println(blockingQueue.offer("4"));


        System.out.println("==============================");

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
    }

    /**
     * 主要add方法如果超出队列的容量的话，则会抛出异常
     */
    private static void testQueueAddAndRemove() {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("1"));
        System.out.println(blockingQueue.add("2"));
        System.out.println(blockingQueue.add("3"));


        System.out.println("==============================");

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
    }
}
