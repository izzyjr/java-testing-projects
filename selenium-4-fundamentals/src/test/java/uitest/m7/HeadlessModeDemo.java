package uitest.m7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Home;

import static factory.DriverFactory.newChromeDriver;

public class HeadlessModeDemo {

    private Home homePage;
    private WebDriver driver;

    @BeforeMethod
    private void pageSetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless=true");

        driver = newChromeDriver(options);
        homePage = Home.homePage(driver);
    }

    @Test
    public void headlessDemo() {
        homePage.goTo();

        Assert.assertEquals(homePage.getRegisterText(), "Register");
        driver.quit();
    }

    @AfterMethod()
    private void closeDriver() {
        driver.quit();
    }
}
