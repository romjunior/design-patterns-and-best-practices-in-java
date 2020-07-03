package com.exemplo.structural.facade;

public class SuperstarCoffeeGrinder implements CoffeeGrinder{
    @Override
    public void startGrinding() {
        System.out.println("Grinding...");
    }

    @Override
    public GroundCoffee stopGrinding() {
        System.out.println("Done grinding");
        return new GroundCoffee();
    }
}
