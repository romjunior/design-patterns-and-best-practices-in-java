package com.estudo.ocp.problema;

public class Frete {

    public double calculaFrete(String estado) {

        if("SAO PAULO".equals(estado.toUpperCase())) {
            return 7.5;
        }else if("MINAS GERAIS".equals(estado.toUpperCase())){
            return 12.5;
        }else if("RIO DE JANEIRO".equals(estado.toUpperCase())) {
            return 10.5;
        }else {
            return 10.0;
        }
    }
}
