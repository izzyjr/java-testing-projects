package uitest.m4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static factory.DriverFactory.newChromeDriver;
import static helper.Pages.HOME;
import static wait.WaitingUtils.pause;

public class AttributesTest {

    @Test
    public void isEnabledTest() {
        WebDriver driver = newChromeDriver();
        driver.get(HOME);

        WebElement textarea = driver.findElement(By.id("textarea"));
        Assert.assertFalse(textarea.isEnabled());

        if (textarea.isEnabled()) {
            textarea.sendKeys("test");
        }

        pause();
        driver.quit();
    }

    @Test
    public void isDisplayed() {
        WebDriver driver = newChromeDriver();;
        driver.get(HOME);

        WebElement feedback = driver.findElement(By.className("invalid-feedback"));
        Assert.assertFalse(feedback.isDisplayed());

        driver.findElement(By.id("register")).click();
        Assert.assertTrue(feedback.isDisplayed());

        driver.quit();
    }
}
