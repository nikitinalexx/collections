package com.alex.nikitin;

public class ReverseQueueElements {

    public static <T> void reverse(Queue<T> queue, int k) {
        Stack<T> stack = new ArrayStack<>();

        for (int i = 0; i < k; i++) {
            stack.push(queue.dequeue());
        }

        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }

        for (int i = 0; i < queue.size() - k; i++) {
            queue.enqueue(queue.dequeue());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedQueue<>();
        for (int i = 10; i <= 100; i += 10) {
            queue.enqueue(i);
        }
        System.out.println(queue);
        reverse(queue, 5);
        System.out.println(queue);
    }
}
