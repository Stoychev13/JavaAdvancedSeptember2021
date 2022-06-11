package com.company.JavaAdvanced2021Sep.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine().split(", ")[0]);

        int[][] matrix = readMatrix(rows, scanner, ", ");
        int sum = 0;
        int[][] maxMatrix = new int[2][2];

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int current = matrix[row][col];
                int inRight = matrix[row][col + 1];
                int inBottom = matrix[row + 1][col];
                int leftRight = matrix[row + 1][col + 1];

                int currentSum = current + inRight + inBottom + leftRight;

                if (sum < currentSum) {
                    sum = currentSum;
                    maxMatrix = new int[][]{
                            {current, inRight},
                            {inBottom, leftRight}
                    };
                }
            }
        }
        printMatrix(maxMatrix);
        System.out.println(sum);
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
