import java.math.BigDecimal;
import java.util.List;

public final class ProdutosPadraoMemoria {
    public static List<AlteracaoPreco> listaDeAlteracoes = List.of(new Promocao(), new TaxaExtra(), new Frete());
    public static final List<AlteracaoPreco> ALTERACOES_SEM_FRETE = List.of(new Promocao(), new TaxaExtra());

    public static final List<Produto> PRODUTOS_PADRAO = List.of(
        new Produto(454, "Suplemento", "WheyProtein", new BigDecimal("100"), listaDeAlteracoes),
        new Produto(132, "Comprimido", "Maca Peruana", new BigDecimal("70"), listaDeAlteracoes),
        new Produto(988, "Manteiga", "Manteiga Ghee", new BigDecimal("150"), ALTERACOES_SEM_FRETE),
        new Produto(984, "Nootrópico", "Café Smart", new BigDecimal("500"), listaDeAlteracoes)
    );
    private ProdutosPadraoMemoria(){}
}
