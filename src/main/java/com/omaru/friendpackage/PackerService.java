package com.omaru.friendpackage;

import com.omaru.friendpackage.model.ContainerPackage;
import com.omaru.friendpackage.model.Item;

import java.util.Collections;
import java.util.List;

public final class PackerService {
    private double solutionWeight = 0.0;
    private double profit = 0.0;
    private boolean calculated = false;
    private final ContainerPackage containerPackage;

    public PackerService(ContainerPackage containerPackage){
        this.containerPackage = containerPackage;
    }

    public Pack pack() {
        List<Item> items = containerPackage.getItems();
        int numberOfItems = items.size();
        int allowedWeight = containerPackage.getAllowedWeight();
        if (numberOfItems > 0  &&  containerPackage.getAllowedWeight() > 0) {
            Collections.sort(items);
            for (int i = 0; (allowedWeight - solutionWeight) > 0.0  &&  i < numberOfItems; i++) {
                Item item = items.get(i);
                if (item.getWeight() >= (allowedWeight - solutionWeight)) {
                    item.setWeightInPackage(allowedWeight - solutionWeight);
                    solutionWeight = allowedWeight;
                    profit += item.getWeightInPackage() / item.getWeight() * item.getCost();
                    break;
                } else {
                    item.setWeightInPackage(item.getWeight());
                    solutionWeight += item.getWeightInPackage();
                    profit += item.getCost();
                }
            }
            calculated = true;
        }
        return new Pack();
    }
}
