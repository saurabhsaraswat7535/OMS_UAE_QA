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
import java.util.Queue;
import java.util.Set;

public class Login_Page extends Abstract_component {
    WebDriver driver;

    public  Login_Page(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    //page object
    @FindBy (xpath = "//input[@type='email']")
    WebElement userEmail;

    @FindBy (xpath = "//input[@type='submit']")
            WebElement Submit_btn;
    @FindBy (xpath = "//input[@type='password']")
            WebElement Password;
    @FindBy (css = ".micorsoftLogin")
            WebElement micro_button;
    @FindBy (id = "idSIButton9")
            WebElement submit_button;

    @FindBy (id = "KmsiCheckboxField")
           WebElement checkbox;
    @FindBy (id = "idSIButton9")
           WebElement SubmitButton;
   @FindBy (className = "form-control")
           WebElement Country;
   //country submit button

    @FindBy(xpath = "//*[contains(text(),'Submit')]")
           WebElement country_submit_btn;


    By Email= By.cssSelector("//input[@type='email']");
    By Pass=By.xpath("//input[@type='password']");


    public void microsoftlogin(String email,String password) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            micro_button.click();
        Set<String> windows = driver.getWindowHandles(); // parent and child id.
        java.util.Iterator<String> it = windows.iterator();
        String parentid = it.next();
        String child = it.next();
        driver.switchTo().window(child);
        WebElement Email = wait.until(ExpectedConditions.elementToBeClickable(userEmail));
        Email.sendKeys(email);
        Submit_btn.click();
        WebElement pass = wait.until(ExpectedConditions.elementToBeClickable(Password));
        Password.sendKeys(password);
        submit_button.click();
        // Wait for the checkbox to be clickable
        WebElement Checkbox = wait.until(ExpectedConditions.elementToBeClickable(checkbox));
        Checkbox.click();
        SubmitButton.click();
        driver.switchTo().window(parentid);
        // Wait for the checkbox to be clickable
        WebElement countryname = wait.until(ExpectedConditions.elementToBeClickable(Country));
        countryname.click();
        Select dropdown=new Select(countryname);
        dropdown.selectByIndex(0);
        countryname.click();
        WebElement country_button = wait.until(ExpectedConditions.elementToBeClickable(country_submit_btn));
        country_button.click();
        }

    public void Websiteurl() {
        driver.get("https://omsbe-qa.moglilabs.com/login");
    }


}
