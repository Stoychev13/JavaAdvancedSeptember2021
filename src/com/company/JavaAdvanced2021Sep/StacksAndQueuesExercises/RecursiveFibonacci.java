package com.company.JavaAdvanced2021Sep.StacksAndQueuesExercises;

import java.util.Scanner;

public class RecursiveFibonacci {
    private static long[] memo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        memo = new long[n + 1];
        System.out.println(recursiveFibonacciWithMemoization(n));
    }

    private static long recursiveFibonacciWithMemoization(int n) {
        if (n <= 1) {
            return 1;
        }

        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] =
                recursiveFibonacciWithMemoization(n - 1) +
                        recursiveFibonacciWithMemoization(n - 2);
        return memo[n];
    }
}

