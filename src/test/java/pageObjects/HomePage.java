package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    // Define locators and methods specific to the Home Page here
    public HomePage(WebDriver driver) {
        super(driver); // here we are passing driver object to parent class constructor
    }

    @FindBy(xpath="//span[text()='My Account']")
    WebElement linkMyAccount;
    @FindBy(xpath="//a[text()='Register']")
    WebElement linkRegister;
    @FindBy(xpath="//a[text()='Login']")
    WebElement linkLogin;

    public void myAccount(){
        linkMyAccount.click();
    }
    public void clickRegister(){
        linkRegister.click();
    }
    public void clickLogin(){
        linkLogin.click();
    }
}
