package uitest.m6;

import base.BaseTestClass;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static helper.Pages.HOME;
import static helper.Pages.SAVINGS;
import static wait.WaitingUtils.pause;

public class WindowManagementDemo extends BaseTestClass {

    @Test
    public void tabsAndWindowsDemo() {
        driver.get(HOME);

        String firstTab = driver.getWindowHandle();

        pause();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(SAVINGS);
        Assert.assertEquals(driver.getWindowHandles().size(), 2);

        driver.switchTo().window(firstTab);
        driver.close();
        Assert.assertEquals(driver.getWindowHandles().size(), 1);
    }
}
