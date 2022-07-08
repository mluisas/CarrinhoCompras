package repository;

import model.Produto;
import service.AlteracaoPreco;
import service.Frete;
import service.Promocao;
import service.TaxaExtra;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class ProdutosPadraoMemoria implements RepositorioBase<Produto, Integer>{

    public static ProdutosPadraoMemoria instance;
    public List<AlteracaoPreco> listaDeAlteracoes = List.of(new Promocao(), new TaxaExtra(), new Frete());
    public final List<AlteracaoPreco> ALTERACOES_SEM_FRETE = List.of(new Promocao(), new TaxaExtra());

    public final List<Produto> PRODUTOS_PADRAO = new ArrayList<>(List.of(
        new Produto(454, "Suplemento", "WheyProtein", new BigDecimal("100"), listaDeAlteracoes),
        new Produto(132, "Comprimido", "Maca Peruana", new BigDecimal("70"), listaDeAlteracoes),
        new Produto(988, "Manteiga", "Manteiga Ghee", new BigDecimal("150"), ALTERACOES_SEM_FRETE),
        new Produto(984, "Nootrópico", "Café Smart", new BigDecimal("500"), listaDeAlteracoes)
    ));

    public static ProdutosPadraoMemoria getInstance(){
        if(instance == null){
            instance = new ProdutosPadraoMemoria();
        }
        return instance;
    }
    private ProdutosPadraoMemoria(){}

    @Override
    public Collection<Produto> getEntries() {
        return this.PRODUTOS_PADRAO;
    }

    @Override
    public void insert(Produto entry) {
        this.PRODUTOS_PADRAO.add(entry);
    }

    @Override
    public void update(Integer id, Produto newValue) {
        Produto novosValores = new Produto(
                newValue.getId(),
                newValue.getDescricao(),
                newValue.getNome(),
                newValue.getPreco(),
                newValue.getAlteracoesPossiveis()
        );
        this.delete(id);
        this.insert(novosValores);
    }

    @Override
    public void delete(Integer id) {
        this.PRODUTOS_PADRAO.remove(this.getById(id));
    }
}
