package com.company.JavaAdvanced2021Sep.DefiningClassesLab.CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        Map<String, ArrayList<Employee>> employeeList = new HashMap<>();
        Map<String, ArrayList<Double>> averageDepartmentSalary = new HashMap<>();

        for (int i = 0; i < count; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            addEmployee(input, employeeList);
            if (!averageDepartmentSalary.containsKey(input[3])) {
                averageDepartmentSalary.put(input[3], new ArrayList<>());

            }
            averageDepartmentSalary.get(input[3]).add(Double.parseDouble(input[1]));


        }


        String highestAverageSalary = averageDepartmentSalary.entrySet().stream()
                .max((entry1, entry2) -> averageValue(entry1.getValue()) > averageValue(entry2.getValue()) ? 1 : -1).get().getKey();


        for (Map.Entry<String, ArrayList<Employee>> arg : employeeList.entrySet()) {
            if (arg.getKey().equals(highestAverageSalary)) {
                System.out.printf("Highest Average Salary: %s%n", arg.getKey());
                arg.getValue().
                        stream().
                        sorted((p1, p2) -> Double.compare(p2.salary, p1.salary)).
                        forEach(employee -> System.out.printf("%s %.2f %s %d%n",
                                employee.name,
                                employee.salary,
                                employee.email,
                                employee.age));


            }


        }


    }

    private static void addEmployee(String[] input, Map<String, ArrayList<Employee>> employeeList) {
        int numStats = input.length;
        if (!employeeList.containsKey(input[3])) {
            employeeList.put(input[3], new ArrayList<>());
        }
        switch (numStats) {

            case 4:
                employeeList.get(input[3]).add(new Employee.Builder().
                        name(input[0]).
                        salary(Double.parseDouble(input[1])).
                        position(input[2]).
                        department(input[3]).
                        build());

                break;

            case 5:
                if (input[4].contains("@")) {
                    employeeList.get(input[3]).add(new Employee.Builder().
                            name(input[0]).
                            salary(Double.parseDouble(input[1])).
                            position(input[2]).
                            department(input[3]).
                            email(input[4]).
                            build());
                } else {
                    employeeList.get(input[3]).add(new Employee.Builder().
                            name(input[0]).
                            salary(Double.parseDouble(input[1])).
                            position(input[2]).
                            department(input[3]).
                            age(Integer.parseInt(input[4])).
                            build());
                }

                break;

            case 6:
                employeeList.get(input[3]).add(new Employee.Builder().
                        name(input[0]).
                        salary(Double.parseDouble(input[1])).
                        position(input[2]).
                        department(input[3]).
                        email(input[4]).
                        age(Integer.parseInt(input[5])).
                        build());
                break;
        }
    }

    private static Double averageValue(ArrayList<Double> value) {

        return value.stream().mapToDouble(i -> i).average().orElse(0);
    }

}
