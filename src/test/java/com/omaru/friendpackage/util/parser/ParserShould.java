package com.omaru.friendpackage.util.parser;

import com.omaru.friendpackage.model.ContainerPackage;
import com.omaru.friendpackage.model.Item;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ParserShould {

    @Test
    public void beAbleToTransformStringInputToPackageContainerObject(){
        String input="81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9)\n" +
                "(6,46.34,€48)";
        ContainerPackage containerPackage = Parser.parse(input);
        assertEquals(6,containerPackage.getItems().size());
        Item item = containerPackage.getItems().get(2);
        assertEquals(3,item.getIndex());
        assertEquals(78.84,item.getWeight(),0.01);
        assertEquals(3,item.getCost(),0.01);
    }
}
