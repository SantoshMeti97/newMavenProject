package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

// ever class has to extend this base class because it contains setUp and tearDown methods which is common for all class
public class BaseClass {
    public static WebDriver driver;
    public Logger logger;
    Logger LogManager;
    public Properties p;
    @BeforeClass(groups={"Sanity", "Regression", "Master"})
    @Parameters({"os","browser"})
    public void setUp(String os,String br) throws IOException {
//        logger= LogManager.getLogger(this.getClass());

        //Loading config.properties file
        FileReader file=new FileReader("./src//test//resources//config.properties");
        p=new Properties();
        p.load(file);

        switch(br.toLowerCase())
        {
            case "chrome" : driver = new ChromeDriver(); break;
            case "firefox" : driver = new FirefoxDriver(); break;
            case "edge" : driver = new EdgeDriver(); break;
            default: System.out.println("Please provide valid browser name"); break;
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(p.getProperty("baseURL")); // getting baseURL from config.properties file
        driver.manage().window().maximize();

    }
    @AfterClass(groups={"Sanity", "Regression", "Master"})
    public void tearDown(){
        driver.quit();
    }

    //RandomStringUtils -->> used to get random alphabets and numbers
    //import org.apache.commons.lang3.RandomStringUtils;  -->> dependency
    public String randomString(){
        // generate a random string of 5 alphabetic characters
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return generatedString;
    }
    public String randomNumber(){
        // generate a random string of 10 numeric characters
        String generatedNumber = RandomStringUtils.randomNumeric(10);
        return generatedNumber;
    }
    public String randomAlphaNumeric(){
        // generate a random string of 5 alphabetic characters and 10 numeric characters
        String generatedAlphaNumeric = RandomStringUtils.randomAlphabetic(5) +"@"+ RandomStringUtils.randomNumeric(5);
        return generatedAlphaNumeric;
    }

    public String captureScreen(String tname) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;
    }
}

