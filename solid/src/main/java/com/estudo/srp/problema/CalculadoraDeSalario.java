package com.estudo.srp.problema;

import static com.estudo.srp.problema.Cargo.DBA;
import static com.estudo.srp.problema.Cargo.DESENVOLVEDOR;
import static com.estudo.srp.problema.Cargo.TESTER;

public class CalculadoraDeSalario {

    public double calcula(Funcionario funcionario) {
        if(DESENVOLVEDOR.equals(funcionario.getCargo())) {
            return dezOuVintePorcento(funcionario);
        }

        if(DBA.equals(funcionario.getCargo()) || TESTER.equals(funcionario.getCargo())) {
            return quinzeOuVinteCintoPorcento(funcionario);
        }

        throw new RuntimeException("funcionário inválido");
    }

    private double quinzeOuVinteCintoPorcento(Funcionario funcionario) {
        if(funcionario.getSalarioBase() > 2000.0) {
            return funcionario.getSalarioBase() * 0.75;
        }
        else {
            return funcionario.getSalarioBase() * 0.85;
        }
    }

    private double dezOuVintePorcento(Funcionario funcionario) {
        if(funcionario.getSalarioBase() > 3000.0) {
            return funcionario.getSalarioBase() * 0.8;
        }
        else {
            return funcionario.getSalarioBase() * 0.9;
        }
    }
}
