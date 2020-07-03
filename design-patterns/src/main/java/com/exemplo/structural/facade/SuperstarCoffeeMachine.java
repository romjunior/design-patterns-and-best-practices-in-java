package com.exemplo.structural.facade;

public class SuperstarCoffeeMachine implements CoffeeMachineFacade{
    @Override
    public CoffeeCup serveCoffee() throws Exception {
        CoffeeGrinder grinder = new SuperstarCoffeeGrinder();
        CoffeeMaker brewer = new SuperstarCoffeeMaker();
        CoffeeCup cup = new CoffeeCup();
        grinder.startGrinding();
        Thread.sleep(500);//wait for grind size coarse
        brewer.placeCup(cup);
        brewer.pourWater(new Water());
        brewer.startBrewing(grinder.stopGrinding());
        Thread.sleep(1000);//wait for the brewing process
        return brewer.finishBrewing();
    }
}
