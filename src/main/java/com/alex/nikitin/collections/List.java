package com.alex.nikitin.collections;

public interface List<T> {
    void insertAtEnd(T value);
    void insertAtHead(T value);
    boolean delete(T element);
    T deleteAtHead();
    T search(int index);
    boolean isEmpty();
    int size();
}

