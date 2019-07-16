package com.omaru.friendpackage.model;

import java.util.LinkedList;
import java.util.List;

public class ContainerPackage {
    private Integer allowedWeight = 0;
    private List<Item> items = new LinkedList<>();
    public  ContainerPackage(){

    }

    public int getAllowedWeight() {
        return allowedWeight;
    }

    public List<Item> getItems() {
        return items;
    }
}
