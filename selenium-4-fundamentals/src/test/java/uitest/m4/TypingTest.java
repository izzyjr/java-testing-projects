package uitest.m4;

import base.BaseTestClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Home;

import static pages.Home.fields.DOB;
import static pages.Home.fields.EMAIL;
import static pages.Home.fields.FIRST_NAME;
import static pages.Home.fields.LAST_NAME;
import static wait.WaitingUtils.pause;

public class TypingTest extends BaseTestClass {

    private Home homePage;

    @BeforeMethod
    private void pageSetUp() {
        homePage = Home.homePage(driver);
    }

    @Test
    private void typingTest() {
        homePage.goTo();

        homePage.sendKeysToFields(FIRST_NAME, "Sofia");
        homePage.sendKeysToFields(LAST_NAME,"Diaz");
        homePage.sendKeysToFields(EMAIL,"sofia@gmail.com");

        pause();
        homePage.clearField(EMAIL);
        homePage.sendKeysToFields(EMAIL, "sofia@gmail.com");
        homePage.sendKeysToFields(DOB, "01/01/2000");

        pause();
    }
}
