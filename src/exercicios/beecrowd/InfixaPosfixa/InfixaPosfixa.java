package exercicios.beecrowd.InfixaPosfixa;

import java.util.Stack;

public class InfixaPosfixa {

    public static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        String infix = "(2*4/a^b)/(2*c)";
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    return; // invalid expression
                } else {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop all the remaining operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return; // invalid expression
            }
            postfix.append(stack.pop());
        }

        System.out.println(postfix.toString());
    }
}