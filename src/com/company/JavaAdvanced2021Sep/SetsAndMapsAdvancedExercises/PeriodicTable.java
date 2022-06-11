package com.company.JavaAdvanced2021Sep.SetsAndMapsAdvancedExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> elements = new TreeSet<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] inputElements = input.split("\\s+");

            elements.addAll(Arrays.asList(inputElements));
        }

        elements.forEach(el -> System.out.print(el + " "));


    }
}
