package com.alex.nikitin.patterns.creational.singleton;

public class OnDemandSingleton {
    private OnDemandSingleton() {
        System.out.println("I was created!");
    }

    public static OnDemandSingleton getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }

    private static class SingletonHolder {
        private static final OnDemandSingleton HOLDER_INSTANCE = new OnDemandSingleton();
    }

}
