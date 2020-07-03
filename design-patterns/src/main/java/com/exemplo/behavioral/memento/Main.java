package com.exemplo.behavioral.memento;

public class Main {

    public static void main(String... args) {
        CarOriginator.Memento savedState = new CarOriginator.Memento("");

        CarOriginator originator = new CarOriginator();
        originator.setState("state1");
        originator.setState("state2");
        savedState = originator.saveState();
        originator.setState("state3");
        originator.restoreState(savedState);
        System.out.println("final state: " + originator.getState());
    }

}
