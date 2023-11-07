package page_Object;

import Abstract_Component.Abstract_component;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Profile_module extends Abstract_component {
    WebDriver  driver;
    public Profile_module(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy ( xpath = "//img[@src=\"../assets/images/menu-2-line.svg\"]")
    WebElement Main_menu_button;

    @FindBy (xpath = "//*[contains(text(),'Supplier Damage')]")
    WebElement Supplier_Damage;

    @FindBy (xpath = "//*[contains(text(),' Customer order ')]")
    WebElement Customer_order;

    @FindBy (xpath = "//span[contains(text(),'Business')]")
    WebElement Business_tab;


    public void Main_Menu(){
                Main_menu_button.click();
    }
    public void clickElementWithJS(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    // Then, in your method

    public void Customer_order_module(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement supplier_damage = wait.until(ExpectedConditions.elementToBeClickable(Customer_order));
        Customer_order.click();
    }


    //this medthod for supplier_damage
    public void Supplier_Damage_Module() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement supplier_damage = wait.until(ExpectedConditions.elementToBeClickable(Supplier_Damage));
        supplier_damage.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", driver.findElement(By.xpath("//div[@class='cdk-overlay-backdrop secondLevel cdk-overlay-backdrop-showing']")));
        WebElement business_tab = wait.until(ExpectedConditions.elementToBeClickable(Business_tab));
        business_tab.click();
        Thread.sleep(1000);
    }

    }


