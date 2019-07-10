package com.alex.nikitin.collections;

public interface Stack<T> {

    void push(T v);
    T pop();
    boolean isEmpty();
    T top();
}
