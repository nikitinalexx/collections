package com.alex.nikitin.sorts;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class MergeSort {

    public static void mergeSort(int[] array) {
        mergeUtil(array, 0, array.length - 1);
    }
    
    private static void mergeUtil(int[] array, int start, int end) {
        int middle = (start + end) / 2;

        if (middle > start) {
            mergeUtil(array, start, middle);
        }
        if (end > middle + 1) {
            mergeUtil(array, middle + 1, end);
        }
        int p1 = start;
        int p2 = middle + 1;

        int[] tmp = new int[end - start + 1];
        for (int i = 0; i < tmp.length; i++) {
            if (p1 == middle + 1) {
                tmp[i] = array[p2++];
            } else if (p2 == end + 1) {
                tmp[i] = array[p1++];
            } else if (array[p1] < array[p2]) {
                tmp[i] = array[p1++];
            } else {
                tmp[i] = array[p2++];
            }
        }
        System.arraycopy(tmp, 0, array, start, tmp.length);
    }


    public static void main(String[] args) {
        Random random = new Random();
        int[] ints = IntStream.generate(() -> random.nextInt(5)).limit(100000).toArray();

        mergeSort(ints);

        System.out.println(Arrays.toString(ints));
    }
}
