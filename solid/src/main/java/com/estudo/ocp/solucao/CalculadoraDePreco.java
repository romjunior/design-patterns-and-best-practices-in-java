package com.estudo.ocp.solucao;

public class CalculadoraDePreco {

    private ServicoDeFrete frete;
    private TabelaDePreco entrega;

    public CalculadoraDePreco(ServicoDeFrete frete, TabelaDePreco entrega) {
        this.frete = frete;
        this.entrega = entrega;
    }

    public double calcula(Produto produto) {
        var desconto = entrega.calculaDesconto(produto.getValor());
        var valorFrete = frete.calculaFrete(produto.getEstado());
        return produto.getValor() * (1 - desconto) + valorFrete;

    }
}
