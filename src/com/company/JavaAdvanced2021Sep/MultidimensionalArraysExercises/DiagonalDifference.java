package com.company.JavaAdvanced2021Sep.MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];
        fillMatrix(scanner, matrix, size);

        int sumPrimary = getSumOfPrimaryDiagonal(matrix, size);
        int sumSecondary = getSumOfSecondaryDiagonal(matrix, size);

        System.out.println(Math.abs(sumPrimary - sumSecondary));
    }

    private static int getSumOfSecondaryDiagonal(int[][] matrix, int size) {
        int sum = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (col == size - row - 1) {
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }

    private static int getSumOfPrimaryDiagonal(int[][] matrix, int size) {
        int sum = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (row == col) {
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }

    private static void fillMatrix(Scanner scanner, int[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = scanner.nextInt();
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
