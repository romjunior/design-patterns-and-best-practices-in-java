package com.estudo.ocp.solucao;

public class TabelaDePrecoAVista implements TabelaDePreco{

    public double calculaDesconto(double valor) {
        if(valor > 100.0) {
            return 0.05;
        }else if(valor > 500.0) {
            return 0.07;
        }else if(valor > 1000.0) {
            return 0.10;
        }else {
            return 0d;
        }
    }
}
