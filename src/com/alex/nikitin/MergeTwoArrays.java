package com.alex.nikitin;

public class MergeTwoArrays {

    public static void main(String[] args) {
        int[] first = new int[]{1, 5, 35, 90, 103};
        int[] second = new int[]{3, 20, 25, 60, 92, 110, 120, 130, 140};

        int firstIndex = 0;
        int secondIndex = 0;
        int totalSize = first.length + second.length;

        int[] result = new int[totalSize];

        for (int i = 0; i < totalSize; i++) {
            if (firstIndex == first.length) {
                result[i] = second[secondIndex++];
            } else if (secondIndex == second.length) {
                result[i] = first[firstIndex++];
            } else {
                if (first[firstIndex] < second[secondIndex]) {
                    result[i] = first[firstIndex++];
                } else {
                    result[i] = second[secondIndex++];
                }
            }
            System.out.print(result[i] + ", ");
        }
    }
}
