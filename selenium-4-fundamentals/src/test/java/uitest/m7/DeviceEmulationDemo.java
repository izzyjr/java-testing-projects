package uitest.m7;

import factory.DriverFactory;
import helper.DemoHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static helper.Pages.HOME;

public class DeviceEmulationDemo {

    @Test
    public void deviceEmulation() {

        WebDriver driver = DriverFactory.newDevice("Nexus 5");
        driver.get(HOME);

        DemoHelper.pause();
        driver.quit();
    }
}
