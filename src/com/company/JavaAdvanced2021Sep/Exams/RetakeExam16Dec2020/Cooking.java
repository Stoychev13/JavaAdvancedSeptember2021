package com.company.JavaAdvanced2021Sep.Exams.RetakeExam16Dec2020;

import java.util.*;
import java.util.stream.Collectors;

public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Queue
        ArrayDeque<Integer> firstNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        // Stack

        ArrayDeque<Integer> secondNumbers = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondNumbers::push);

        Map<Integer, String> cookingTable = new HashMap<>();
        cookingTable.put(25, "Bread");
        cookingTable.put(50, "Cake");
        cookingTable.put(75, "Pastry");
        cookingTable.put(100, "Fruit Pie");

        Map<String, Integer> productsCooked = new TreeMap<>();
        cookingTable
                .values()
                .forEach(p -> productsCooked.put(p, 0));


        while (!firstNumbers.isEmpty() && !secondNumbers.isEmpty()) {
            int currentLiquid = firstNumbers.poll();
            int currentIngredient = secondNumbers.pop();

            int sum = currentLiquid + currentIngredient;

            if (ableToCookProduct(sum)) {
                String product = cookingTable.get(sum);
                productsCooked.put(product, productsCooked.get(product) + 1);

            } else {
                secondNumbers.push(currentIngredient + 3);
            }
        }

        if (hasCookedEachMeal(productsCooked)) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        System.out.println("Liquids left: " + getElementsInfo(firstNumbers));
        System.out.println("Ingredients left: " + getElementsInfo(secondNumbers));

        productsCooked.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });

    }

    private static String getElementsInfo(ArrayDeque<Integer> firstNumbers) {
        return firstNumbers.isEmpty()
                ? "none"
                : firstNumbers.
                stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

    }

    private static boolean hasCookedEachMeal(Map<String, Integer> productsCooked) {
        for (Integer value : productsCooked.values()) {
            if (value == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean ableToCookProduct(int sum) {
        return sum == 25 || sum == 50 || sum == 75 || sum == 100;
    }
}
