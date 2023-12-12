package uitest.m4;

import base.BaseTestClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Home;

public class UnderstandingWebElement extends BaseTestClass {

    private Home homePage;

    @BeforeMethod
    private void pageSetUp() {
        homePage = Home.homePage(driver);
    }

    @Test
    private void webElementTest() {
        homePage.goTo();

        System.out.println(homePage.isFirstnameDisplayed());

        System.out.println(homePage.getRegisterText());
    }
}
