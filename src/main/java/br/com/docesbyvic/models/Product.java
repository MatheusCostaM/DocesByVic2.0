package br.com.docesbyvic.models;

public class Product {
    private String tipe;
    private String sabor;
    private Double value;

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
