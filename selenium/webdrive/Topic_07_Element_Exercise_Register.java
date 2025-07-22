package webdrive;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_07_Element_Exercise_Register {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
    @Test
    public void TC_01_Register_Empty(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtFirstname-error")).getText(),"Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtEmail-error")).getText(),"Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtCEmail-error")).getText(),"Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtPassword-error")).getText(),"Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtCPassword-error")).getText(),"Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtPhone-error")).getText(),"Vui lòng nhập số điện thoại.");

    }

    @Test
    public void TC_02_Register_Invalid_Email() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("Trần Thị Oanh");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("123@123@123");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("123@123@123");
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("0987654321");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtEmail-error")).getText(),"Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtCEmail-error")).getText(),"Email nhập lại không đúng");


    }

    @Test
    public void TC_03_Register_Incorrect_Confirm_Email(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("Trần Thị Oanh");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("oanhtt@gmail.com");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("oanh@gmail.com");
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("0987654321");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtCEmail-error")).getText(),"Email nhập lại không đúng");

    }

    @Test
    public void TC_04_Register_Invalid_Password(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("Trần Thị Oanh");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("oanhtt@gmail.com");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("oanhtt@gmail.com");
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("1234");
        driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("1234");
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("0987654321");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtCPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");



    }

    @Test
    public void TC_05_Register_Incorrect_Confirm_Password(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("Trần Thị Oanh");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("oanhtt@gmail.com");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("oanhtt@gmail.com");
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("1234567");
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("0987654321");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtCPassword-error")).getText(),"Mật khẩu bạn nhập không khớp");


    }

    @Test
    public void TC_06_Register_Invalid_PhoneNumber(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("Trần Thị Oanh");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("oanhtt@gmail.com");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("oanhtt@gmail.com");
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("098765432122");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");

        driver.findElement(By.cssSelector("input#txtPhone")).clear();
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("0287654321");
        Assert.assertEquals(driver.findElement(By.cssSelector("label#txtPhone-error")).getText(),"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");


    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
