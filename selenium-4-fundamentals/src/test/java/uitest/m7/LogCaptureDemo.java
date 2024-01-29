package uitest.m7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Home;

import static factory.DriverFactory.newChromeDriver;
import static factory.LogCaptureFactory.newLogCapture;

public class LogCaptureDemo {

    private Home homePage;
    private WebDriver driver;

    @BeforeMethod
    private void pageSetUp() {
        ChromeOptions options = newLogCapture();

        driver = newChromeDriver(options);
        homePage = Home.homePage(driver);
    }

    @Test
    private void logCaptureDemo() {

        homePage.goTo();
        homePage.clickOnRegister();

        LogEntries browserLogs = driver.manage().logs().get(LogType.BROWSER);
        Assert.assertFalse(browserLogs.getAll().isEmpty());

        browserLogs.forEach(System.out::println);

        browserLogs.forEach(logEntry -> System.out.println(logEntry.getLevel() + " " + logEntry.getMessage()));

        browserLogs.forEach(logEntry -> checkNoError(logEntry));
    }

    private void checkNoError(LogEntry logEntry) {
        Assert.assertNotEquals(logEntry.getLevel().getName(), "SEVERE");
    }

    @AfterMethod(alwaysRun = true)
    private void closeDriver() {
        driver.quit();
    }
}
