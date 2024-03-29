package uitest.m6;

import base.BaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Home;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class ScreenshotTest extends BaseTestClass {

    private Home homePage;

    @BeforeMethod
    private void pageSetUp() {
        homePage = Home.homePage(driver);
    }

    @Test
    public void fullPageScreenShot() throws IOException {
        homePage.goTo();

        TakesScreenshot ts = (TakesScreenshot) driver;

        File screenshot = ts.getScreenshotAs(OutputType.FILE);
        Path destination = Paths.get("failure-screenshot.png");

        Files.move(screenshot.toPath(), destination, REPLACE_EXISTING);
    }

    @Test
    public void elementScreenshot() throws IOException {
        homePage.goTo();

        var form = driver.findElement(By.tagName("form"));

        File screenshot = form.getScreenshotAs(OutputType.FILE);
        Path destination = Paths.get("failure-screenshot.png");

        Files.move(screenshot.toPath(), destination, REPLACE_EXISTING);
    }
}
