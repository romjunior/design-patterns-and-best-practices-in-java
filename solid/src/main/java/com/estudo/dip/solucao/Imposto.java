package com.estudo.dip.solucao;

import java.math.BigDecimal;

public interface Imposto {
    BigDecimal calcularImposto(final BigDecimal preco);
}
