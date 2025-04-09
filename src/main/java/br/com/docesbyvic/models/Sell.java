package br.com.docesbyvic.models;

import jakarta.persistence.*;

@Entity
public class Sell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;
    private Double value;

    @ManyToOne
    private Product product;

    @ManyToOne
    private CompleteSell completeSell;

    public Sell() {}

    public Sell(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
        setValue();
    }

    // Calcula o valor total da venda (produto x quantidade)
    protected Double calculateValue() {
        return this.product.getValue() * this.quantity;
    }

    // Atualiza o valor com base no preço do produto
    protected void setValue() {
        this.value = calculateValue();
    }

    // Permite setar um novo valor unitário (usado em promoções por exemplo)
    public void setValue(Double newValue) {
        this.value = newValue * this.quantity;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
        setValue(); // sempre recalcula o valor ao alterar a quantidade
    }

    public Double getValue() {
        return value;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        setValue(); // sempre recalcula o valor ao alterar o produto
    }

    public CompleteSell getCompleteSell() {
        return completeSell;
    }

    public void setCompleteSell(CompleteSell completeSell) {
        this.completeSell = completeSell;
    }

    @Override
    public String toString() {
        return String.format("%s x %s | Total: R$%.2f", quantity, product, value);
    }
}
