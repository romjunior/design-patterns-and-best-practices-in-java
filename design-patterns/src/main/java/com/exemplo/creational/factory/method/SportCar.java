package com.exemplo.creational.factory.method;

public class SportCar implements Vehicle {

    private String color;

    @Override
    public void drive() {
        System.out.println("Sport Car drive");
    }

    @Override
    public void setColor(final String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return this.color;
    }
}
