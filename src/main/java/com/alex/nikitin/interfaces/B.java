package com.alex.nikitin.interfaces;

public interface B {

    default void s() {
        System.out.println("B");
    }

    void a();

}
