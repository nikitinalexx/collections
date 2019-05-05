package com.alex.nikitin;

public interface Queue<T> {

    void enqueue(T value);
    T dequeue();
    boolean isEmpty();
    T top();
    int size();


}
