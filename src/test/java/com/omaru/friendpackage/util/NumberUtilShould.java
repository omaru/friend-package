package com.omaru.friendpackage.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberUtilShould {
    @Test
    public void beAbleToTruncateADoubleValue(){
        double input = 100.55689;
        double expected = 100.55;
        double result = NumberUtil.truncate(input);
        assertEquals(expected,result,0.01);
    }
}
