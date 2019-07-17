package com.omaru.friendpackage.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode @Getter
public class Item implements Comparable<Item>{
    private final int index;
    private final double weight;
    private final double cost;
    private double weightInPackage =-0.0001;
    public Item(Integer index,Double weight,Double cost){
        this.index = index;
        this.weight = Math.max(weight,0);
        this.cost = Math.max(cost,0);//assumming there are no negative costs
    }

    public void setWeightInPackage(double weightInPackage) {
        this.weightInPackage = Math.max(weightInPackage, 0);
    }

    @Override
    public int compareTo(Item item) {
        int result = 0;
        double thisRate = getCost()/getWeight();
        double thatRate = item.getCost()/item.getWeight();
        if(thisRate > thatRate){
            result = -1;
        }else if(thisRate < thatRate){
            result =1;
        }
        return result;
    }
}
