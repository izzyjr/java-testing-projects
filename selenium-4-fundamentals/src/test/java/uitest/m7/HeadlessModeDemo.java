package uitest.m7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static factory.DriverFactory.newChromeDriver;
import static helper.Pages.HOME;

public class HeadlessModeDemo {

    @Test
    public void headlessDemo() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless=true");

        WebDriver driver = newChromeDriver(options);
        driver.get(HOME);

        WebElement button = driver.findElement(By.id("register"));
        Assert.assertEquals(button.getText(), "Register");

        driver.quit();
    }
}
