package uitest.m5;

import base.BaseTestClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Home;

import static pages.Home.fields.DATE_PICKER;
import static wait.WaitingUtils.pause;

public class ByCssTest extends BaseTestClass {

    private Home homePage;

    @BeforeMethod
    private void pageSetUp() {
        homePage = Home.homePage(driver);
    }

    @Test
    private void byCssSelector() {
        homePage.goTo();
        homePage.sendKeysToFields(DATE_PICKER, "06/14/2023");
    }

    @Test
    private void byCssSelector_2() {
        homePage.goTo();
        homePage.clickOnCheckbox();

        pause();
    }
}
