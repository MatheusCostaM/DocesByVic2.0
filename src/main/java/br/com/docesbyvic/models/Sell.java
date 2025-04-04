package br.com.docesbyvic.models;

import java.time.format.DateTimeFormatter;

import static java.lang.String.format;

import jakarta.persistence.*;

@Entity
public class Sell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    private Double value;

    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;

    @ManyToOne
    private CompleteSell completeSell;

    public Sell() {}

    public Sell(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
        setValue();
    }

    protected Double calculateValue(){
        return this.product.getValue() * this.quantity;
    }

    public void setCompleteSell(CompleteSell completeSell) {
        this.completeSell = completeSell;
    }

    protected void setValue() {
        this.value = calculateValue();
    }

    public void setValue(Double newValue){
        this.value = newValue * this.quantity;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public String toString(){
        return String.format("%s %s: R$%s", quantity,product,value);
    }

}
