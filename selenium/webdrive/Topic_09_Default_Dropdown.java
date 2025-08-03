package webdrive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_09_Default_Dropdown {
    WebDriver driver;
    Select select;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();

    }
    @Test
    public void TC_01() throws InterruptedException {
        driver.get("https://www.facebook.com/r.php?locale=en_EN&display=page");

        //Khởi tạo thư việc select khi dropdown xuất hiện
        select = new Select(driver.findElement(By.cssSelector("select#month")));
        select.selectByVisibleText("Oct");
        Thread.sleep(2000);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Oct");
        Assert.assertEquals(select.getOptions().size(),12);
        Assert.assertFalse(select.isMultiple());

        select = new Select(driver.findElement(By.cssSelector("select#day")));
        select.selectByVisibleText("5");
        Thread.sleep(2000);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"5");
        Assert.assertEquals(select.getOptions().size(),31);
        Assert.assertFalse(select.isMultiple());

        select = new Select(driver.findElement(By.cssSelector("select#year")));
        select.selectByVisibleText("1995");
        Thread.sleep(2000);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"1995");
        Assert.assertFalse(select.isMultiple());

    }

    @Test
    public void TC_02() throws InterruptedException {
        driver.get("https://rode.com/en/support/where-to-buy");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement allowButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Allow All']")));
        allowButton.click();

        new Select(driver.findElement(By.cssSelector("select#country"))).selectByVisibleText("Vietnam");
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("input#map_search_query")).sendKeys("HO CHI MINH");
        driver.findElement(By.xpath("//button[text()='Search']")).click();

        Assert.assertEquals(driver.findElements(By.xpath("//h3[text()='Dealers']/following-sibling::div/div")).size(),16);
        List<WebElement> dealers = driver.findElements(By.xpath("//h3[text()='Dealers']/following-sibling::div/div//h4"));
        for (WebElement temp:dealers){
            System.out.println(temp.getText());
        }


    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
