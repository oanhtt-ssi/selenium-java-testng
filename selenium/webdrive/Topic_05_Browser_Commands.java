package webdrive;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_05_Browser_Commands {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

    }
    @Test
    public void TC_01(){
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        //Đóng trình duyệt - tất cả các tab đang có
        driver.quit();

        //Đóng tab đang active
        driver.close();

        //Tìm 1 element
        driver.findElement(By.cssSelector(""));

        //Tìm nhiều element
        driver.findElements(By.cssSelector(""));

        //URL của page hiện tại
        String pageURL = driver.getCurrentUrl();
        System.out.println(pageURL);

        //HTML source code của page hiện tại
        driver.getPageSource();

        //Trả về ID của tab đang active
        driver.getWindowHandle();

        // Trả về ID của tất cả các tab
        driver.getWindowHandles();

        //Mở rộng cửa sổ trình duyệt
        driver.manage().window().maximize();

        //Thu nhỏ cửa sổ về dưới taskBar
        driver.manage().window().minimize();

        //Full màn hình/full viền
        driver.manage().window().fullscreen();

        //Lấy ra kích thước của browser
        driver.manage().window().getSize();

        //Set vị trí của màn hình so với độ phân giải màn hình hiện tại
        driver.manage().window().setPosition(new Point(0,80));

        //Lấy ra tọa độ của browser
        driver.manage().window().getPosition();

        //Set cho tìm kiếm element
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
        driver.manage().timeouts().getImplicitWaitTimeout();

        //Áp dụng cho javaScript
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().getScriptTimeout();

        //Áp dụng cho page được load tối đa bao nhiêu
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().getPageLoadTimeout();

        //Lấy ra cookies theo tên/xóa cookies/xóa toàn bộ
        driver.manage().getCookieNamed("");
        driver.manage().getCookies();
        driver.manage().deleteCookieNamed("");
        driver.manage().deleteAllCookies();

        //Thao tác trình duyệt
        driver.navigate().to("https://live.techpanda.org/index.php/customer/account/login/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        //switch to
        driver.switchTo().alert();
        driver.switchTo().window("");
        driver.switchTo().frame("");


        //Title của page
        driver.getTitle();

    }

    @Test
    public void TC_02(){

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
