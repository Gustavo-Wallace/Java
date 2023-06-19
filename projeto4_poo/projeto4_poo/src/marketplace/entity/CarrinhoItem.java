package marketplace.entity;

class CarrinhoItem {
    private Produto produto;
    private int quantidade;

    public CarrinhoItem(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "Produto: " + produto.getNome() + ", Preço Unitário: R$" + produto.getPreco() + ", Quantidade: " + quantidade;
    }
}