package com.omaru.friendpackage.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ContainerPackageShould {
    @Test
    public void beAbleToGetAllowedWeight(){
        int allowedWeight = 15;
        ContainerPackage containerPackage = new ContainerPackage(allowedWeight,new ArrayList<>());
        assertEquals(allowedWeight,containerPackage.getAllowedWeight());
    }
    @Test
    public void beAbleToGetItemsInContainer(){
        ContainerPackage containerPackage = new ContainerPackage(10,new ArrayList<>());
        List<Item> items = containerPackage.getItems();
        assertTrue("should retrieve a list of items",items.size()>=0);
    }
}
