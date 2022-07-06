import repository.Id;
import repository.ModeloBase;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Produto implements ModeloBase<Integer> {

    public Produto(Integer id, String descricao, String nome, BigDecimal preco, List<AlteracaoPreco> alteracoesPossiveis) {
        this.id = id;
        this.descricao = descricao;
        this.nome = nome;
        this.preco = preco;
        this.alteracoesPossiveis = alteracoesPossiveis;
    }

    public Produto(){

    }
    @Id
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

    @Override
    public Type[] getActualTypeArguments() {
        return new Type[]{Integer.class};
    }

    @Override
    public Type getRawType() {
        return this.getClass();
    }

    @Override
    public Type getOwnerType() {
        return null;
    }
}
