package uitest.m7;

import base.BaseTestClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static helper.Pages.HOME;
import static wait.WaitingUtils.pause;

public class WindowSizeDemo extends BaseTestClass {

    @Test
    public void windowSizeDemo() {

        WebDriver.Window window = driver.manage().window();

        window.maximize();
        window.minimize();
        window.setSize(new Dimension(1200, 800));

        driver.get(HOME);

        pause();
    }
}
