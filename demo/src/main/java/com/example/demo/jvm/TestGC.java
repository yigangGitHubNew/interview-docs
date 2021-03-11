package com.example.demo.jvm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 测试java虚拟机的一些参数使用
 */
public class TestGC {

    public static void main(String[] args) throws InterruptedException {
        List<String> strings = Arrays.asList("1","2","3","4");
//        List<String> strings = new ArrayList<>();
//        strings.add("1");
//        strings.add("2");
//        strings.add("3");
//        strings.add("4");
        List<String> strs1 = new ArrayList<>();
        strs1.add("1");
        strs1.add("2");
        strs1.add("3");
        System.out.println(strings.contains("6"));


        System.out.println("********************Hello GC");
//        Byte[] bytes = new Byte[1024*1024*5];
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
