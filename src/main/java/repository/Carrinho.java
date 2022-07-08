package repository;

import model.Pessoa;
import model.Produto;
import repository.RepositorioBase;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Carrinho implements RepositorioBase<Produto, Integer>{
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
        if(quantidade > 0){
            int adicional = 0;
            if(produtos.containsKey(produto)){
                adicional = produtos.get(produto);
            }
            produtos.put(produto, quantidade + adicional);
        }
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

    @Override
    public Collection<Produto> getEntries() {
        return this.produtos.keySet();
    }

    @Override
    public void insert(Produto entry) {
        this.addProduto(entry, 1);
    }

    @Override
    public void update(Integer id, Produto newValue) {
        Produto produto = new Produto();
        if(!id.equals(newValue.getId())){
            this.delete(id);
            produto.setId(id);
            this.insert(produto);
        }
        produto.setNome(newValue.getNome());
        produto.setDescricao(newValue.getDescricao());
        produto.setAlteracoesPossiveis(newValue.getAlteracoesPossiveis());
        produto.setPreco(newValue.getPreco());
    }

    @Override
    public void delete(Integer id) {
        this.removeProduto(this.getById(id));
    }
}
