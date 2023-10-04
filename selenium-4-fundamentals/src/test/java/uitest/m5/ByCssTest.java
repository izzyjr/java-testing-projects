package uitest.m5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static factory.DriverFactory.newChromeDriver;
import static helper.Pages.HOME;
import static wait.WaitingUtils.pause;

public class ByCssTest {

    WebDriver driver;

    @Test
    public void byCssSelector() {
        driver = newChromeDriver();
        driver.get(HOME);
        var datePicker = driver.findElement(By.cssSelector("input[type=date]"));
        datePicker.sendKeys("06/14/2023");
    }

    @Test
    public void byCssSelector_2() {
        driver = newChromeDriver();
        driver.get(HOME);
        var checkbox = driver.findElement(By.cssSelector("[type=checkbox]:not(:checked)"));
        checkbox.click();

        pause();
    }

    @AfterMethod
    public void cleanup() {
        driver.quit();
    }
}
