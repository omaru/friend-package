package com.omaru.friendpackage.model;

import java.util.LinkedList;
import java.util.List;

public class ContainerPackage {
    private final Integer allowedWeight;
    private List<Item> items = new LinkedList<>();
    public  ContainerPackage(Integer allowedWeight){
        this.allowedWeight = Math.max(allowedWeight,0);
    }

    public int getAllowedWeight() {
        return allowedWeight;
    }

    public List<Item> getItems() {
        return items;
    }
}
