package br.com.docesbyvic.telas;

import br.com.docesbyvic.models.*;
import br.com.docesbyvic.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class Menu {

    @Autowired
    private ClientService clientService;
    @Autowired
    private ProductService productService;
    @Autowired
    private PromotionService promotionService;
    @Autowired
    private CompleteSellService completeSellService;

    private final Scanner read = new Scanner(System.in);

    public void displayMenu() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("""
                [1] Adicionar Cliente
                [2] Adicionar Produto
                [3] Adicionar Promoção
                [4] Realizar Compra
                [5] Listar Clientes
                [6] Listar Produtos
                [0] Sair
                """);

            opcao = read.nextInt();
            read.nextLine();

            switch (opcao) {
                case 1 -> addClient();
                case 2 -> addProduct();
                case 3 -> addPromotion();
                case 4 -> makePurchase();
                case 5 -> showClients();
                case 6 -> showProducts();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void addClient() {
        System.out.println("Nome do Cliente:");
        String name = read.nextLine();

        System.out.println("Telefone do Cliente:");
        String phone = read.nextLine();

        Client client = new Client(name, phone);

        System.out.println(client);
        clientService.createClient(client); // correto
        System.out.println("Cliente salvo com sucesso!");
    }

    private void addProduct() {
        System.out.println("Tipo do Produto:");
        String type = read.nextLine();

        System.out.println("Sabor do Produto:");
        String taste = read.nextLine();

        System.out.println("Valor do Produto:");
        Double value = read.nextDouble();
        read.nextLine();

        Product product = new Product(type, taste, value);
        productService.saveProduct(product); // correto
        System.out.println("Produto salvo com sucesso!");
    }

    private void addPromotion() {

        System.out.println("Nome da Promoção");
        var name = read.nextLine();

        System.out.println("Valor dos Produtos Elegiveis:");
        var value = read.nextDouble();
        read.nextLine();

        System.out.println("Valor Promocional:");
        var newValue = read.nextDouble();
        read.nextLine();

        System.out.println("Quantidade de Produtos:");
        var rule = read.nextInt();
        read.nextLine();

        Promotion promotion = new Promotion(name, value, newValue,rule);
        promotionService.savePromotion(promotion);
        System.out.println(promotion);

    }

    private void makePurchase() {

        var escolha = 1;
        List<Sell> shop = new ArrayList<>();

        System.out.println("Quem é o cliente? (Digite o Numero)");
        showClients();
        var idClient = read.nextLong();
        read.nextLine();
        Client client = clientService.getClientById(idClient);

        System.out.println("Qual é a data de hoje?");
        var date = read.nextLine();

        while (escolha != 0) {

            System.out.println("Qual é o produto? (Digite o Numero)");
            showProducts();
            var idProduct = read.nextLong();
            read.nextLine();
            Product product = productService.getProductById(idProduct);

            System.out.println("Quantos produtos?");
            var quantity = read.nextInt();
            read.nextLine();

            Sell sell = new Sell(product,quantity);
            shop.add(sell);

            System.out.println("[0] Finalizar compra \n [1] Continuar compra");
            escolha = read.nextInt();
            read.nextLine();

        }

        var promotionList = promotionService.getAllPromotions();

        CompleteSell completeSell = new CompleteSell(shop,date,client,promotionList);
        client.setDebt(completeSell.getValue());
        clientService.updateClient(idClient,client);
        System.out.println(completeSell);
        completeSellService.save(completeSell);

    }

    private void showClients() {
        List<Client> clients = clientService.getAllClients();

        if (clients.isEmpty()) {
            System.out.println("Nenhum cliente encontrado.");
        } else {
            for (Client client : clients) {
                System.out.println(client);
            }
        }
    }

    private void showProducts() {
        List<Product> products = productService.getAllProducts(); // correto
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
