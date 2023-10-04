package uitest.m5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static factory.DriverFactory.newChromeDriver;
import static helper.Pages.HOME;
import static wait.WaitingUtils.pause;

public class ByLinkText {

    @Test
    public void byLinkText() {
        WebDriver driver = newChromeDriver();
        driver.get(HOME);

        driver.findElement(By.linkText("Savings")).click();
        pause();

        driver.findElement(By.partialLinkText("Reg")).click();
        pause();

        driver.quit();
    }
}
