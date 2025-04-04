package br.com.docesbyvic.models;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String name;
    private String phone;
    private Double divida;
    private List<CompleteSell> comprasList = new ArrayList<>();

    public Cliente(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.divida = 0.0;
    }

    public Double getDivida() {
        return divida;
    }

    public void setDivida(Double divida) {
        this.divida = divida;
    }

    public List<CompleteSell> getComprasList() {
        return comprasList;
    }

    public void addCompra(CompleteSell compra){
        this.comprasList.add(compra);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void getInfo(){
        System.out.println(this.toString());
        System.out.println("Lista de Compras: \n");
        comprasList.forEach(System.out::println);
    }

    @Override
    public String toString(){
        return "Nome: "+name+" / Divida :"+divida+" / Telefone: "+ phone;
    }
}
