package webdrive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_14_Actions_I {
    WebDriver driver;
    Actions actions;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }
    @Test
    public void TC_01_Hover(){
        driver.get("https://automationfc.github.io/jquery-tooltip/");

        actions.moveToElement(driver.findElement(By.cssSelector("input#age"))).perform();

        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='ui-tooltip-content']")).getText(),
                "We ask for your age only for statistical purposes.");

    }

    @Test
    public void TC_02_Fahasa(){
        driver.get("https://www.fahasa.com/");

        actions.moveToElement(driver.findElement(By.cssSelector("span.icon_menu"))).perform();
        actions.pause(Duration.ofSeconds(2)).perform();

        actions.moveToElement(driver.findElement(By.xpath("//span[text()='Đồ Chơi']"))).perform();
        //actions.pause(Duration.ofSeconds(2)).perform();

        driver.findElement(By.xpath("//div[@class='fhs_column_stretch']//a[text()='Mô Hình Giấy']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//ol[@class='breadcrumb']//strong[text()='Mô Hình Giấy']")).isDisplayed());

    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
