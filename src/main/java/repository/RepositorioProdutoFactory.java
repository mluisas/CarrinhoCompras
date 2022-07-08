package repository;

import model.Produto;

public final class RepositorioProdutoFactory {
    private RepositorioProdutoFactory(){}

    public static RepositorioBase<Produto, Integer> createRepositorio(String tipo){
        switch(tipo){
            case "arquivo":
                return new ProdutosPadraoArquivo();
            case "memória":
                return ProdutosPadraoMemoria.getInstance();
            default:
                throw new IllegalArgumentException("Tipo de repositório inválido.");
        }
    }

}
