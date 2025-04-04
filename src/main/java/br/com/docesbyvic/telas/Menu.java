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

        while(this.getOpcao() != 0){

            System.out.println(this.texto);
            setOpcao(read.nextInt());
            read.nextLine();


            switch (opcao){
                case 1:
                    addClient();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    addPromotion();
                    break;
                case 4:
                    makePurchase();
                    break;
                case 5:
                    var client = infoClient();
                    client.getInfo();
                    break;
                case 6:
                    var product = infoProduct();
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

    public void addPromotion(){

        //String name, Double value, Double newValue,Integer regra

        System.out.println("Digite o Nome da Promoção");
        var name = read.nextLine();

        System.out.println("Digite o Valor dos Produtos Elegiveis");
        var value = read.nextDouble();
        read.nextLine();

        System.out.println("Digite o Valor dos Produtos com Desconto");
        var newValue = read.nextDouble();
        read.nextLine();

        System.out.println("Digite Quantos Produtos tem Que ser Vendidos para Entrar na Promoção");
        var rule = read.nextInt();
        read.nextLine();

        Promotion promotion = new Promotion(name,value,newValue,rule);
        this.promotionList.add(promotion);

        System.out.println("Lista de Promoções Atualizada");
        System.out.println(this.promotionList);

    }

    public void addClient(){

        System.out.println("Digite o Nome do Cliente");
        var nome = read.nextLine();

        System.out.println("Digite o Telefone do Cliente");
        var phone = read.nextLine();

        Cliente cliente = new Cliente(nome,phone);
        this.clienteList.add(cliente);

        System.out.println("Lista de Clientes Atualizada");
        System.out.println(this.clienteList);

    }

    public void addProduct(){

        System.out.println("Digite o Tipo do Produto");
        var type = read.nextLine();

        System.out.println("Digite o Sabor do Produto");
        var taste = read.nextLine();

        System.out.println("Digite o Valor do Produto");
        var value = read.nextDouble();
        read.nextLine();

        Product product = new Product(type,taste,value);
        this.productList.add(product);

        System.out.println("Lista de Produtos Atualizada");
        System.out.println(this.productList);

    }

    public void makePurchase(){

        var choice = -1;
        List<Sell> sells = new ArrayList<>();

        var client = infoClient();
        System.out.println(client);

        System.out.println("Qual a data de hoje?");
        var date = read.nextLine();

        while(choice != 0){

            var product = infoProduct();
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
            choice = read.nextInt();
            read.nextLine();
        }

        CompleteSell fullSell = new CompleteSell(sells,date,client,promotionList);
        client.addCompra(fullSell);

        System.out.println(fullSell);
    }

    public Cliente infoClient(){
        System.out.println("Lista de Clientes Escolha um e digite seu nome");
        System.out.println(this.clienteList);
        var clientName = read.nextLine();
        var client = this.clienteList.stream()
                .filter(c -> c.getName().equalsIgnoreCase(clientName))
                .findFirst()
                .orElse(null);

        return client;
    }

    public Product infoProduct(){
        System.out.println("Lista de tipos Produtos Escolha um e digite o tipo");
        this.productList.forEach(p -> System.out.println(p.getTipe()));
        var productTypeName = read.nextLine();

        System.out.println("Lista de sabores Escolha um e digite o sabor");
        this.productList.stream()
                .filter(p -> p.getTipe().equalsIgnoreCase(productTypeName))
                .distinct()
                .forEach(p -> System.out.println(p.getSabor()));
        var productTasteName = read.nextLine();

        var product = this.productList.stream()
                .filter(p -> p.getTipe().equalsIgnoreCase(productTypeName))
                .filter(p -> p.getSabor().equalsIgnoreCase(productTasteName))
                .findFirst()
                .orElse(null);

        return product;
    }
}
