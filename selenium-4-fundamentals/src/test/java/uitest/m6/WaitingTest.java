package uitest.m6;

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

import static factory.DriverFactory.newChromeDriver;
import static helper.Pages.LOANS;
import static wait.WaitingUtils.waitUntilClickable;

public class WaitingTest {

    WebDriver driver;

    @Test
    public void implicitWaitTest() {
        driver = newChromeDriver();
        driver.get(LOANS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.findElement(By.id("borrow")).sendKeys("500");

        driver.findElement(By.id("result")).click();
    }

    @Test
    public void explicitWaitTest() {
        driver = newChromeDriver();
        driver.get(LOANS);
        driver.findElement(By.id("borrow")).sendKeys("500");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));

        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        Assert.assertTrue(result.isDisplayed());
    }

    @Test
    public void explicitWaitTestRefactored() {
        driver = newChromeDriver();
        driver.get(LOANS);
        driver.findElement(By.id("borrow")).sendKeys("500");

        WebElement result = waitUntilClickable(driver, By.id("result"), 6);
        Assert.assertTrue(result.isDisplayed());
    }

    @Test
    public void fluentWait() {
        driver = newChromeDriver();
        driver.get(LOANS);
        driver.findElement(By.id("borrow")).sendKeys("500");

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(6))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);

        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        Assert.assertTrue(result.isDisplayed());
    }

    @AfterMethod
    public void cleanup() {
        driver.quit();
    }
}
