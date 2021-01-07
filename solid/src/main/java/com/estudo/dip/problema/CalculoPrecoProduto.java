package com.estudo.dip.problema;

import java.math.BigDecimal;

public class CalculoPrecoProduto {

    public BigDecimal calcular(final BigDecimal preco) {
        var imposto = new ICMS();
        return preco.add(imposto.calcularICMS(preco));
    }

}
