package com.estudo.lsp.problema;

public class ContaCorrenteComum {

    protected double saldo;

    public ContaCorrenteComum() {
        this.saldo = 0;
    }

    public void deposita(double valor) {
        this.saldo += valor;
    }

    public void saca(double valor) {
        if(valor <= this.saldo) {
            this.saldo -= valor;
        }else{
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void rende()      {
        this.saldo*= 0.02;
    }
}
