package com.company.JavaAdvanced2021Sep.DefiningClassesLab.Google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> map = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String personName = tokens[0];
            String key = tokens[1];
            if (!map.containsKey(personName)) {
                Person newPerson = new Person();
                switch (key) {
                    case "company":
                        String companyName = tokens[2];
                        String department = tokens[3];
                        String salary = tokens[4];
                        Company newCompany = new Company(companyName, department, salary);
                        newPerson.setCompany(newCompany);
                        break;
                    case "pokemon":
                        String pokemonName = tokens[2];
                        String pokemonType = tokens[3];
                        Pokemon newPokemon = new Pokemon(pokemonName, pokemonType);
                        newPerson.setPokemon(newPokemon);
                        break;
                    case "parents":
                        String parentName = tokens[2];
                        String parentBirthday = tokens[3];
                        Parents newParents = new Parents(parentName, parentBirthday);
                        newPerson.setParents(newParents);
                        break;
                    case "children":
                        String childName = tokens[2];
                        String childBirthday = tokens[3];
                        Children newChildren = new Children(childName, childBirthday);
                        newPerson.setChildren(newChildren);
                        break;
                    case "car":
                        String carModel = tokens[2];
                        String carSpeed = tokens[3];
                        Car newCar = new Car(carModel, carSpeed);
                        newPerson.setCar(newCar);
                        break;
                }
                map.put(personName, newPerson);
            } else {
                switch (key) {
                    case "company":
                        String companyName = tokens[2];
                        String department = tokens[3];
                        String salary = tokens[4];
                        Company newCompany = new Company(companyName, department, salary);
                        map.get(personName).setCompany(newCompany);
                        break;
                    case "pokemon":
                        String pokemonName = tokens[2];
                        String pokemonType = tokens[3];
                        Pokemon newPokemon = new Pokemon(pokemonName, pokemonType);
                        map.get(personName).setPokemon(newPokemon);
                        break;
                    case "parents":
                        String parentName = tokens[2];
                        String parentBirthday = tokens[3];
                        Parents newParents = new Parents(parentName, parentBirthday);
                        map.get(personName).setParents(newParents);
                        break;
                    case "children":
                        String childName = tokens[2];
                        String childBirthday = tokens[3];
                        Children newChildren = new Children(childName, childBirthday);
                        map.get(personName).setChildren(newChildren);
                        break;
                    case "car":
                        String carModel = tokens[2];
                        String carSpeed = tokens[3];
                        Car newCar = new Car(carModel, carSpeed);
                        map.get(personName).setCar(newCar);
                        break;
                }
            }
            input = scanner.nextLine();
        }

        String printName = scanner.next();
        System.out.println(printName);
        System.out.println(map.get(printName).toString());

    }
}
