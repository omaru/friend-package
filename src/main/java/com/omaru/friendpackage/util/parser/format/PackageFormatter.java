package com.omaru.friendpackage.util.parser.format;

import com.omaru.friendpackage.Package;
import com.omaru.friendpackage.model.Item;

import java.util.Collection;

import static java.util.stream.Collectors.joining;

public class PackageFormatter {

    public static String format(Package toFormat){
        Collection<Item> items = toFormat.getItemsInPack();
        StringBuilder output =new StringBuilder(String.valueOf(items.size()));
        output.append("\n");
        output.append("-");
        output.append("\n");
        output.append(getIndexesCommaSeparated(items));
        return output.toString();
    }

    private static String getIndexesCommaSeparated(Collection<Item> items) {
       return items.stream().map(Item::getIndex).map(String::valueOf).collect(joining(","));
    }
}