package uitest.m8;

import base.BaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Home;

import java.util.Optional;

import static factory.DevToolsFactory.newChromeDevTool;
import static pages.Home.homeIDs.LOCATION;
import static wait.WaitingUtils.waitUntilVisible;

public class GeoLocationDemo extends BaseTestClass {

    private Home homePage;

    @BeforeMethod
    private void pageSetUp() {
        homePage = Home.homePage(driver);
    }

    @Test
    private void geoLocationDemo() {
        DevTools tools = newChromeDevTool(driver);
        tools.createSession();

        tools.send(Emulation.setGeolocationOverride(Optional.of(51.49937053990275),
                Optional.of(-0.09953871364387087), Optional.of(100)));

        homePage.goTo();
        WebElement location = waitUntilVisible(driver, By.id(LOCATION.getId()),6);

        tools.close();
    }
}
