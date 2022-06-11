package com.company.JavaAdvanced2021Sep.DefiningClassesLab.CarInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, BankAccount> bankAccounts = new HashMap<>();
        String command = scanner.nextLine();
        String output = null;

        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");

            switch (tokens[0]) {
                case "Create":
                    BankAccount account = new BankAccount();
                    bankAccounts.put(account.getId(), account);
                    output = "Account ID" + account.getId() + " created";
                    break;
                case "Deposit": {
                    int id = Integer.parseInt(tokens[1]);
                    int amount = Integer.parseInt(tokens[2]);

                    if (!bankAccounts.containsKey(id)) {
                        output = "Account does not exist";
                    } else {
                        bankAccounts.get(id).deposit(amount);
                        output = "Deposited " + amount + " to ID" + id;
                    }
                    break;
                }
                case "SetInterest":
                    BankAccount.setInterestRate(Double.parseDouble(tokens[1]));
                    break;
                default: {
                    int id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);

                    if (!bankAccounts.containsKey(id)) {
                        output = "Account does not exist";
                    } else {
                        double interest = bankAccounts.get(id).getInterest(years);
                        output = String.format("%.2f", interest);
                    }
                    break;
                }
            }

            if (output != null) {
                System.out.println(output);
            }

            command = scanner.nextLine();
        }


    }
}
