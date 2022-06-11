package com.company.JavaAdvanced2021Sep.Exams.Exam20Feb2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ProblemTwoBomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> commands = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",")).forEach(commands::offer);

        int[] sapperData = new int[3];

        char[][] bombField = createFieldFindSapperCountBombs(scanner, fieldSize, sapperData);

        boolean noMoreBombs = false;
        boolean sapperReachedEnd = false;

        while (!commands.isEmpty()) {
            int row = sapperData[0];
            int col = sapperData[1];
            int totalBombs = sapperData[2];
            String currentCommand = commands.pop();

            switch (currentCommand) {
                case "up":
                    if (row - 1 >= 0) {
                        row--;
                    }
                    break;

                case "down":
                    if (row + 1 < fieldSize) {
                        row++;
                    }
                    break;
                case "left":
                    if (col - 1 >= 0) {
                        col--;
                    }
                    break;

                case "right":
                    if (col + 1 < fieldSize) {
                        col++;
                    }
                    break;
            }
            if (bombField[row][col] == 'e') {
                sapperReachedEnd = true;
                break;
            }
            if (bombField[row][col] == 'B') {
                System.out.println("You found a bomb!");
                bombField[row][col] = '+';
                totalBombs--;
                sapperData[2] = totalBombs;
                if (totalBombs == 0) {
                    noMoreBombs = true;
                    break;
                }
            }
            sapperData[0] = row;
            sapperData[1] = col;
        }

        if (noMoreBombs) {
            System.out.print("Congratulations! You found all bombs!");
        }
        if (sapperReachedEnd) {
            System.out.printf("END! %d bombs left on the field", sapperData[2]);
        }
        if (!noMoreBombs && !sapperReachedEnd) {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)",
                    sapperData[2], sapperData[0], sapperData[1]);
        }
    }

    private static char[][] createFieldFindSapperCountBombs(Scanner scanner, int fieldSize, int[] sapperData) {
        char[][] bombField = new char[fieldSize][fieldSize];

        for (int row = 0; row < fieldSize; row++) {
            bombField[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();

            for (int col = 0; col < fieldSize; col++) {
                char currentPosition = bombField[row][col];
                if (currentPosition == 's') {
                    sapperData[0] = row;
                    sapperData[1] = col;
                }
                if (currentPosition == 'B') {
                    sapperData[2]++;
                }
            }
        }
        return bombField;
    }
}
