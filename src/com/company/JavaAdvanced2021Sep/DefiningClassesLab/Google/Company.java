package com.company.JavaAdvanced2021Sep.DefiningClassesLab.Google;

public class Company {
    private String companyName;
    private String department;
    private String salary;

    public Company(String companyName, String department, String salary) {
        this.companyName = companyName;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return this.companyName + " " +
                this.department + " " +
                this.salary + " ";
    }
}
