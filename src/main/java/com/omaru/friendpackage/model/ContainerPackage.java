package com.omaru.friendpackage.model;

import com.mobiquityinc.exception.APIException;
import lombok.Getter;

import java.util.List;

import static com.omaru.friendpackage.util.ApplicationConstraints.maxAllowedWeightInPackage;
import static com.omaru.friendpackage.util.NumberUtil.truncate;

@Getter
public class ContainerPackage {
    private final double allowedWeight;
    private final List<Item> items ;
    public  ContainerPackage(double allowedWeight,List<Item> items)throws APIException{
        this.allowedWeight = maxAllowedWeightInPackage(truncate(Math.max(allowedWeight,0)));
        this.items = items;
    }
}
