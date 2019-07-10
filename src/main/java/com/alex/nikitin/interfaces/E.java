package com.alex.nikitin.interfaces;

@FunctionalInterface
public interface E {

    void a();

    default void b() {
        System.out.println("Method b");
    }

    public static void main(String[] args) {
        E e = () -> {
            System.out.println("Method a");
        };

        e.a();
        e.b();
    }
}
