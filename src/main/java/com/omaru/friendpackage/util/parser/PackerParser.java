package com.omaru.friendpackage.util.parser;

import com.omaru.friendpackage.model.ContainerPackage;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PackerParser {
    private PackerParser() throws IllegalAccessException {
        throw new IllegalAccessException("shouldn't have an instance");
    }

    public static ContainerPackage parse(String input) {
            //        final String input = "8 : (1,2.3,€34) (2,2.5,€35) (3,5.6,€20) (4,7.9,€15) (5,8,€1)";
        Pattern pattern = Pattern.compile("(\\((.*?)\\))");
        Matcher matcher = pattern.matcher(input);
            System.out.println(matcher.groupCount());
        for(int c =0;c< matcher.groupCount();c++){
            System.out.println(matcher.group(c));


        }

        return new ContainerPackage(18,new ArrayList<>());
    }
}
