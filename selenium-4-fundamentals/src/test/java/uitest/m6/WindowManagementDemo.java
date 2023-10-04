package uitest.m6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static factory.DriverFactory.newChromeDriver;
import static helper.Pages.HOME;
import static helper.Pages.SAVINGS;
import static wait.WaitingUtils.pause;

public class WindowManagementDemo {

    @Test
    public void tabsAndWindowsDemo() {
        WebDriver driver = newChromeDriver();
        driver.get(HOME);

        String firstTab = driver.getWindowHandle();

        pause();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(SAVINGS);
        Assert.assertEquals(driver.getWindowHandles().size(), 2);

        driver.switchTo().window(firstTab);
        driver.close();
        Assert.assertEquals(driver.getWindowHandles().size(), 1);

        driver.quit();
    }
}
