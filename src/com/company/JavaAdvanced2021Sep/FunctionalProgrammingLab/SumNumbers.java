package com.company.JavaAdvanced2021Sep.FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int count = 0;
        int sum = 0;

        for (int num : numbers) {
            count++;
            sum += num;
        }

        System.out.printf("Count = %d\n", count);
        System.out.printf("Sum = %d", sum);

    }
}
