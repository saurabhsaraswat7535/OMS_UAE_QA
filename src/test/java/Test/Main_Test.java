package Test;

import Test_Component.Base_Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import page_Object.Business_module;
import page_Object.Login_Page;
import page_Object.Profile_module;

public class Main_Test extends Base_Test {
    String invoice_No="nfh6637";
    String suppliername="Mogli Labs (india) Private Limited";
    String remark="abc";
    @Test
    public void Verifyloginprocess() throws InterruptedException {
        Login_Page login_page = new Login_Page(driver);
        login_page.microsoftlogin("saurabh.saraswat@moglix.com","Nokia2690@");
        Profile_module profile_module=new Profile_module(driver);
        profile_module.Main_Menu();
        profile_module.Supplier_Damage_Module();
    }
    @Test
    public void Business_module() throws InterruptedException {
        Business_module business_module=new Business_module(driver);
        business_module.verifyInputBox("nfh6637");
        business_module.verifySupplierDropdown((suppliername));
        business_module.verifySearchButton();
        business_module.Download_button();
        business_module.verifyItemIdInputBox("3343284");
        business_module.filter_Result(invoice_No);
        business_module.verify_Invoice_View();
        business_module.verify_history_view();
        business_module.verify_request_button();
        business_module.Verify_approve_Button();
        business_module.Create_request(suppliername,"test123",remark);
    }
}
