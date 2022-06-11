package com.company.JavaAdvanced2021Sep.DefiningClassesLab.RawData;

import java.util.ArrayList;

public class Car {
    private String model;
    private int engineSpeed;
    private int hp;
    private int cargoW;
    private String cargoType;
    private ArrayList<Type> tyres;

    public Car(String model, int engineSpeed, int hp, int cargoW, String cargoType,ArrayList<Type>tyres) {
        this.model = model;
        this.engineSpeed = engineSpeed;
        this.hp = hp;
        this.cargoW = cargoW;
        this.cargoType = cargoType;
        this.tyres=tyres;
    }

    public ArrayList<Type> getTyres() {
        return tyres;
    }

    public void setTyres(ArrayList<Type> tyres) {
        this.tyres = tyres;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getEngineSpeed() {
        return engineSpeed;
    }

    public void setEngineSpeed(int engineSpeed) {
        this.engineSpeed = engineSpeed;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getCargoW() {
        return cargoW;
    }

    public void setCargoW(int cargoW) {
        this.cargoW = cargoW;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }
}
