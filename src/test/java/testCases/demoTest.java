package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ElectronDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.loginPage;

import java.time.Duration;
import java.util.Set;

//import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.header;

public class demoTest{
@Test(priority = 1)
    public void fileUpload() throws InterruptedException {
       // logger.info("********* Starting TC02_LoginTest **********");

        WebDriver driver=new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        System.out.println("Current page : "+driver.getTitle());

//
            WebElement fileUploaderHeader= driver.findElement(By.xpath("//h3[text()='File Uploader']"));
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(fileUploaderHeader));
            Thread.sleep(3000);
            WebElement uploadFIleBtn=driver.findElement(By.id("file-submit"));//            u
            uploadFIleBtn.sendKeys("C:\\Users\\vinur\\Downloads\\New folder");
            Thread.sleep(3000);

        driver.close();
    }

    @Test(priority = 2)
    public void windowHandling() throws InterruptedException {
        // logger.info("********* Starting TC02_LoginTest **********");

        WebDriver driver=new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        System.out.println("Current page : "+driver.getTitle());

        String parent = driver.getWindowHandle();   // Parent window
        System.out.println(" Parent window id is : "+parent);

        Thread.sleep(2000);
        driver.findElement(By.linkText("Elemental Selenium")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Thread.sleep(2000);
        Set<String> allWindows = driver.getWindowHandles();
        System.out.println(" Child window id's are : "+allWindows);

        for (String handle : allWindows) {
            if (!handle.equals(parent)) {
                driver.switchTo().window(handle);   // Switch to child
                System.out.println("Current page : "+driver.getTitle());
                Thread.sleep(2000);
                driver.close();                     // Close child
            }
        }

        driver.switchTo().window(parent);           // Back to parent
        Thread.sleep(2000);
        driver.close();
    }

@Test(priority = 3)
    public void fileDownload() throws InterruptedException {
        // logger.info("********* Starting TC02_LoginTest **********");

        WebDriver driver=new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        System.out.println("Current page : "+driver.getTitle());

        WebElement fileDownloaderBtn= driver.findElement(By.linkText("File Download"));
        fileDownloaderBtn.click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement fileDownloaderText=driver.findElement(By.xpath("//h3[text()='File Downloader']"));

        wait.until(ExpectedConditions.visibilityOf(fileDownloaderText));

        driver.findElement(By.linkText("1-upload-probe.txt")).click();

         Thread.sleep(2000);
        driver.close();
    }
}
