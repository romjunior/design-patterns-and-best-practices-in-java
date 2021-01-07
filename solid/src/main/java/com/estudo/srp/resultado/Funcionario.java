package com.estudo.srp.resultado;

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

    public double calculaSalario() {
        return cargo.getRegra().calcula(this);
    }
}
