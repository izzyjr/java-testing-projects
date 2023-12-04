package uitest.m4;

import base.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Home;

import static wait.WaitingUtils.pause;

public class AttributesTest extends BaseTestClass {

    private Home homePage;

    @BeforeMethod
    private void pageSetUp() {
        homePage = Home.homePage(driver);
    }

    @Test
    private void isEnabledTest() {
        homePage.goTo();

        Assert.assertFalse(homePage.textAreaEnabled());

        if (homePage.textAreaEnabled()) {
            homePage.sendKeysTextArea("test");
        }

        pause();
    }

    @Test
    private void isDisplayed() {
        homePage.goTo();

        Assert.assertFalse(homePage.isFeedbackDisplayed());

        homePage.clickOnRegister();
        Assert.assertTrue(homePage.isFeedbackDisplayed());
    }
}
