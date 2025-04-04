package br.com.docesbyvic.telas;

import br.com.docesbyvic.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private List<Cliente> clienteList = new ArrayList<>();
    private List<Product> productList = new ArrayList<>();
    private List<Promotion> promotionList = new ArrayList<>();

    private Integer opcao = -1;
    private String texto = """
            [1] Adicionar Cliente
            [2] Adicionar Produto
            [3] Adicionar Promoção
            [4] Realizar Compra
            [5] Informações Cliente
            [6] Informações Produto
            """;
    final Scanner read = new Scanner(System.in);

    public Integer getOpcao() {
        return opcao;
    }

    public void setOpcao(Integer opcao) {
        this.opcao = opcao;
    }

    public void displayMenu(){

        Promotion promotion = new Promotion("2 por 16",10.0,8.0,2);
        promotionList.add(promotion);

        while(this.getOpcao() != 0){

            System.out.println(this.texto);
            setOpcao(read.nextInt());
            read.nextLine();


            switch (opcao){
                case 1:
                    adicionarCliente();
                    break;
                case 2:
                    adicionarProduto();
                    break;
                case 3:
                    adicionarPromotion();
                    break;
                case 4:
                    realizarCompra();
                    break;
                case 5:
                    var client = informacoesCliente();
                    client.getInfo();
                    break;
                case 6:
                    var product = informacoesProduto();
                    product.getInfo();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção invalida, tente novamente");
                    break;
            }

        }

    }

    public void adicionarPromotion(){

    }

    public void adicionarCliente(){

        System.out.println("Digite o Nome do Cliente");
        var nome = read.nextLine();

        System.out.println("Digite o Telefone do Cliente");
        var phone = read.nextLine();

        Cliente cliente = new Cliente(nome,phone);
        this.clienteList.add(cliente);

        System.out.println("Lista de Clientes Atualizada");
        System.out.println(this.clienteList);

    }

    public void adicionarProduto(){

        System.out.println("Digite o Tipo do Produto");
        var tipo = read.nextLine();

        System.out.println("Digite o Sabor do Produto");
        var sabor = read.nextLine();

        System.out.println("Digite o Valor do Produto");
        var valor = read.nextDouble();
        read.nextLine();

        Product product = new Product(tipo,sabor,valor);
        this.productList.add(product);

        System.out.println("Lista de Produtos Atualizada");
        System.out.println(this.productList);

    }

    public void realizarCompra(){

        var escolha = -1;
        List<Sell> sells = new ArrayList<>();

        var client = informacoesCliente();
        System.out.println(client);

        System.out.println("Qual a data de hoje?");
        var date = read.nextLine();

        while(escolha != 0){

            var product = informacoesProduto();
            System.out.println(product);

            System.out.println("Quantos?");
            var quantity = read.nextInt();
            read.nextLine();

            Sell sell = new Sell(product,quantity);

            sells.add(sell);

            System.out.println(String.format(
                    """
                       [0] Finalizar Compra
                       [1] Continuar Compra
                            """
            ));
            escolha = read.nextInt();
            read.nextLine();
        }

        CompleteSell completeSell = new CompleteSell(sells,date,client,promotionList);
        client.addCompra(completeSell);

        System.out.println(completeSell);
    }

    public Cliente informacoesCliente(){
        System.out.println("Lista de Clientes Escolha um e digite seu nome");
        System.out.println(this.clienteList);
        var clientname = read.nextLine();
        var client = this.clienteList.stream()
                .filter(c -> c.getName().equalsIgnoreCase(clientname))
                .findFirst()
                .orElse(null);

        return client;
    }

    public Product informacoesProduto(){
        System.out.println("Lista de tipos Produtos Escolha um e digite o tipo");
        this.productList.forEach(p -> System.out.println(p.getTipe()));
        var producttipename = read.nextLine();

        System.out.println("Lista de sabores Escolha um e digite o sabor");
        this.productList.stream()
                .filter(p -> p.getTipe().equalsIgnoreCase(producttipename))
                .distinct()
                .forEach(p -> System.out.println(p.getSabor()));
        var productsaborname = read.nextLine();

        var product = this.productList.stream()
                .filter(p -> p.getTipe().equalsIgnoreCase(producttipename))
                .filter(p -> p.getSabor().equalsIgnoreCase(productsaborname))
                .findFirst()
                .orElse(null);

        return product;
    }
}
