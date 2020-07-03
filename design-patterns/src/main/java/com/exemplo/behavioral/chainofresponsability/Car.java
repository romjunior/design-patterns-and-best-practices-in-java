package com.exemplo.behavioral.chainofresponsability;

public class Car {

    private String type;
    private String color;

    private Car(String type, String color) {
        this.type = type;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public static class Builder {
        private String type;
        private String color;

        public Builder() {
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Car build() {
            return new Car(this.type, this.color);
        }
    }
}
