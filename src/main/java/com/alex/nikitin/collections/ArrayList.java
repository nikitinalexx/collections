package com.alex.nikitin.collections;

import java.util.Arrays;

public class ArrayList<T> {
    private Object[] array;
    private int size = 0;

    public ArrayList() {
        array = new Object[10];
    }

    public void add(T t) {
        if (array.length == size) {
            Object[] tmp = array;
            array = new Object[size * 3 / 2 + 1];
            System.arraycopy(tmp, 0, array, 0, size);
        }
        array[size++] = t;
    }

    public T get(int index) {
        checkIndex(index);
        return (T) array[index];
    }

    public void delete(int index) {
        checkIndex(index);
        array[index] = null;
        for (int i = index; i + 1 < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public int size() {
        return size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }


}
