package uitest.m6;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static factory.DriverFactory.newChromeDriver;
import static helper.Pages.HOME;
import static wait.WaitingUtils.pause;

public class HandleDialogTest {

    WebDriver driver;

    @Test
    void dismissAlertTest() {
        driver = newChromeDriver();
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
        driver = newChromeDriver();
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

    @AfterMethod
    void cleanUp() {
        driver.quit();
    }
}
