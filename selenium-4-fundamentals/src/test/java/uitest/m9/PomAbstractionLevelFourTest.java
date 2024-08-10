package uitest.m9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Loans;

import static factory.DriverFactory.newChromeDriver;
import static pages.Loans.Period.ONE_MONTH;
import static pages.Loans.loansIDSs.RESULT;
import static wait.WaitingUtils.waitUntilVisible;

public class PomAbstractionLevelFourTest {

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
        WebElement result = waitUntilVisible(driver, By.id(RESULT.toString()), 6);
        loansPage.verifyResultMessage(result,"You will pay us back 4000");
    }

    @AfterMethod
    private void closeDriver() {
        driver.quit();
    }

}
