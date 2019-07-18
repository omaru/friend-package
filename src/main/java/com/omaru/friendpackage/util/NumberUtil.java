package com.omaru.friendpackage.util;

public class NumberUtil {
    private NumberUtil() throws IllegalAccessException {
        throw new IllegalAccessException("utility class");
    }

    /**
     * Method that truncates a double to two decimals floating point.
     * i.e. 12.343 returns 12.34
     * @param value to truncate
     * @return value truncated with two decimal points positions.
     */
    public static double truncate(double value){
        return Math.floor(value * 100) / 100;
    }
}
