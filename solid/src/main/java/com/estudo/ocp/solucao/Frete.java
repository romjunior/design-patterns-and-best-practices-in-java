package com.estudo.ocp.solucao;

public class Frete implements ServicoDeFrete{

    public double calculaFrete(String estado) {

        switch (estado.toUpperCase()) {
            case "SAO PAULO":
                return 7.5;
            case "MINAS GERAIS":
                return 12.5;
            case "RIO DE JANEIRO":
                return 10.5;
            default:
                return 10.0;
        }
    }
}
