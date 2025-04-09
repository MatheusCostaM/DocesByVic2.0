package br.com.docesbyvic.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phone;

    private Double debt;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<CompleteSell> purchaseList = new ArrayList<>();

    public Client() {}

    public Client(String name) {
        this.name = name;
        this.phone = "";
        this.debt = 0.0;
    }

    public Client(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.debt = 0.0;
    }

    public Long getId() {
        return id;
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

    public Double getDebt() {
        return debt;
    }

    public void setDebt(Double debt) {
        this.debt = debt;
    }

    public List<CompleteSell> getPurchaseList() {
        return purchaseList;
    }

    public void addPurchase(CompleteSell purchase) {
        this.purchaseList.add(purchase);
        purchase.setClient(this);
    }

    @Override
    public String toString() {
        return "Name: " + name + " / Debt: " + debt + " / Phone: " + phone;
    }
}
