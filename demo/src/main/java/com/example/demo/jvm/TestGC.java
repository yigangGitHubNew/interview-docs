package com.example.demo.jvm;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * 测试java虚拟机的一些参数使用
 */
public class TestGC {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("********************Hello GC");
        System.out.println(new BigDecimal(0.000000D));
//        TimeUnit.MILLISECONDS.sleep(Long.MAX_VALUE);
//        querySystemParams();
    }

    private static void querySystemParams() {
        System.out.println("系统的环境变量："+System.getenv());
        System.out.println("CPU核数："+Runtime.getRuntime().availableProcessors());
        System.out.println("最大内存："+Runtime.getRuntime().maxMemory());
        System.out.println("总内存："+Runtime.getRuntime().totalMemory());
    }
}
