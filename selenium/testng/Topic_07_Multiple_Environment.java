package testng;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.*;

public class Topic_07_Multiple_Environment {
    WebDriver driver;
    String serverUrl;

    @Parameters({"serverName","browserName"})
    @BeforeClass
    public void beforeClass(@Optional("Live") String serverName, String browserName){
        switch (serverName){
            case "Dev":
                serverUrl = "https://www.dev.fahasa.com" ;
                break;
            case  "Test":
                serverUrl = "https://www.test.fahasa.com" ;
                break;
            case "Live":
                serverUrl = "https://www.fahasa.com" ;
                break;
            default:
                throw new RuntimeException("Server name is not valid!!");
        }
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

