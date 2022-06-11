package com.company.JavaAdvanced2021Sep.DefiningClassesLab.SpeedRacing;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int carsAmount = Integer.parseInt(scanner.nextLine());

        Map<String, Car> cars = new TreeMap<>();

        for (int i = 0; i < carsAmount; i++) {
            String[] line = scanner.nextLine().split("\\s+");

            String carModel = line[0];
            double fuel = Double.parseDouble(line[1]);
            double fuelCostPerKm = Double.parseDouble(line[2]);
            cars.put(carModel, new Car(carModel, fuel, fuelCostPerKm));
        }
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("End")) {
                break;
            }
            String[] lineArr = line.split("\\s+");

            String carModelToDrive = lineArr[1];
            int kmToDrive = Integer.parseInt(lineArr[2]);
            if (!cars.get(carModelToDrive).canCarMove(kmToDrive)) {
                System.out.println("Insufficient fuel for the drive");
            }
        }

        for (Car car : cars.values()) {
            System.out.printf("%s %s %d%n", car.carModel, String.format("%.2f", car.fuelAmount), car.distanceTraveled);
        }
    }

}

