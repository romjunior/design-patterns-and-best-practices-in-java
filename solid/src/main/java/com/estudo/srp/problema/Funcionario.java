package com.estudo.srp.problema;

public class Funcionario {

    private final double salarioBase;
    private final Cargo cargo;

    public Funcionario(double salarioBase, Cargo cargo) {
        this.salarioBase = salarioBase;
        this.cargo = cargo;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public Cargo getCargo() {
        return cargo;
    }
}
