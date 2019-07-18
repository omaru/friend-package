package com.omaru.friendpackage;

import com.omaru.friendpackage.model.ContainerPackage;
import com.omaru.friendpackage.model.Item;

import java.util.*;
import java.util.stream.Collectors;

public final class Packer {
    private double solutionWeight = 0.0d;
    private final ContainerPackage containerPackage;
    private double [][] packTable;
    private final int totalItems;
    private final List<Double> weights;
    private final List<Double> values;
    private double totalCostValue;
    public Packer(ContainerPackage containerPackage){
        this.totalItems = containerPackage.getItems().size();
        this.containerPackage = containerPackage;
        this.packTable = new double[totalItems+1][containerPackage.getAllowedWeight()+1];
        this.weights = containerPackage.getItems().stream().map(i->i.getWeightInPackage()).collect(Collectors.toList());
        this.values = containerPackage.getItems().stream().map(i->i.getCost()).collect(Collectors.toList());
    }

    public Pack pack() {
        for(double i = 1;i<totalItems+1;i++){
            for(double w =1;w<containerPackage.getAllowedWeight()+1;w++){
                double notTakingItem = packTable[(int)i-1][(int)w];
                double takingItem = 0;
                if(weights.get((int)i)<=w){
                    takingItem = values.get((int)i) + packTable[(int)i-1][(int)(w-weights.get((int)i))];
                }
                packTable[(int)i][(int)w] = Math.max(notTakingItem,takingItem);
            }
        }
        totalCostValue = packTable[totalItems][containerPackage.getAllowedWeight()];
        return null;
    }

}