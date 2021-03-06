package com.company.JavaAdvanced2021Sep.FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> evenNumber = numbers
                .stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());

        String firstOutput = evenNumber
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(firstOutput);


        String secondOutput = evenNumber
                .stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(secondOutput);
    }
}
