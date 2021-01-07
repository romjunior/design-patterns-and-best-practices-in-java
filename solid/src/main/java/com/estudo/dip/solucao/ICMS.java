package com.estudo.dip.solucao;

import java.math.BigDecimal;

public class ICMS implements Imposto{

    @Override
    public BigDecimal calcularImposto(BigDecimal preco) {
        return preco.multiply(new BigDecimal(0.02));
    }
}
