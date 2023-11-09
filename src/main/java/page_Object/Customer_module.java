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
    public void verifyDropdown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(dropdown1));
        dropdown1.click();

        if (!matOptions.isEmpty()) {
            matOptions.get(0).click(); // Click on the first element
        } else {
            // Handle the case where there are no options in the dropdown
            System.out.println("No options found in the dropdown.");
        }
    }
    public void verifyApplyButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(Apply_button));
        org.testng.Assert.assertTrue(Apply_button.isDisplayed(), "Apply button is not displayed");
        org.testng.Assert.assertTrue(Apply_button.isEnabled(), "Apply button is not enabled");
        org.testng.Assert.assertEquals(Apply_button.getText(), "Apply", "Apply button text is not as expected");
    }
    public void verifyResetButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(Reset_Button));
        org.testng.Assert.assertTrue(Reset_Button.isDisplayed(), "Reset Filter button is not displayed");
        org.testng.Assert.assertTrue(Reset_Button.isEnabled(), "Reset Filter button is not enabled");
        org.testng.Assert.assertEquals(Reset_Button.getText(), "Reset Filter", "Reset Filter button text is not as expected");
    }


    }
