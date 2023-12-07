package uitest.m4;

import base.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Savings;

import static wait.WaitingUtils.pause;

public class SelectingTest extends BaseTestClass {

    private Savings savingsPage;

    @BeforeMethod
    private void pageSetUp() {
        savingsPage = Savings.savingsPage(driver);
    }

    @Test
    private void selectingTest() {
        savingsPage.goTo();

        savingsPage.inputDeposit("100");

        savingsPage.selectPeriodDropdown("6 months");
        pause();
        savingsPage.selectPeriodDropdown("1 Year");
        pause();
        savingsPage.selectPeriodDropdownByIndex(2);

        Assert.assertEquals(savingsPage.getResultText(), "After 2 Years you will earn $12.00 on your deposit");
    }
}
