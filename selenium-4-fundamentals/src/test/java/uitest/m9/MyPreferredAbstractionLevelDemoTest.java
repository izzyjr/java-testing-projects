package uitest.m9;

import base.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Savings;

import static pages.Savings.Period.ONE_YEAR;

public class MyPreferredAbstractionLevelDemoTest extends BaseTestClass {

    private Savings savingsPage;

    @BeforeMethod
    private void pageSetup() {
        savingsPage = Savings.savingsPage(driver);
    }

    @Test
    private void savingsTest() {
        savingsPage.goTo();
        savingsPage.inputDeposit("500");
        savingsPage.selectPeriodDropdown(ONE_YEAR);

        Assert.assertTrue(savingsPage.isResultDisplayed());
        Assert.assertEquals(savingsPage.getResultText(), "After 1 Year you will earn $25.00 on your deposit");
    }
}
