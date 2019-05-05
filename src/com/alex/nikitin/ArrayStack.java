package com.alex.nikitin;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayStack<T> implements Stack<T>{
    private Object[] elements = new Object[10];
    private int size = 0;

    @Override
    public void push(T v) {
        ensureCapacity(size + 1);
        elements[size++] = v;
    }

    private void ensureCapacity(int neededSize) {
        if (neededSize > elements.length) {
            Object[] tmp = elements;
            elements = new Object[tmp.length * 3 / 2 + 1];
            System.arraycopy(tmp, 0, elements, 0, size);
        }
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T value = (T) elements[--size];
        elements[size] = null;
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
        return (T) elements[size - 1];
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }

    public static void main(String[] args) {
        Stack<Integer> arrayStack = new ArrayStack<>();
        arrayStack.push(1);
        arrayStack.push(2);
        System.out.println(arrayStack.top());
        System.out.println("Popped " + arrayStack.pop());

        System.out.println(arrayStack);

        arrayStack.push(3);
        System.out.println(arrayStack);
    }
}
