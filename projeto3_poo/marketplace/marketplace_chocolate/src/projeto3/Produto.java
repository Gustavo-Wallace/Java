package projeto3;

class Produto {
    private static int proximoCodigo = 1;

    private int codigo;
    private String nome;
    private double preco;
    private Vendedor vendedor;
    private int quantidade;

    public Produto(String nome, double preco, Vendedor vendedor) {
        this.codigo = proximoCodigo++;
        this.nome = nome;
        this.preco = preco;
        this.vendedor = vendedor;
        this.quantidade = 1;
    }

    public int getCodigo() {
        return codigo;
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

    public Vendedor getVendedor() {
        return vendedor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void incrementarQuantidade() {
        quantidade++;
    }

    public void decrementarQuantidade() {
        quantidade--;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nome: " + nome + ", Preço: R$" + preco + ", Vendedor: " + vendedor.getNomeUsuario();
    }
}
