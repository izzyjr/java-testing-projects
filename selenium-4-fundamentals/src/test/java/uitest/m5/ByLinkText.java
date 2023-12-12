package uitest.m5;

import base.BaseTestClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Home;

import static wait.WaitingUtils.pause;

public class ByLinkText extends BaseTestClass {

    private Home homePage;

    @BeforeMethod
    private void pageSetUp() {
        homePage = Home.homePage(driver);
    }

    @Test
    public void byLinkText() {
        homePage.goTo();

        homePage.clickOnSavings();
        pause();

        homePage.clickOnReg();
        pause();
    }
}
