package com.company.JavaAdvanced2021Sep.DefiningClassesLab.OpinionPoll;

import java.util.*;

public class PeopleFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputNumber = Integer.parseInt(scanner.nextLine());

        Person person;
        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < inputNumber; i++) {
            String[] peopleInformation = scanner.nextLine().split("\\s+");

            person = new Person(peopleInformation[0], Integer.parseInt(peopleInformation[1]));
            if (person.getAge() >= 30) {
                personList.add(person);
            }
        }

        personList
                .stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach((p -> System.out.printf("%s - %d%n", p.name, p.age)));
    }
}
