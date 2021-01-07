package com.estudo.lsp.problema;

public class ContaSalario extends ContaCorrenteComum {

    @Override
    public void rende() {
        throw new RuntimeException("Essa conta não possui rendimento");
    }
}
