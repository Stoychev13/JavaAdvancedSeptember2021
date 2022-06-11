package com.company.JavaAdvanced2021Sep.FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        Predicate<String> isUpperCase = s -> Character.isUpperCase(s.charAt(0));

        List<String> upperCaseString = Arrays.stream(input)
                .filter(isUpperCase)
                .collect(Collectors.toList());

        System.out.println(upperCaseString.size());
        System.out.println(String.join(System.lineSeparator(), upperCaseString));


    }
}
