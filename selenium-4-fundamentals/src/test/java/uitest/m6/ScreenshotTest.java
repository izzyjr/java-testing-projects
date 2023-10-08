package uitest.m6;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static factory.DriverFactory.newChromeDriver;
import static helper.Pages.HOME;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class ScreenshotTest {

    WebDriver driver;

    @BeforeMethod
    public void initDriver() {
        driver = newChromeDriver();
    }
    
    @Test
    public void fullPageScreenShot() throws IOException {
        driver.get(HOME);

        TakesScreenshot ts = (TakesScreenshot) driver;

        File screenshot = ts.getScreenshotAs(OutputType.FILE);
        Path destination = Paths.get("failure-screenshot.png");

        Files.move(screenshot.toPath(), destination, REPLACE_EXISTING);
    }

    @Test
    public void elementScreenshot() throws IOException {
        driver.get(HOME);

        var form = driver.findElement(By.tagName("form"));

        File screenshot = form.getScreenshotAs(OutputType.FILE);
        Path destination = Paths.get("failure-screenshot.png");

        Files.move(screenshot.toPath(), destination, REPLACE_EXISTING);
    }

    @AfterMethod(alwaysRun = true)
    void closeDriver() {
        driver.quit();
    }
}
