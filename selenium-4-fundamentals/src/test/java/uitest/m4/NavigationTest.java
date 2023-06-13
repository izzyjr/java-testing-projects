package uitest.m4;

import helper.DemoHelper;
import helper.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static helper.Pages.HOME;
import static helper.Pages.PREFIX;
import static helper.Pages.SAVINGS;

public class NavigationTest {

    @Test
    public void basicNavigationTest() {
        WebDriver driver = DriverFactory.newDriver();

        driver.get(PREFIX + HOME);

        DemoHelper.pause();
        driver.get(PREFIX + SAVINGS);

        DemoHelper.pause();
        driver.navigate().back();

        DemoHelper.pause();
        driver.navigate().forward();

        driver.navigate().refresh();

        driver.quit();
    }
}
