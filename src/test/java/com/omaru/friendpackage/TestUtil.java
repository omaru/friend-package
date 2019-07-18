package com.omaru.friendpackage;

import com.mobiquityinc.exception.APIException;
import com.omaru.friendpackage.model.Item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestUtil {

    private TestUtil()throws Exception{
        throw new IllegalAccessException("utility class");
    }

    public static Collection<Item> getItems() throws APIException {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1,2.3d,34));
        items.add(new Item(2,2.5d,35));
        items.add(new Item(3,8d,1));
        return items;
    }
}
