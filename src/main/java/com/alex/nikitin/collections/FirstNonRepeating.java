package com.alex.nikitin.collections;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FirstNonRepeating {

    public static void main(String[] args) {
        Random random = new Random();


        List<Integer> list = IntStream.generate(() -> random.nextInt(500)).limit(50).boxed().collect(Collectors.toList());

        Set<Integer> metInts = new HashSet<>();
        Set<Integer> uniqueInts = new HashSet<>(list);//O(n)

        list.forEach(i -> {
            if (metInts.contains(i)) {//O(n)
                uniqueInts.remove(i);//O(n)
            } else {
                metInts.add(i);//O(n)
            }
        });






    }
}
