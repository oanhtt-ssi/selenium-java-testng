package webdrive;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_16_Shadow_DOM {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Home_Shop(){
        driver.get("https://shop.polymer-project.org/");

        WebElement shopAppShadowHost = driver.findElement(By.cssSelector("shop-app"));
        SearchContext shopAppShadowRoot = shopAppShadowHost.getShadowRoot();

        WebElement shopHomeShadowHost = shopAppShadowRoot.findElement(By.cssSelector("iron-pages>shop-home"));
        SearchContext shopHomeShadowRoot = shopHomeShadowHost.getShadowRoot();

        shopHomeShadowRoot.findElement(By.cssSelector("shop-button>a[href *='mens_outerwear']")).click();


    }

    @Test
    public void TC_02_Nested(){
        driver.get("https://automationfc.github.io/shadow-dom");

        Assert.assertEquals(driver.findElement(By.xpath("//a")).getText(), "scroll.html");
        Assert.assertEquals(driver.findElements(By.xpath("//a")).size(),1);

        WebElement firstShadowHost = driver.findElement(By.cssSelector("div#shadow_host"));
        SearchContext firstShadowRoot = firstShadowHost.getShadowRoot();

        Assert.assertEquals(firstShadowRoot.findElement(By.cssSelector("span#shadow_content>span")).getText(),"some text");
        Assert.assertEquals(firstShadowRoot.findElement(By.cssSelector("a")).getText(),"nested scroll.html");
        Assert.assertFalse(firstShadowRoot.findElement(By.cssSelector("input[type='checkbox']")).isSelected());

        WebElement secondShadowHost = firstShadowRoot.findElement(By.cssSelector("div#nested_shadow_host"));
        SearchContext secondShadowRoot = secondShadowHost.getShadowRoot();

        Assert.assertEquals(secondShadowRoot.findElement(By.cssSelector("div#nested_shadow_content>div")).getText(),"nested text");

    }

    @Test
    public void TC_03_Book_App() throws InterruptedException {
        driver.get("https://books-pwakit.appspot.com/");
        Thread.sleep(3000);

        WebElement bookAppShadowHost = driver.findElement(By.cssSelector("book-app"));
        SearchContext bookAppShadowRoot = bookAppShadowHost.getShadowRoot();

        bookAppShadowRoot.findElement(By.cssSelector("book-input-decorator>input#input")).sendKeys("Harry Potter");

        WebElement bookDecoratorShadowHost = bookAppShadowRoot.findElement(By.cssSelector("book-input-decorator"));
        SearchContext bookDecoratorShadowRoot = bookDecoratorShadowHost.getShadowRoot();

        bookDecoratorShadowRoot.findElement(By.cssSelector("div.icon")).click();
        Thread.sleep(3000);

        bookAppShadowHost = driver.findElement(By.cssSelector("book-app"));
        bookAppShadowRoot = bookAppShadowHost.getShadowRoot();

        WebElement bookExplorerShadowHost = bookAppShadowRoot.findElement(By.cssSelector("book-explore"));
        SearchContext bookExplorerShadowRoot = bookExplorerShadowHost.getShadowRoot();

        List<WebElement> listBookItems = bookExplorerShadowRoot.findElements(By.cssSelector("section>ul.books>li>book-item"));

        for (WebElement bookItem :listBookItems){
            SearchContext bookItemShadowRoot = bookItem.getShadowRoot();
            System.out.println(bookItemShadowRoot.findElement(By.cssSelector("div.title-container>h2")).getText());
        }

    }

    @AfterClass
    public void afterClass(){

        //driver.quit();
    }
}
