import java.util.HashMap;
import java.util.Map;

public class Carrinho {
    private Pessoa pessoa;
    private final Map<Produto, Integer> produtos = new HashMap<>();

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Map<Produto, Integer> getProdutos() {
        return produtos;
    }

    public void addProduto(Produto produto, Integer quantidade) {
        produtos.put(produto, quantidade);
    }

    public void removeProduto(Produto produto){
        produtos.remove(produto);
    }

    public void alteraQuantidade(Produto produto, Integer quantidade){
        if(!produtos.containsKey(produto)){
            return;
        }
        if(quantidade <= 0){
            removeProduto(produto);
        } else {
            produtos.put(produto, quantidade);
        }
    }
}
