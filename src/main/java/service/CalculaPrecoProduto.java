package service;

import model.Produto;

import java.math.BigDecimal;

public class CalculaPrecoProduto implements CalculaPreco<Produto>{
    @Override
    public BigDecimal calcular(Produto produto){
        BigDecimal preco = produto.getPreco();
        for(AlteracaoPreco alteracaoPreco:produto.getAlteracoesPossiveis()){
            preco = preco.add(alteracaoPreco.alteraPreco(preco));
        }
        return preco;
    }
}
