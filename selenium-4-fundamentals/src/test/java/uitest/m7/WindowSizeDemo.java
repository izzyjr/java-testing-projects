package uitest.m7;

import static wait.WaitingUtils.pause;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static helper.Pages.HOME;

public class WindowSizeDemo {

    @Test
    public void windowSizeDemo() {
        WebDriver driver = new ChromeDriver();

        WebDriver.Window window = driver.manage().window();

        window.maximize();
        window.minimize();
        window.setSize(new Dimension(1200, 800));

        driver.get(HOME);

        pause();
        driver.quit();
    }
}
