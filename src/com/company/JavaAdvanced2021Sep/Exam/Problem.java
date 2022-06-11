package com.company.JavaAdvanced2021Sep.Exam;

import java.util.*;
import java.util.stream.Collectors;

public class Problem {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> ingredient = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        Deque<Integer> freshness = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(freshness::push);

        Map<String, Integer> num = new TreeMap<>();
        num.put("Pear Sour", 0);
        num.put("The Harvest", 0);
        num.put("Apple Hinny", 0);
        num.put("High Fashion", 0);

        while (!freshness.isEmpty() || !ingredient.isEmpty()) {
            if (ingredient.isEmpty() || freshness.isEmpty()) {
                break;
            }
            int first = ingredient.poll();
            int second = freshness.pop();
            int sum = first * second;

            switch (sum) {
                case 150:
                    num.put("Pear Sour", num.get("Pear Sour") + 1);
                    break;
                case 250:
                    num.put("The Harvest", num.get("The Harvest") + 1);
                    break;
                case 300:
                    num.put("Apple Hinny", num.get("Apple Hinny") + 1);
                    break;
                case 400:
                    num.put("High Fashion", num.get("High Fashion") + 1);
                    break;
                default:
                    ingredient.offerLast(first + 5);
                    break;
            }
            sum = 0;
        }
        if (num.get("Pear Sour") > 0 && num.get("The Harvest") > 0 && num.get("Apple Hinny") > 0 && num.get("High Fashion") > 0) {
            System.out.println("It's party time! The cocktails are ready!");
            num.forEach((key, value) -> System.out.printf("# %s --> %d\n", key, value));
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
            if (!ingredient.isEmpty()) {
                int totalSum = 0;
                for (Integer queueIngredient : ingredient) {
                    totalSum += queueIngredient;
                }
                System.out.printf("Ingredients left: %d\n", totalSum);
            }
            if (num.get("Pear Sour") > 0) {
                System.out.printf("# Pear Sour --> %d\n", num.get("Pear Sour"));

            }
            if (num.get("The Harvest") > 0) {
                System.out.printf("# The Harvest --> %d\n", num.get("The Harvest"));

            }
            if (num.get("Apple Hinny") > 0) {
                System.out.printf("# Apple Hinny --> %d\n", num.get("Apple Hinny"));

            }
            if (num.get("High Fashion") > 0) {
                System.out.printf("# High Fashion --> %d\n", num.get("High Fashion"));

            }
        }
    }
}
