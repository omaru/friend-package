package com.omaru.friendpackage;

import com.mobiquityinc.exception.APIException;
import com.omaru.friendpackage.util.parser.Parser;
import com.omaru.friendpackage.util.parser.format.PackageFormatter;
import org.junit.Test;

import static org.springframework.test.util.AssertionErrors.assertEquals;

public class PackagingShould {

    @Test
    public void parseFromLineAndRetrieveOptimalPackages()throws APIException {
        final String input = "8 : (1,2.3,€34) (2,2.5,€35) (3,5.6,€20) (4,7.9,€15) (5,8,€1)";
        final String output="2\n-\n2,1";
        assertEquals("should be equal",output,
                PackageFormatter.format(new Packer(Parser.parse(input)).pack()));
    }
}
