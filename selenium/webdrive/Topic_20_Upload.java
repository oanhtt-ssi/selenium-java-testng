package webdrive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_20_Upload {
    WebDriver driver;
    String uploadFilePath = System.getProperty("user.dir") + "\\uploadFiles\\";

    String mountainFile = "Mountain.png";
    String riverFile = "River.png";
    String treeFile = "Tree.png";

    String mountainFilePath = uploadFilePath + mountainFile;
    String riverFilePath = uploadFilePath + riverFile;
    String treeFilePath = uploadFilePath + treeFile;



    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void TC_01_Single_File() throws InterruptedException {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By uploadFileBy = By.cssSelector("input[type = 'file']");

        driver.findElement(uploadFileBy).sendKeys(mountainFilePath);
        driver.findElement(uploadFileBy).sendKeys(riverFilePath);
        driver.findElement(uploadFileBy).sendKeys(treeFilePath);

        Assert.assertTrue(driver.findElement(By.xpath("//p[@class = 'name' and text()='"+ mountainFile + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class = 'name' and text()='"+ riverFile + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class = 'name' and text()='"+ treeFile + "']")).isDisplayed());

        List <WebElement> startUploadButtons = driver.findElements(By.cssSelector("table button.start"));
        for (WebElement startButton:startUploadButtons){
            startButton.click();
            Thread.sleep(1000);
        }

        Assert.assertTrue(driver.findElement(By.xpath("//p[@class = 'name']/a[text()='"+ mountainFile + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class = 'name']/a[text()='"+ riverFile + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class = 'name']/a[text()='"+ treeFile + "']")).isDisplayed());

    }

    @Test
    public void TC_02_Multiple_File() throws InterruptedException {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By uploadFileBy = By.cssSelector("input[type = 'file']");

        driver.findElement(uploadFileBy).sendKeys(mountainFilePath + "\n" + riverFilePath + "\n" + treeFilePath );

        Assert.assertTrue(driver.findElement(By.xpath("//p[@class = 'name' and text()='"+ mountainFile + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class = 'name' and text()='"+ riverFile + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class = 'name' and text()='"+ treeFile + "']")).isDisplayed());

        List <WebElement> startUploadButtons = driver.findElements(By.cssSelector("table button.start"));
        for (WebElement startButton:startUploadButtons){
            startButton.click();
            Thread.sleep(1000);
        }

        Assert.assertTrue(driver.findElement(By.xpath("//p[@class = 'name']/a[text()='"+ mountainFile + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class = 'name']/a[text()='"+ riverFile + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class = 'name']/a[text()='"+ treeFile + "']")).isDisplayed());

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
