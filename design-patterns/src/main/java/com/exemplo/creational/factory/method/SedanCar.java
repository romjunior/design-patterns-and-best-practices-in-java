package com.exemplo.creational.factory.method;

public class SedanCar implements Vehicle {

    private String color;

    @Override
    public void drive() {
        System.out.println("Sedan Car drive");
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return this.color;
    }
}
