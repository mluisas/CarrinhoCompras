package app;

import model.Produto;
import repository.Carrinho;
import repository.ProdutosPadraoMemoria;
import repository.RepositorioBase;
import repository.RepositorioProdutoFactory;
import service.ListaProdutoQuantidadePrecoTotal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Aplicacao {
    public static void main(String[] args) {
        Carrinho carrinho = new Carrinho();

        Random random = new Random();

        RepositorioBase<Produto, Integer> repositorio;

        if(args.length > 0){
            repositorio = RepositorioProdutoFactory.createRepositorio(args[0]);
        } else{
            repositorio = ProdutosPadraoMemoria.getInstance();
        }

        List<Produto> listaProdutos = new ArrayList<>(repositorio.getEntries());

        for(Produto produto : listaProdutos){
            carrinho.addProduto(produto, 1+random.nextInt(5));
        }

        ListaProdutoQuantidadePrecoTotal listagem = new ListaProdutoQuantidadePrecoTotal();
        listagem.listarProdutos(carrinho);
        System.out.println("\n");

        for(int i = 0; i < 10; i++){
            carrinho.insert(listaProdutos.get(0));
        }

        listagem.listarProdutos(carrinho);
        System.out.println("\n");

        carrinho.alteraQuantidade(listaProdutos.get(0), 0);

        carrinho.addProduto(listaProdutos.get(1), 0);

        carrinho.removeProduto(listaProdutos.get(3));

        listagem.listarProdutos(carrinho);
    }
}
