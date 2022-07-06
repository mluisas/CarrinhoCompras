import repository.RepositorioBase;

import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

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
