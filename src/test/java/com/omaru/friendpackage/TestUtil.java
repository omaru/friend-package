package com.omaru.friendpackage;

import com.omaru.friendpackage.model.Item;

import java.util.ArrayList;
import java.util.List;

public class TestUtil {

    private TestUtil()throws Exception{
        throw new IllegalAccessException("utility class");
    }
    public static List<Item> getItems(){
        List<Item> items = new ArrayList<>();
        items.add(new Item(1,2.3d,34d));
        items.add(new Item(2,2.5d,35d));
        items.add(new Item(3,5.6d,20d));
        items.add(new Item(4,7.9d,15d));
        items.add(new Item(5,5.8d,1d));
        return items;
    }
}
