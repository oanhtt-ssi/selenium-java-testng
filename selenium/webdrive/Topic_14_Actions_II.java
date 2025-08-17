package webdrive;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_14_Actions_II {
    WebDriver driver;
    JavascriptExecutor jsExecutor;
    Actions actions;
    String osName = System.getProperty("os.name");


    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        actions = new Actions(driver);
        jsExecutor = (JavascriptExecutor) driver;

    }
    @Test
    public void TC_01_Click_And_Hold_Block(){
        driver.get("https://automationfc.github.io/jquery-selectable/");

        List<WebElement> allItems = driver.findElements(By.cssSelector("ol#selectable>li"));

        actions.clickAndHold(allItems.getFirst()).moveToElement(allItems.get(7)).release().perform();
        actions.pause(Duration.ofSeconds(2));

        Assert.assertEquals(driver.findElements(By.cssSelector("ol#selectable>li.ui-selected")).size(),8);

    }

    @Test
    public void TC_02_Click_And_Hold_Random() {
        driver.get("https://automationfc.github.io/jquery-selectable/");

        List<WebElement> allItems = driver.findElements(By.cssSelector("ol#selectable>li"));

        Keys keys = null;
        if (osName.contains("Windows")) {
            keys = Keys.CONTROL;
        } else {
            keys = Keys.COMMAND;
        }

        actions.keyDown(keys).perform();

        actions.click(allItems.get(0))
                .click(allItems.get(2))
                .click(allItems.get(5))
                .click(allItems.get(10))
                .perform();

        actions.keyUp(keys).perform();

        Assert.assertEquals(driver.findElements(By.cssSelector("ol#selectable>li.ui-selected")).size(),4);

    }

    @Test
    public void TC_03_Double_Click(){
        driver.get("https://automationfc.github.io/basic-form/index.html");

        if(driver.toString().contains("Firefox")) {
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);",
                    driver.findElement(By.xpath("//button[text()='Double click me']")));
            actions.pause(Duration.ofSeconds(3)).perform();
        }

        actions.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();

        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(),"Hello Automation Guys!");
    }

    @Test
    public void TC_04_Right_Click() throws InterruptedException {
        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

        Assert.assertFalse(driver.findElement(By.cssSelector("li.context-menu-icon-quit")).isDisplayed());

        actions.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();
        actions.pause(Duration.ofSeconds(2));

        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-quit")).isDisplayed());

        actions.moveToElement(driver.findElement(By.cssSelector("li.context-menu-icon-quit"))).perform();
        actions.pause(Duration.ofSeconds(2));

        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-quit.context-menu-visible.context-menu-hover")).isDisplayed());

        driver.findElement(By.cssSelector("li.context-menu-icon-quit")).click();

        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.alertIsPresent()).accept();
        Assert.assertFalse(driver.findElement(By.cssSelector("li.context-menu-icon-quit")).isDisplayed());


    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
