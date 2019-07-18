package com.omaru.friendpackage.util;

import com.mobiquityinc.exception.APIException;
import org.junit.Test;

public class ApplicationConstraintsShould {
    @Test(expected = APIException.class)
    public void throwApiExceptionWhenAllowedWeightItemIsBeyondAllowed()throws APIException{
        ApplicationConstraints.maxAllowedWeightInItem(ApplicationConstraints.MAX_ALLOWED_WEIGHT_IN_ITEM+1);
    }
    @Test(expected = APIException.class)
    public void throwApiExceptionWhenAllowedCostItemIsBeyondAllowed()throws APIException{
        ApplicationConstraints.maxAllowedCostInItem(ApplicationConstraints.MAX_ALLOWED_COST_ITEM+1);
    }
    @Test(expected = APIException.class)
    public void throwApiExceptionWhenAllowedWeightInPackageIsBeyondAllowed()throws APIException{
        ApplicationConstraints.maxAllowedWeightInPackage(ApplicationConstraints.MAX_ALLOWED_WEIGHT_IN_PACKAGE +1);
    }
}
