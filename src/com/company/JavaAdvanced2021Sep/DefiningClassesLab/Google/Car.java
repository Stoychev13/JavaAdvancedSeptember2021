package com.company.JavaAdvanced2021Sep.DefiningClassesLab.Google;

public class Car {
    private String model;
    private String speed;

    public Car(String model, String speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return this.model + " " +
                this.speed + " ";
    }
}
