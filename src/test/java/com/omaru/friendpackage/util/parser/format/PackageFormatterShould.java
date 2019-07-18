package com.omaru.friendpackage.util.parser.format;

import com.mobiquityinc.exception.APIException;
import com.omaru.friendpackage.Package;
import com.omaru.friendpackage.TestUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PackageFormatterShould {
    @Test
    public void retrievePackageFormattedAsString()throws APIException {
        Package testPackage = new Package(TestUtil.getItems());
        String expected="3\n-\n1,2,3";
        String result = PackageFormatter.format(testPackage);
        assertEquals("expected format should match",expected,result);
    }
}
