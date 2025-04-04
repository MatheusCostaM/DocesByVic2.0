package br.com.docesbyvic.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phone;

    private Double divida;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<CompleteSell> comprasList = new ArrayList<>();

    public Cliente() {}

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

    public void addCompra(CompleteSell compra) {
        this.comprasList.add(compra);
        compra.setCliente(this);
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
