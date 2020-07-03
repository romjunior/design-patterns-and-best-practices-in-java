package com.exemplo.structural.composite;

public class NumericValue implements ArithmeticComposite{

    private int value;

    public NumericValue(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return this.value;
    }
}
