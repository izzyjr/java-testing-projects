package uitest.m5;

import base.BaseTestClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Home;
import pages.Savings;

public class ByXpath extends BaseTestClass {

    private Savings savingsPage;
    private Home homePage;

    @BeforeMethod
    private void pageSetUp() {
        savingsPage = Savings.savingsPage(driver);
        homePage = Home.homePage(driver);
    }

    @Test
    private void byXpath() {
        savingsPage.goTo();

        System.out.println("Chrome full xpath: " + savingsPage.getCell1Text());
        System.out.println("Chrome xpath: " + savingsPage.getCell2Text());
    }

    @Test
    private void byXpath_2() {
        homePage.goTo();

        System.out.println(homePage.getRegisterByXpathText());
    }
}
