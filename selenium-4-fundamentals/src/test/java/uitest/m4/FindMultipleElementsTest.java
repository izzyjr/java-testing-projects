package uitest.m4;

import base.BaseTestClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Home;

public class FindMultipleElementsTest extends BaseTestClass {

    private Home homePage;

    @BeforeMethod
    private void pageSetUp() {
        homePage = Home.homePage(driver);
    }

    @Test
    private void multipleElementsTest() {
        homePage.goTo();

        homePage.clickOnRegister();
        print(homePage.getFeedbackText(0));
        print(homePage.getFeedbackText(1));
    }

    private void print(String text) {
        System.out.println("Feedback:" + text);
    }
}
