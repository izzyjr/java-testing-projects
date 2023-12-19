package uitest.m6;

import base.BaseTestClass;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Home;
import pages.Savings;

import static wait.WaitingUtils.pause;

public class WindowManagementDemo extends BaseTestClass {

    private Home homePage;
    private Savings savingsPage;

    @BeforeMethod
    private void pageSetUp() {
        homePage = Home.homePage(driver);
        savingsPage = Savings.savingsPage(driver);
    }

    @Test
    private void tabsAndWindowsDemo() {
        homePage.goTo();

        String firstTab = driver.getWindowHandle();

        pause();
        driver.switchTo().newWindow(WindowType.TAB);
        savingsPage.goTo();
        Assert.assertEquals(driver.getWindowHandles().size(), 2);

        driver.switchTo().window(firstTab);
        driver.close();
        Assert.assertEquals(driver.getWindowHandles().size(), 1);
    }
}
