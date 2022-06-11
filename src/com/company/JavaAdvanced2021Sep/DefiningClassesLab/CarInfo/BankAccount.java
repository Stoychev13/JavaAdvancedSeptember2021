package com.company.JavaAdvanced2021Sep.DefiningClassesLab.CarInfo;

public class BankAccount {
    private static int accountsCount = 1;
    private static double interestRate = 0.02;

    private int id;

    private double balanced;

    public BankAccount() {
        this.id = accountsCount;
        accountsCount++;
    }

    public static void setInterestRate(double interest) {
        interestRate = interest;
    }

    public double getInterest(int years) {
        return interestRate * years * balanced;
    }

    public void deposit(double amount) {
        this.balanced += amount;
    }

    public int getId() {
        return id;
    }


}
