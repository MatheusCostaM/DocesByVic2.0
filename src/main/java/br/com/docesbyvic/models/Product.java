package br.com.docesbyvic.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String tipe;

    private String sabor;

    private Double value;


    public Product(){}

    public Product(String tipe,String sabor, Double value) {
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

    public void getInfo(){
        String.format("Produto: %s %s / Valor: %s",this.getTipe(),this.getSabor(),this.getValue());
    }

    @Override
    public String toString() {
        return String.format("%s %s",this.getTipe(),this.getSabor());
    }
}
