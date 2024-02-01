package uitest.m8;

import base.BaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Home;

import java.util.Optional;

import static factory.DevToolsFactory.newChromeDevTool;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class GeoLocationDemo extends BaseTestClass {

    private Home homePage;

    @BeforeMethod
    private void pageSetUp() {
        homePage = Home.homePage(driver);
    }

    @Test
    public void geoLocationDemo() {
        DevTools tools = newChromeDevTool(driver);
        tools.createSession();

        tools.send(Emulation.setGeolocationOverride(Optional.of(51.49937053990275),
                Optional.of(-0.09953871364387087), Optional.of(100)));

        homePage.goTo();
        WebDriverWait wait = homePage.waitFor(6);
        WebElement location = wait.until(visibilityOfElementLocated(By.id("location")));

        tools.close();
    }
}
