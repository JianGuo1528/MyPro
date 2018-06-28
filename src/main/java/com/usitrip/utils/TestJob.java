package com.usitrip.utils;

import org.springframework.scheduling.annotation.Scheduled;

public class TestJob {

    @Scheduled(fixedDelay=5000)
    public void doSomething() {
        System.out.println("TestJob.doSomething" + (int)(Math.random() * 100));
    }
}
