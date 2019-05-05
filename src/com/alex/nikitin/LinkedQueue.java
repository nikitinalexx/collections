package com.alex.nikitin;

import java.util.NoSuchElementException;

public class LinkedQueue<T> implements Queue<T> {
    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> previous;

        private Node(T value) {
            this.value = value;
        }

    }

    @Override
    public int size() {
        return size;
    }

    private Node<T> front;
    private Node<T> back;
    private int size = 0;

    @Override
    public void enqueue(T value) {
        if (isEmpty()) {
            front = back = new Node<>(value);
        } else {
            Node<T> node = new Node<>(value);
            node.next = back;
            back.previous = node;
            back = node;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            T value = front.value;
            if (front.previous != null) {
                front.previous.next = null;
                front = front.previous;
            } else {
                front = back = null;
            }
            size--;
            return value;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T top() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return front.value;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> temp = front;
        while (temp != null) {
            sb.append(temp.value);
            sb.append(", ");
            temp = temp.previous;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedQueue<>();
        for (int i = 0; i < 6; i++) {
            queue.enqueue(i);
        }
        queue.dequeue();
        System.out.println(queue.top());
        queue.dequeue();
        queue.enqueue(6);
        queue.enqueue(7);
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
        queue.enqueue(8);

        System.out.println(queue);
    }
}
