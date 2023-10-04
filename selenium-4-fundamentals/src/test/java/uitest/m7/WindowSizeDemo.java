package uitest.m7;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static factory.DriverFactory.newChromeDriver;
import static helper.Pages.HOME;
import static wait.WaitingUtils.pause;

public class WindowSizeDemo {

    @Test
    public void windowSizeDemo() {
        WebDriver driver = newChromeDriver();

        WebDriver.Window window = driver.manage().window();

        window.maximize();
        window.minimize();
        window.setSize(new Dimension(1200, 800));

        driver.get(HOME);

        pause();
        driver.quit();
    }
}
