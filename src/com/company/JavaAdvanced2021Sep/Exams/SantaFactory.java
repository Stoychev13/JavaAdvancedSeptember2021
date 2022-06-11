package com.company.JavaAdvanced2021Sep.Exams;

import java.util.*;
import java.util.stream.Collectors;

public class SantaFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> magicLevel = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));


        ArrayDeque<Integer> materials = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(materials::push);

        Map<Integer, String> presentTable = new HashMap<>();
        presentTable.put(150, "Pear Sour ");
        presentTable.put(250, "Wooden train");
        presentTable.put(300, "Teddy bear");
        presentTable.put(400, "Bicycle");

        Map<String, Integer> toys = new TreeMap<>();
        presentTable
                .values()
                .forEach(p -> toys.put(p, 0));



        while (!materials.isEmpty() && !magicLevel.isEmpty()) {
            int firstMaterial = materials.peek();
            int firstMagicLevel = magicLevel.peek();

            int sum = firstMaterial * firstMagicLevel;

            if (ableToCrateToys(sum)) {
                String toy = presentTable.get(sum);
                toys.put(toy, toys.get(toy) + 1);

                materials.pop();
                magicLevel.poll();
            } else if (sum < 0) {
                sum = firstMaterial + firstMagicLevel;
                magicLevel.poll();
                materials.pop();

                materials.push(sum);
            } else if (firstMaterial == 0 || firstMagicLevel == 0 || sum == 0) {
                if (0 == firstMagicLevel) {
                    magicLevel.poll();
                } else {
                    materials.pop();
                }
            } else {
                magicLevel.poll();
                materials.pop();

                materials.push(firstMaterial + 15);
            }
        }

        if (completePairs(toys)) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (magicLevel.isEmpty()) {
            System.out.println("Materials left: " + materials.toString().replaceAll("[\\[\\]]", ""));
        } else {
            System.out.println("Magic left: " + magicLevel.toString().replaceAll("[\\[\\]]", ""));
        }

        toys.forEach((k, v) -> {
            if (v > 0) {
                System.out.println(k + ": " + v);
            }
        });
    }


    private static boolean completePairs(Map<String, Integer> toys) {
        return !toys.get("Bicycle").equals(0) && !toys.get("Teddy bear").equals(0) || !toys.get("Doll").equals(0) && !toys.get("Wooden train").equals(0);
    }

    private static boolean ableToCrateToys(int sum) {
        return sum == 150 || sum == 250 || sum == 300 || sum == 400;
    }
}
