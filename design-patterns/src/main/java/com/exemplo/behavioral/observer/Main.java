package com.exemplo.behavioral.observer;

public class Main {

    public static void main(String... args) {
        ConcreteSubject subject1 = new ConcreteSubject();
        Observer observer1 = new ConcreteObserver("observer1");
        subject1.attach(observer1);
        subject1.setState("Oi");
        subject1.setState("vai dormir");
    }
}
