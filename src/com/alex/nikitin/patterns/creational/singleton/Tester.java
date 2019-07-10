package com.alex.nikitin.patterns.creational.singleton;

import java.util.concurrent.TimeUnit;

public class Tester {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Started a program");
        TimeUnit.SECONDS.sleep(2);

        System.out.println("Starting to get singleton");
        OnDemandSingleton.getInstance();
        System.out.println("Finished getting the singleton");
    }

}
