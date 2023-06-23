package uitest.m6;

import helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static helper.Pages.LOANS;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class WaitingTest {

    WebDriver driver;

    @Test
    public void implicitWaitTest() {
        driver = DriverFactory.newDriver();
        driver.get(LOANS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.findElement(By.id("borrow")).sendKeys("500");

        driver.findElement(By.id("result")).click();
    }

    @Test
    public void explicitWaitTest() {
        driver = DriverFactory.newDriver();
        driver.get(LOANS);
        driver.findElement(By.id("borrow")).sendKeys("500");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));

        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        Assert.assertTrue(result.isDisplayed());
    }

    @Test
    public void explicitWaitTestRefactored() {
        driver = DriverFactory.newDriver();
        driver.get(LOANS);
        driver.findElement(By.id("borrow")).sendKeys("500");

        WebElement result = waitUntilClickable(driver, By.id("result"), 6);
        Assert.assertTrue(result.isDisplayed());
    }

    @Test
    public void fluentWait() {
        driver = DriverFactory.newDriver();
        driver.get(LOANS);
        driver.findElement(By.id("borrow")).sendKeys("500");

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(6))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);

        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        Assert.assertTrue(result.isDisplayed());
    }

    public static WebElement waitUntilClickable(WebDriver driver, By locator, long seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(elementToBeClickable(locator));
    }

    @AfterMethod
    public void cleanup() {
        driver.quit();
    }
}
