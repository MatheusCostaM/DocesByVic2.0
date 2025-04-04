package br.com.docesbyvic.models;

import jakarta.persistence.*;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Entity
public class CompleteSell {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String date;

    @ManyToOne
    private Cliente cliente;

    private Double value;

    @OneToMany(mappedBy = "completeSell", cascade = CascadeType.ALL)
    private List<Sell> sellList = new ArrayList<>();

    public CompleteSell() {}

    public CompleteSell(List<Sell> sellList, String date, Cliente cliente, List<Promotion> promotionList) {
        this.sellList = sellList;
        this.date = date;
        this.cliente = cliente;
        aplicarPromotion(promotionList);
        calculateValue();
        setDividaCliente();

        this.sellList.forEach(sell -> sell.setCompleteSell(this));
    }

    public void aplicarPromotion(List<Promotion> promotionList){
        promotionList.stream()
                .anyMatch(p -> p.promotionValue(sellList));
    }

    public void calculateValue(){
        this.value = sellList.stream()
                                .mapToDouble(Sell::getValue)
                                .sum();
    }

    protected void setDividaCliente(){
        this.cliente.setDivida(this.cliente.getDivida() + this.value);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String  date) {
        this.date = date;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void addSell(Sell sell){
        this.sellList.add(sell);
    }

    public void addSell(List<Sell> sells){
        this.sellList.addAll(sells);
    }

    public List<Sell> getSellList() {
        return sellList;
    }

    @Override
    public String toString() {
        String produtos = sellList.stream()
                .map(Sell::toString)
                .collect(java.util.stream.Collectors.joining("\n"));

        return String.format("""
                %s / %s
                Produtos: %s 
                Valor total: %s
                """,date,cliente,produtos,value);
    }
}
