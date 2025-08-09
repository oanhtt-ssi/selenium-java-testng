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

import java.time.Duration;
import java.util.List;

public class Topic_12_Default_Custom_Checkbox_Radio {
    WebDriver driver;
    JavascriptExecutor jsExecutor;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        jsExecutor = (JavascriptExecutor) driver;
    }
    @Test
    public void TC_01_Telerik_Checkbox_Radio(){
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");

        By dualZoneCheckbox = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");
        By leatherTrimCheckbox = By.xpath("//label[text()='Leather trim']/preceding-sibling::span/input");
        By towBarCheckbox = By.xpath("//label[text()='Towbar preparation']/preceding-sibling::span/input");
        By petrol2Radio = By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span/input");

        if (!driver.findElement(dualZoneCheckbox).isSelected()){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("div.demo-section")));
            driver.findElement(dualZoneCheckbox).click();
        }
        Assert.assertTrue(driver.findElement(dualZoneCheckbox).isSelected());

        Assert.assertFalse(driver.findElement(leatherTrimCheckbox).isEnabled());
        Assert.assertTrue(driver.findElement(leatherTrimCheckbox).isSelected());

        Assert.assertFalse(driver.findElement(towBarCheckbox).isEnabled());
        Assert.assertFalse(driver.findElement(towBarCheckbox).isSelected());

        if (driver.findElement(dualZoneCheckbox).isSelected()){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("div.demo-section")));
            driver.findElement(dualZoneCheckbox).click();
        }
        Assert.assertFalse(driver.findElement(dualZoneCheckbox).isSelected());

        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        if (!driver.findElement(petrol2Radio).isSelected()){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("div.demo-section")));
            driver.findElement(petrol2Radio).click();
        }
        Assert.assertTrue(driver.findElement(petrol2Radio).isSelected());
        if (driver.findElement(petrol2Radio).isSelected()){
            driver.findElement(petrol2Radio).click();
        }
        Assert.assertTrue(driver.findElement(petrol2Radio).isSelected());
    }

    @Test
    public void TC_02_Material_Checkbox_Radio(){
        driver.get("https://material.angular.io/components/radio/examples");

        By summerRadio = By.xpath("//label[text()='Summer']/preceding-sibling::div/input");
        By checkedCheckbox = By.xpath("//label[text()='Checked']/preceding-sibling::div/input");
        By indeterminateCheckbox = By.xpath("//label[text()='Indeterminate']/preceding-sibling::div/input");

        if (!driver.findElement(summerRadio).isSelected()){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("div.docs-example-viewer-body")));
            driver.findElement(summerRadio).click();
        }

        Assert.assertTrue(driver.findElement(summerRadio).isSelected());

        driver.get("https://material.angular.io/components/checkbox/examples");
        if (!driver.findElement(checkedCheckbox).isSelected()){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("div.docs-example-viewer-body")));
            driver.findElement(checkedCheckbox).click();
        }

        Assert.assertTrue(driver.findElement(checkedCheckbox).isSelected());

        if (!driver.findElement(indeterminateCheckbox).isSelected()){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("div.docs-example-viewer-body")));
            driver.findElement(indeterminateCheckbox).click();
        }

        Assert.assertTrue(driver.findElement(indeterminateCheckbox).isSelected());

        if (driver.findElement(checkedCheckbox).isSelected()){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("div.docs-example-viewer-body")));
            driver.findElement(checkedCheckbox).click();
        }

        Assert.assertFalse(driver.findElement(checkedCheckbox).isSelected());

        if (driver.findElement(indeterminateCheckbox).isSelected()){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("div.docs-example-viewer-body")));
            driver.findElement(indeterminateCheckbox).click();
        }

        Assert.assertFalse(driver.findElement(indeterminateCheckbox).isSelected());

    }

    @Test
    public void TC_03_Checkbox_All() {
        driver.get("https://automationfc.github.io/multiple-fields/");

        List<WebElement> everhadCheckboxes = driver.findElements(By.xpath(
                "//label[contains(text(),'Have you ever had')]/following-sibling::div//input[@type='checkbox']"));

        for (WebElement checkbox : everhadCheckboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
            Assert.assertTrue(checkbox.isSelected());
        }

        for (WebElement checkbox : everhadCheckboxes) {
            if (checkbox.isSelected()) {
                checkbox.click();
            }
            Assert.assertFalse(checkbox.isSelected());
        }
        for (WebElement checkbox : everhadCheckboxes) {
            if (!checkbox.isSelected() && checkbox.getDomAttribute("value").equals("Heart Attack")) {
                checkbox.click();
                break;
            }

            Assert.assertFalse(driver.findElement(By.xpath("//label[text()=' Heart Attack ']/preceding-sibling::input")).isSelected());
        }


    }

    @Test
    public void TC_04_Ubuntu_Custom_Checkbox_Radio() throws InterruptedException {
        driver.get("https://login.ubuntu.com/");
        By newUserRadio = By.cssSelector("input#id_new_user");
        By acceptToCheckbox = By.cssSelector("input#id_accept_tos");

        jsExecutor.executeScript("arguments[0].click();", driver.findElement(newUserRadio));
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(newUserRadio).isSelected());

        jsExecutor.executeScript("arguments[0].click();", driver.findElement(acceptToCheckbox));
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(acceptToCheckbox).isSelected());

    }

    @Test
    public void TC_05_Google_Custom_Checkbox_Radio() throws InterruptedException {
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");

        By canthoRadio = By.cssSelector("div[aria-label='Cần Thơ']");
        By hanoiRadio = By.cssSelector("div[aria-label='Hà Nội']");

        driver.findElement(canthoRadio).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(canthoRadio).getDomAttribute("aria-checked"),"true");

        driver.findElement(hanoiRadio).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(hanoiRadio).getDomAttribute("aria-checked"),"true");
    }

    @AfterClass
    public void afterClass(){
       // driver.quit();
    }
}
