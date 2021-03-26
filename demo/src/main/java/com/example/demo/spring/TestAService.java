package com.example.demo.spring;

public class TestAService {

    public TestAService(){
        System.out.println("Test Service A is load");
    }

    TestServiceB testServiceB;

    public TestServiceB getTestServiceB() {
        return testServiceB;
    }

    public void setTestServiceB(TestServiceB testServiceB) {
        this.testServiceB = testServiceB;
    }
}
