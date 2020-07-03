package com.exemplo.structural.facade;

public class SuperstarCoffeeMaker implements CoffeeMaker{

    @Override
    public void pourWater(Water water) {
        System.out.println("Pouring water...");
    }

    @Override
    public void placeCup(CoffeeCup cup) {
        System.out.println("Placing the cup...");
    }

    @Override
    public void startBrewing(GroundCoffee groundCoffee) {
        System.out.println("Brewing...");
    }

    @Override
    public CoffeeCup finishBrewing() {
        System.out.println("Done brewing. Enjoy!");
        return null;
    }
}
