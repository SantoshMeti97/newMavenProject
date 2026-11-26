package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    private static final DateTimeFormatter TIMESTAMP_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd_HH.mm.ss_SSS");

    public static String takeScreenshot(WebDriver driver, String testName) {
        try {
            String timestamp = LocalDateTime.now().format(TIMESTAMP_FORMAT);
            String safeTestName = testName.replaceAll("[^a-zA-Z0-9._-]", "_");

            Path screenshotDir = Paths.get("Screenshots");
            Files.createDirectories(screenshotDir);

            File source = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            Path destination = screenshotDir.resolve(
                    safeTestName + "_" + timestamp + ".png");

            Files.copy(source.toPath(), destination,
                    StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Screenshot saved: " + destination.toAbsolutePath());
            return destination.toAbsolutePath().toString();

        } catch (IOException e) {
            throw new RuntimeException("Unable to save screenshot", e);
        }
    }
}
