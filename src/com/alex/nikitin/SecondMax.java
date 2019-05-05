package com.alex.nikitin;

import java.util.Random;

public class SecondMax {

    public static void main(String[] args) {
        ArrayList<Integer> myArrayList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            myArrayList.add(random.nextInt(500));
        }
        System.out.println(myArrayList);

        int max = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;

        for (int i = 0; i < 10; i++) {
            if (myArrayList.get(i) > max) {
                smax = max;
                max = myArrayList.get(i);
            } else if (myArrayList.get(i) > smax) {
                smax = myArrayList.get(i);
            }
        }
        System.out.println(max);
        System.out.println(smax);
    }
}
