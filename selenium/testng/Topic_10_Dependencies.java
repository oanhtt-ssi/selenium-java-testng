package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_10_Dependencies {

    @Test
    public void Employee_01_CreateNewEmployee(){
        Assert.assertTrue(false);

    }

    @Test(dependsOnMethods = "Employee_01_CreateNewEmployee")
    public void Employee_02_SearchEmployee(){

    }

    @Test(dependsOnMethods = "Employee_01_CreateNewEmployee")
    public void Employee_03_EditExistEmployee(){

    }

    @Test(dependsOnMethods = "Employee_01_CreateNewEmployee")
    public void Employee_01_DeleteEmployee(){

    }
}
