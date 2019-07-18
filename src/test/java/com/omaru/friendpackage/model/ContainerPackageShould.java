package com.omaru.friendpackage.model;

import com.mobiquityinc.exception.APIException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ContainerPackageShould {
    @Test
    public void beAbleToGetAllowedWeight()throws APIException {
        double allowedWeight = 15;
        ContainerPackage containerPackage = new ContainerPackage(allowedWeight,new ArrayList<>());
        assertEquals(allowedWeight,containerPackage.getAllowedWeight(),0.01);
    }
    @Test
    public void beAbleToGetItemsInContainer()throws APIException{
        ContainerPackage containerPackage = new ContainerPackage(10,new ArrayList<>());
        List<Item> items = containerPackage.getItems();
        assertTrue("should retrieve a list of items",items.size()>=0);
    }
}
