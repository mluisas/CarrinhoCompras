package service;

import repository.Carrinho;

import java.math.BigDecimal;

public class CalculaPrecoCarrinho implements CalculaPreco<Carrinho>{

    @Override
    public BigDecimal calcular(Carrinho carrinho) {
        BigDecimal soma= BigDecimal.ZERO;
        carrinho.getProdutos().forEach((produto, quantidade) -> {
            soma.add(produto.getPreco().multiply(BigDecimal.valueOf(quantidade)));
        });
        return soma;
    }
}
