package com.exemplo.structural.proxy.original;

public class ConcreteSubject implements Subject {

    @Override
    public void doSomeWork()
    {
        System.out.println(" Eu sou de uma classe concreta do sujeito.");
    }
}
