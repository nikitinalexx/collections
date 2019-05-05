package com.alex.nikitin;

public class PostfixTest {

    public static void main(String[] args) {
        String expression = "2 3 1 * + 9 -";

        Stack<Integer> stack = new LinkedStack<>();

        String[] values = expression.split(" ");
        for (int i = 0; i < values.length; i++) {
            switch (values[i]) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int f = stack.pop();
                    stack.push(stack.pop() - f);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int first = stack.pop();
                    stack.push(stack.pop() / first);
                    break;
                default:
                    stack.push(Integer.parseInt(values[i]));
            }
        }
        System.out.println(stack.top());
    }
}
