package com.exemplo.behavioral.observer;
import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject{
    private final List<Observer> observerList = new ArrayList<>();

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        final var oldState = this.state;
        this.state = state;
        notification(oldState, this.state);
    }

    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notification(final String oldState, final String newState) {
        observerList.forEach(observer -> observer.update(oldState, newState));
    }
}
