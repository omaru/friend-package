package com.omaru.friendpackage;

import com.mobiquityinc.exception.APIException;
import com.omaru.friendpackage.model.ContainerPackage;
import com.omaru.friendpackage.model.Item;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PackerShould {
    @Test
    public void retrieveOptimizedPackages()throws APIException{
        List<Item> items = new ArrayList<>();
        items.add(new Item(1,10d,60));
        items.add(new Item(2,20d,100));
        items.add(new Item(3,30d,20));
        ContainerPackage containerPackage = new ContainerPackage(50,items);
        Packer packer = new Packer(containerPackage);
        Package aPackage = packer.pack();
        Collection<Item> itemsInPack = aPackage.getItemsInPack();
        Item item = itemsInPack.stream().filter(i->i.getIndex() == 1).findFirst().orElseThrow(()
                ->new RuntimeException("item not found"));
        assertEquals(1,item.getIndex().intValue());
        item = itemsInPack.stream().filter(i->i.getIndex() == 2).findFirst().orElseThrow(()
                ->new RuntimeException("item not found"));
        assertEquals(2,item.getIndex().intValue());
    }
    @Test
    public void retrieveOptimizedPackagesForDoubleCosts() throws APIException {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1,2.3d,34));
        items.add(new Item(2,2.5d,35));
        items.add(new Item(3,5.6d,20));
        items.add(new Item(4,7.9,15));
        items.add(new Item(5,8d,1));
        ContainerPackage containerPackage = new ContainerPackage(50,items);
        Packer packer = new Packer(containerPackage);
        Package aPackage = packer.pack();
        Collection<Item> itemsInPack = aPackage.getItemsInPack();
        Item item = itemsInPack.stream().filter(i->i.getIndex() == 1).findFirst().orElseThrow(()
                ->new RuntimeException("item not found"));
        assertEquals(1,item.getIndex().intValue());
        item = itemsInPack.stream().filter(i->i.getIndex() == 2).findFirst().orElseThrow(()
                ->new RuntimeException("item not found"));
        assertEquals(2,item.getIndex().intValue());
    }
}
