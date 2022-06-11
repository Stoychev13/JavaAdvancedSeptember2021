package com.company.JavaAdvanced2021Sep.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> history = new ArrayDeque<>();
        String command = scanner.nextLine();
        String currentUrl = "";

        while (!command.equals("Home")) {
            if (command.equals("back")) {
                if (history.isEmpty()) {
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                }
                currentUrl = history.pop();

            } else {
                if (!currentUrl.equals("")) {
                    history.push(currentUrl);
                }
                currentUrl = command;
            }

            System.out.println(currentUrl);
            command = scanner.nextLine();
        }
    }
}
