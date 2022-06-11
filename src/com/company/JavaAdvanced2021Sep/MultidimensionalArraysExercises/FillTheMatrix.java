package com.company.JavaAdvanced2021Sep.MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[size][size];

        if (pattern.equals("A")) {
            fillPatternA(matrix, size);
        } else if (pattern.equals("B")) {
            fillPatternB(matrix, size);
        }

        printMatrix(matrix);

    }

    private static void fillPatternB(int[][] matrix, int size) {
        int startNumber = 1;
        for (int col = 0; col < size; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = startNumber;
                    startNumber++;
                }
            } else {
                for (int row = size - 1; row >= 0; row--) {
                    matrix[row][col] = startNumber;
                    startNumber++;
                }
            }
        }
    }

    private static void fillPatternA(int[][] matrix, int size) {
        // size -> count rows + count cols
        int startNumber = 1;
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] = startNumber;
                startNumber++;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int c : arr) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    private static int[][] readMatrix(int rows, Scanner scanner, String splitPattern) {
        int[][] matrix = new int[rows][];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine()
                    .split(splitPattern))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}
