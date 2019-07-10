package com.alex.nikitin.collections;

public interface Queue<T> {

    void enqueue(T value);
    T dequeue();
    boolean isEmpty();
    T top();
    int size();


}
