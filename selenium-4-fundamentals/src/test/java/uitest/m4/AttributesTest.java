package uitest.m4;

import base.BaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static helper.Pages.HOME;
import static wait.WaitingUtils.pause;

public class AttributesTest extends BaseTestClass {

    @Test
    public void isEnabledTest() {
        driver.get(HOME);

        WebElement textarea = driver.findElement(By.id("textarea"));
        Assert.assertFalse(textarea.isEnabled());

        if (textarea.isEnabled()) {
            textarea.sendKeys("test");
        }

        pause();
    }

    @Test
    public void isDisplayed() {
        driver.get(HOME);

        WebElement feedback = driver.findElement(By.className("invalid-feedback"));
        Assert.assertFalse(feedback.isDisplayed());

        driver.findElement(By.id("register")).click();
        Assert.assertTrue(feedback.isDisplayed());
    }
}
