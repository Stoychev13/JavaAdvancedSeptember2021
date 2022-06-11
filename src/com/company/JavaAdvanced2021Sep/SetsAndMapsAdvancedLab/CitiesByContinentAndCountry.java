package com.company.JavaAdvanced2021Sep.SetsAndMapsAdvancedLab;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<String>>> countries = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            countries.putIfAbsent(continent, new LinkedHashMap<>());
            Map<String, List<String>> map = countries.get(continent);
            map.putIfAbsent(country, new ArrayList<>());
            List<String> cities = map.get(country);
            cities.add(city);
        }
        countries.entrySet()
                .stream()
                .forEach(e -> {
                    System.out.println(e.getKey() + ":");

                    e.getValue().entrySet()
                            .stream()
                            .forEach(ie -> {
                                System.out.println("  " + ie.getKey() + " -> " + String.join(", ", ie.getValue()));
                            });
                });
    }
}
