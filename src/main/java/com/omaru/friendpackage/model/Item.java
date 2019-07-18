package com.omaru.friendpackage.model;

import com.mobiquityinc.exception.APIException;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import static com.omaru.friendpackage.util.ApplicationConstraints.maxAllowedCostInItem;
import static com.omaru.friendpackage.util.ApplicationConstraints.maxAllowedWeightInItem;
import static com.omaru.friendpackage.util.NumberUtil.truncate;

@EqualsAndHashCode @Getter
public class Item{
    private final Integer index;
    private final Double weight;
    private final Integer cost;

    public Item(Integer index,Double weight,Integer cost)throws APIException {
        this.index = index;
        this.weight = maxAllowedWeightInItem(truncate(Math.max(weight,0)));
        this.cost = maxAllowedCostInItem(Math.max(cost,0));//assumming there are no negative costs
    }

}