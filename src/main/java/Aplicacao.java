import java.util.Random;

public class Aplicacao {
    public static void main(String[] args) {
        Carrinho carrinho = new Carrinho();

        Random random = new Random();

        for(Produto produto : ProdutosPadraoMemoria.PRODUTOS_PADRAO){
            carrinho.addProduto(produto, 1+random.nextInt(5));
        }

        ListaProdutoQuantidadePrecoTotal listagem = new ListaProdutoQuantidadePrecoTotal();
        listagem.listarProdutos(carrinho);
        System.out.println("\n");

        for(int i = 0; i < 10; i++){
            carrinho.insert(ProdutosPadraoMemoria.PRODUTOS_PADRAO.get(0));
        }

        listagem.listarProdutos(carrinho);
        System.out.println("\n");

        carrinho.alteraQuantidade(ProdutosPadraoMemoria.PRODUTOS_PADRAO.get(0), 0);

        carrinho.addProduto(ProdutosPadraoMemoria.PRODUTOS_PADRAO.get(1), 0);

        carrinho.removeProduto(ProdutosPadraoMemoria.PRODUTOS_PADRAO.get(3));

        listagem.listarProdutos(carrinho);
    }
}
