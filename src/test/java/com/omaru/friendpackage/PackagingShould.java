package com.omaru.friendpackage;

import com.omaru.friendpackage.util.parser.PackFormatter;
import com.omaru.friendpackage.util.parser.PackerParser;
import org.junit.Test;

import static org.springframework.test.util.AssertionErrors.assertEquals;

public class PackagingShould {

    @Test
    public void parseFromLineAndRetrieveOptimalPackages(){
        final String input = "8 : (1,2.3,€34) (2,2.5,€35) (3,5.6,€20) (4,7.9,€15) (5,8,€1)";
        final String output="2:1,2";
      assertEquals("should be equal",output,
                PackFormatter.format(new Packer(PackerParser.parse(input)).pack()));

    }
}
