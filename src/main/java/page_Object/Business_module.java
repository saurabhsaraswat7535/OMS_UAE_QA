package page_Object;

import Abstract_Component.Abstract_component;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
    @FindBy(xpath = "//span[contains(@class, 'mat-checkbox-inner-container')]/input[@type='checkbox']")
    WebElement Checkbox;

    //invoice_view button
    @FindBy(xpath = "//span[contains(@class, 'redColor') and .//a[contains(@href, 'supplierDamageInvoice')]]")
    WebElement invoice_view_btn;

    //history view button
    @FindBy(xpath = "//i[contains(@class, 'ri-time-line')]")
    WebElement history_view_btn;

    //request id button
    @FindBy(xpath = "//td[@class='mat-cell cdk-cell cdk-column-name mat-column-name ng-star-inserted']/button[@class='redColor']")
    WebElement request_btn;

    //Approve button
    @FindBy(xpath = "//button[contains(text(), 'Approve Request')]")
    WebElement Approve_btn;

    //add request button
    @FindBy(xpath = "//a[contains(text(), 'Add Request')]")
    WebElement create_Request_Btn;

    //add request supplier x path
    @FindBy(xpath = "//input[@formcontrolname='supplierName']")
    WebElement search_Supplier;

    //invoice no add request
    @FindBy(xpath = "//input[@formcontrolname='invoiceNum']")
    WebElement Invoice_no;

    //add request calender
    @FindBy(xpath = "(//button[contains(@aria-label, 'Open calendar')])[3]")
    WebElement Calender;

    //add request current date
    @FindBy(xpath = "//div[@class='mat-calendar-body-cell-content mat-focus-indicator mat-calendar-body-today']")
    WebElement current_Date;

    //add request remark
    @FindBy(xpath = "//textarea[@id='textarea' and @formcontrolname='Remarks']")
    WebElement remark;

    //upload invoice
    @FindBy(id = "select-file")
    WebElement Upload_Invoice;

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

    public void verifySupplierDropdown(String Supplier_name) {
        searchableDropdownInput.sendKeys(Supplier_name);
        searchableDropdownInput.sendKeys(Keys.ENTER);
        String selectedOption = searchableDropdownInput.getAttribute("value");
        org.testng.Assert.assertEquals(selectedOption, Supplier_name, "Dropdown selection is not as expected");
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

    public void filter_Result(String searchfilter){
        WebElement filtered_data=driver.findElement(By.xpath("//td[contains(@class, 'mat-cell') and contains(@class, 'cdk-cell') and contains(@class, 'cdk-column-qty')]"));
        Assert.assertEquals(filtered_data.getText(),searchfilter, "Filtered data does not match expected criteria");
    }

    public void Download_button(){
        Download_btn.click();

    }
    public void verify_Invoice_View(){
        Assert.assertTrue(invoice_view_btn.isDisplayed(), "button not visible");
        Assert.assertTrue(invoice_view_btn.isEnabled(), "Checkbox is not enabled.");
    }
    public void verify_history_view(){
        Assert.assertTrue(history_view_btn.isDisplayed(), "button not visible");
        Assert.assertTrue(history_view_btn.isEnabled(), "Checkbox is not enabled.");
    }
    public void verify_request_button(){
        Assert.assertTrue(request_btn.isDisplayed(), "button not visible");
        Assert.assertTrue(request_btn.isEnabled(), "Checkbox is not enabled.");
    }
    public void Verify_approve_Button() throws InterruptedException {
        // Check the state of the checkbox
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", Checkbox);
        Thread.sleep(2000);
        if (Checkbox.isSelected()) {
            System.out.println("Checkbox is selected. Button is enabled.");
            Assert.assertTrue(Approve_btn.isEnabled(), "Button should be enabled.");
        } else {
            System.out.println("Checkbox is not selected. Button is disabled.");
            Assert.assertFalse(Approve_btn.isEnabled(), "Button should be disabled.");
        }
    }
    public void Create_request(String Supplier_name,String Invoice_No,String Remark){
        create_Request_Btn.click();
        search_Supplier.sendKeys(Supplier_name);
        search_Supplier.sendKeys(Keys.ENTER);
        String selectedOption = search_Supplier.getAttribute("value");
        org.testng.Assert.assertEquals(selectedOption, Supplier_name, "Dropdown selection is not as expected");
        // invoice no
        org.testng.Assert.assertTrue(Invoice_no.isDisplayed(), "Input box is not displayed");
        org.testng.Assert.assertTrue(Invoice_no.isEnabled(), "Input box is not enabled");
        Invoice_no.sendKeys(Invoice_No);
        org.testng.Assert.assertEquals(Invoice_no.getAttribute("value"), Invoice_No, "Input text is not as expected");
        Calender.click();
        current_Date.click();
        remark.sendKeys(Remark);
       // Upload_Invoice.click();
        Upload_Invoice.sendKeys("/home/moglix/Desktop/image.jpg");
    }

    }
