package com.company.JavaAdvanced2021Sep.MultidimensionalArraysExercises;

import java.io.IOException;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = fillMatrix(scanner);

        int maxSum = Integer.MIN_VALUE;
        int row = 0;
        int col = 0;
        for (int rows = 0; rows < matrix.length - 2; rows++) {
            for (int cols = 0; cols < matrix[0].length - 2; cols++) {
                int sum = 0;
                sum += matrix[rows][cols] + matrix[rows][cols + 1] + matrix[rows][cols + 2];
                sum += matrix[rows + 1][cols] + matrix[rows + 1][cols + 1] + matrix[rows + 1][cols + 2];
                sum += matrix[rows + 2][cols] + matrix[rows + 2][cols + 1] + matrix[rows + 2][cols + 2];

                if (sum > maxSum) {
                    maxSum = sum;
                    row = rows;
                    col = cols;
                }
            }
        }


        System.out.println("Sum = " + maxSum);
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }


    }

    private static int[][] fillMatrix(Scanner scanner) throws IOException {
        String[] rowsCols = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(rowsCols[0]);
        int cols = Integer.parseInt(rowsCols[1]);

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] numInput = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(numInput[col]);
            }
        }
        return matrix;

    }
}

