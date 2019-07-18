package com.omaru.friendpackage.util;

import com.mobiquityinc.exception.APIException;

public class ApplicationConstraints {
    public static final int MAX_ALLOWED_COST_ITEM =100;
    public static final double MAX_ALLOWED_WEIGHT_IN_ITEM=100d;
    public static final double MAX_ALLOWED_WEIGHT_IN_PACKAGE =100d;
    private ApplicationConstraints() throws IllegalAccessException {
        throw new IllegalAccessException("not meant to instantiate");
    }

    public static final double maxAllowedWeightInPackage(double weight)throws APIException {
        if (weight > MAX_ALLOWED_WEIGHT_IN_PACKAGE){
            throw new APIException("the max allowed weight for a package is: "+ MAX_ALLOWED_WEIGHT_IN_PACKAGE);
        }
        return weight;
    }

    public static final double maxAllowedWeightInItem(double weight)throws APIException {
        if (weight >MAX_ALLOWED_WEIGHT_IN_ITEM){
            throw new APIException("the max allowed weight in item is: "+MAX_ALLOWED_WEIGHT_IN_ITEM);
        }
        return weight;
    }

    public static final int maxAllowedCostInItem(int cost)throws APIException {
        if (cost >MAX_ALLOWED_COST_ITEM){
            throw new APIException("this cost is beyond allowed, max allowed is"+MAX_ALLOWED_COST_ITEM);
        }
        return cost;
    }
}
