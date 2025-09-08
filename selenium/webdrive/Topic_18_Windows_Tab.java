package webdrive;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Topic_18_Windows_Tab {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Github(){
        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
        sleepInSecond(3);

        String githubWindowID = driver.getWindowHandle();

        switchToWindowByID(githubWindowID);

        driver.findElement(By.cssSelector("textarea[name='q']")).sendKeys("Manual testing");
        driver.findElement(By.cssSelector("textarea[name='q']")).sendKeys(Keys.ENTER);

        String googleWindowID = driver.getWindowHandle();

        switchToWindowByID(googleWindowID);

        driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
        sleepInSecond(2);

        switchToWindowByTitle("Facebook");

        Assert.assertEquals(driver.getTitle(),"Facebook – log in or sign up");

        driver.findElement(By.cssSelector("input#email")).sendKeys("oanhtt@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("oanhtt");

        switchToWindowByTitle("Selenium WebDriver");
        sleepInSecond(2);

        driver.findElement(By.xpath("//a[text()='TIKI']")).click();
        sleepInSecond(2);

        switchToWindowByTitle("Tiki");

        Assert.assertEquals(driver.getTitle(),"Tiki - Mua hàng online giá tốt, hàng chuẩn, ship nhanh");

        closeAllWindowWithoutParent(githubWindowID);
        sleepInSecond(3);

        Assert.assertEquals(driver.getTitle(),"Selenium WebDriver");
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationfc.github.io/basic-form/index.html");
    }

    @Test
    public void TC_02_TechPanda(){
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        sleepInSecond(3);

        driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2" +
                "/following-sibling::div[@class='actions']//a[text()='Add to Compare']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span"))
                .getText(),"The product Sony Xperia has been added to comparison list.");

        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']/parent::h2" +
                "/following-sibling::div[@class='actions']//a[text()='Add to Compare']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span"))
                .getText(),"The product Samsung Galaxy has been added to comparison list.");

        driver.findElement(By.cssSelector("button[title='Compare']")).click();
        sleepInSecond(2);

        switchToWindowByTitle("Products Comparison List");

        Assert.assertEquals(driver.getTitle(),"Products Comparison List - Magento Commerce");

        driver.findElement(By.xpath("//span[text()='Close Window']")).click();
        sleepInSecond(2);

        switchToWindowByTitle("Mobile");
        sleepInSecond(2);

        driver.findElement(By.xpath("//a[text()='Clear All']")).click();

        driver.switchTo().alert().accept();
        sleepInSecond(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"The comparison list was cleared.");

    }

    @Test
    public void TC_03_Cambridge(){
        driver.get("https://dictionary.cambridge.org/vi/");

        String homeWindowID = driver.getWindowHandle();

        driver.findElement(By.cssSelector("span[class *='cdo-login-button'] span.tb")).click();
        sleepInSecond(2);

        switchToWindowByTitle("Login");

        driver.findElement(By.cssSelector("input[value='Log in']")).click();
        sleepInSecond(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("span[id *='login-form-loginID']")).getText(),"This field is required");
        Assert.assertEquals(driver.findElement(By.cssSelector("span[id *='login-form-password']")).getText(),"This field is required");

        closeAllWindowWithoutParent(homeWindowID);

        String keyword = "automation";

        driver.findElement(By.cssSelector("input#searchword")).sendKeys(keyword);
        driver.findElement(By.cssSelector("input#searchword")).sendKeys(Keys.ENTER);
        sleepInSecond(2);

        Assert.assertEquals(driver.findElement(By.xpath("//span[contains(@class,'uk')]/preceding-sibling::div[@class='di-title']/span/span")).getText().toLowerCase(), keyword);

    }

    @Test
    public void TC_04_Harvard(){
        driver.get("https://courses.dce.harvard.edu/");

        String homePageWindowID = driver.getWindowHandle();

        driver.findElement(By.cssSelector("a[data-action='login']")).click();
        sleepInSecond(2);

        switchToWindowByID(homePageWindowID);

        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='DCE Login Portal']")).isDisplayed());

        switchToWindowByTitle("DCE Course Search");

        Assert.assertTrue(driver.findElement(By.cssSelector("div.activescreen")).isDisplayed());
        driver.findElement(By.cssSelector("button[class*= 'button--cancel']")).click();
        sleepInSecond(3);

        driver.findElement(By.cssSelector("input#crit-keyword")).sendKeys("Data Science: An Artificial Ecosystem");
        new Select(driver.findElement(By.cssSelector("select#crit-srcdb"))).selectByVisibleText("Harvard Summer School 2025");
        new Select(driver.findElement(By.cssSelector("select#crit-summer_school"))).selectByVisibleText("Secondary School Program");
        new Select(driver.findElement(By.cssSelector("select#crit-session"))).selectByVisibleText("Full Term");

        driver.findElement(By.cssSelector("button#search-button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("span.result__headline span.result__title")).getText(),"Data Science: An Artificial Ecosystem");


    }

    private void sleepInSecond(long timeInSecond)  {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void switchToWindowByID(String windowID){
        Set<String> allWindowIDs = driver.getWindowHandles();

        for (String id : allWindowIDs){
            if (!id.equals(windowID)){
                driver.switchTo().window(id);
                break;
            }
        }
    }

    private void switchToWindowByTitle(String expectedPageTitle){
        Set<String> allWindowIDs = driver.getWindowHandles();

        for (String id : allWindowIDs){
            driver.switchTo().window(id);
            sleepInSecond(1);
            if (driver.getTitle().contains(expectedPageTitle)){
                break;
            }
        }
    }

    private void closeAllWindowWithoutParent(String windowID){
        Set<String> allWindowIDs = driver.getWindowHandles();
        for (String id : allWindowIDs){
            if (!id.equals(windowID)){
                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(windowID);
    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
