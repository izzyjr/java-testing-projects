package uitest.m6;

import base.BaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Loans;

import java.time.Duration;

import static pages.Loans.loansIDSs.RESULT;
import static wait.WaitingUtils.waitUntilClickable;
import static wait.WaitingUtils.waitUntilVisible;

public class WaitingTest extends BaseTestClass {

    private Loans loansPage;

    @BeforeMethod
    private void pageSetUp() {
        loansPage = Loans.loansPage(driver);
    }

    @Test
    private void implicitWaitTest() {
        loansPage.goTo();

        loansPage.implicitlyWait(6);
        loansPage.sendKeysBorrow("500");

        loansPage.clickOnResult();
    }

    @Test
    private void explicitWaitTest() {
        loansPage.goTo();
        loansPage.sendKeysBorrow("500");

        WebElement result = waitUntilVisible(driver, By.id(RESULT.toString()), 6);
        Assert.assertTrue(result.isDisplayed());
    }

    @Test
    private void explicitWaitTestRefactored() {
        loansPage.goTo();
        loansPage.sendKeysBorrow("500");

        WebElement result = waitUntilClickable(driver, By.id("result"), 6);
        Assert.assertTrue(result.isDisplayed());
    }

    @Test
    private void fluentWait() {
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
