package uitest.m9;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Loans;

import static factory.DriverFactory.newChromeDriver;
import static pages.Loans.Period.ONE_MONTH;

public class PomAbstractionLevelFour {

    WebDriver driver;

    @BeforeMethod
    private void initDriver() {
        driver = newChromeDriver();
    }

    @Test
    private void loansTest() {
        var loansPage = Loans.loansPage(driver);
        loansPage.goTo();
        loansPage.enterBorrowAmount("2000");
        loansPage.selectTimePeriod(ONE_MONTH);
        loansPage.verifyResultMessage("You will pays us back 4000");
    }

    @AfterMethod
    private void closeDriver() {
        driver.quit();
    }

}
