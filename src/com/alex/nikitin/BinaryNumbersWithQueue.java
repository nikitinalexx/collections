package com.alex.nikitin;

public class BinaryNumbersWithQueue {

    public static void main(String[] args) {
        Queue<String> numbers = new LinkedQueue<>();
        numbers.enqueue("1");

        int n = 10;

        for (int i = 0; i < n; i++) {
            String binary = numbers.dequeue();
            System.out.println(binary);
            numbers.enqueue(binary + '0');
            numbers.enqueue(binary + '1');
        }
    }
}
