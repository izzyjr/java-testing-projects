package uitest.m7;

import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import static factory.DriverFactory.newChromeDriver;
import static helper.Pages.HOME;
import static wait.WaitingUtils.pause;

public class HandleAlertsByDefault {

    @Test
    public void handleAlertsByDefault() {
        ChromeOptions options = new ChromeOptions();
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);

        WebDriver driver = newChromeDriver(options);
        driver.get(HOME);

        driver.findElement(By.id("clear")).click();
        driver.findElement(By.id("register")).click();
        pause();
        driver.quit();
    }
}
