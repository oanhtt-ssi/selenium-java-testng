package webdrive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_01_Locator {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
         driver = new FirefoxDriver();
         driver.get("https://live.techpanda.org/index.php/customer/account/login/");

    }

    @Test
    public void TC_01_ID(){
        driver.findElement(By.id("search"));
        driver.findElement(By.id("email"));
        driver.findElement(By.id("pass"));
        driver.findElement(By.id("send2"));
        driver.findElement(By.id("newsletter"));

    }
    @Test
    public void TC_02_Class(){
        driver.findElement(By.className("form-instructions"));
        driver.findElement(By.className("validate-email"));
        driver.findElement(By.className("validate-password"));
        driver.findElement(By.className("button"));
        driver.findElement(By.className("input-box"));
        driver.findElement(By.className("search-button"));
        driver.findElement(By.className("page-title"));

    }
    @Test
    public void TC_03_Name(){
        driver.findElement(By.name("q"));
        driver.findElement(By.name("login[username]"));
        driver.findElement(By.name("login[password]"));
        driver.findElement(By.name("email"));
        driver.findElement(By.name("send"));


    }
    @Test
    public void TC_04_Tagname(){
        int inputNumber = driver.findElements(By.tagName("input")).size();
        System.out.println("Số lượng thẻ input: "+inputNumber);
        int formNumber = driver.findElements(By.tagName("form")).size();
        System.out.println("Số lượng thẻ form: "+formNumber);
        int buttonNumber = driver.findElements(By.tagName("button")).size();
        System.out.println("Số lượng thẻ button: "+buttonNumber);
        int labelNumber = driver.findElements(By.tagName("label")).size();
        System.out.println("Số lượng thẻ label: "+labelNumber);
        int h1Number = driver.findElements(By.tagName("h1")).size();
        System.out.println("Số lượng thẻ h1: "+h1Number);
        int h2Number = driver.findElements(By.tagName("h2")).size();
        System.out.println("Số lượng thẻ h2: "+h2Number);
    }
    @Test
    public void TC_05_LinkText(){
        driver.findElement(By.linkText("Forgot Your Password?"));
        driver.findElement(By.linkText("ABOUT US"));
        driver.findElement(By.linkText("CONTACT US"));
        driver.findElement(By.linkText("CUSTOMER SERVICE"));
        driver.findElement(By.linkText("PRIVACY POLICY"));
        driver.findElement(By.linkText("SITE MAP"));
        driver.findElement(By.linkText("SEARCH TERMS"));
        driver.findElement(By.linkText("ADVANCED SEARCH"));
        driver.findElement(By.linkText("MY ACCOUNT"));
        driver.findElement(By.linkText("ORDERS AND RETURNS"));


    }
    @Test
    public void TC_06_Partial_LinkText(){
        driver.findElement(By.partialLinkText("?"));
        driver.findElement(By.partialLinkText("ABOUT"));
        driver.findElement(By.partialLinkText(" US"));
        driver.findElement(By.partialLinkText("CUSTOMER "));
        driver.findElement(By.partialLinkText("PRIVACY POLICY"));
        driver.findElement(By.partialLinkText(" MAP"));
        driver.findElement(By.partialLinkText(" TERMS"));
        driver.findElement(By.partialLinkText(" SEARCH"));
        driver.findElement(By.partialLinkText("MY ACCOUNT"));
        driver.findElement(By.partialLinkText("ORDERS AND RETURNS"));
    }
    @Test
    public void TC_07_CSS(){
        //CSS vs ID
        driver.findElement(By.cssSelector("input[id='search']"));
        driver.findElement(By.cssSelector("#search"));
        driver.findElement(By.cssSelector("input#search"));

        driver.findElement(By.cssSelector("input[id='email']"));
        driver.findElement(By.cssSelector("#email"));
        driver.findElement(By.cssSelector("input#email"));

        driver.findElement(By.cssSelector("input[id='pass']"));
        driver.findElement(By.cssSelector("#pass"));
        driver.findElement(By.cssSelector("input#pass"));

        driver.findElement(By.cssSelector("button[id='send2']"));
        driver.findElement(By.cssSelector("#send2"));
        driver.findElement(By.cssSelector("button#send2"));

        driver.findElement(By.cssSelector("input[id='newsletter']"));
        driver.findElement(By.cssSelector("#newsletter"));
        driver.findElement(By.cssSelector("input#newsletter"));

        //CSS với Class
        driver.findElement(By.cssSelector("p[class='form-instructions']"));
        driver.findElement(By.cssSelector("p.form-instructions"));
        driver.findElement(By.cssSelector(".form-instructions"));

        driver.findElement(By.cssSelector("div[class='col-1 new-users']"));
        driver.findElement(By.cssSelector("div.col-1"));
        driver.findElement(By.cssSelector("div.col-1.new-users"));
        driver.findElement(By.cssSelector(".col-1.new-users"));

        driver.findElement(By.cssSelector("input[class='input-text required-entry validate-email']"));
        driver.findElement(By.cssSelector("input.input-text.required-entry.validate-email"));
        //driver.findElement(By.cssSelector("input.input-text required-entry validate-email"));
        driver.findElement(By.cssSelector("input.validate-email"));

        //CSS vs Name
        driver.findElement(By.cssSelector("input[name='q']"));
        driver.findElement(By.cssSelector("input[name='login[username]']"));
        driver.findElement(By.cssSelector("input[name='login[password]']"));
        driver.findElement(By.cssSelector("input[name='email']"));
        driver.findElement(By.cssSelector("button[name='send']"));

        //CSS với link
        driver.findElement(By.cssSelector("a[href='http://live.techpanda.org/index.php/customer/account/forgotpassword/']"));
        driver.findElement(By.cssSelector("a[href='http://live.techpanda.org/index.php/about-magento-demo-store/']"));
        driver.findElement(By.cssSelector("a[href='http://live.techpanda.org/index.php/contacts/']"));
        driver.findElement(By.cssSelector("a[href='http://live.techpanda.org/index.php/customer-service/']"));
        driver.findElement(By.cssSelector("a[href='http://live.techpanda.org/index.php/privacy-policy-cookie-restriction-mode/']"));
        driver.findElement(By.cssSelector("a[href='http://live.techpanda.org/index.php/catalog/seo_sitemap/category/']"));
        driver.findElement(By.cssSelector("a[href='http://live.techpanda.org/index.php/catalogsearch/term/popular/']"));
        driver.findElement(By.cssSelector("a[href='http://live.techpanda.org/index.php/catalogsearch/advanced/']"));
        driver.findElement(By.cssSelector("a[href='http://live.techpanda.org/index.php/customer/account/']"));
        driver.findElement(By.cssSelector("a[href='http://live.techpanda.org/index.php/sales/guest/form/']"));

        //CSS vs partial link
        driver.findElement(By.cssSelector("a[href*='/account/forgotpassword/']"));
        driver.findElement(By.cssSelector("a[href*='about-magento-demo-store/']"));
        driver.findElement(By.cssSelector("a[href*='/index.php/contacts/']"));
        driver.findElement(By.cssSelector("a[href*='customer-service/']"));
        driver.findElement(By.cssSelector("a[href*='/privacy-policy-cookie-restriction-mode/']"));
        driver.findElement(By.cssSelector("a[href*='/catalog/seo_sitemap/category/']"));
        driver.findElement(By.cssSelector("a[href*='term/popular/']"));
        driver.findElement(By.cssSelector("a[href*='/catalogsearch/advanced/']"));
        driver.findElement(By.cssSelector("a[href*='/index.php/customer/account/']"));
        driver.findElement(By.cssSelector("a[href*='http://live.techpanda.org/index.php/sales/guest/form/']"));


    }
    @Test
    public void TC_08_Xpath(){
        //XPath vs ID
        driver.findElement(By.xpath("//input[@id='search']"));
        driver.findElement(By.xpath("//input[@id='email']"));
        driver.findElement(By.xpath("//input[@id='pass']"));
        driver.findElement(By.xpath("//button[@id='send2']"));
        driver.findElement(By.xpath("//input[@id='newsletter']"));

        //XPath vs Class
        driver.findElement(By.xpath("//p[@class='form-instructions']"));
        driver.findElement(By.xpath("//div[@class='col-1 new-users']"));
        driver.findElement(By.xpath("//input[@class='input-text required-entry validate-email']"));
        //driver.findElement(By.xpath("//input[@class='validate-email']"));

        //XPath với Name
        driver.findElement(By.xpath("//input[@name='q']"));
        driver.findElement(By.xpath("//input[@name='login[username]']"));
        driver.findElement(By.xpath("//input[@name='login[password]']"));
        driver.findElement(By.xpath("//input[@name='email']"));
        driver.findElement(By.xpath("//button[@name='send']"));

        //XPath với link
        driver.findElement(By.xpath("//a[@href='http://live.techpanda.org/index.php/customer/account/forgotpassword/']"));
        driver.findElement(By.xpath("//a[text()='Forgot Your Password?']"));

        driver.findElement(By.xpath("//a[@href='http://live.techpanda.org/index.php/about-magento-demo-store/']"));
        driver.findElement(By.xpath("//a[text()='About Us']"));

        driver.findElement(By.xpath("//a[@href='http://live.techpanda.org/index.php/contacts/']"));
        driver.findElement(By.xpath("//a[text()='Contact Us']"));

        driver.findElement(By.xpath("//a[@href='http://live.techpanda.org/index.php/customer-service/']"));
        driver.findElement(By.xpath("//a[text()='Customer Service']"));

        driver.findElement(By.xpath("//a[@href='http://live.techpanda.org/index.php/privacy-policy-cookie-restriction-mode/']"));
        driver.findElement(By.xpath("//a[text()='Privacy Policy']"));

        driver.findElement(By.xpath("//a[@href='http://live.techpanda.org/index.php/catalog/seo_sitemap/category/']"));
        driver.findElement(By.xpath("//a[text()='Site Map']"));

        driver.findElement(By.xpath("//a[@href='http://live.techpanda.org/index.php/catalogsearch/term/popular/']"));
        driver.findElement(By.xpath("//a[text()='Search Terms']"));

        driver.findElement(By.xpath("//a[@href='http://live.techpanda.org/index.php/catalogsearch/advanced/']"));
        driver.findElement(By.xpath("//a[text()='Advanced Search']"));

        driver.findElement(By.xpath("//a[@href='http://live.techpanda.org/index.php/customer/account/']"));
        driver.findElement(By.xpath("//a[text()='My Account']"));

        driver.findElement(By.xpath("//a[@href='http://live.techpanda.org/index.php/sales/guest/form/']"));
        driver.findElement(By.xpath("//a[text()='Orders and Returns']"));

        //XPath vs partial link
        driver.findElement(By.xpath("//a[contains(@href,'/account/forgotpassword/')]"));
        driver.findElement(By.xpath("//a[contains(text(),'Forgot Your Password?')]"));

        driver.findElement(By.xpath("//a[contains(@href,'about-magento-demo-store/')]"));
        driver.findElement(By.xpath("//a[contains(text(),'Us')]"));

        driver.findElement(By.xpath("//a[contains(@href,'/index.php/contacts/')]"));
        driver.findElement(By.xpath("//a[contains(text(),'Contact')]"));

        driver.findElement(By.xpath("//a[contains(@href,'customer-service/')]"));
        driver.findElement(By.xpath("//a[contains(text(),'Service')]"));

        driver.findElement(By.xpath("//a[contains(@href,'/privacy-policy-cookie-restriction-mode/')]"));
        driver.findElement(By.xpath("//a[contains(text(),'Privacy')]"));

        driver.findElement(By.xpath("//a[contains(@href,'/catalog/seo_sitemap/category/')]"));
        driver.findElement(By.xpath("//a[contains(text(),'Site Map')]"));

        driver.findElement(By.xpath("//a[contains(@href,'term/popular/')]"));
        driver.findElement(By.xpath("//a[contains(text(),'Search')]"));

        driver.findElement(By.xpath("//a[contains(@href,'/catalogsearch/advanced/')]"));
        driver.findElement(By.xpath("//a[contains(text(),'Advanced Search')]"));

        driver.findElement(By.xpath("//a[contains(@href,'/index.php/customer/account/')]"));
        driver.findElement(By.xpath("//a[contains(text(),'Account')]"));

        driver.findElement(By.xpath("//a[contains(@href,'http://live.techpanda.org/index.php/sales/guest/form/')]"));
        driver.findElement(By.xpath("//a[contains(text(),'and Returns')]"));

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
