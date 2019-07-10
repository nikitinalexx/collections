package com.alex.nikitin.collections;

public class SortStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
    }

    // This function return the sorted stack
    private static Stack<Integer> sortstack(Stack<Integer> input) {
        Stack<Integer> tmpStack = new ArrayStack<>();
        while (!input.isEmpty()) {
            int tmp = input.pop();

            while (!tmpStack.isEmpty() && tmpStack.top() > tmp) {
                input.push(tmpStack.pop());
            }

            tmpStack.push(tmp);
        }
        return tmpStack;
    }
}
