package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    private static final int DEFAULT_TIMEOUT_SECONDS = 10;

    private static WebDriverWait getWait(WebDriver driver) {
        return new WebDriverWait(
                driver, Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS));
    }

    public static WebElement waitForVisibility(WebDriver driver, By locator) {
        return getWait(driver).until(
                ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickable(WebDriver driver, By locator) {
        return getWait(driver).until(
                ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitForPresence(WebDriver driver, By locator) {
        return getWait(driver).until(
                ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static boolean waitForInvisibility(WebDriver driver, By locator) {
        return getWait(driver).until(
                ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static boolean waitForText(WebDriver driver, By locator, String text) {
        return getWait(driver).until(
                ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public static boolean waitForUrlContains(WebDriver driver, String text) {
        return getWait(driver).until(
                ExpectedConditions.urlContains(text));
    }

    public static boolean waitForTitleContains(WebDriver driver, String title) {
        return getWait(driver).until(
                ExpectedConditions.titleContains(title));
    }
}
