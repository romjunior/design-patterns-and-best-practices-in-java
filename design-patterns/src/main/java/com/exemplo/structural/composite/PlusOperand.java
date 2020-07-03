package com.exemplo.structural.composite;

public class PlusOperand extends ArithmeticOperand{

    public PlusOperand(ArithmeticComposite left, ArithmeticComposite right) {
        super(left, right);
    }


    @Override
    public int getValue() {
        return left.getValue() + right.getValue();
    }
}
