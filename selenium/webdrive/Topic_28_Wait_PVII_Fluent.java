package webdrive;

import graphql.com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_28_Wait_PVII_Fluent {
    WebDriver driver;
    FluentWait<WebDriver> fluentWait;
    FluentWait<WebElement> elementFluentWait;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
    }
    @Test
    public void TC_01(){
        driver.get("https://automationfc.github.io/dynamic-loading/");

        clickToElement("div#start>button");

        String helloText = getElementText("div#finish>h4");

        Assert.assertEquals(helloText,"Hello World!");

    }

    @Test
    public void TC_02(){
        driver.get("https://automationfc.github.io/fluent-wait/");

        WebElement countdownElement = getElememt("div#javacript_countdown_time");

        elementFluentWait = new FluentWait<>(countdownElement);

        elementFluentWait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(Exception.class);

       Assert.assertTrue( elementFluentWait.until(new Function<WebElement, Boolean>() {
            @Override
            public Boolean apply(WebElement element) {
                return element.getText().endsWith("00");
            }
        }));

    }

    // Viết hàm để sửa lại các hàm findElement/click/getText/isDisplayed với polling time mới
    private WebElement getElememt(String cssLocator){
        FluentWait <WebDriver> fluentWait = new FluentWait(driver);

        fluentWait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(Exception.class);

       return fluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.cssSelector(cssLocator));
            }
        });
    }

    private void clickToElement(String cssLocator){
        FluentWait <WebDriver> fluentWait = new FluentWait(driver);

        fluentWait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(Exception.class)
                .until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.cssSelector(cssLocator));
            }
        }).click();
    }

    private String getElementText(String cssLocator){
        FluentWait <WebDriver> fluentWait = new FluentWait(driver);

     return   fluentWait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(Exception.class)
                .until(new Function<WebDriver, WebElement>() {
                    @Override
                    public WebElement apply(WebDriver driver) {
                        return driver.findElement(By.cssSelector(cssLocator));
                    }
                }).getText();
    }

    private boolean isElementDisplayed(String cssLocator){
        FluentWait <WebDriver> fluentWait = new FluentWait(driver);

      return  fluentWait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(Exception.class)
                .until(new Function<WebDriver, WebElement>() {
                    @Override
                    public WebElement apply(WebDriver driver) {
                        return driver.findElement(By.cssSelector(cssLocator));
                    }
                }).isDisplayed();
    }

    private boolean waitVisible(String cssLocator){
        FluentWait <WebDriver> fluentWait = new FluentWait(driver);

        return  fluentWait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(Exception.class)
                .until(new ExpectedCondition<Boolean>() {
                    @Override
                    public Boolean apply(WebDriver driver) {
                        return driver.findElement(By.cssSelector(cssLocator)).isDisplayed();
                    }
                });
    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
