package com.company.JavaAdvanced2021Sep.DefiningClassesLab.CarInfo;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    public Car(String carBrand, String carModel, int hP) {
        this.brand = carBrand;
        this.model = carModel;
        this.horsePower = hP;
    }

    public Car(String brand, String model) {
        this(brand, model, 0);
    }

    public Car(String brand, int horsePower) {
        this(brand, null, 0);
    }

    public Car(String brand) {
        this(brand, "unknown", -1);
    }


    //getters

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    //setters

    public void setHorsePower(int horsePower) {
        if (horsePower < 0) {
            horsePower = 0;
        }

        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.",
                this.getBrand(), this.getModel(), this.getHorsePower());
    }
}
