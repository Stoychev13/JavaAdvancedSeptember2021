package com.company.JavaAdvanced2021Sep.Exams.Exam26June2021;

import java.util.Scanner;

public class ProblemTwoPython {
    static int food = 0;
    static int pRow = 0;
    static int pCol = 0;
    static int length = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[] commands = scanner.nextLine().split(", ");

        char[][] matrix = new char[size][size];

        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            matrix[i] = line.toCharArray();

            if (line.contains("s")) {
                pRow = i;
                pCol = line.indexOf("s");
            }

            for (char c : matrix[i]) {
                if (c == 'f') {
                    food++;
                }
            }
        }

        for (String command : commands) {
            switch (command) {
                case "up":
                    movePython(matrix, pRow - 1, pCol);
                    break;
                case "down":
                    movePython(matrix, pRow + 1, pCol);
                    break;
                case "left":
                    movePython(matrix, pRow, pCol - 1);
                    break;
                case "right":
                    movePython(matrix, pRow, pCol + 1);
                    break;
            }
            if (length == -1 || food == 0) {
                break;
            }
        }

        if (food == 0) {
            System.out.println("You win! Final python length is " + length);
        } else if (food > 0 && length != -1) {
            System.out.println("You lose! There is still " + food + " food to be eaten.");
        } else {
            System.out.println("You lose! Killed by an enemy!");
        }
    }

    private static void movePython(char[][] matrix, int newRow, int newCol) {
        if (isOutOfBounds(matrix, newRow, newCol)) {
            int[] newIndexes = flipSnakeSide(matrix.length, newRow, newCol);
            newRow = newIndexes[0];
            newCol = newIndexes[1];
        }

        if (matrix[newRow][newCol] == 'e') {
            length = -1;
        } else if (matrix[newRow][newCol] == 'f') {
            length++;
            food--;
        }

        pRow = newRow;
        pCol = newCol;
    }

    private static int[] flipSnakeSide(int length, int newRow, int newCol) {
        int[] result = new int[2];
        if (newRow < 0) {
            result[0] = length - 1;
            result[1] = newCol;

        } else if (newRow >= length) {
            result[1] = newCol;

        } else if (newCol < 0) {
            result[0] = newRow;
            result[1] = length - 1;

        } else {
            result[0] = newRow;
        }
        return result;
    }

    private static boolean isOutOfBounds(char[][] matrix, int newRow, int newCol) {
        return newRow < 0 || newRow >= matrix.length || newCol < 0 || newCol >= matrix[newRow].length;
    }
}
