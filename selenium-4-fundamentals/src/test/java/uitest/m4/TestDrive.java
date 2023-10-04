package uitest.m4;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static factory.DriverFactory.newChromeDriver;


public class TestDrive {

    @Test
    public void test() {
        WebDriver driver = newChromeDriver();
        driver.quit();
    }
}
