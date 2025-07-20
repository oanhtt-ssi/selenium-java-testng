package webdrive;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Element_Commands {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");
    }
    @Test
    public void TC_01(){
        //Click vào element
        driver.findElement(By.cssSelector("")).click();

        //Nhập liệu vào element cho phép edit
        driver.findElement(By.cssSelector("")).clear();
        driver.findElement(By.cssSelector("")).sendKeys();

        driver.findElement(By.cssSelector(".input-box"))
                .findElement(By.cssSelector("input#searh"));
        driver.findElement(By.cssSelector(".input-box>input#search"));

        //Kiểm tra 1 element là enable hay disable
        Assert.assertTrue(driver.findElement(By.cssSelector("")).isEnabled());
        Assert.assertFalse(driver.findElement(By.cssSelector("")).isEnabled());

        //Kiểm tra element hiển thị hay không hiển thị
        Assert.assertTrue(driver.findElement(By.cssSelector("")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("")).isDisplayed());

        //Kiểm tra 1 element được chọn hay chưa
        Assert.assertTrue(driver.findElement(By.cssSelector("")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("")).isDisplayed());

        //Lấy dữ liệu dạng text của element
        driver.findElement(By.cssSelector("")).getText();
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getText(), "This is a required field.");

        //Lấy ra giá trị của thuộc tính HTML
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getAttribute("placeholder"), "Search entire store here...");

        Assert.assertEquals(driver.findElement(By.cssSelector("")).getDomAttribute("placeholder"), "Search entire store here...");

        //Lấy ra giá trị của thuộc tính trong DOM (Document Object Model)
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getDomProperty("placeholder"), "Search entire store here...");
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getDomProperty("tagName"), "INPUT");

        //Lấy ra giá trị của CSS
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getCssValue("background"), "#2e8ab8");
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getCssValue("font-size"), "13px");

        // Lấy ra chiều cao x chiều rộng của element
        Dimension loginButtonSize = driver.findElement(By.cssSelector("")).getSize();
        loginButtonSize.getHeight();
        loginButtonSize.getWidth();

        // Lấy ra vị trí của element so với màn hình
        Point loginButtonLocation = driver.findElement(By.cssSelector("")).getLocation();
        loginButtonLocation.getX();
        loginButtonLocation.getY();

        //Lấy ra bao gồm cả size và location
        Rectangle loginButtonRect = driver.findElement(By.cssSelector("")).getRect();
        loginButtonRect.getHeight();
        loginButtonRect.getWidth();
        loginButtonRect.getX();
        loginButtonRect.getY();

        loginButtonSize = loginButtonRect.getDimension();
        loginButtonLocation = loginButtonRect.getPoint();

        //Lấy ra thẻ HTML của element ấy
        driver.findElement(By.cssSelector("")).getTagName();

        //Shadow DOM
        driver.findElement(By.cssSelector("")).getShadowRoot();

        //Chỉ áp dụng cho element nằm trong form
        driver.findElement(By.cssSelector("")).submit();

        driver.findElement(By.cssSelector("")).getAccessibleName();
        driver.findElement(By.cssSelector("")).getAriaRole();


    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
