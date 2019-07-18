package com.omaru.friendpackage;

import com.omaru.friendpackage.model.Item;
import lombok.Getter;

import java.util.Collection;
@Getter
public class Package {
    private final Collection<Item> itemsInPack;
    public Package(Collection<Item> itemsInPack) {
        this.itemsInPack = itemsInPack;
    }
}