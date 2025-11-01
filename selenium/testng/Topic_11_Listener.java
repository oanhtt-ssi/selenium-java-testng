package testng;
import listener.ScreenshotListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.*;



public class Topic_11_Listener {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
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
                .getCssValue("background-color")).asHex().toUpperCase(),"#E92127");



    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}

