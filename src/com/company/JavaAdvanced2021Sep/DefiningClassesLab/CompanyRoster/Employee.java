package com.company.JavaAdvanced2021Sep.DefiningClassesLab.CompanyRoster;

public class Employee {
    public String name;
    public double salary;
    public String position;
    public String department;
    public String email;
    public int age;

    public Employee(Builder builder) {
        this.name = builder.name;
        this.salary = builder.salary;
        this.position = builder.position;
        this.department = builder.department;
        this.email = builder.email;
        this.age = builder.age;
    }



    public static class Builder {
        private String name;
        private double salary;
        private String position;
        private String department;
        private String email = "n/a";
        private int age = -1;

        Builder name(String name){
            this.name = name;
            return this;
        }

        Builder salary(Double salary){
            this.salary = salary;
            return this;
        }

        Builder position(String position){
            this.position = position;
            return this;
        }

        Builder department(String department){
            this.department = department;
            return this;
        }

        Builder email(String email){
            this.email = email;
            return this;
        }

        Builder age(Integer age){
            this.age = age;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}
