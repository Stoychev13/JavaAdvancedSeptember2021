package com.company.JavaAdvanced2021Sep.StreamsFilesAndDirectoriesLabExercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class SumLines {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String path = "D:\\programirane\\JavaAdvancedSeptember2021\\src\\com\\company\\JavaAdvanced2021Sep\\StreamsFilesAndDirectoriesLabExercises\\SumLines.txt";

        Files.readAllLines(Path.of(path)).stream()
                .map(String::toCharArray)  //str -> str.toCharArray
                .forEach(charArray ->
                {
                    int sum = 0;
                    for (char symbol : charArray) {
                        sum += symbol;
                    }
                    System.out.println(sum);
                });
    }
}
