package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC01_AccountRegistrationTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void verify_account_register(){
        //in the home page there is a driver object,
        // so we can pass that driver object to the HomePage class constructor

            HomePage hp = new HomePage(driver);
            hp.myAccount();
            hp.clickRegister();

            AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

            regpage.setFirstName(randomString().toUpperCase());
            regpage.setLastName(randomString().toUpperCase());
            regpage.setEmailId(randomString() + "@gmail.com");
            regpage.setTelephone(randomNumber());

            String password = randomAlphaNumeric();
            regpage.setTxtPassword(password);
            regpage.setTxtConfirmPassword(password);

            regpage.setChkdPolicy();
            regpage.clickBtnContinue();

    }
    
}
