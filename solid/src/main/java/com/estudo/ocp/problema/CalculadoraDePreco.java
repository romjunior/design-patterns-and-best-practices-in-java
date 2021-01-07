package com.estudo.ocp.problema;

public class CalculadoraDePreco {

    public double calcula(Produto produto) {

        Frete frete = new Frete();
        var desconto = 0d;
        int regra = produto.getMeioPagamento();

        switch(regra) {
            case 1:
                System.out.println("Venda à vista");
                TabelaDePrecoAVista tabela1 = new TabelaDePrecoAVista();
                desconto = tabela1.calculaDesconto(produto.getValor());
                break;
            case 2:
                System.out.println("Venda à prazo");
                TabelaDePrecoAPrazo tabela2 = new TabelaDePrecoAPrazo();
                desconto = tabela2.calculaDesconto(produto.getValor());
                break;
        }

        double valorFrete = frete.calculaFrete(produto.getEstado());
        return produto.getValor() * (1 - desconto) + valorFrete;

    }
}
