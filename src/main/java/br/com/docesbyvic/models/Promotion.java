package br.com.docesbyvic.models;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Double value;
    private Double newValue;
    private Integer regra;

    public Promotion() {}

    public Promotion(String name, Double value, Double newValue, Integer regra) {
        this.name = name;
        this.value = value;
        this.newValue = newValue;
        this.regra = regra;
    }

    // Lógica da promoção (verifica e aplica se puder)
    public Boolean applyPromotionIfEligible(List<Sell> sells) {
        List<Sell> promotionSells = sells.stream()
                .filter(e -> Objects.equals(e.getProduct().getValue(), this.value))
                .toList();

        int productsPromotion = promotionSells.stream()
                .mapToInt(Sell::getQuantity)
                .sum();

        if (productsPromotion >= this.regra) {
            promotionSells.forEach(s -> s.setValue(this.newValue));
            return true;
        } else {
            return false;
        }
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getNewValue() {
        return newValue;
    }

    public void setNewValue(Double newValue) {
        this.newValue = newValue;
    }

    public Integer getRegra() {
        return regra;
    }

    public void setRegra(Integer regra) {
        this.regra = regra;
    }

    @Override
    public String toString() {
        return String.format("Promotion: %s | From: %.2f To: %.2f | Rule: %d",
                this.name, this.value, this.newValue, this.regra);
    }
}
