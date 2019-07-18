package com.omaru.friendpackage;

import com.omaru.friendpackage.model.ContainerPackage;
import com.omaru.friendpackage.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.max;

public final class Packer {
    int packageContainer[][];
    private final int totalItems;
    private final List<Integer> weights;
    private final List<Integer> values;
    private final int maximumWeightAllowed;
    private final List<Item> items;
    /**
     * Packages received items using 0/1 knapsack algorithm ,
     * because of the use of decimal points decided to multiply values to use integers in order to be able to construct
     * the table needed, inside Item I am truncating to two decimal points to ensure multiplication works.
     */
    public Packer(ContainerPackage containerPackage){
        this.items = containerPackage.getItems();
        this.weights =items.stream().map(i->(int)i.getWeight().doubleValue()*100).collect(Collectors.toList());
        this.values = items.stream().map(Item::getCost).collect(Collectors.toList());
        this.totalItems = containerPackage.getItems().size();
        this.maximumWeightAllowed = (int)containerPackage.getAllowedWeight()*100;
        this.packageContainer = new int[totalItems + 1][maximumWeightAllowed + 1];
    }

    private int getMaximumCost(){
        int i, w;
        // Build table packageContainer[][] in bottom up manner
        for (i = 0; i <= totalItems; i++) {
            for (w = 0; w <= maximumWeightAllowed; w++) {
                if (i == 0 || w == 0)
                    packageContainer[i][w] = 0;
                else if (weights.get(i - 1) <= w)
                    packageContainer[i][w] = max(values.get(i - 1) +
                            packageContainer[i - 1][w - weights.get(i - 1)], packageContainer[i - 1][w]);
                else
                    packageContainer[i][w] = packageContainer[i - 1][w];
            }
        }
        return packageContainer[totalItems][maximumWeightAllowed];
    }

    public Package pack() {
        int maximumCostReached = getMaximumCost();
        List<Integer> costIndexes = getCostIndexes(maximumCostReached);
        List<Item> itemsInPack = costIndexes.stream().map(items::get).collect(Collectors.toList());
        return new Package(itemsInPack);
    }

    private List<Integer> getCostIndexes(int maximumCostReached) {
        List<Integer> costIndexes = new ArrayList<>();
        int w = maximumWeightAllowed;
        for (int i = totalItems; i > 0 && maximumCostReached > 0; i--) {
            int index = i-1;
            // either the result comes from the top
            // (K[i-1][w]) or from (val[i-1] + K[i-1]
            // [w-wt[i-1]]) as in Knapsack table. If
            // it comes from the latter one/ it means
            // the item is included.
            if(maximumCostReached != packageContainer[index][w]){
                costIndexes.add(index);
                // Since this weight is included its
                // value is deducted
                maximumCostReached = maximumCostReached - values.get(index);
                w = w - weights.get(index);
            }
        }
        return costIndexes;
    }

}