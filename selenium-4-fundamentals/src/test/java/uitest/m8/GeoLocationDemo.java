package uitest.m8;

import base.BaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Optional;

import static factory.DevToolsFactory.newChromeDevTool;
import static helper.Pages.HOME;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class GeoLocationDemo extends BaseTestClass {

    @Test
    public void geoLocationDemo() {
        DevTools tools = newChromeDevTool(driver);
        tools.createSession();

        tools.send(Emulation.setGeolocationOverride(Optional.of(51.49937053990275),
                Optional.of(-0.09953871364387087), Optional.of(100)));

        driver.get(HOME);
        WebElement location = new WebDriverWait(driver, Duration.ofSeconds(3)).until(visibilityOfElementLocated(By.id("location")));

        tools.close();
    }
}
