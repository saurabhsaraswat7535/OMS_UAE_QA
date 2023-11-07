package Test_Component;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import page_Object.Login_Page;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base_Test {
    public WebDriver driver; // Global variable
    public Login_Page login;

    @BeforeClass
    public void initializeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream fin = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//resources//Global_data.properties");
        prop.load(fin);
        String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            // Initialize Firefox driver
        }
        driver.manage().window().maximize();

        // Initiate the login page
        login = new Login_Page(driver);
        login.Websiteurl();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
