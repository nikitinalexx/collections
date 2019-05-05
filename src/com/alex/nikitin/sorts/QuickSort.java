package com.alex.nikitin.sorts;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class QuickSort {

    public static void sort(int[] array) {
        sortUtil(array, 0, array.length - 1);
    }

    private static void sortUtil(int[] array, int start, int end) {
        if (end - start < 1) {
            return;
        }
        int baseValue = array[start + (end - start) / 2];
        int i = start;
        int j = end;

        while (i <= j) {
            while (array[i] < baseValue) {
                i++;
            }
            while (array[j] > baseValue) {
                j--;
            }

            if (i <= j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            }
        }

        if (j > start) {
            sortUtil(array, start, j);
        }
        if (i < end) {
            sortUtil(array, i, end);
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] ints = IntStream.generate(() -> random.nextInt(5)).limit(50).toArray();
        System.out.println(Arrays.toString(ints));
        sort(ints);
        System.out.println(Arrays.toString(ints));

    }


}
