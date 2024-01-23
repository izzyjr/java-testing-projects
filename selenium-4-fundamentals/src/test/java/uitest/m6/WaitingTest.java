package uitest.m6;

import base.BaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Loans;

import java.time.Duration;

import static wait.WaitingUtils.waitUntilClickable;

public class WaitingTest extends BaseTestClass {

    private Loans loansPage;

    @BeforeMethod
    private void pageSetUp() {
        loansPage = Loans.loansPage(driver);
    }

    @Test
    public void implicitWaitTest() {
        loansPage.goTo();

        loansPage.implicitlyWait(6);
        loansPage.sendKeysBorrow("500");

        loansPage.clickOnResult();
    }

    @Test
    public void explicitWaitTest() {
        loansPage.goTo();
        loansPage.sendKeysBorrow("500");

        WebDriverWait wait = loansPage.waitFor(6);

        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        Assert.assertTrue(result.isDisplayed());
    }

    @Test
    public void explicitWaitTestRefactored() {
        loansPage.goTo();
        loansPage.sendKeysBorrow("500");

        WebElement result = waitUntilClickable(driver, By.id("result"), 6);
        Assert.assertTrue(result.isDisplayed());
    }

    @Test
    public void fluentWait() {
        loansPage.goTo();
        loansPage.sendKeysBorrow("500");

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(6))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);

        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        Assert.assertTrue(result.isDisplayed());
    }
}
