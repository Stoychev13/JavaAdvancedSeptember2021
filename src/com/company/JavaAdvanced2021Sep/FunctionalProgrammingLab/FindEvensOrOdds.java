package com.company.JavaAdvanced2021Sep.FunctionalProgrammingLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputNumbers = scanner.nextLine().split("\\s+");
        String type = scanner.nextLine();

        int startNumber = Integer.parseInt(inputNumbers[0]);
        int endNumber = Integer.parseInt(inputNumbers[1]);

        List<Integer> numbers = new ArrayList<>();

        if (type.equals("odd")) {
            for (int i = startNumber; i <= endNumber; i++) {
                if (i % 2 != 0) {
                    numbers.add(i);
                }
            }
        } else if (type.equals("even")) {
            for (int i = startNumber; i <= endNumber; i++) {
                if (i % 2 == 0) {
                    numbers.add(i);
                }
            }
        }
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
    }
}
