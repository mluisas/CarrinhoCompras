package repository;

import model.Produto;
import repository.RepositorioBase;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProdutosPadraoArquivo implements RepositorioBase<Produto, Integer> {

    private Path arquivo;

    public ProdutosPadraoArquivo(Path arquivo){
        this.arquivo = arquivo;
    }
    public ProdutosPadraoArquivo() {
        this(null);
    }

    public Path getArquivo() {
        return arquivo;
    }

    public void setArquivo(Path arquivo) {
        this.arquivo = arquivo;
    }

    @Override
    public Collection<Produto> getEntries() {
        List<Produto> res = new ArrayList<>();

        // carrega produtos no arquivo

        return res;
    }

    @Override
    public void insert(Produto entry) {
        // insere produto no arquivo
    }

    @Override
    public void update(Integer id, Produto newValue) {
        // atualiza produto no arquivo
    }

    @Override
    public void delete(Integer id) {
        // deleta produto no arquivo
    }
}
