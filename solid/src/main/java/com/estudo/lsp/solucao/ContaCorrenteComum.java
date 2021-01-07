package com.estudo.lsp.solucao;

public class ContaCorrenteComum {

    private GerenciadorDeContas gerenciador;

    public ContaCorrenteComum() {
        this.gerenciador = new GerenciadorDeContas();
    }

    public void deposita(double valor) {
        this.gerenciador.deposita(valor);
    }

    public void saca(double valor) {
        this.gerenciador.saca(valor);
    }

    public double getSaldo() {
        return this.gerenciador.getSaldo();
    }

    public void rende() {
        this.gerenciador.rende(0.02);
    }

    @Override
    public String toString() {
        return "Saldo conta corrente-> " + this.getSaldo();
    }
}
