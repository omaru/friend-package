package com.omaru.friendpackage.model;

import com.mobiquityinc.exception.APIException;
import com.omaru.friendpackage.util.ApplicationConstraints;
import org.junit.Test;

import static org.springframework.test.util.AssertionErrors.assertEquals;

public class ItemShould {
    @Test
    public void retrieveIndex() throws APIException {
        final Integer index = 789;
        final Double weight =38d;
        final Integer cost = 35;
        Item item = new Item(index, weight, cost);
        assertEquals("index should match", index, item.getIndex());
    }
    @Test
    public void retrieveWeightAndIndexAndCost() throws APIException{
        final Integer index = 789;
        final Double weight =38d;
        final Integer cost = 35;
        Item item = new Item(index,weight,cost);
        assertEquals("weight should match",weight,item.getWeight());
        assertEquals("cost should match",cost,item.getCost());
        assertEquals("cost should match",index,item.getIndex());

    }
    @Test(expected = APIException.class)
    public void throwExceptionIfMaxAllowedWeightIsPassed() throws APIException{
        final Integer index = 789;
        final Integer cost = 35;
        new Item(index, ApplicationConstraints.MAX_ALLOWED_WEIGHT_IN_ITEM+0.12,cost);
    }
    @Test(expected = APIException.class)
    public void throwExceptionIfMaxAllowedCostIsPassed() throws APIException{
        final Integer index = 789;
        final Double weight =38d;
        new Item(index, weight,ApplicationConstraints.MAX_ALLOWED_COST_ITEM+1);
    }
}
