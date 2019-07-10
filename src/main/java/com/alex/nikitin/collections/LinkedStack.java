package com.alex.nikitin.collections;

import java.util.NoSuchElementException;

public class LinkedStack<T> implements Stack<T> {
    private static class Node<T> {
        private T value;

        private Node<T> previous;

        private Node(T value) {
            this.value = value;
        }

        private Node(T value, Node<T> previous) {
            this.value = value;
            this.previous = previous;
        }

    }

    private Node<T> top;
    private int size = 0;



    @Override
    public void push(T v) {
        if (top == null) {
            top = new Node<>(v);
        } else {
            top = new Node<>(v, top);
        }
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T value = top.value;
        top = top.previous;
        size--;
        return value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T top() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return top.value;
    }



    public static void main(String[] args) {
        Stack<Integer> linkedStack = new LinkedStack<>();
        linkedStack.push(1);
        linkedStack.push(2);
        System.out.println(linkedStack.top());
        System.out.println("Popped " + linkedStack.pop());

        System.out.println(linkedStack.top());

        linkedStack.push(3);
        System.out.println(linkedStack.top());
        linkedStack.pop();
        System.out.println(linkedStack.top());
        linkedStack.pop();
        System.out.println(linkedStack.isEmpty());
    }
}
