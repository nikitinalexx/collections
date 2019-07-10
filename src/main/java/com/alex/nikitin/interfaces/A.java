package com.alex.nikitin.interfaces;

public interface A {

    default void s() {
        System.out.println("A");
    }

    void a();

}
