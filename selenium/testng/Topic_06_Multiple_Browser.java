package testng;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.awt.*;
import java.time.Duration;

public class Topic_06_Multiple_Browser {
    WebDriver driver;

    @Parameters({"browserName"})
    @BeforeClass
    public void beforeClass(String browserName){
        switch (browserName){
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case  "Firefox":
                driver = new FirefoxDriver();
                break;
            case "Edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not valid!!");
        }
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


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}

