package com.exemplo.structural.composite;

public class MinusOperand extends ArithmeticOperand{

    public MinusOperand(ArithmeticComposite left, ArithmeticComposite right) {
        super(left, right);
    }

    @Override
    public int getValue() {
        return left.getValue() - right.getValue();
    }
}
