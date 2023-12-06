package uitest.m4;

import base.BaseTestClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Home;
import pages.Savings;

import static wait.WaitingUtils.pause;

public class NavigationTest extends BaseTestClass {

    private Home homePage;
    private Savings savingsPage;

    @BeforeMethod
    private void pageSetUp() {
        homePage = Home.homePage(driver);
        savingsPage = Savings.savingsPage(driver);
    }

    @Test
    private void basicNavigationTest() {

        homePage.goTo();

        pause();
        savingsPage.goTo();

        pause();
        back();

        pause();
        forward();

        refresh();
    }
}
