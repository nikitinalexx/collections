package com.alex.nikitin.collections;

import java.util.NoSuchElementException;

public class StackFromQueue<T> implements Stack<T> {
    private Queue<T> q1 = new LinkedQueue<>();
    private Queue<T> q2 = new LinkedQueue<>();

    @Override
    public void push(T v) {
        q1.enqueue(v);
    }

    @Override
    public T pop() {
        while (!q1.isEmpty()) {
            T temp = q1.dequeue();
            if (q1.isEmpty()) {
                swapQueues();
                return temp;
            } else {
                q2.enqueue(temp);
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public boolean isEmpty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    @Override
    public T top() {
        while (!q1.isEmpty()) {
            T temp = q1.dequeue();
            q2.enqueue(temp);
            if (q1.isEmpty()) {
                swapQueues();
                return temp;
            }
        }
        throw new NoSuchElementException();
    }

    private void swapQueues() {
        Queue<T> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    @Override
    public String toString() {
        return q1.toString();
    }

    public static void main(String[] args) {
        Stack<Integer> stackQueue = new StackFromQueue<>();
        stackQueue.push(1);
        stackQueue.push(2);
        System.out.println(stackQueue.top());
        System.out.println("Popped " + stackQueue.pop());

        System.out.println(stackQueue);

        stackQueue.push(3);
        System.out.println(stackQueue);

        stackQueue.push(4);
        System.out.println(stackQueue);

        stackQueue.pop();
        System.out.println(stackQueue);
    }
}
