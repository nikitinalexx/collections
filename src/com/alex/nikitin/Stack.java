package com.alex.nikitin;

public interface Stack<T> {

    void push(T v);
    T pop();
    boolean isEmpty();
    T top();
}
