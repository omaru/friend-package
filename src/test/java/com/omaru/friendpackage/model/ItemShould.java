package com.omaru.friendpackage.model;

import org.junit.Test;

import static org.springframework.test.util.AssertionErrors.assertEquals;

public class ItemShould {
    @Test
    public void retrieveIndex() {
        final Integer index = 789;
        final Double weight =123.3;
        final Double cost = 35.5;
        Item item = new Item(index, weight, cost);
        assertEquals("index should match", index, item.getIndex());
    }
    @Test
    public void retrieveWeightAndIndexAndCost(){
        final Integer index = 789;
        final Double weight =123.3;
        final Double cost = 35.5;
        Item item = new Item(index,weight,cost);
        assertEquals("weight should match",weight,item.getWeight());
        assertEquals("cost should match",cost,item.getCost());
        assertEquals("cost should match",index,item.getIndex());

    }
    @Test
    public void compareAgainstAnotherItemAndRetrieveGreater(){
        Integer index = 789;
        Double weight =123.3;
        Double cost = 35.5;
        Item lowerRateItem = new Item(index,weight,cost);
        index = 8;
        weight=20.3;
        cost=51.2;
        Item higherRateItem = new Item(index,weight,cost);
        assertEquals("should retrieve greater",1,lowerRateItem.compareTo(higherRateItem));

    }
}
