package com.example.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class TestMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(TestConfig.class);
        TestServiceB testServiceB = annotationConfigApplicationContext.getBean(TestServiceB.class);
        System.out.println(testServiceB);
        TestAService testAService = annotationConfigApplicationContext.getBean(TestAService.class);
        System.out.println(testAService);
    }
}
