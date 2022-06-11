package com.company.JavaAdvanced2021Sep.DefiningClassesLab.RawData;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new LinkedList<>();

        int num = Integer.parseInt(scanner.nextLine());
        while (num-- > 0) {
            String[] inline = scanner.nextLine().split("\\s+");
            String model = inline[0];
            int engineSpeed = Integer.parseInt(inline[1]);
            int hp = Integer.parseInt(inline[2]);
            int cargoW = Integer.parseInt(inline[3]);
            String cargoType = inline[4];

            ArrayList<Type> tyres = new ArrayList<>();
            Type tyre = new Type(Double.parseDouble(inline[5]), Integer.parseInt(inline[6]),
                    Double.parseDouble(inline[7]), Integer.parseInt(inline[8]),
                    Double.parseDouble(inline[9]), Integer.parseInt(inline[10]),
                    Double.parseDouble(inline[11]), Integer.parseInt(inline[12]));
            tyres.add(tyre);


            Car car = new Car(model, engineSpeed, hp, cargoW, cargoType, tyres);
            cars.add(car);
        }
        String type = scanner.nextLine();
        if (type.equals("fragile")) {
            List<String> model = new ArrayList<>();
            for (Car car : cars) {
                if (car.getTyres().get(0).getPressure1() < 1 || car.getTyres().get(0).getPressure2() < 1
                        || car.getTyres().get(0).getPressure3() < 1 || car.getTyres().get(0).getPressure4() < 1) {
                    model.add(car.getModel());
                }

            }
            model.forEach(System.out::println);
        } else {
            cars.forEach(e -> {
                if (e.getHp() >= 250) {
                    System.out.printf("%s%n", e.getModel());
                }
            });
        }
    }
}
