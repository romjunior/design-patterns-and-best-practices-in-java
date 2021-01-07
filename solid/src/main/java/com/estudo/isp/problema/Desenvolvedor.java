package com.estudo.isp.problema;

public class Desenvolvedor extends Funcionario{

    private double salario;

    public Desenvolvedor(double salario) {
        this.salario = salario;
    }

    @Override
    public double getSalario() {
        return this.salario;
    }

    @Override
    public double getComissao() {
        return 0d;
    }

}
