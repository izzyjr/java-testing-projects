package uitest.m4;

import base.BaseTestClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Home;

import static wait.WaitingUtils.pause;

public class ClickingTest extends BaseTestClass {

    private Home homePage;

    @BeforeMethod
    private void pageSetUp() {
        homePage = Home.homePage(driver);
    }

    @Test
    private void clickingTest() {
        homePage.goTo();

        homePage.clickOnCheckbox();
        homePage.clickOnRegister();
        pause();

        driver.quit();
    }

    @Test
    private void moreClicking() {
        homePage.goTo();

        homePage.doubleClickCheckbox();
        pause();
        homePage.rightClick();
        pause();

        driver.quit();
    }
}
