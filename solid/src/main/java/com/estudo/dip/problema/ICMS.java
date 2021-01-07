package com.estudo.dip.problema;

import java.math.BigDecimal;

public class ICMS {

    public BigDecimal calcularICMS(final BigDecimal preco) {
        return preco.multiply(new BigDecimal(0.02));
    }

}
