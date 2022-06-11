package com.company.JavaAdvanced2021Sep.DefiningClassesLab.Google;

public class Children {
    private String name;
    private String birthday;

    public Children(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        StringBuilder strBuild = new StringBuilder();
        strBuild.append(this.name).append(" ");
        strBuild.append(this.birthday).append(" ");
        return strBuild.toString();
    }
}
