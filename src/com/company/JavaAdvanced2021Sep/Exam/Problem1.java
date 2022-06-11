package com.company.JavaAdvanced2021Sep.Exam;

import java.util.*;
import java.util.stream.Collectors;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> ingredient = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> freshness = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(freshness::push);


        Map<Integer, String> cocktailTable = new LinkedHashMap<>();
        cocktailTable.put(150, "Pear Sour");
        cocktailTable.put(250, "The Harvest");
        cocktailTable.put(300, "Apple Hinny");
        cocktailTable.put(400, "High Fashion");

        Map<String, Integer> num = new TreeMap<>();
        cocktailTable
                .values()
                .forEach(p -> num.put(p, 0));


        while (!ingredient.isEmpty() && !freshness.isEmpty()) {
            int first = ingredient.peek();
            int second = freshness.peek();

            int sum = first * second;

            if (ableToCocktails(sum)) {
                String cocktail = cocktailTable.get(sum);
                num.put(cocktail, num.get(cocktail) + 1);

                ingredient.pop();
                freshness.poll();
            } else if (first == 0 || second == 0) {
                if (first == 0) {
                    ingredient.poll();
                } else {
                    freshness.pop();
                }
            } else {
                freshness.poll();
                ingredient.pop();

                int add = first + 5;
                ingredient.addLast(add);
            }
        }

        if (completePairs(num)) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!ingredient.isEmpty()) {
            int endSum = 0;
            for (int numbers : ingredient) {
                endSum += numbers;
            }

            if (endSum != 0) {
                System.out.printf("Ingredients left: %d\n", endSum);
            }
        }

        num.forEach((k, v) -> {
            if (v > 0) {
                System.out.println(" # " + k + " --> " + v);
            }
        });

    }

    private static boolean completePairs(Map<String, Integer> num) {
        if (num.size() >= 4) {
            return !num.get("Apple Hinny").equals(0) && !num.get("High Fashion").equals(0) || !num.get("Pear Sour").equals(0) && !num.get("The Harvest").equals(0);
        }
        return false;
    }

    private static boolean ableToCocktails(int sum) {
        return sum == 150 || sum == 250 || sum == 300 || sum == 400;
    }
}
