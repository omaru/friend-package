package com.omaru.friendpackage.model;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;
@Getter
public class ContainerPackage {
    private final int allowedWeight;
    private final List<Item> items ;
    public  ContainerPackage(int allowedWeight,List<Item> items){
        this.allowedWeight = Math.max(allowedWeight,0);
        this.items = items;
    }
}
