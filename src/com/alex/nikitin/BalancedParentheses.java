package com.alex.nikitin;

public class BalancedParentheses {

    public static void main(String[] args) {

        String validExpression = "(asf(vdf(fs)sdfdsf)sdf(dsfdsf))";
        String invalidExpression1 = ")sdfdsf(";
        String invalidExpression2 = "(fsdfsdf(fsdfdsf)";
        String invalidExpression3 = "(dfbdfbd(bdfbdf)bdfbfd)bdfbf)";

        String[] expressions = new String[] { validExpression, invalidExpression1, invalidExpression2, invalidExpression3 };

        testExpressions(expressions);
    }

    private static void testExpressions(String[] expressions) {
        for (int i = 0; i < expressions.length; i++) {
            Stack<Character> parentheses = new ArrayStack<>();
            char[] chars = expressions[i].toCharArray();

            boolean valid = true;
            for (char c : chars) {
                if (c == '(') {
                    parentheses.push('(');
                } else if (c == ')'){
                    if (!parentheses.isEmpty()) {
                        parentheses.pop();
                    } else {
                        valid = false;
                        break;
                    }
                }
            }
            if (!parentheses.isEmpty()) {
                valid = false;
            }
            System.out.println(valid);
        }
    }
}
