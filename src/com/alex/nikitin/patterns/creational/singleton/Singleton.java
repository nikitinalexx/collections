package com.alex.nikitin.patterns.creational.singleton;

public class Singleton {
    private static volatile Singleton INSTANCE;

    private Singleton() {

    }

    public static Singleton getInstance() {
        Singleton localSingleton = INSTANCE;
        if (localSingleton == null) {
            synchronized (Singleton.class) {
                localSingleton = INSTANCE;
                if (localSingleton == null) {
                    INSTANCE = localSingleton = new Singleton();
                }
            }
        }
        return localSingleton;
    }

}
