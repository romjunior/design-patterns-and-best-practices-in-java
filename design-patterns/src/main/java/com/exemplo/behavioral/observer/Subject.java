package com.exemplo.behavioral.observer;

public interface Subject {

    void attach(Observer observer);
    void detach(Observer observer);
    void notification(String oldState, String newState);

}
