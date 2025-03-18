package entidades;

import java.sql.Timestamp;

public class Produto implements Cloneable{
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private Timestamp dataAdicionado;

    public Produto(int id, String nome, String descricao, double preco, Timestamp dataAdicionado) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.dataAdicionado = dataAdicionado;
    }

    public Produto(Produto produto){
        this.id = produto.id;
        this.nome = produto.nome;
        this.descricao = produto.descricao;
        this.preco = produto.preco;
        this.dataAdicionado = produto.dataAdicionado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Timestamp getDataAdicionado() {
        return dataAdicionado;
    }

    public void setDataAdicionado(Timestamp dataAdicionado) {
        this.dataAdicionado = dataAdicionado;
    }

    public Produto clone(){
        return new Produto(this);
    }

    @Override
    public String toString() {
        return "----------------------------------\n" +
                "| ID: " + id + "\n" +
                "| Nome: " + nome + "\n" +
                "| Descrição: " + descricao + "\n" +
                "| Preço: R$ " + String.format("%.2f", preco) + "\n" +
                "| Adicionado em: " + dataAdicionado + "\n" +
                "----------------------------------";
    }

}
