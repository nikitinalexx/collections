package com.alex.nikitin;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.IntStream;

public class MinHeap {
    private int[] array = new int[10 + 1];
    private int index = 1;
    private int size = 0;

    public void insertElement(int element) {
        ensureCapacity(size + 1);
        array[index++] = element;
        size++;

        int currentIndex = index - 1;
        while (currentIndex != 1) {
            if (array[currentIndex] < getParentValue(currentIndex)) {
                swapWithParent(currentIndex);
            }
            currentIndex = currentIndex / 2;
        }
    }

    public int size() {
        return size;
    }

    private void swapWithParent(int index) {
        int tmp = array[index];
        array[index] = array[index / 2];
        array[index / 2] = tmp;
    }

    private int getParentValue(int index) {
        return array[index / 2];
    }

    private void ensureCapacity(int requiredSize) {
        if (requiredSize > array.length - 1) {
            int[] tmp = array;
            array = new int[(array.length - 1) * 3 / 2 + 2];
            System.arraycopy(tmp, 0, array, 0, tmp.length);
        }
    }

    public int getMin() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return array[1];
    }

    public int extractMin() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int value = array[1];
        array[1] = array[--index];
        size--;
        extractMinUtil(1);
        return value;
    }

    private void extractMinUtil(int current) {
        if (current <= size) {
            if (hasLeftChild(current) && array[current] > leftChildValue(current) || hasRightChild(current) && array[current] > rightChildValue(current)) {
                if (hasLeftChild(current) && hasRightChild(current) && leftChildValue(current) < rightChildValue(current)) {
                    swapWithParent(current * 2);
                    extractMinUtil(current * 2);
                } else {
                    swapWithParent(current * 2 + 1);
                    extractMinUtil(current * 2 + 1);
                }
            }
        }
    }

    private boolean hasLeftChild(int parent) {
        return parent * 2 <= size;
    }

    private int leftChildValue(int parent) {
        return array[parent * 2];
    }

    private boolean hasRightChild(int parent) {
        return parent * 2 + 1 <= size;
    }

    private int rightChildValue(int parent) {
        return array[parent * 2 + 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        Random random = new Random();
        IntStream.generate(() -> random.nextInt(50)).limit(10).forEach((int i) -> {
            minHeap.insertElement(i);
            System.out.print(i + ", ");
        });
        System.out.println();
        System.out.println("Min " + minHeap.extractMin());
        System.out.println("Min " + minHeap.extractMin());
        System.out.println(minHeap.getMin());
    }
}
