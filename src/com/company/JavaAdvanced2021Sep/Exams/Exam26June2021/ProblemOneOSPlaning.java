package com.company.JavaAdvanced2021Sep.Exams.Exam26June2021;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProblemOneOSPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> exercises = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> threads = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int killedNumber = Integer.parseInt(scanner.nextLine());
        int threadValue = 0;

        for (int i = exercises.size() - 1; i > 0; i--) {
            for (int j = 0; j < threads.size(); j++) {
                int firstNum = exercises.get(exercises.size() - 1);
                int secondNum = threads.get(0);

                if (killedNumber == firstNum || killedNumber == secondNum) {
                    threadValue += secondNum;
                    break;
                }

                if (secondNum >= firstNum) {
                    exercises.remove(exercises.size() - 1);
                    i--;
                }
                threads.remove(0);

            }
        }

        List<Integer> leftNumbers = new LinkedList<>(threads);

        System.out.printf("Thread with value %d ", threadValue);
        System.out.printf("killed task %d\n", killedNumber);
        System.out.println(leftNumbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
