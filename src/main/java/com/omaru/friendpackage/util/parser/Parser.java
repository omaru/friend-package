package com.omaru.friendpackage.util.parser;

import com.mobiquityinc.exception.APIException;
import com.omaru.friendpackage.model.ContainerPackage;
import com.omaru.friendpackage.model.Item;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import static org.apache.logging.log4j.util.Strings.isNotBlank;

public final class Parser {
    private static final int ITEM_INDEX_POSITION=0;
    private static final int ITEM_WEIGHT_POSITION=1;
    private static final int ITEM_COST_POSITION=2;
    private static final double DEFAULT_WEIGHT=0;
    private static final String DELIMITERS = ":(),€";
    public static ContainerPackage parse(String input) throws APIException {
        double allowedWeight= getAllowedWeight(input);
        List<List<Object>> values = getValues(input);
        List<Item> items = toItems(values);
        return new ContainerPackage(allowedWeight,items);
    }

    private static double getAllowedWeight(String input) {
        StringTokenizer tokenizer = new StringTokenizer(input, DELIMITERS);
        while(tokenizer.hasMoreTokens()){
            String token = tokenizer.nextToken();
            if(isNotBlank(token)){
                return Double.valueOf(token);
            }else{
                break;
            }
        }
        return DEFAULT_WEIGHT;
    }

    private static List<Item> toItems(List<List<Object>> values) throws APIException{
        List<Item> items = new ArrayList<>();
        for(List<Object> value : values){
            Item item = new Item((Integer)value.get(ITEM_INDEX_POSITION),
                        (Double)value.get(ITEM_WEIGHT_POSITION),
                        (Integer)value.get(ITEM_COST_POSITION));
            items.add(item);
        }
        return items;
    }

    private static List<List<Object>> getValues(String input) {
        List<List<Object>> values = new LinkedList<>();
        StringTokenizer tokenizer = new StringTokenizer(input, DELIMITERS);
        int index = -1;
        while(tokenizer.hasMoreTokens()){
            String token = tokenizer.nextToken();
            if(isNotBlank(token)){
                switch(index){
                    case -1:break;
                    case ITEM_INDEX_POSITION:values.add(new ArrayList<>());
                        values.get(values.size()-1).add(Integer.valueOf(token));
                        break;
                    case ITEM_WEIGHT_POSITION:values.get(values.size()-1).add(Double.valueOf(token));
                        break;
                    case ITEM_COST_POSITION:values.get(values.size()-1).add(Integer.valueOf(token));
                        break;
                }
                index = index >= ITEM_COST_POSITION ? ITEM_INDEX_POSITION : ++index;
            }
        }
        return values;
    }
}
