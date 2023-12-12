package uitest.m5;

import base.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Home;
import pages.Savings;

public class ByIdClassTagTest extends BaseTestClass {

    private Home homePage;
    private Savings savingsPage;

    @BeforeMethod
    private void pageSetup() {
        homePage = Home.homePage(driver);
        savingsPage = Savings.savingsPage(driver);
    }

    @Test
    private void byId() {
        homePage.goTo();

        homePage.clickOnRegister();
        driver.quit();
    }

    @Test
    private void byClass() {
        homePage.goTo();
        homePage.clickOnRegister();

        Assert.assertEquals(homePage.getFeedbackText(0), "Valid first name is required");
        Assert.assertEquals(homePage.getFeedbackText(1), "Valid last name is required");
        Assert.assertEquals(homePage.getFeedbackText(2), "Please enter a valid email address");
    }

    @Test
    private void byTagName() {
        savingsPage.goTo();

        System.out.println(savingsPage.getTableText());
        System.out.println(savingsPage.getSameTableText());
    }
}
