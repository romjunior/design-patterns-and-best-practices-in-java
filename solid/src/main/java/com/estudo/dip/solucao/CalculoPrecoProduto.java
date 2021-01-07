package com.estudo.dip.solucao;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculoPrecoProduto {

    private Imposto imposto;

    public CalculoPrecoProduto(Imposto imposto) {
        this.imposto = imposto;
    }

    public BigDecimal calcular(final BigDecimal preco) {
        return preco.add(imposto.calcularImposto(preco)).setScale(2, RoundingMode.DOWN);
    }

}
