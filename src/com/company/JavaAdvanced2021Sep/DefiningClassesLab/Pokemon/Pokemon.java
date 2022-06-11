package com.company.JavaAdvanced2021Sep.DefiningClassesLab.Pokemon;

public class Pokemon {
    public String name;
    public String element;
    public String getName;
    private int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }


    public String getElement() {
        return element;
    }

    public void lowerHealth() {
        this.health -= 10;
    }

    public int getHealth() {
        return health;
    }

}
