package page_Object;

import Abstract_Component.Abstract_component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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

    @FindBy(xpath = "//mat-select[@formcontrolname='selectedId']")
    WebElement dropdown1;

    @FindBy(xpath = "//mat-option[@role='option']")
    List<WebElement> matOptions;

    @FindBy(xpath = "//*[contains(text(),'Apply')]")
    WebElement Apply_button;

    @FindBy(xpath = "//*[contains(text(),'Reset Filter')]")
    WebElement Reset_Button;


    public void verifyInputBox(String text) throws InterruptedException {
        org.testng.Assert.assertTrue(searchbox.isDisplayed(), "Input box is not displayed");
        org.testng.Assert.assertTrue(searchbox.isEnabled(), "Input box is not enabled");
        searchbox.sendKeys(text);
        org.testng.Assert.assertEquals(searchbox.getAttribute("value"), text, "Input text is not as expected");
        searchbox.clear();
        org.testng.Assert.assertTrue(searchbox.getAttribute("value").isEmpty(), "Input box is not empty after clearing");
    }
    public void verifyDropdown(String optionToSelect) {

        // Click on the mat-select to open the dropdown
        dropdown1.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(matOptions));
        if (!matOptions.isEmpty()) {
            matOptions.get(0).click(); // Click on the first element
        } else {
            // Handle the case where there are no options in the dropdown
            System.out.println("No options found in the dropdown.");
        }
    }
    public void verify_Apply_Button(){
        org.testng.Assert.assertTrue(Apply_button.isDisplayed(), "Button is not displayed");
        org.testng.Assert.assertTrue(Apply_button.isEnabled(), "Button is not enabled");
        org.testng.Assert.assertEquals(Apply_button.getText(), "Apply", "Button text is not as expected");
    }
    public void verify_Reset_Filter(){
        org.testng.Assert.assertTrue(Reset_Button.isDisplayed(), "Button is not displayed");
        org.testng.Assert.assertTrue(Reset_Button.isEnabled(), "Button is not enabled");
        org.testng.Assert.assertEquals(Reset_Button.getText(), "Reset Filter", "Button text is not as expected");
    }


    }
