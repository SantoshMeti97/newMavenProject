package utilities;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownUtils {

    private static Select getSelect(WebElement dropdown) {
        return new Select(dropdown);
    }

    public static void selectByVisibleText(WebElement dropdown, String text) {
        getSelect(dropdown).selectByVisibleText(text);
    }

    public static void selectByValue(WebElement dropdown, String value) {
        getSelect(dropdown).selectByValue(value);
    }

    public static void selectByIndex(WebElement dropdown, int index) {
        getSelect(dropdown).selectByIndex(index);
    }

    public static String getSelectedOption(WebElement dropdown) {
        return getSelect(dropdown).getFirstSelectedOption().getText();
    }

    public static List<WebElement> getAllOptions(WebElement dropdown) {
        return getSelect(dropdown).getOptions();
    }

    public static void printAllOptions(WebElement dropdown) {
        for (WebElement option : getAllOptions(dropdown)) {
            System.out.println(option.getText());
        }
    }

    public static boolean isMultiple(WebElement dropdown) {
        return getSelect(dropdown).isMultiple();
    }

    public static void deselectAll(WebElement dropdown) {
        getSelect(dropdown).deselectAll();
    }
}
