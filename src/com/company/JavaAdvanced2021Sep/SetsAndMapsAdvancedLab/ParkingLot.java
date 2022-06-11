package com.company.JavaAdvanced2021Sep.SetsAndMapsAdvancedLab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = "";
        Set<String> cars = new LinkedHashSet<>();

        while (true) {
            String[] input = scanner.nextLine().split(", ");
            command = input[0];
            if (command.equals("END")) {
                break;
            }
            String carNumber = input[1];

            if (command.equals("IN")) {
                cars.add(carNumber);
            } else if (command.equals("OUT")) {
                cars.remove(carNumber);
            }
        }
        if (cars.size() > 0) {
            for (String print : cars) {
                System.out.println(print);
            }
        } else {
            System.out.println("Parking Lot is Empty");
        }
    }
}
