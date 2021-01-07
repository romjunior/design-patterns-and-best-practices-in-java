package com.estudo.dip.solucao;

import java.math.BigDecimal;

public class Main {

    public final static void main(String[] args) {
        var calculo = new CalculoPrecoProduto(new ICMS());
        System.out.println(calculo.calcular(new BigDecimal(10.00)));
    }
}
