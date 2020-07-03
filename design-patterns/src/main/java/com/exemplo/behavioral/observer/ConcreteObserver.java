package com.exemplo.behavioral.observer;

public class ConcreteObserver implements Observer{

    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String oldState, String newState) {
        System.out.println(name + " oldState: " + oldState + " newState: " + newState);
    }
}
