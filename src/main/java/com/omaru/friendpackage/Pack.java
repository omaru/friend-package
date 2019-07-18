package com.omaru.friendpackage;

import com.omaru.friendpackage.model.Item;
import lombok.Getter;

import java.util.Collection;
@Getter
public class Pack {
    private final double solutionWeight;
    private final double totalCostValue;
    private final Collection<Item> itemsInPack;
    public Pack(double solutionWeight, double totalCostValue, Collection<Item> itemsInPack) {
        this.solutionWeight = solutionWeight;
        this.totalCostValue = totalCostValue;
        this.itemsInPack = itemsInPack;
    }
}