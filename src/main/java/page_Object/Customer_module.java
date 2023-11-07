package page_Object;

import Abstract_Component.Abstract_component;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Customer_module extends Abstract_component {
    WebDriver driver;

    public Customer_module(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //page object
    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement searchbox;

    public void verifyInputBox(String text) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        org.testng.Assert.assertTrue(searchbox.isDisplayed(), "Input box is not displayed");
        org.testng.Assert.assertTrue(searchbox.isEnabled(), "Input box is not enabled");
        searchbox.sendKeys(text);
        org.testng.Assert.assertEquals(searchbox.getAttribute("value"), text, "Input text is not as expected");
        searchbox.clear();
        org.testng.Assert.assertTrue(searchbox.getAttribute("value").isEmpty(), "Input box is not empty after clearing");

    }
}
