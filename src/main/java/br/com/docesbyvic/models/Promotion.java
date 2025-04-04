package br.com.docesbyvic.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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

    public Boolean promotionValue(List<Sell> sells) {
        List<Sell> promotionSells = sells.stream()
                .filter(e -> Objects.equals(e.getProduct().getValue(), this.value))
                .peek(System.out::println)
                .toList();

        int productsPromotion = promotionSells.stream()
                .mapToInt(Sell::getQuantity)
                .sum();

        if (productsPromotion >= 2) {
            promotionSells.forEach(s -> s.setValue(this.newValue));
            return true;
        } else {
            return false;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Double getValue() {
        return value;
    }

    public Double getNewValue() {
        return newValue;
    }

    public Integer getRegra() {
        return regra;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void setNewValue(Double newValue) {
        this.newValue = newValue;
    }

    public void setRegra(Integer regra) {
        this.regra = regra;
    }

    @Override
    public String toString() {
        return String.format("Promoção: %s | De %.2f por %.2f | Regra: %d", name, value, newValue, regra);
    }
}
