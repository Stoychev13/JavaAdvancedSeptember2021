package com.company.JavaAdvanced2021Sep.Exams.Exam14April2021;

import java.util.*;
import java.util.stream.Collectors;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tulips = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(tulips::push);

        ArrayDeque<Integer> daffodils = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        List<Integer> leftFlowers = new ArrayList<>();

        int numBouquets = 0;

        while (!tulips.isEmpty() && !daffodils.isEmpty()) {
            int currentTulips = tulips.peek();
            int currentDaffodils = daffodils.peek();

            int sum = currentTulips + currentDaffodils;

            if (sum == 15) {
                numBouquets++;
                tulips.pop();
                daffodils.poll();
            } else if (sum > 15) {
                tulips.removeFirst();
                tulips.push(currentTulips - 2);
            } else {
                leftFlowers.add(0, sum);
                tulips.pop();
                daffodils.poll();
            }
        }


        int allLeftNumbers = 0;
        if (!leftFlowers.isEmpty()) {
            for (int num : leftFlowers) {
                allLeftNumbers += num;
            }
            if (allLeftNumbers > 15) {
                allLeftNumbers = Math.abs(allLeftNumbers / 15);
                numBouquets += allLeftNumbers;
            }
        }

        if (numBouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", numBouquets);
        } else {
            numBouquets = Math.abs(numBouquets - 5);
            System.out.printf("You failed... You need more %d bouquets.", numBouquets);
        }

    }
}
