package uitest.m6;

import base.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Home;

import static wait.WaitingUtils.pause;

public class HandleDialogTest extends BaseTestClass {

    private Home homePage;

    @BeforeMethod
    private void pageSetUp() {
        homePage = Home.homePage(driver);
    }


    @Test
    private void dismissAlertTest() {
        homePage.goTo();

        homePage.sendKeysToFields(Home.fields.FIRST_NAME, "John");
        homePage.sendKeysToFields(Home.fields.LAST_NAME, "Smith");

        pause();
        homePage.clickOnClear();

        homePage.dismissAlert();

        Assert.assertEquals(homePage.getFirstnameAttribute(), "John");
        Assert.assertEquals(homePage.getLastnameAttribute(), "Smith");
    }

    @Test
    private void dismissAlertTest_2() {
        homePage.goTo();

        homePage.sendKeysToFields(Home.fields.FIRST_NAME, "John");
        homePage.sendKeysToFields(Home.fields.LAST_NAME, "Smith");

        pause();
        homePage.clickOnClear();

        homePage.acceptAlert();

        Assert.assertEquals(homePage.getFirstnameAttribute(), "");
        Assert.assertEquals(homePage.getLastnameAttribute(), "");
    }
}
