package br.com.docesbyvic.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Promotion {
    private String name;
    private Double value;
    private Double newValue;
    final Integer regra;

    public Promotion(String name, Double value, Double newValue,Integer regra) {
        this.name = name;
        this.value = value;
        this.newValue = newValue;
        this.regra = regra;
    }

    public Boolean promotionValue(List<Sell> sells){

        List<Sell> promotionSells = sells.stream()
                .filter(e -> Objects.equals(e.getProduct().getValue(), this.value))
                .peek(System.out::println)
                .toList();

        int productsPromotion = promotionSells.stream()
                .mapToInt(Sell::getQuantity)
                .sum();

        if(productsPromotion >= 2){
            promotionSells.forEach(s -> s.setValue(this.newValue));
            return true;
        } else {
            return false;
        }

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
}
