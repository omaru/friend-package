package com.omaru.friendpackage.model;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ContainerPackageShould {
    @Test
    public void beAbleToGetAllowedWeight(){
        ContainerPackage containerPackage = new ContainerPackage();
        assertEquals(0,containerPackage.getAllowedWeight());
    }
    @Test
    public void beAbleToGetItemsInContainer(){
        ContainerPackage containerPackage = new ContainerPackage();
        List<Item> items = containerPackage.getItems();
        assertTrue("should retrieve a list of items",items.size()>=0);
    }
}
