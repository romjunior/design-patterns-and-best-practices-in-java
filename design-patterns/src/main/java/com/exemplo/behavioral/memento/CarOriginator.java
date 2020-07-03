package com.exemplo.behavioral.memento;

public class CarOriginator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento saveState() {
        return new Memento(state);
    }

    public void restoreState(final Memento memento) {
        this.state = memento.getState();
    }

    public static class Memento {
        private final String state;
        public Memento(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }

}
