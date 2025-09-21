package webdrive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;
import java.util.List;

public class Topic_22_Wait_PII_FindElement {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void TC_01_Find_Element(){
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2Fregister");

        //1 - Nếu như tìm element có duy nhất 1 cái
        // Không cần chờ hết tổng thời gian 10s
        // chuyển action tiếp theo luôn
        System.out.println("Start Time: " + getDateTimeNow());
        driver.findElement(By.cssSelector("input#small-searchterms"));
        System.out.println("End Time: " + getDateTimeNow());

        //2 - Nếu như tìm element có nhiêu hơn 1 cái
        // Không cần chờ hết tổng thời gian 10s
        // Luôn lấy element đầu tiên đề thao tác
        System.out.println("Start Time: " + getDateTimeNow());
        driver.findElement(By.cssSelector("input[type = 'email']")).sendKeys("oanhtt@gmail.com");
        System.out.println("End Time: " + getDateTimeNow());

        //3 - Nếu như không tìm thấy element nào
        // Sẽ cố gắng tìm đi tìm lại cứ mỗi nửa giây 1 lần
        // Nếu giữa chừng tìm thấy thì không cần chờ hết thời gian còn lại
        // Nếu hết thời gian mà không tìm thấy thì show ra exception: NoSuchElement và đánh fail testcase tại vị trí code đó
        // Không chạy tiếp step tiếp theo/còn lại nữa
        System.out.println("Start Time: " + getDateTimeNow());
        driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Automation Testing");
        System.out.println("End Time: " + getDateTimeNow());

    }

    @Test
    public void TC_02_Find_Elements(){
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2Fregister");
        List<WebElement> elementList = null;

        //1 - Nếu như tìm element có duy nhất 1 cái
        System.out.println("Start Time: " + getDateTimeNow());
        elementList = driver.findElements(By.cssSelector("input#small-searchterms"));
        System.out.println("Tổng số lượng element trong List: " + elementList.size());
        System.out.println("End Time: " + getDateTimeNow());

        //2 - Nếu như tìm element có nhiêu hơn 1 cái
        System.out.println("Start Time: " + getDateTimeNow());
        elementList = driver.findElements(By.xpath("//a[@href]"));
        System.out.println("End Time: " + getDateTimeNow());
        System.out.println("Tổng số lượng element trong List: " + elementList.size());

        for (WebElement element:elementList){
            System.out.println(element.getDomProperty("href"));
        }

        //3 - Nếu như không tìm thấy element nào
        System.out.println("Start Time: " + getDateTimeNow());
        elementList = driver.findElements(By.cssSelector("input#FirstName"));
        System.out.println("Tổng số lượng element trong List: " + elementList.size());
        System.out.println("End Time: " + getDateTimeNow());
        //Chờ hết timeout
        //Hết timeout không tìm thấy thì không đánh fail testcase
        //Trả về 1 List rỗng = 0

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    private String getDateTimeNow(){
        return new Date().toString();
    }
}
