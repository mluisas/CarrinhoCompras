import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Produto {
    private Integer id;
    private String descricao;
    private String nome;
    private BigDecimal preco;
    private List<AlteracaoPreco> alteracoesPossiveis;

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public List<AlteracaoPreco> getAlteracoesPossiveis() {
        return alteracoesPossiveis;
    }

    public void setAlteracoesPossiveis(List<AlteracaoPreco> alteracoesPossiveis) {
        this.alteracoesPossiveis = alteracoesPossiveis;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return id.equals(produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
