package uitest.m5;

import static wait.WaitingUtils.pause;
import helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static helper.Pages.HOME;

public class ByLinkText {

    @Test
    public void byLinkText() {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);

        driver.findElement(By.linkText("Savings")).click();
        pause();

        driver.findElement(By.partialLinkText("Reg")).click();
        pause();

        driver.quit();
    }
}
