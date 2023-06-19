package marketplace.entity;

import java.util.ArrayList;
import java.util.List;

class Comprador extends Usuario {
    public List<CarrinhoItem> carrinho;

    public Comprador(String nomeUsuario, String senha) {
        super(nomeUsuario, senha);
        this.carrinho = new ArrayList<>();
    }

    public void adicionarItemCarrinho(CarrinhoItem item) {
        carrinho.add(item);
    }

    public void exibirCarrinho() {
        System.out.println("\n=== Carrinho de Compras ===");

        for (CarrinhoItem item : carrinho) {
            System.out.println(item);
        }
    }

    public double calcularTotalCompra() {
        double total = 0.0;

        for (CarrinhoItem item : carrinho) {
            total += item.getProduto().getPreco() * item.getQuantidade();
        }

        return total;
    }

    public void limparCarrinho() {
        carrinho.clear();
        System.out.println("Carrinho limpo!");
    }
}
