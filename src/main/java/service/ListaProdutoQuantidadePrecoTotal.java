package service;

import model.Produto;
import repository.Carrinho;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class ListaProdutoQuantidadePrecoTotal implements ListaProdutos{
    @Override
    public void listarProdutos(Carrinho carrinho) {
        CalculaPrecoProduto calculaPrecoProduto = new CalculaPrecoProduto();
        for(Map.Entry<Produto, Integer> itens : carrinho.getProdutos().entrySet()){
            Produto produto = itens.getKey();
            BigDecimal quantidade = new BigDecimal(itens.getValue());
            BigDecimal precoSemAlteracao = produto.getPreco().multiply(quantidade);
            BigDecimal precoComAlteracao = calculaPrecoProduto.calcular(produto).multiply(quantidade).setScale(2, RoundingMode.HALF_EVEN);
            System.out.println("ID do produto: ");
            System.out.println(produto.getId());
            System.out.println("Nome do produto: ");
            System.out.println(produto.getNome());
            System.out.println("Descrição do produto: ");
            System.out.println(produto.getDescricao());
            System.out.println("Preço unitário: ");
            System.out.println(produto.getPreco());
            System.out.println("Quantidade: ");
            System.out.println(quantidade);
            System.out.println("Preço total do produto sem taxas ou descontos: ");
            System.out.println(precoSemAlteracao);
            if(!precoSemAlteracao.equals(precoComAlteracao)){
                System.out.println("Preço total do produto com taxas ou descontos: ");
                System.out.println(precoComAlteracao);
            }
        }
    }
}
