package com.exemplo.structural.composite;

public class Main {

    public static void main(String... args) {
        ArithmeticComposite expr = new MinusOperand(new PlusOperand(new NumericValue(1), new NumericValue(4)), new NumericValue(2));
        System.out.println(expr.getValue());
    }
}
