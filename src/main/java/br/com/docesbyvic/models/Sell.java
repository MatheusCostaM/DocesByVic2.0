package br.com.docesbyvic.models;

import java.time.format.DateTimeFormatter;

import static java.lang.String.format;

public class Sell {
    private Product product;
    private Integer quantity;
    private Double value;

    public Sell(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
        setValue();
    }

    protected Double calculateValue(){
        return this.product.getValue() * this.quantity;
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
