package com.example.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public TestAService testAService(){
        return new TestAService();
    }

    @Bean
    public TestServiceB testServiceB(){
        return new TestServiceB();
    }
}
