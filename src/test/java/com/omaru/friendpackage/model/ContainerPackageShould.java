package com.omaru.friendpackage.model;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ContainerPackageShould {
    @Test
    public void beAbleToGetAllowedWeight(){
        int allowedWeight = 15;
        ContainerPackage containerPackage = new ContainerPackage(allowedWeight);
        assertEquals(allowedWeight,containerPackage.getAllowedWeight());
    }
    @Test
    public void beAbleToGetItemsInContainer(){
        ContainerPackage containerPackage = new ContainerPackage(10);
        List<Item> items = containerPackage.getItems();
        assertTrue("should retrieve a list of items",items.size()>=0);
    }
}
