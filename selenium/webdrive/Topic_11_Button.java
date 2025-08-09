package webdrive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;

public class Topic_11_Button {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void TC_01(){
        driver.get("https://www.fahasa.com/customer/account/create");
        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
        By btnLogin = By.cssSelector("button.fhs-btn-login");

        Assert.assertFalse(driver.findElement(btnLogin).isEnabled());

        Assert.assertEquals(Color.fromString(driver.findElement(By.cssSelector("button.fhs-btn-login"))
                .getCssValue("background-color")).asHex().toUpperCase(),"#000000");

        driver.findElement(By.cssSelector("input#login_username")).sendKeys("oanhtt@gmail.com");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("123456");
        Assert.assertEquals(Color.fromString(driver.findElement(By.cssSelector("button.fhs-btn-login"))
                .getCssValue("background-color")).asHex().toUpperCase(),"#C92127");



    }

    @Test
    public void TC_02(){

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
