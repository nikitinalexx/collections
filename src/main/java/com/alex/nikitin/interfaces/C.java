package com.alex.nikitin.interfaces;

public interface C extends A {

    default void s() {
        System.out.println("C");
    }
}
