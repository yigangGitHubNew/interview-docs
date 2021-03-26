package com.example.demo.spring;

public class TestServiceB {


    public TestServiceB(){
        System.out.println("Test Service B is load");
    }

    TestAService testAService;

    public TestAService getTestAService() {
        return testAService;
    }

    public void setTestAService(TestAService testAService) {
        this.testAService = testAService;
    }
}
