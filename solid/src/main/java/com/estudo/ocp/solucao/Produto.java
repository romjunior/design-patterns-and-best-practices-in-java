package com.estudo.ocp.solucao;

public class Produto {

    private String nome;

    private double valor;

    private Integer meioPagamento;

    private String estado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Integer getMeioPagamento() {
        return meioPagamento;
    }

    public void setMeioPagamento(Integer meioPagamento) {
        this.meioPagamento = meioPagamento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
