package br.com.docesbyvic.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class CompleteSell {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String date;

    @ManyToOne
    private Client client;

    private Double value;

    @OneToMany(mappedBy = "completeSell", cascade = CascadeType.ALL)
    private List<Sell> sellList = new ArrayList<>();

    public CompleteSell() {}

    public CompleteSell(List<Sell> sellList, String date, Client client, List<Promotion> promotionList) {
        this.sellList = sellList;
        this.date = date;
        this.client = client;
        aplicarPromotion(promotionList);
        calculateValue();
        setDebtClient();

        this.sellList.forEach(sell -> sell.setCompleteSell(this));
    }

    public void aplicarPromotion(List<Promotion> promotionList) {
        promotionList.forEach(p -> p.applyPromotionIfEligible(sellList));
    }

    public void calculateValue() {
        this.value = sellList.stream()
                .mapToDouble(Sell::getValue)
                .sum();
    }

    protected void setDebtClient() {
        this.client.setDebt(this.client.getDebt() + this.value);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public List<Sell> getSellList() {
        return sellList;
    }

    public void setSellList(List<Sell> sellList) {
        this.sellList = sellList;
    }

    public void addSell(Sell sell) {
        this.sellList.add(sell);
    }

    public void addSell(List<Sell> sells) {
        this.sellList.addAll(sells);
    }

    @Override
    public String toString() {
        String produtos = sellList.stream()
                .map(Sell::toString)
                .collect(Collectors.joining("\n"));

        return String.format("""
                %s / %s
                Produtos: %s 
                Valor total: %s
                """, date, client, produtos, value);
    }
}
