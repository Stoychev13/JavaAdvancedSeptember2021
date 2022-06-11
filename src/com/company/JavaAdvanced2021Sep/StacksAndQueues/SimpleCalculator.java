package com.company.JavaAdvanced2021Sep.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] expressionElements = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = expressionElements.length - 1; i >= 0; i--) {
            stack.push(expressionElements[i]);
        }

        while (stack.size() > 1) {
            int right = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int left = Integer.parseInt(stack.pop());

            int result = operator.equals("+")
                    ? left + right
                    : right - left;

            stack.push(String.valueOf(result));

        }
        System.out.println(stack.pop());
    }
}
