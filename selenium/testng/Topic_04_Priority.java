package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Priority {
    WebDriver driver;

    @Test(description = "Create new Account")
    public void TC_01_CreateNewAccount(){
        System.out.println("newAccount");
    }

    @Test
    public void TC_02_EditAccount(){
        System.out.println("editAccount");

    }

    @Test(enabled = false)
    public void TC_03_MoveAccount(){
        System.out.println("moveAccount");

    }

    @Test
    public void TC_04_DeleteAccount(){
        System.out.println("deleteAccount");

    }

}
