package com.exemplo.behavioral.strategy;

import java.util.Arrays;

public enum Context {
    ADD(new SumStrategy()),
    MINUS(new SubtractStrategy()),
    MULTIPLY(new MultiplyStrategy());

    private Strategy strategy;

    Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int operate(final int a, final int b) {
        return strategy.execute(a, b);
    }

    public static Context getOperation(final String opValue) {
        return Arrays.stream(Context.values())
                .filter(op -> op.toString().equals(opValue))
                .findFirst()
                .orElse(null);
    }
}
