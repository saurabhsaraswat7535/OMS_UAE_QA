package page_Object;

import Abstract_Component.Abstract_component;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class Business_module extends Abstract_component {
    WebDriver driver;
    public Business_module(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }
    @FindBy (xpath = "//input[@name='invoiceNum']")
    WebElement inputBox;

    @FindBy(xpath = "//input[@id='mat-input-1' and @aria-label='Number' and @name='supplier']")
    WebElement searchableDropdownInput;

    @FindBy(xpath = "//button[@class='searchBtn']")
    WebElement searchButton;
    @FindBy(xpath = "//i[contains(@class, 'ri-download-2-line')]")
    WebElement Download_btn;

    @FindBy(xpath = "//input[@name='itemId']")
    WebElement Item_id_input;
    //from date
    @FindBy(xpath = "//mat-datepicker-toggle[@class='mat-datepicker-toggle ng-tns-c84-3']")
     WebElement from_date;

    //Checkbox
    @FindBy(xpath = "//span[contains(@class, 'mat-checkbox-inner-container')]/input")
    WebElement Checkbox;



    public void verifyInputBox(String text) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement Input_Box = wait.until(ExpectedConditions.elementToBeClickable(inputBox));
        org.testng.Assert.assertTrue(Input_Box.isDisplayed(), "Input box is not displayed");
        org.testng.Assert.assertTrue(Input_Box.isEnabled(), "Input box is not enabled");
        Input_Box.sendKeys(text);
        org.testng.Assert.assertEquals(Input_Box.getAttribute("value"), text, "Input text is not as expected");
        Input_Box.clear();
        org.testng.Assert.assertTrue(Input_Box.getAttribute("value").isEmpty(), "Input box is not empty after clearing");
    }

    public void verifySupplierDropdown(String optionText) {
        searchableDropdownInput.sendKeys(optionText);
        searchableDropdownInput.sendKeys(Keys.ENTER);
        String selectedOption = searchableDropdownInput.getAttribute("value");
        org.testng.Assert.assertEquals(selectedOption, optionText, "Dropdown selection is not as expected");
    }

    public void verifyItemIdInputBox(String Item_id){
        org.testng.Assert.assertTrue(Item_id_input.isDisplayed(), "Input box is not displayed");
        org.testng.Assert.assertTrue(Item_id_input.isEnabled(), "Input box is not enabled");
        Item_id_input.sendKeys(Item_id);
        org.testng.Assert.assertEquals(Item_id_input.getAttribute("value"), Item_id, "Input text is not as expected");
        Item_id_input.clear();
        org.testng.Assert.assertTrue(Item_id_input.getAttribute("value").isEmpty(), "Input box is not empty after clearing");
    }

    public void verifySearchButton() throws InterruptedException {
        org.testng.Assert.assertTrue(searchButton.isDisplayed(), "Button is not displayed");
        org.testng.Assert.assertTrue(searchButton.isEnabled(), "Button is not enabled");
        org.testng.Assert.assertEquals(searchButton.getText(), "SEARCH", "Button text is not as expected");
        searchButton.click();
        Thread.sleep(2000);
        try {
            // Switch to the alert and accept it
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (org.openqa.selenium.NoAlertPresentException e) {
            // Handle the case where there's no alert
            System.out.println("No alert found.");
        }

    }
    public void verifyCalender(){
        from_date.click();
    }
    public void verifyCheckbox() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait for the checkbox to be clickable
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(Checkbox));
        org.testng.Assert.assertTrue(checkbox.isDisplayed(), "Checkbox is not displayed.");
        org.testng.Assert.assertTrue(checkbox.isEnabled(), "Checkbox is not enabled.");
        checkbox.click(); // Check the checkbox
        org.testng.Assert.assertTrue(checkbox.isSelected(), "Checkbox is not selected.");
        checkbox.click(); // Check the checkbox
        checkbox.click(); // Uncheck the checkbox
        org.testng.Assert.assertFalse(checkbox.isSelected(), "Checkbox is still selected.");
    }

    public void filter_Result(){
        WebElement invoice_no=driver.findElement(By.xpath("//td[contains(@class, 'mat-cell') and contains(@class, 'cdk-cell') and contains(@class, 'cdk-column-qty') and contains(@class, 'ng-star-inserted')]"));
    }
    public void Download_button(){
        Download_btn.click();

    }

    }
