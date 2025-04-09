package br.com.docesbyvic.models;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipe;

    private String sabor;

    private Double value;

    public Product() {}

    public Product(String tipe, String sabor, Double value) {
        this.tipe = tipe;
        this.sabor = sabor;
        this.value = value;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getTipe(), this.getSabor());
    }
}
