package testCases;

import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.loginPage;

public class TC02_LoginTest extends BaseClass{
    @Test(groups={"Sanity", "Master"})
    public void loginTest() throws InterruptedException {
       // logger.info("********* Starting TC02_LoginTest **********");

        HomePage hp=new HomePage(driver); // creating object of HomePage class to get myAccount and clickLogin methods
        hp.myAccount();
        hp.clickLogin();

        loginPage lp=new loginPage(driver); // creating object of loginPage class to get setEmail and setPassword methods
        lp.setEmail(p.getProperty("email")); // taking email and password from config.properties file
        lp.setPassword(p.getProperty("password"));
        lp.loginbtn();

        MyAccountPage macc=new MyAccountPage(driver); // creating object of MyAccountPage class to get isMyAccountPageExists method
        Boolean targetpage=macc.isMyAccountPageExists();// checking if MyAccount page is displayed or not
        macc.clickLogOut();

    }

}
