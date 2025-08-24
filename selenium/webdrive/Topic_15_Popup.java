package webdrive;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.lang.model.element.Element;
import java.time.Duration;
import java.util.List;

public class Topic_15_Popup {
    WebDriver driver;
    JavascriptExecutor jsExecutor;
    int shortTimeout = 3;
    int longTimeout = 15;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
        driver.manage().window().maximize();
        jsExecutor = (JavascriptExecutor) driver;
    }
    @Test
    public void TC_01_In_HTML() throws InterruptedException {
        driver.get("http://www.kmplayer.com/");
        Thread.sleep(2000);

        By iconClose = By.cssSelector("div.close");

        if (driver.findElement(By.cssSelector("div[class='pop-container']")).isDisplayed()){
            //System.out.println("Hiển thị popup");
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(iconClose));
            driver.findElement(iconClose).click();
            Thread.sleep(2000);
        }

        Assert.assertFalse(driver.findElement(By.cssSelector("div[class='pop-container']")).isDisplayed());
       // System.out.println("Không hiển thị popup");

        driver.findElement(By.xpath("//a[text()='FAQ']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='KMPlayer FAQ']")).isDisplayed());


    }

    @Test
    public void TC_02_Not_In_HTML() throws InterruptedException {
        driver.get("https://tienganhcomaiphuong.vn/");

        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
        Thread.sleep(2000);

        By popup = By.cssSelector("div[class *= 'custom-dialog-paper']");
        Assert.assertTrue(driver.findElement(popup).isDisplayed());

        driver.findElement(By.cssSelector("input[placeholder= 'Tài khoản đăng nhập']")).sendKeys("oanhtt");
        driver.findElement(By.cssSelector("input[placeholder= 'Mật khẩu']")).sendKeys("123456");
        driver.findElement(By.xpath("//form//button[text() ='Đăng nhập']")).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#notistack-snackbar")).getText(),"Bạn đã nhập sai tài khoản hoặc mật khẩu!");

        driver.findElement(By.cssSelector("h2>button.close-btn")).click();
        Thread.sleep(2000);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertEquals(driver.findElements(popup).size(),0);

    }

    @Test
    public void TC_03_Tiki() throws InterruptedException {
        driver.get("https://tiki.vn/");
        Thread.sleep(5000);
        By bundlePopup = By.cssSelector("div#VIP_BUNDLE");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(shortTimeout));
        List <WebElement> bundlePopupElements = driver.findElements(bundlePopup);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));

        if (bundlePopupElements.size() > 0 && bundlePopupElements.get(0).isDisplayed()){
            driver.findElement(By.cssSelector("picture.webpimg-container >img[alt='close-icon']")).click();
            Thread.sleep(1500);
        }

        driver.findElement(By.cssSelector("div[data-view-id='header_header_account_container']")).click();

        By loginPopup = By.cssSelector("div[class *= 'ReactModal__Content']");

        Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("p.login-with-email")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='error-mess' and text()='Email không được để trống']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='error-mess' and text()='Mật khẩu không được để trống']")).isDisplayed());

        driver.findElement(By.cssSelector("button>img.close-img")).click();
        Thread.sleep(1000);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(shortTimeout));
        Assert.assertEquals(driver.findElements(bundlePopup).size(),0);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(shortTimeout));
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
