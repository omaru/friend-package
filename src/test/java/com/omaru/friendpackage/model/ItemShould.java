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
    public void retrieveWeightAndCost(){
        final Integer index = 789;
        final Double weight =123.3;
        final Double cost = 35.5;
        Item item = new Item(index,weight,cost);
        assertEquals("weight should match",weight,item.getWeight());
        assertEquals("cost should match",cost,item.getCost());
    }
}
