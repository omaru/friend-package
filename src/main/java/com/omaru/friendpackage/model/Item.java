package com.omaru.friendpackage.model;

import lombok.Data;

@Data
public class Item {
    private final Integer index;
    private final Double weight;
    private final Double cost;
    public Item(Integer index,Double weight,Double cost){
        this.index = index;
        this.weight = weight;
        this.cost = cost;
    }
}
