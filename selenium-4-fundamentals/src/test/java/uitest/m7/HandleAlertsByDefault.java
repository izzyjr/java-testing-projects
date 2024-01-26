package uitest.m7;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Home;

import static factory.DriverFactory.newChromeDriver;
import static wait.WaitingUtils.pause;

public class HandleAlertsByDefault {

    private Home homePage;
    private WebDriver driver;

    @BeforeMethod
    private void pageSetUp() {
        ChromeOptions options = new ChromeOptions();
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);

        driver = newChromeDriver(options);
        homePage = Home.homePage(driver);
    }

    @Test
    private void handleAlertsByDefault() {
        homePage.goTo();

        homePage.clickOnClear();
        homePage.clickOnRegister();
        pause();
    }

    @AfterMethod()
    private void closeDriver() {
        driver.quit();
    }
}
