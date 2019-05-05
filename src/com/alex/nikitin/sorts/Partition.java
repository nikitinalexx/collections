package com.alex.nikitin.sorts;

import java.util.Arrays;

public class Partition {

    public static int[] rearrange(int[] array) {
        int start = 0;
        int end = array.length - 1;

        boolean negativeFirst = array[0] > 0;
        int baseValue = 0;
        int i = start;
        int j = end;

        while (i <= j) {
            while (i <= end && array[i] < baseValue) {
                i++;
            }
            while (j >= start && array[j] > baseValue) {
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

        int[] result = new int[array.length];
        int r1 = 0;
        int r2 = j + 1;
        for (int k = 0; k < result.length; ) {
            if (negativeFirst) {
                if (r1 != i) {
                    result[k++] = array[r1++];
                }
                if (r2 != end + 1) {
                    result[k++] = array[r2++];
                }
            } else {
                if (r2 != end + 1) {
                    result[k++] = array[r2++];
                }
                if (r1 != i) {
                    result[k++] = array[r1++];
                }
            }
        }
        return result;
    }

    public static int[] partition(int[] array) {
        int i = 0;

        for (int j = 0; j < array.length; j++) {
            if (array[j] < 0) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
            }
        }

        int negative = 0;
        int positive = i;

        while (negative < positive && positive != array.length) {
            int tmp = array[negative];
            array[negative] = array[positive];
            array[positive] = tmp;
            negative += 2;
            positive++;
        }

        return array;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 2, -3, 4, 5, 6, -7, 8, 9, -1, -2, -3, -4, -5, 3, 6, 7, 9, 10, 11};
        System.out.println(Arrays.toString(partition(arr)));
        //-1 -2 4   5 6 7 8
    }
}
