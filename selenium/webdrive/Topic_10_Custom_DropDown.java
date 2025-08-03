package webdrive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_10_Custom_DropDown {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }
    @Test
    public void TC_01_OrangeHRM_Normal() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Assert.assertTrue(isLoadingIconDisappear());

        Assert.assertTrue(driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed());

        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        Assert.assertTrue(isLoadingIconDisappear());
        Assert.assertTrue(driver.findElement(By.xpath("//h6[text()='PIM']")).isDisplayed());

        //Dropdown Employment Status
        //Click Element để dropdown sổ ra (Parent locator)
        driver.findElement(By.xpath("//label[text()='Employment Status']/parent::div/following-sibling::div/div")).click();

        //Chờ cho các item trong dropdown đó được load ra hết
        List <WebElement> allItems_employmentStatus = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
                "//label[text()='Employment Status']/parent::div/following-sibling::div//div[@class='oxd-select-option']/span")));

        //Nếu tìm thấy thì click vào item đó
        for (WebElement temp:allItems_employmentStatus){
            if (temp.getText().equals("Full-Time Contract")){
                temp.click();
                Thread.sleep(2000);
                break;
            }
        }

        //Dropdown Include
        //Click Element để dropdown sổ ra (Parent locator)
        driver.findElement(By.xpath("//label[text()='Include']/parent::div/following-sibling::div/div")).click();

        //Chờ cho các item trong dropdown đó được load ra hết
        List <WebElement> allItems_Include = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
                "//label[text()='Include']/parent::div/following-sibling::div//div[@class='oxd-select-option']/span")));

        //Nếu tìm thấy thì click vào item đó
        for (WebElement temp:allItems_Include){
            if (temp.getText().equals("Current and Past Employees")){
                temp.click();
                Thread.sleep(2000);
                break;
            }
        }

        //Dropdown Job Title
        //Click Element để dropdown sổ ra (Parent locator)
        driver.findElement(By.xpath("//label[text()='Job Title']/parent::div/following-sibling::div/div")).click();

        //Chờ cho các item trong dropdown đó được load ra hết
        List <WebElement> allItems_jobTitle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
                "//label[text()='Job Title']/parent::div/following-sibling::div//div[@class='oxd-select-option']/span")));

        //Nếu tìm thấy thì click vào item đó
        for (WebElement temp:allItems_jobTitle){
            if (temp.getText().equals("Chief Financial Officer")){
                temp.click();
                Thread.sleep(2000);
                break;
            }
        }

        //Dropdown Sub Unit
        //Click Element để dropdown sổ ra (Parent locator)
        driver.findElement(By.xpath("//label[text()='Sub Unit']/parent::div/following-sibling::div/div[@class='oxd-select-wrapper']")).click();

        //Chờ cho các item trong dropdown đó được load ra hết
        List <WebElement> allItems_subUnit = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
                "//label[text()='Sub Unit']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-option')]/span")));
        //Nếu tìm thấy thì click vào item đó
        for (WebElement temp:allItems_subUnit){
            if (temp.getText().equals("Administration")){
                temp.click();
                Thread.sleep(2000);
                break;
            }
        }
    }

    @Test
    public void TC_02_OrangeHRM() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Assert.assertTrue(isLoadingIconDisappear());

        Assert.assertTrue(driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed());

        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        Assert.assertTrue(isLoadingIconDisappear());
        Assert.assertTrue(driver.findElement(By.xpath("//h6[text()='PIM']")).isDisplayed());

        selectItemInOrangeHRMDropDown("Employment Status", "Employment Status", "Full-Time Contract");

        selectItemInOrangeHRMDropDown("Include", "Include", "Current and Past Employees");

        selectItemInOrangeHRMDropDown("Job Title", "Job Title", "Chief Financial Officer");

        selectItemInOrangeHRMDropDown("Sub Unit", "Sub Unit", "Administration");

        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employment Status']/parent::div/following-sibling::div/div[@class='oxd-select-wrapper']"))
                .getText(),"Full-Time Contract");

        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Include']/parent::div/following-sibling::div/div[@class='oxd-select-wrapper']"))
                .getText(),"Current and Past Employees");

        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Job Title']/parent::div/following-sibling::div/div[@class='oxd-select-wrapper']"))
                .getText(),"Chief Financial Officer");

        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Sub Unit']/parent::div/following-sibling::div/div[@class='oxd-select-wrapper']"))
                .getText(),"Administration");


    }

    @Test
    public void TC_03_JQuery() throws InterruptedException{
        driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
        selectItemInSelectableDropDown("//span[@id='speed-button']","//ul[@id='speed-menu']/li/div","Fast");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='speed-button']")).getText(),"Fast");
        selectItemInSelectableDropDown("//span[@id='files-button']","//ul[@id='files-menu']/li/div","Some other file with a very long option text");
        selectItemInSelectableDropDown("//span[@id='number-button']","//ul[@id='number-menu']/li/div","10");
        selectItemInSelectableDropDown("//span[@id='salutation-button']","//ul[@id='salutation-menu']/li/div","Other");
        selectItemInSelectableDropDown("//span[@id='speed-button']","//ul[@id='speed-menu']/li/div","Slower");

        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='speed-button']")).getText(),"Slower");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='files-button']")).getText(),"Some other file with a very long option text");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='number-button']")).getText(),"10");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='salutation-button']")).getText(),"Other");

    }

    @Test
    public void TC_04_ReactJS() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
        selectItemInSelectableDropDown("//div[@id='root']","//div[@class='item']/span","Elliot Fu");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='root']//div[@class='divider text']"))
                .getText(),"Elliot Fu");

        selectItemInSelectableDropDown("//div[@id='root']","//div[@class='item']/span","Justen Kitsune");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='root']//div[@class='divider text']"))
                .getText(),"Justen Kitsune");
    }

    @Test
    public void TC_05_VueJS() throws InterruptedException {
        driver.get("https://mikerodham.github.io/vue-dropdowns/");
        selectItemInSelectableDropDown("//li[@class='dropdown-toggle']","//ul[@class='dropdown-menu']//a","Second Option");
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='dropdown-toggle']")).getText(),"Second Option");

        selectItemInSelectableDropDown("//li[@class='dropdown-toggle']","//ul[@class='dropdown-menu']//a","First Option");
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='dropdown-toggle']")).getText(),"First Option");

        selectItemInSelectableDropDown("//li[@class='dropdown-toggle']","//ul[@class='dropdown-menu']//a","Third Option");
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='dropdown-toggle']")).getText(),"Third Option");
    }

    @Test
    public void TC_06_Editable_ReactJS() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
        selectItemInEditableDropDown("//input[@class='search']","//div[@class='visible menu transition']//span","Bahamas");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(),"Bahamas");

        selectItemInEditableDropDown("//input[@class='search']","//div[@class='visible menu transition']//span","Benin");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(),"Benin");
    }

    @Test
    public void TC_06_Editable_Finpeace() throws InterruptedException {
        driver.get("https://sps.finpeace.vn/tools/sktccn");
        selectItemInEditableDropDown("//input[@id='job_id']",
                "//div[@id='job_id_list']/following-sibling::div[@class='rc-virtual-list']//div[@class='ant-select-item-option-content']",
                "Ngân hàng");
        Assert.assertEquals(driver.findElement(By.xpath("//label[@title='Nghề nghiệp']/parent::div/following-sibling::div//span[@class='ant-select-selection-item']"))
                .getText(),"Ngân hàng");

        selectItemInEditableDropDown("//input[@id='gender']",
                "//div[@id='gender_list']/following-sibling::div[@class='rc-virtual-list']//div[@class='ant-select-item-option-content']",
                "Nam");
        Assert.assertEquals(driver.findElement(By.xpath("//label[@title='Giới tính']/parent::div/following-sibling::div//span[@class='ant-select-selection-item']"))
                .getText(),"Nam");

        selectItemInEditableDropDown("//input[@id='married_status']",
                "//div[@id='married_status_list']/following-sibling::div[@class='rc-virtual-list']//div[@class='ant-select-item-option-content']",
                "Kết hôn, đã có con");
        Assert.assertEquals(driver.findElement(By.xpath("//label[@title='Tình trạng hôn nhân']/parent::div/following-sibling::div//span[@class='ant-select-selection-item']"))
                .getText(),"Kết hôn, đã có con");

        selectItemInEditableDropDown("//input[@id='job_id']",
                "//div[@id='job_id_list']/following-sibling::div[@class='rc-virtual-list']//div[@class='ant-select-item-option-content']",
                "Công nghệ thông tin");

        Assert.assertEquals(driver.findElement(By.xpath("//label[@title='Nghề nghiệp']/parent::div/following-sibling::div//span[@class='ant-select-selection-item']"))
                .getText(),"Công nghệ thông tin");

    }

    private void selectItemInEditableDropDown(String editableXpath, String childXpath, String expectedTextItem) throws InterruptedException {

        driver.findElement(By.xpath(editableXpath)).sendKeys(expectedTextItem);
        Thread.sleep(2000);
        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childXpath)));
        for (WebElement temp : allItems) {
            if (temp.getText().equals(expectedTextItem)) {
                temp.click();
                Thread.sleep(2000);
                break;
            }
        }
    }

    private void selectItemInSelectableDropDown(String parentXpath, String childXpath, String expectedTextItem) throws InterruptedException {

        driver.findElement(By.xpath(parentXpath)).click();
        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childXpath)));
        for (WebElement temp : allItems) {
            if (temp.getText().equals(expectedTextItem)) {
                temp.click();
                Thread.sleep(2000);
                break;
            }
        }
    }

    private void selectItemInOrangeHRMDropDown(String parentLocator, String childLocator, String expectedTextItem) throws InterruptedException {

        driver.findElement(By.xpath("//label[text()='"+parentLocator+"']/parent::div/following-sibling::div/div")).click();

       List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
                "//label[text()='"+childLocator+"']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-option')]/span")));

        for (WebElement temp : allItems) {
            if (temp.getText().equals(expectedTextItem)) {
                temp.click();
                Thread.sleep(2000);
                break;
            }
        }
    }

    private Boolean isLoadingIconDisappear() {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .invisibilityOfAllElements(driver.findElement(By.cssSelector("div.oxd-loading-spinner"))));
    }
    
    

    @AfterClass
    public void afterClass(){
      //  driver.quit();
    }
}
