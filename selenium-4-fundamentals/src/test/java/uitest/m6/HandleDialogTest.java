package uitest.m6;

import base.BaseTestClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static helper.Pages.HOME;
import static wait.WaitingUtils.pause;

public class HandleDialogTest extends BaseTestClass {

    @Test
    void dismissAlertTest() {
        driver.get(HOME);

        var first = driver.findElement(By.id("firstName"));
        var last = driver.findElement(By.id("lastName"));

        first.sendKeys("John");
        last.sendKeys("Smith");

        pause();
        driver.findElement(By.id("clear")).click();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        Assert.assertEquals(first.getAttribute("value"), "John");
        Assert.assertEquals(last.getAttribute("value"), "Smith");
    }

    @Test
    void dismissAlertTest_2() {
        driver.get(HOME);

        var first = driver.findElement(By.id("firstName"));
        var last = driver.findElement(By.id("lastName"));

        first.sendKeys("John");
        last.sendKeys("Smith");

        pause();
        driver.findElement(By.id("clear")).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        Assert.assertEquals(first.getAttribute("value"), "");
        Assert.assertEquals(last.getAttribute("value"), "");
    }
}
