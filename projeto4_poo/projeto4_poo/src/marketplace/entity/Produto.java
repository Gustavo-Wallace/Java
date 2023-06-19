package marketplace.entity;

public class Produto {

    private int codigo;
    private String nome;
    private double preco;
    private int quantidade;
    private String vendedor;

    public Produto(String nome, double preco, int quantidade, String vendedor) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.vendedor = vendedor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nome: " + nome + ", Preço: R$" + preco + ", Vendedor: " + vendedor;
    }
}
