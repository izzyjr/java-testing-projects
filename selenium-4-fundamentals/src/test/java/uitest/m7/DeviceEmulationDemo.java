package uitest.m7;

import base.BaseTestClass;
import factory.DriverFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Home;

import static wait.WaitingUtils.pause;

public class DeviceEmulationDemo extends BaseTestClass {

    private Home homePage;

    @BeforeMethod
    private void pageSetUp() {
        driver = DriverFactory.newDevice("Nexus 5");
        homePage = Home.homePage(driver);
    }


    @Test
    private void deviceEmulation() {
        homePage.goTo();

        pause();
    }
}
