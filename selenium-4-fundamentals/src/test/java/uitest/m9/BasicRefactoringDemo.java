package uitest.m9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static factory.DriverFactory.newChromeDriver;
import static factory.DriverFactory.newEdgeDriver;
import static factory.DriverFactory.newFirefoxDriver;
import static helper.Pages.LOANS;
import static wait.WaitingUtils.waitUntilVisible;

public class BasicRefactoringDemo {

    @Test
    public void beforeRefactoring() {
        // setup
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless=true");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();

        // do things
    }

    @Test
    public void newDriverAndToolsDemo() {

        WebDriver chromeDriver = newChromeDriver();

        WebDriver edgeDriver = newEdgeDriver();

        WebDriver firefoxDriver = newFirefoxDriver();
    }

    @Test
    public void refactoredTestDemo() {

        var driver = newChromeDriver();
        driver.get(LOANS);
        driver.findElement(By.id("borrow")).sendKeys("500");

        var message = waitUntilVisible(driver, By.id("result"), 6);
        Assert.assertEquals(message.getText(), "You will pays us back 1000");
    }
}
