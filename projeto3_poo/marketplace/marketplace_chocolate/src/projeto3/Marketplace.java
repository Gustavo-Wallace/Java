package projeto3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Marketplace {
    private static List<Comprador> compradores = new ArrayList<>();
    private static List<Vendedor> vendedores = new ArrayList<>();
    private static List<Admin> admins = new ArrayList<>();
    private static List<Produto> produtos = new ArrayList<>();
    private static Usuario usuarioLogado;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Admin admin = new Admin("admin", "admin123");
        admins.add(admin);

        while (true) {
            System.out.println("\n=== CHOCOGOD ===");
            System.out.println("(1) Cadastrar Comprador");
            System.out.println("(2) Cadastrar Vendedor");
            System.out.println("(3) Login");
            System.out.println("(0) Sair");
            System.out.println("==================");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarComprador();
                    break;
                case 2:
                    cadastrarVendedor();
                    break;
                case 3:
                    realizarLogin();
                    break;
                case 0:
                    System.out.println("Saindo da aplicação...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    // Cadastrar novo comprador
    private static void cadastrarComprador() {
        System.out.print("Digite o nome de usuário: ");
        String nomeUsuario = scanner.next();
        System.out.print("Digite a senha: ");
        String senha = scanner.next();

        Comprador comprador = new Comprador(nomeUsuario, senha);
        compradores.add(comprador);

        System.out.println("Comprador cadastrado com sucesso!");
    }

    // Cadastrar novo vendedor
    private static void cadastrarVendedor() {
        System.out.print("Digite o nome de usuário: ");
        String nomeUsuario = scanner.next();
        System.out.print("Digite a senha: ");
        String senha = scanner.next();

        Vendedor vendedor = new Vendedor(nomeUsuario, senha);
        vendedores.add(vendedor);

        System.out.println("Vendedor cadastrado com sucesso!");
    }

    // Realizar login do usuário
    private static void realizarLogin() {
        System.out.print("Digite o nome de usuário: ");
        String nomeUsuario = scanner.next();
        System.out.print("Digite a senha: ");
        String senha = scanner.next();

        Usuario usuario = autenticarUsuario(nomeUsuario, senha);

        if (usuario instanceof Comprador) {
            usuarioLogado = usuario;
            MenuComprador();
        } else if (usuario instanceof Vendedor) {
            usuarioLogado = usuario;
            MenuVendedor();
        } else if (usuario instanceof Admin) {
            usuarioLogado = usuario;
            MenuAdmin();
        } else {
            System.out.println("Usuário ou senha inválidos!");
        }
    }

    // Autenticar usuario
    private static Usuario autenticarUsuario(String nomeUsuario, String senha) {
        for (Comprador comprador : compradores) {
            if (comprador.getNomeUsuario().equals(nomeUsuario) && comprador.getSenha().equals(senha)) {
                return comprador;
            }
        }

        for (Vendedor vendedor : vendedores) {
            if (vendedor.getNomeUsuario().equals(nomeUsuario) && vendedor.getSenha().equals(senha)) {
                return vendedor;
            }
        }

        for (Admin admin : admins) {
            if (admin.getNomeUsuario().equals(nomeUsuario) && admin.getSenha().equals(senha)) {
                return admin;
            }
        }

        return null;
    }

    // Exiber menu do comprador
    private static void MenuComprador() {
        while (true) {
            System.out.println("\n=== Menu do Comprador ===");
            System.out.println("(1) Visualizar Produtos");
            System.out.println("(2) Comprar Produto");
            System.out.println("(3) Visualizar Carrinho");
            System.out.println("(4) Finalizar Compra");
            System.out.println("==================");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    exibirProdutos();
                    break;
                case 2:
                    comprarProduto();
                    break;
                case 3:
                    visualizarCarrinho();
                    break;
                case 4:
                    finalizarCompra();
                    break;
                case 0:
                    usuarioLogado = null;
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    // Exibir lista de produtos
    private static void exibirProdutos() {
        System.out.println("\n=== Produtos Disponíveis ===");

        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }

    // Comprar produto
    private static void comprarProduto() {
        exibirProdutos();

        System.out.print("Digite o código do produto desejado: ");
        int codigo = scanner.nextInt();

        Produto produtoSelecionado = encontrarProduto(codigo);

        if (produtoSelecionado != null) {
            if (produtoSelecionado.getQuantidade() > 0) {
                CarrinhoItem item = new CarrinhoItem(produtoSelecionado, 1);
                ((Comprador) usuarioLogado).adicionarItemCarrinho(item);
                System.out.println("Produto adicionado ao carrinho!");
            } else {
                System.out.println("Produto indisponível no momento!");
            }
        } else {
            System.out.println("Código de produto inválido!");
        }
    }

    // Exibir carrinho
    private static void visualizarCarrinho() {
        System.out.println("\n=== Carrinho de Compras ===");
        ((Comprador) usuarioLogado).exibirCarrinho();
    }

    // Finalizar compra
    private static void finalizarCompra() {
        double total = ((Comprador) usuarioLogado).calcularTotalCompra();
        System.out.println("Total da compra: R$" + total);
        System.out.println("Compra realizada com sucesso!");
        ((Comprador) usuarioLogado).limparCarrinho();
    }

    // Exibir menu do vendedor
    private static void MenuVendedor() {
        while (true) {
            System.out.println("\n=== Menu do Vendedor ===");
            System.out.println("(1) Visualizar Produtos");
            System.out.println("(2) Adicionar Produto");
            System.out.println("(3) Atualizar Produto");
            System.out.println("(4) Remover Produto");
            System.out.println("==================");
            System.out.println("(0) Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    exibirProdutos();
                    break;
                case 2:
                    adicionarProduto();
                    break;
                case 3:
                    atualizarProduto();
                    break;
                case 4:
                    removerProduto();
                    break;
                case 0:
                    usuarioLogado = null;
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    // Adicionar um novo produto
    private static void adicionarProduto() {
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.next();
        System.out.print("Digite o preço do produto: ");
        double preco = scanner.nextDouble();

        Produto produto = new Produto(nome, preco, (Vendedor) usuarioLogado);
        produtos.add(produto);

        System.out.println("Produto adicionado com sucesso!");
    }

    // Atualizar um produto
    private static void atualizarProduto() {
        System.out.print("Digite o código do produto a ser atualizado: ");
        int codigo = scanner.nextInt();

        Produto produtoSelecionado = encontrarProduto(codigo);

        if (produtoSelecionado != null) {
            System.out.print("Digite o novo nome do produto: ");
            String nome = scanner.next();
            System.out.print("Digite o novo preço do produto: ");
            double preco = scanner.nextDouble();

            produtoSelecionado.setNome(nome);
            produtoSelecionado.setPreco(preco);

            System.out.println("Produto atualizado com sucesso!");
        } else {
            System.out.println("Código de produto inválido!");
        }
    }

    // Remover um produto
    private static void removerProduto() {
        System.out.print("Digite o código do produto a ser removido: ");
        int codigo = scanner.nextInt();

        Produto produtoSelecionado = encontrarProduto(codigo);

        if (produtoSelecionado != null) {
            produtos.remove(produtoSelecionado);
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Código de produto inválido!");
        }
    }

    // Encontra um produto com base no código
    private static Produto encontrarProduto(int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }

    // Exibir menu do administrador
    private static void MenuAdmin() {
        while (true) {
            System.out.println("\n=== Menu do Administrador ===");
            System.out.println("(1) Visualizar Produtos");
            System.out.println("(2) Visualizar Compradores");
            System.out.println("(3) Visualizar Vendedores");
            System.out.println("(0) Sair");
            System.out.println("==================");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    exibirProdutos();
                    break;
                case 2:
                    exibirCompradores();
                    break;
                case 3:
                    exibirVendedores();
                    break;
                case 0:
                    usuarioLogado = null;
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    // Exibir lista de compradores
    private static void exibirCompradores() {
        System.out.println("\n=== Compradores Cadastrados ===");

        for (Comprador comprador : compradores) {
            System.out.println(comprador);
        }
    }

    // Exibir lista de vendedores
    private static void exibirVendedores() {
        System.out.println("\n=== Vendedores Cadastrados ===");

        for (Vendedor vendedor : vendedores) {
            System.out.println(vendedor);
        }
    }

}

